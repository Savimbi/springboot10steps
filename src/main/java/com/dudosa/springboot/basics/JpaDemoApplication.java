package com.dudosa.springboot.basics;

import com.dudosa.springboot.basics.entity.Person;
import com.dudosa.springboot.basics.jdbc.PersonJdbcDao;
import com.dudosa.springboot.basics.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJpaRepository dao;

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		logger.info("All users ->{}", dao.findAll());
		logger.info("Users  id 10001->{}", dao.findById(10001));
////		logger.info("Deleted rows are: ->{}", dao.deleteById(10002));
	logger.info("Inserted rows are: ->{}", dao.insert( new Person(10004, "Tara","Berlin",new Date())));
	logger.info("Updated rows are: ->{}", dao.update( new Person(10003, "Kamana","Paris",new Date())));
	}
}
