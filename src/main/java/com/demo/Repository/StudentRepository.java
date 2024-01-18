package com.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.demo.Entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	Iterable<Student> findByCity(String city);
	
	Optional<Student>findByEmail(String email);
}
