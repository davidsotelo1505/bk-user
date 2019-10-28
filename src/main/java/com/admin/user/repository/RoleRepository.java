package com.admin.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.user.model.Role;
import com.admin.user.model.State;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	State findByName(String name);
	
	
}
