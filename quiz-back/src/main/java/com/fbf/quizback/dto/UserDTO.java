package com.fbf.quizback.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserDTO implements Serializable{
	
	private String name;
	private String email;
}
