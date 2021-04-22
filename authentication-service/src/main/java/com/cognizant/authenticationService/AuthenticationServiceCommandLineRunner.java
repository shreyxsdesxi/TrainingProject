package com.cognizant.authenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.authenticationService.model.User;
import com.cognizant.authenticationService.repository.UserRepository;

@Component
public class AuthenticationServiceCommandLineRunner implements CommandLineRunner{

	@Autowired UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
		user.setUsername("shreyas");
		user.setPassword("password");
		userRepository.save(user);
		
		User user1 = new User();
		user1.setUsername("harvey");
		user1.setPassword("password");
		userRepository.save(user1);

		
	}

}
