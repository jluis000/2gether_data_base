package com.twogether.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twogether.app.model.UserSkill;

import com.twogether.app.service.UserSkillService;

@RestController
@RequestMapping("/api/v1/user/skills")
@CrossOrigin(origins = "*")
public class UserSkillController {
	private final UserSkillService userSkillService;


	public UserSkillController(UserSkillService userSkillService) {
		this.userSkillService = userSkillService;
	}

	@GetMapping
	ResponseEntity<Iterable<UserSkill>> GetAllUsersSkills() {
		return ResponseEntity.ok(userSkillService.findAll());
	}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserSkill>> getSkillsByUser(@PathVariable Long userId) {
    	List<UserSkill> skills = userSkillService.getUserSkills(userId);
        return skills.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(skills);
    }
    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<UserSkill>> getUsersBySkill(@PathVariable Long skillId) {
    	List<UserSkill> users = userSkillService.getUsersBySkill(skillId);
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }



	@PostMapping
	ResponseEntity<UserSkill> createUserSkill(@RequestBody UserSkill userSkill) {
		UserSkill createdSkill = userSkillService.save(userSkill);
		return ResponseEntity.status(201).body(createdSkill);
	}
	
	
}
