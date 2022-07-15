package com.springbootjwp.springbootjwt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootjwp.springbootjwt.entity.User;
import com.springbootjwp.springbootjwt.repository.UserRepository;

@SpringBootApplication
public class SpringbootjwtApplication {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void UserInit() {
		List<User> users = Stream.of(
					new User(1, "khmerside", "123", "khmerside@mail.com"),
					new User(2, "chumkiri", "111", "chumkiri@mail.com")
				).collect(Collectors.toList());
		
		userRepository.saveAll(users);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootjwtApplication.class, args);
	}

}
