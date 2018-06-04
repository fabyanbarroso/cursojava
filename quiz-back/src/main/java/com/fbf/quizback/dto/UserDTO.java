package com.fbf.quizback.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUser;
	private String name;
	private String email;
}
