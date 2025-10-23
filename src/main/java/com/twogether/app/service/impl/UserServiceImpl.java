package com.twogether.app.service.impl;

import com.twogether.app.dto.UserDto;
import com.twogether.app.model.Skill;
import com.twogether.app.model.User;
import com.twogether.app.model.UserSkill;
import com.twogether.app.model.UserSkillId;
import com.twogether.app.repository.SkillRepository;
import com.twogether.app.repository.UserRepository;
import com.twogether.app.repository.UserSkillRepository;
import com.twogether.app.service.UserService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    
    private UserRepository userRepository;
    private SkillRepository skillRepository;
    private UserSkillRepository userSkillRepository;

    public UserServiceImpl(UserRepository userRepository, SkillRepository skillRepository,
			UserSkillRepository userSkillRepository) {
		this.userRepository = userRepository;
		this.skillRepository = skillRepository;
		this.userSkillRepository = userSkillRepository;
	}

	@Override
    public UserDto createUser(UserDto userDto) {
        
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("El correo electrónico ya está en uso.");
        }

        // 1. Mapear de DTO a Entidad User
        User userToSave = new User();
        userToSave.setName(userDto.getName());
        userToSave.setEmail(userDto.getEmail());
        userToSave.setBirthDate(userDto.getBirthDate());
        userToSave.setPassword(userDto.getPassword());
        userToSave.setCountry("-");
        
        User savedUser = userRepository.save(userToSave);

        // 2. Lógica de Skills (usando los campos del DTO)
        if (userDto.getLearningSkillName() != null && !userDto.getLearningSkillName().isEmpty()) {
            skillRepository.findByNameSkills(userDto.getLearningSkillName()).ifPresent(skill -> {
                UserSkill us = saveUserSkill(savedUser, skill, "LEARN", null);
                savedUser.getUserSkills().add(us); 
            });
        }
        if (userDto.getTeachingSkillName() != null && !userDto.getTeachingSkillName().isEmpty()) {
            skillRepository.findByNameSkills(userDto.getTeachingSkillName()).ifPresent(skill -> {
                UserSkill us = saveUserSkill(savedUser, skill, "TEACH", userDto.getTeachingSkillLevel());
                savedUser.getUserSkills().add(us);
            });
        }

        // 3. Mapear la entidad guardada de vuelta a un DTO para la respuesta
        return toDto(savedUser);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));

        // 1. Actualizar campos
        if (userDto.getName() != null) {
            existingUser.setName(userDto.getName());
        }
        if (userDto.getAboutMe() != null) {
            existingUser.setAboutMe(userDto.getAboutMe());
        }
        if (userDto.getPhotoUrl() != null) {
            existingUser.setPhotoUrl(userDto.getPhotoUrl());
        }

        // 2. Lógica de Skills
        List<UserSkill> skillsToRemove = new ArrayList<>();
        
        // Si el DTO trae un "learningSkillName", borramos el "LEARN" anterior
        if (userDto.getLearningSkillName() != null) {
            skillsToRemove.addAll(
                existingUser.getUserSkills().stream()
                    .filter(us -> "LEARN".equals(us.getType()))
                    .collect(Collectors.toList())
            );
        }
        // Si el DTO trae un "teachingSkillName", borramos el "TEACH" anterior
        if (userDto.getTeachingSkillName() != null) {
            skillsToRemove.addAll(
                existingUser.getUserSkills().stream()
                    .filter(us -> "TEACH".equals(us.getType()))
                    .collect(Collectors.toList())
            );
        }

        existingUser.getUserSkills().removeAll(skillsToRemove);
        userSkillRepository.deleteAllInBatch(skillsToRemove);

        // 3. CREAR nuevas habilidades
        if (userDto.getLearningSkillName() != null && !userDto.getLearningSkillName().isEmpty()) {
            skillRepository.findByNameSkills(userDto.getLearningSkillName()).ifPresent(skill -> {
                UserSkill us = saveUserSkill(existingUser, skill, "LEARN", null);
                existingUser.getUserSkills().add(us); 
            });
        }
        if (userDto.getTeachingSkillName() != null && !userDto.getTeachingSkillName().isEmpty()) {
            skillRepository.findByNameSkills(userDto.getTeachingSkillName()).ifPresent(skill -> {
                UserSkill us = saveUserSkill(existingUser, skill, "TEACH", userDto.getTeachingSkillLevel());
                existingUser.getUserSkills().add(us);
            });
        }
        
        User updatedUser = userRepository.save(existingUser);
        
        // 4. Mapear de vuelta a DTO
        return toDto(updatedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::toDto);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
        userRepository.deleteById(id);
    }
    
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Método helper para crear y guardar la relación UserSkill
     */
    private UserSkill saveUserSkill(User user, Skill skill, String type, String experienceLevel) {
        UserSkillId userSkillId = new UserSkillId(user.getId(), skill.getSkillId());
        UserSkill userSkill = new UserSkill();
        userSkill.setId(userSkillId);
        userSkill.setUser(user);
        userSkill.setSkill(skill);
        userSkill.setType(type);
        if ("TEACH".equals(type)) {
            userSkill.setExperienceLevel(experienceLevel);
        }
        return userSkillRepository.save(userSkill);
    }

    /**
     * Convierte una entidad User a un UserDto
     */
    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setBirthDate(user.getBirthDate());
        dto.setPhotoUrl(user.getPhotoUrl());
        dto.setAboutMe(user.getAboutMe());
        dto.setRating(user.getRating());
        dto.setNumReviewers(user.getNumReviewers());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setUserSkills(user.getUserSkills()); 
        return dto;
    }
}