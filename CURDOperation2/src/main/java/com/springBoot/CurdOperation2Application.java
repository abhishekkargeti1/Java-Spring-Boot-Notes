package com.springBoot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springBoot.dao.userDao;
import com.springBoot.entities.UserDetails1;

@SpringBootApplication
public class CurdOperation2Application {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(CurdOperation2Application.class, args);
			userDao dao = con.getBean(userDao.class);
			UserDetails1 details = new UserDetails1();
			
			details.setName("Nikhil");
			details.setEmail("nikhil.kageti@gmail.com");
			details.setPassword("174482");
			details.setPhoneNumber("011-41056302");
			details.setStatus("Not Active");
			
			//UserDetails1 details1 = dao.save(details);
			//System.out.println("Details are "+details1);
			
			
			List<UserDetails1> dataRecived = dao.findByName("Abhishek");
			dataRecived.forEach(data->System.out.println("Data by Name "+data));
			
			

			List<UserDetails1> dataRecived1 = dao.findByEmailAndPassword("abhishek.kageti@gmail.com","1808");
			dataRecived1.forEach(data->System.out.println("Data by Email and Password "+data));
			

			List<UserDetails1> dataRecived2 = dao.findByPhoneNumber("011-41056302");
			dataRecived2.forEach(data->System.out.println("Data by PhoneNumber "+data));
			
			List<UserDetails1> dataRecived3 = dao.findByStatusEquals("Active");
			dataRecived3.forEach(data->System.out.println("Data by Status "+data));
			
			
	}

}
