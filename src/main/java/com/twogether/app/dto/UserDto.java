package com.twogether.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.twogether.app.model.UserSkill;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;
    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    private String password;
    private LocalDate birthDate;
    private String photoUrl;
    private String aboutMe;
    private Double rating;
    private Long numReviewers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<UserSkill> userSkills;
    private String learningSkillName;
    private String teachingSkillName;
    private String teachingSkillLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getNumReviewers() {
        return numReviewers;
    }

    public void setNumReviewers(Long numReviewers) {
        this.numReviewers = numReviewers;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<UserSkill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<UserSkill> userSkills) {
        this.userSkills = userSkills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLearningSkillName() {
        return learningSkillName;
    }

    public void setLearningSkillName(String learningSkillName) {
        this.learningSkillName = learningSkillName;
    }

    public String getTeachingSkillName() {
        return teachingSkillName;
    }

    public void setTeachingSkillName(String teachingSkillName) {
        this.teachingSkillName = teachingSkillName;
    }

    public String getTeachingSkillLevel() {
        return teachingSkillLevel;
    }

    public void setTeachingSkillLevel(String teachingSkillLevel) {
        this.teachingSkillLevel = teachingSkillLevel;
    }
}