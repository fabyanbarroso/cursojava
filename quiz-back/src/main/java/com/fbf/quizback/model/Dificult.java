package com.fbf.quizback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dificult {

	@Id
	@GeneratedValue
	private int idDificult;
	
	@Column
	private int dificult;
}
