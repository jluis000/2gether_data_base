package com.twogether.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twogether.app.model.UserSkill;
import com.twogether.app.model.UserSkillId;

public interface UserSkillRepository extends JpaRepository<UserSkill, UserSkillId>{
}
