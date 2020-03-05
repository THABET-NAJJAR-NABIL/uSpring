package com.springBoot.uSpring.User;

import com.springBoot.uSpring.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
        Optional<User> findByUserName(String userName);
}
