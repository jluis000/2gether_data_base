package com.twogether.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.twogether.app.model.Skill;

import com.twogether.app.repository.SkillRepository;
import com.twogether.app.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	private final SkillRepository skillRepository;

	public SkillServiceImpl(SkillRepository skillRepository) {
		super();
		this.skillRepository = skillRepository;
	}

	@Override
	public Skill save(Skill skill) {

		return skillRepository.save(skill);
	}

	@Override
	public Skill findById(Long id) {
		Optional<Skill> skillOptional = skillRepository.findById(id);
		if (skillOptional.isEmpty()) {
			throw new IllegalStateException("Skill does not exist with id " + id);
		}

		return skillOptional.get();
	}

	@Override
	public Iterable<Skill> findAll() {
		// TODO Auto-generated method stub
		return skillRepository.findAll();
	}

	@Override
	public Skill update(Long id, Skill skill) {

		Optional<Skill> skillOptional = skillRepository.findById(id);
		if (skillOptional.isEmpty()) {
			throw new IllegalStateException("Skill does not exist with id " + id);
		}
		Skill newSkill = skillOptional.get();

		newSkill.setDescription(skill.getDescription());
		newSkill.setNameSkills(skill.getNameSkills());

		return skillRepository.save(newSkill);
	}

	@Override
	public void deleteByID(Long id) {
		// TODO Auto-generated method stub
		Optional<Skill> skillOptional = skillRepository.findById(id);
		if (skillOptional.isEmpty()) {
			throw new IllegalStateException("Role does not exist with id " + id);
		}
		Skill existingSkill = skillOptional.get(); // 

		skillRepository.delete(existingSkill);

	}

}
