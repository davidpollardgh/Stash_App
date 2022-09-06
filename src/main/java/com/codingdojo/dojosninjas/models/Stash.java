package com.codingdojo.dojosninjas.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Stash {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Item name is required")
	private String stashItem;
	
	@NotEmpty(message="Room is required")
	private String stashRoom;
	
	@NotEmpty(message="Location are required")
	@Size(min = 5, message = "Location must be at least 5 characters")
	private String stashLocation;
	
	private String stashNotes;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date updatedAt;
	
	@PreUpdate
	public void onUpdate() {
		updatedAt = new Date();
	}
	
// Setters and Getters

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStashItem() {
		return stashItem;
	}

	public void setStashItem(String stashItem) {
		this.stashItem = stashItem;
	}

	public String getStashLocation() {
		return stashLocation;
	}

	public void setStashLocation(String stashLocation) {
		this.stashLocation = stashLocation;
	}
	
	public String getStashRoom() {
		return stashRoom;
	}

	public void setStashRoom(String stashRoom) {
		this.stashRoom = stashRoom;
	}

	
	public String getStashNotes() {
		return stashNotes;
	}

	public void setStashNotes(String stashNotes) {
		this.stashNotes = stashNotes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
//  Blank constructor
	public Stash() {
	}
}
