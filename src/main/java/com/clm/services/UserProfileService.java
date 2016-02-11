package com.clm.services;

import java.util.List;

import com.clm.entities.Role;
import com.clm.entities.UserProfile;



public interface UserProfileService {

	Role findById(int id);

	Role findByType(String type);
	
	List<Role> findAll();
	
}
