package com.springBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springBoot.entities.UserDetails;

public interface UserDao extends CrudRepository<UserDetails, Integer> {

	public List<UserDetails> findByName(String name);

	@Query("select u from UserDetails u")
	public List<UserDetails> getAllUser();
	
	@Query("select u from UserDetails u where u.status =:s")
	public List<UserDetails> getUserByStatus(@Param("s") String  status);
	
	@Query(value = "SELECT email FROM data WHERE id = ?1", nativeQuery = true)
	String getEmail(String id);
	
}
