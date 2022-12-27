package com.ippon.hexagonal;

import com.ippon.hexagonal.domain.model.Student;
import com.ippon.hexagonal.infrastructure.secondary.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class HexagonalApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(HexagonalApplication.class, args);
//	}

//	 Local test
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(HexagonalApplication.class, args);

		StudentRepository studentRepository = configurableApplicationContext.getBean(StudentRepository.class);

		studentRepository.saveAll(List.of(
				new Student("Steave", "ssun@ippon.fr", LocalDate.of(2020, 12, 7), "Paris"),
				new Student("Michael", "michael@ippon.fr", LocalDate.of(1990, 12, 7), "London"),
				new Student("John", "john@ippon.fr", LocalDate.of(1997, 12, 7), "Paris")
		));
	}

}
