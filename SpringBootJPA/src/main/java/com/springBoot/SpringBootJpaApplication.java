package com.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.springBoot.dao.userDao;
import com.springBoot.entities.User;

@SpringBootApplication
@EntityScan("com.springBoot.entities")
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(SpringBootJpaApplication.class, args);
		userDao dao = con.getBean(userDao.class);
		User details = new User();
		details.setName("Abhishek");
		details.setCity("Delhi");
		details.setStatus("Active");
		
		User save = dao.save(details);
		System.out.println("User Details are "+save);
	}

}
