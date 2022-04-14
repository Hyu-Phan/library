package com.elcom.library;

import com.elcom.library.entity.auth.Role;
import com.elcom.library.entity.auth.User;
import com.elcom.library.entity.lib.Book;
import com.elcom.library.repository.auth.RoleRepository;
import com.elcom.library.repository.auth.UserRepository;
import com.elcom.library.repository.lib.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@ComponentScan(basePackages = "com.elcom.library.**")
@EntityScan(basePackages = {"com.elcom.library.entity.auth.*", "com.elcom.library.entity.lib.*"})
@EnableCaching
public class LibraryApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void insertData(){
		for(int i = 0; i< 4; i++){
			Book book = new Book();
			book.setName("Habbit");
			book.setTime("1940");
			bookRepository.save(book);
		}

		for(int i = 0; i< 4; i++){
			User user = new User();
			user.setUsername("user");
			user.setPassword(passwordEncoder.encode("12345678"));
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepository.findByName("ROLE_ADMIN")
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
			roles.add(adminRole);
			user.setRoles(roles);
			userRepository.save(user);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception {
		insertData();
	}
}
