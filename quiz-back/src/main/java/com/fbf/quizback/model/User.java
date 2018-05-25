package com.fbf.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter

@Entity
public class User {
	@Id
	@GeneratedValue
	private int idUser;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_USER)
	private List<Result> results;
	
	
}
