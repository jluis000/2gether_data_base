package com.twogether.app.service;

import com.twogether.app.model.Skill;

public interface SkillService {

	// ========= CRUD ============

	Skill save(Skill role);
	
	Skill findById(Long id);
	
	Iterable<Skill> findAll();
	
	Skill update(Long id, Skill role);
	
	void deleteByID(Long id);
	
}
