package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return argg->{
            Student jon = new Student("Jon", LocalDate.of(2000, Month.JANUARY,5),"jondoe@mail.com");
            Student john = new Student("John", LocalDate.of(2001, Month.FEBRUARY,7),"johndoe@mail.com");
            repository.saveAll(List.of(jon,john));
        };


    }
}
