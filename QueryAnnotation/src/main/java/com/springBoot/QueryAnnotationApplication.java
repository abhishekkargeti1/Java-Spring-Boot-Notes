package com.springBoot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.springBoot.dao.UserDao;
import com.springBoot.entities.UserDetails;

@SpringBootApplication
public class QueryAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(QueryAnnotationApplication.class, args);
			UserDao dao = con.getBean(UserDao.class);
			UserDetails details = new UserDetails();
			  List<UserDetails> allUser = dao.getAllUser();
			//allUser.forEach(user->System.out.println("User Details are "+user));
			
				List<UserDetails> result = dao.getUserByStatus("Not Active");
				System.out.println("Result is "+result);
				
				String email = dao.getEmail("1");
				System.out.println("Email is "+email);
	}

}
