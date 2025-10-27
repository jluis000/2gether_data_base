package com.twogether.app.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Messages")
public class Message {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;
	private LocalDateTime shippingDate;
	
	public Message () {} //Constructor sin parametros

	public Message(Long id, String message, LocalDateTime shippingDate) {
		this.message = message;
		this.shippingDate = shippingDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(LocalDateTime shippingDate) {
		this.shippingDate = shippingDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", message=");
		builder.append(message);
		builder.append(", shippingDate=");
		builder.append(shippingDate);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message, shippingDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(id, other.id) && Objects.equals(message, other.message)
				&& Objects.equals(shippingDate, other.shippingDate);
	}
}
	