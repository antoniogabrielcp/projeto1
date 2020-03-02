package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("Gabriel Carvalho", "antoniogabrielcp@gmal.com");
			createUser("Teste1", "teste1@teste.com");
			createUser("Teste2", "teste2@teste.com");
					
		}
		
		User user = userRepository.getOne(2L);
		System.out.println(user.getName());
		
		User user2 = userRepository.findByName("Teste2");
		System.out.println(user2.getName());
		
		User user3 = userRepository.findByQualquerCoisa("Gab");
		System.out.println(user3.getName());
	}
	
	public void createUser(String name, String email) {
		User user = new User(name, email);
		
		userRepository.save(user);
	}

}
