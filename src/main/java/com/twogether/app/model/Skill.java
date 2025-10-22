package com.twogether.app.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Skills")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skills_id")
	private Long skillId;
	@Column(name = "name_skills", length = 100)
	private String nameSkills;
	@Column(name = "description", columnDefinition  = "TEXT")
	private String description;
	
	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	public String getNameSkills() {
		return nameSkills;
	}
	public void setNameSkills(String nameSkills) {
		this.nameSkills = nameSkills;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, nameSkills, skillId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return Objects.equals(description, other.description) && Objects.equals(nameSkills, other.nameSkills)
				&& Objects.equals(skillId, other.skillId);
	}
	
	
	
}

