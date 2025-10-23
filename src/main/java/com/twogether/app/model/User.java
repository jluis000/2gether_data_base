  package com.twogether.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;
	@Column(name = "password", length= 255,  nullable = false)
	private String password;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
	@Column(name = "country", length = 100, nullable = false)
	private String country;
	@Column(name = "photo_url", length= 255, nullable = true)
	private String photoUrl;
	@Column(name = "about_me", length= 255, nullable = true)
	private String aboutMe;
	@Column(name = "rating", nullable = true)
	private Double rating = 0.0;
	@Column(name = "num_reviewers", nullable = true)	
	private Long numReviewers = 0L;
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<UserSkill> userSkills = new ArrayList<>();
	
	public User() {}

	public User(Long id, String name, String email, String password, LocalDate birthDate, String country,
			String photoUrl, String aboutMe, Double rating, Long numReviewers, LocalDateTime createdAt,
			LocalDateTime updatedAt, List<UserSkill> userSkills) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.country = country;
		this.photoUrl = photoUrl;
		this.aboutMe = aboutMe;
		this.rating = rating;
		this.numReviewers = numReviewers;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userSkills = userSkills;
	}
	
	public User(String name, String email, String password, LocalDate birthDate, String country, String photoUrl, String aboutMe,
			Double rating, Long numReviewers, LocalDateTime createdAt, LocalDateTime updatedAt, List<UserSkill> userSkills) {
		this(null, name, email, password, birthDate, country, photoUrl, aboutMe, rating, numReviewers, null, null, userSkills);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", birthDate="
				+ birthDate + ", country=" + country + ", photoUrl=" + photoUrl + ", aboutMe=" + aboutMe + ", rating="
				+ rating + ", numReviewers=" + numReviewers + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", userSkills=" + userSkills + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aboutMe, birthDate, country, createdAt, email, id, name, numReviewers, password, photoUrl,
				rating, updatedAt, userSkills);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(aboutMe, other.aboutMe) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(country, other.country) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(numReviewers, other.numReviewers)
				&& Objects.equals(password, other.password) && Objects.equals(photoUrl, other.photoUrl)
				&& Objects.equals(rating, other.rating) && Objects.equals(updatedAt, other.updatedAt)
				&& Objects.equals(userSkills, other.userSkills);
	}
	
}
