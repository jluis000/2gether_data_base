package com.twogether.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="users_skills")
public class UserSkill {
	
    @EmbeddedId
    private UserSkillId id;

	@ManyToOne
    @MapsId("skillId")
	@JoinColumn(name = "skills_id")
	private Skill skill;
	
	@ManyToOne
    @MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;
	
	public UserSkillId getId() {
		return id;
	}
	public void setId(UserSkillId id) {
		this.id = id;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	public UserSkill(UserSkillId id, Skill skill, User user, String type, String experienceLevel) {
		super();
		this.id = id;
		this.skill = skill;
		this.user = user;
		this.type = type;
		this.experienceLevel = experienceLevel;
	}
	public UserSkill() {

	}
	@Column(name = "type", length = 50)
	private String type;
	@Column(name = "experience_level", length = 50)
	private String experienceLevel;
	
	
}
