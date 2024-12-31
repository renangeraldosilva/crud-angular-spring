package com.loiane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;
import com.loiane.model.Course;
import com.loiane.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
        return args -> {
           courseRepository.deleteAll();

            Course c = new Course();
            c.setName("Angular com Spring"); 
            c.setCategory("front-end");

           courseRepository.save(c);
        };
    }
}
