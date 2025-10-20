package com.twogether.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twogether.app.model.Skill;
import com.twogether.app.service.SkillService;

@RestController
@RequestMapping("/api/v1/skills")
@CrossOrigin(origins = "*")
public class SkillController {
	
	private final SkillService skillService;

	public SkillController(SkillService skillService) {
		this.skillService = skillService;
	}
	
	@GetMapping
	ResponseEntity<Iterable<Skill>> GetAllSkills(){
		return ResponseEntity.ok(skillService.findAll());
	}
	
	
	
}
