package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.Entity.Student;
import com.demo.Repository.StudentRepository;

@SpringBootTest
class HibernateApplicationTests {

	@Autowired
	StudentRepository repo;
	
	@Test
	void test() {
		
		Student s= new Student();
		s.setName("arkeb");
		s.setCity("asansol");
		s.setEmail("arkeb11");
		
		repo.save(s);
		
		
	}
	
	
	
	@Test
	void getData()
	{
		Optional<Student> stud = repo.findById(1);
		
		Student s = stud.get();
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getCity());
		System.out.println(s.getEmail());
		
	}
	
	@Test
	void deleteData()
	{
		repo.deleteById(3);
	}
	
	@Test
	void updateData()
	{
		Optional<Student> stud = repo.findById(1);
		
		Student s2 = stud.get();
		s2.setName("updated");
		s2.setCity("kolkata");
		s2.setEmail("aryan@");
		repo.save(s2);
	}
	
	@Test
	void getData2()
	{
		Iterable<Student> findAll = repo.findAll();
		
		for(Student s3: findAll)
		{
			System.out.println(s3.getName());
			System.out.println(s3.getCity());
			System.out.println(s3.getEmail());
		}
	}

	@Test
	public void findBycity() 
	
	{
		
		Iterable<Student> student = repo.findByCity("kolkata");
		
		for (Student s1 : student) 
		{
			System.out.println(s1.getName());
			System.out.println(s1.getEmail());
			
		}
		
	}
	
	@Test
	public void findByemail()
	{
		Optional<Student> findByemail = repo.findByEmail("ankit@q");
		Student s = findByemail.get();
		System.out.println(s.getName());
		System.out.println(s.getCity());
	}
	
	
}
