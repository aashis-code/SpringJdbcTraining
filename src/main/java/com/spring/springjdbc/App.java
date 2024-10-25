package com.spring.springjdbc;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.springjdbc.dao.StudentDaoImpl;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

//		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDaoImpl studentDao = context.getBean("studentDao", StudentDaoImpl.class);

		// Create Student object
		Student std = new Student();
		std.setId(117);
		std.setName("UpdateNepal");
		std.setCity("UpdateKathmandu");

		// Call insert method
//		int result = studentDao.insert(std);
//		System.out.println("the result is: "+ result);
		
//		int update = studentDao.update(std);
//		System.out.println("The student is updated :"+update);
		
//		int delete = studentDao.delete(113);
//		System.out.println("The student is deleted :"+delete);
		
		
//		Student student = studentDao.getStudent(112);
//		System.out.println(student);

		List<Student> allStudents = studentDao.getAllStudents();
		for (Student student : allStudents) {
			System.out.println(student);
		}
		

	}
}
