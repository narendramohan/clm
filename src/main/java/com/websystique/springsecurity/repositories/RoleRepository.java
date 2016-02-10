package com.websystique.springsecurity.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websystique.springsecurity.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}
