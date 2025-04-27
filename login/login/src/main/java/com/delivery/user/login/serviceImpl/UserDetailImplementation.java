package com.delivery.user.login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.delivery.user.login.entity.User;
import com.delivery.user.login.repository.UserRepository;

public class UserDetailImplementation implements UserDetailsService
{
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		if(username==null)
		{
			throw new UsernameNotFoundException("User not found !!");
		}
		
		User user= repo.getUserByUsername(username);
		customUserdetails userdetails = new customUserdetails(user);
		 return userdetails;
	}

}
