package com.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
	Users findByUsernameAndEmail(String username, String email);
	
	@Transactional
	@Modifying
	@Query("UPDATE Users u SET u.password = :pwd WHERE u.id = :id ")
	void updateById(@Param("pwd") String password, @Param("id") long id);
}
