package com.springBoot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.springBoot.dao.UserDao;
import com.springBoot.entities.UserDetails;

@SpringBootApplication
public class PracticesCustomFinderJpa1Application {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(PracticesCustomFinderJpa1Application.class, args);
		UserDao dao = con.getBean(UserDao.class);
		UserDetails details = new UserDetails();
		details.setName("RAM");
		details.setEmail("abhishek.kargeti@gmail.com");
		details.setPassword("1808");
		details.setStatus("Active");
		
		//UserDetails result = dao.save(details);
		//System.out.println("Result is "+result);
		List<UserDetails> detailsRecived = dao.findByName("RAM");
		detailsRecived.forEach(details1 ->System.out.println("Details are "+details1));
	}

	
}
