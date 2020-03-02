package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(String name);
	
	@Query("select u from User u where u.name like %?1%")
	User findByQualquerCoisa(String name);

}
