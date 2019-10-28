package com.admin.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.admin.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>	{
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
	
	@Query(value = "Select u from User u "
			+ "where UPPER(u.username) LIKE UPPER(CONCAT('%', :filter, '%')) "
			//+ "where UPPER(u.names) LIKE UPPER(CONCAT('%', :filter, '%')) "
			//+ "OR UPPER(u.lastNames) LIKE UPPER(CONCAT('%', :filter, '%')) "
			//+ "OR UPPER(u.email) LIKE UPPER(CONCAT('%', :filter, '%')) "
			)
	Page<User> findAllByFiltersAndPage(@Param("filter") String filter,
			Pageable pageable);
	
}
