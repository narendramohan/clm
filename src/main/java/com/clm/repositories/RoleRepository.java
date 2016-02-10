package com.clm.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clm.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}
