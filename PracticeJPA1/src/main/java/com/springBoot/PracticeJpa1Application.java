package com.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.springBoot.dao.userDao;
import com.springBoot.entities.UserDetails;

@SpringBootApplication
public class PracticeJpa1Application {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(PracticeJpa1Application.class, args);
		userDao dao = con.getBean(userDao.class);
		UserDetails details = new UserDetails();
		details.setName("Abhishek kargeti");
		details.setEmail("abhishek.karegti@gmail.com");
		details.setPassword("1808");
		details.setPhoneNumber("964368742");
			UserDetails details1 = dao.save(details);
			System.out.println("Details are "+details1);
	}

}
