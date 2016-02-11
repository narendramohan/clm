package com.clm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.clm.entities.Role;
import com.clm.entities.UserProfile;




@Repository("Role")
public class UserProfileDaoImpl extends AbstractDao<Integer, Role>implements UserProfileDao{

	public Role findById(int id) {
		return getByKey(id);
	}

	public Role findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (Role) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<Role>)crit.list();
	}
	
}
