package com.fbf.quizback.dto;

import lombok.Data;

@Data
public class UserPostDTO extends UserDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
}