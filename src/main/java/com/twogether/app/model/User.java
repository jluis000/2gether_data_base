package com.twogether.app.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(name = "country", length = 100, nullable = false)
	private String country;
	@Column(name = "photo_url", length= 255, nullable = true)
	private String photoUrl;
	@Column(name = "about_me", length= 255, nullable = false)
	private String aboutMe;
	@Column(name = "rating", nullable = true)
	private Long rating;
	@Column(name = "num_reviewers", nullable = true)	
	private Long numReviewers;
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
	/*
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserSkill> userSkills = new ArrayList<>();
	 */

	public User() {}
	
	public User(Long id, String name, String email, String password, String country, String photoUrl, String aboutMe,
			Long rating, Long numReviewers, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
		this.photoUrl = photoUrl;
		this.aboutMe = aboutMe;
		this.rating = rating;
		this.numReviewers = numReviewers;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", country=");
		builder.append(country);
		builder.append(", photoUrl=");
		builder.append(photoUrl);
		builder.append(", aboutMe=");
		builder.append(aboutMe);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", numReviewers=");
		builder.append(numReviewers);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(aboutMe, country, createdAt, email, id, name, numReviewers, password, photoUrl, rating,
				updatedAt);
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
		return Objects.equals(aboutMe, other.aboutMe) && Objects.equals(country, other.country)
				&& Objects.equals(createdAt, other.createdAt) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(numReviewers, other.numReviewers) && Objects.equals(password, other.password)
				&& Objects.equals(photoUrl, other.photoUrl) && Objects.equals(rating, other.rating)
				&& Objects.equals(updatedAt, other.updatedAt);
	}
}
