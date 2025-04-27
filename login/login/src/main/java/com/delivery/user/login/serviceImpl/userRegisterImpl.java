package com.delivery.user.login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.delivery.user.login.entity.User;
import com.delivery.user.login.repository.UserRepository;
import com.delivery.user.login.service.UserRegister;

@Service
public class userRegisterImpl implements UserRegister
{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean register(User user)
	{
		  if (userRepo.existsByEmail(user.getEmail())) {
		        throw new IllegalArgumentException("User already registered with this email");
		    }
		
		
		User userobj= new User();
		userobj.setUsername(user.getUsername());
		
		userobj.setEmail(user.getEmail());
		userobj.setPassword(passwordEncoder.encode(user.getPassword()));
		
		 userobj.setContactno(user.getContactno());
	        userobj.setAddress(user.getAddress());

	        // Set default role if not provided
	        userobj.setRole(user.getRole() != null ? user.getRole() : "USER");

	     User saveobj=  userRepo.save(userobj);
	     
	     if(saveobj == null)
	    	 return false;
	     
		// TODO Auto-generated method stub
		return true;
	}
	

}
