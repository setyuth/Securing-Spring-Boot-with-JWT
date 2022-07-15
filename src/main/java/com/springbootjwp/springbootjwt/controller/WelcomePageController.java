package com.springbootjwp.springbootjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjwp.springbootjwt.entity.Authorize;
import com.springbootjwp.springbootjwt.util.service.JwtUtilService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class WelcomePageController {

	@Autowired
	private JwtUtilService jwtUtilService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/")
	public String welcomePage() {
		return "Welcome...!";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody Authorize authorize) throws Exception {
		
		try {
			System.out.println("Action in controller authenticat....");
			authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(authorize.getUserName(), authorize.getPassword())
					);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Invalid username/password");
		}
		
		return jwtUtilService.generateToken(authorize.getUserName());
		
	}
	
}
