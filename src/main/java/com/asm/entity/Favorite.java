package com.asm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the favorites database table.
 * 
 */
@Entity
@Table(name="favorites")
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date likeDate;
	

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="videoId")
	private Video video;

	public Favorite() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLikeDate() {
		return this.likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}