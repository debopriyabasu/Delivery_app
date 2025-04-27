package com.delivery.user.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.user.login.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
	public User getUserByUsername(String username);

	public boolean existsByEmail(String email);
	

	

}