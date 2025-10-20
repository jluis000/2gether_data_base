package com.twogether.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twogether.app.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
