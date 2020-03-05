package com.springBoot.uSpring;

import com.springBoot.uSpring.Comments.CommentRepository;
import com.springBoot.uSpring.User.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, CommentRepository.class})
public class USpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(USpringApplication.class, args);
	}

}
