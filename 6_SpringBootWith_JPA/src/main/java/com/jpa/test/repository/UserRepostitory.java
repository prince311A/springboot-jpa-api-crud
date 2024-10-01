package com.jpa.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpa.test.entity.User;

public interface UserRepostitory extends JpaRepository<User, Integer> {
	// custom finder
	public List<User> findByCity(String city);
	// find --> introducer
	// By--> criteria
	// Name --> property
// https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods.query-creation

	// Example to fetch user-name and password for logging
    // public User findByNameAndPassword(String name, String password);
	// findByNameStartingWith(String prefix)
	// findByNameEndingWith(String suffix)
	// findByNameContaining(String word)
	// findByNameLike(String likePattern)
	// findByAgeLessThan(int Age)
	// findByAgeGreaterThanEqual(int Age)
	// findByNameOrderBy(String name)
}
