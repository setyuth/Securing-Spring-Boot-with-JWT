package com.springbootjwp.springbootjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Authorize {

	private String userName;
	private String password;
}
