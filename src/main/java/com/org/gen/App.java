package com.org.gen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        	System.out.println( "Hello World!" );
        
        	SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        	dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
        	dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        	dataSource.setUsername("root");
        	dataSource.setPassword("Sql#@9080");
        	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);



        	String sqlInsert = "INSERT INTO employee1 (id, name, salary)"
        	+ " VALUES (?, ?, ?)";
        	jdbcTemplate.update(sqlInsert, "123", "tom", "12345");



        	String sqlUpdate = "UPDATE employee1 set name=? where id=?";
        	jdbcTemplate.update(sqlUpdate, "tom", "123");



        	String sqlSelect = "SELECT * FROM employee1";
        	List<Employee1> listContact = jdbcTemplate.query(sqlSelect, new RowMapper<Employee1>() {



        	public Employee1 mapRow(ResultSet result, int rowNum) throws SQLException {
        	Employee1 employee1 = new Employee1();
        	employee1.setId(result.getInt("id"));
        	employee1.setName(result.getString("name"));
        	employee1.setSalary(result.getInt("salary"));
        	return employee1;
        	}



        	});
        	for(Employee1 e : listContact) {
        	System.out.println(e);
        	}
        	// String sqlDel = "delete from Employeewhere id=?";
        	//jdbcTemplate.update(sqlDel);
        	}
        	}

