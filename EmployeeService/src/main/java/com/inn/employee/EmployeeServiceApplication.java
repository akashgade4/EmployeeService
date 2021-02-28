package com.inn.employee;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.inn.employee.dao.EmployeeDao;
import com.inn.employee.model.Employee;

@SpringBootApplication
@EnableJpaRepositories("com.inn.employee.dao")
@EntityScan("com.inn.employee.model")
public class EmployeeServiceApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	Environment environment;

	@Autowired
	EmployeeDao systemRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Our DataSource is = " + environment.getProperty("spring.datasource.url"));
		System.out.println("Our DataSource is = " + dataSource);
		Iterable<Employee> systemlist = systemRepository.findAll();
		for (Employee systemmodel : systemlist) {
			System.out.println("Here is a system: " + systemmodel.toString());
		}

	}

}
