package com.clm.dao;

import java.util.List;

import com.clm.entities.Role;
import com.clm.entities.UserProfile;



public interface UserProfileDao {

	List<Role> findAll();
	
	Role findByType(String type);
	
	Role findById(int id);
}
