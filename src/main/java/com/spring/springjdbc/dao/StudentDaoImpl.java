package com.spring.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.springjdbc.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		 //insert query
        String query = "insert into student(id,name,city) values(?,?,?)";
        int update = jdbcTemplate.update(query,new Object[] {student.getId(),student.getName(),student.getCity()});
		return update;
	}
	

	@Override
	public int update(Student student) {
		String query = "update student set name=? ,city=? where id=?";
		int update = this.jdbcTemplate.update(query,new Object[] {student.getName(),student.getCity(),student.getId()});
		return update;
	}
	
	@Override
	public Student getStudent(int id) {
		String query = "select * from student where id=?";
		RowMapperImpl rowMapperImpl = new RowMapperImpl();
        Student queryForObject = this.jdbcTemplate.queryForObject(query, rowMapperImpl, id);
		return queryForObject;
	}
	
	

	@Override
	public List<Student> getAllStudents() {
		String query = "select * from student";
		RowMapperImpl rowMapperImpl = new RowMapperImpl();
		List<Student> studentList = this.jdbcTemplate.query(query, rowMapperImpl);
		return studentList;
	}
	
	

	@Override
	public int delete(int id) {
		String query = "delete from student where id=?";
		int delete = this.jdbcTemplate.update(query, new Object[] {id});
		return delete;
	}

	


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}




	








}
