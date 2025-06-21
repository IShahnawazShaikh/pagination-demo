package com.example.pagination;

import com.example.pagination.entity.StudentEntity;
import com.example.pagination.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PaginationApplication implements CommandLineRunner {

   @Autowired
   private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
         List<StudentEntity> studentEntityList = new ArrayList<>();
		 studentEntityList.add(StudentEntity.builder()
				 .name("Luffy")
				 .city("Goa").build());

		 studentEntityList.add(StudentEntity.builder()
				 .name("Shanks")
				 .city("Lougetown").build());

		 studentEntityList.add(StudentEntity.builder()
				 .name("Zoro")
				 .city("Wano").build());

		 studentEntityList.add(StudentEntity.builder()
				 .name("Sanji")
				 .city("whole cake").build());
		 studentEntityList.add(StudentEntity.builder()
				 .name("Loki")
				 .city("Elbaf").build());
		studentEntityList.add(StudentEntity.builder()
				.name("SpongeBob")
				.city("US").build());

		studentEntityList.add(StudentEntity.builder()
				.name("Tom")
				.city("India").build());

		studentEntityList.add(StudentEntity.builder()
				.name("Jerry")
				.city("India").build());
		studentEntityList.add(StudentEntity.builder()
				.name("Mickey Mouse")
				.city("Thailand").build());
		studentEntityList.add(StudentEntity.builder()
				.name("Pooh")
				.city("Thailand").build());

		studentEntityList.add(StudentEntity.builder().name("Doremon").city("China").build());
		studentEntityList.add(StudentEntity.builder().name("chota bhim").city("India").build());
		studentEntityList.add(StudentEntity.builder().name("Ash").city("Thailand").build());
		studentEntityList.add(StudentEntity.builder().name("Popeye").city("Scotland").build());
		studentEntityList.add(StudentEntity.builder().name("Shinchan").city("China").build());
		studentEntityList.add(StudentEntity.builder().name("Johnny Bravo").city("US").build());
		studentEntityList.add(StudentEntity.builder().name("Scooby Doo").city("US").build());
		studentEntityList.add(StudentEntity.builder().name("Korra").city("China").build());

        studentRepository.deleteAll();
		studentRepository.saveAll(studentEntityList);

	}
}
