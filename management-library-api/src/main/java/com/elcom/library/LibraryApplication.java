package com.elcom.library;

import com.elcom.library.entity.lib.Book;
import com.elcom.library.repository.auth.UserRepository;
import com.elcom.library.repository.lib.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.elcom.library.**")
@EntityScan(basePackages = {"com.elcom.library.entity.auth.*", "com.elcom.library.entity.lib.*"})
public class LibraryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
}
