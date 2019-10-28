package com.admin.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.user.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{
	State findByName(String name);
}
