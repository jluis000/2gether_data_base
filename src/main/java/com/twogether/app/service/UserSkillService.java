package com.twogether.app.service;

import java.util.List;

import com.twogether.app.model.UserSkill;

public interface UserSkillService {
	UserSkill save(UserSkill userSkill);
	
	UserSkill findById(Long id);
	
	Iterable<UserSkill> findAll(
			
			);
	
	UserSkill update(Long id, UserSkill user);
	
	void deleteById(Long id);
	
	List<UserSkill> getUserSkills(Long userId);
	List<UserSkill> getUsersBySkill(Long skillId);
}
