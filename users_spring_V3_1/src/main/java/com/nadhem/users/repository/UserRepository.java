package com.nadhem.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nadhem.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

		User findByUsername(String username);

}
