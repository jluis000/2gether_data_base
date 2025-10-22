package com.twogether.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.twogether.app.model.UserSkill;
import com.twogether.app.repository.UserSkillRepository;
import com.twogether.app.service.UserSkillService;


@Service
public class UserSkillServiceImpl implements UserSkillService {
	
	
	
	private final UserSkillRepository userSkillRepository;

	public UserSkillServiceImpl(UserSkillRepository userSkillRepository) {
		super();
		this.userSkillRepository = userSkillRepository;
	}

	@Override
	public UserSkill save(UserSkill userSkill) {
		return userSkillRepository.save(userSkill);
	}

	@Override
	public UserSkill findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserSkill> findAll() {
		// TODO Auto-generated method stub
		return userSkillRepository.findAll();
	}

	@Override
	public UserSkill update(Long id, UserSkill user) {
		return null;

	}



	@Override
	public List<UserSkill> getUserSkills(Long userId) {
		 return userSkillRepository.findByUser_UserId(userId);
	}

	@Override
	public List<UserSkill> getUsersBySkill(Long skillId) {
		// TODO Auto-generated method stub
		return userSkillRepository.findBySkill_SkillsId(skillId);
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
