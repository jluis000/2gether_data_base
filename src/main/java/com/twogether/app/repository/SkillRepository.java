package com.twogether.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twogether.app.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
	Optional<Skill> findByNameSkills(String nameSkills);
}
