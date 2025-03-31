package com.springBoot;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springBoot.dao.UserDao;
import com.springBoot.entities.UserDetails;

@SpringBootApplication
public class CurdOperationApplication {

	public static void main(String[] args) {
		ApplicationContext con = SpringApplication.run(CurdOperationApplication.class, args);
		UserDao dao = con.getBean(UserDao.class);
		UserDetails user = new UserDetails();
		// Insert operation
		/*
		 * UserDetails details = new UserDetails(); details.setName("Abhishek");
		 * details.setEmail("abhishek.kargeti@gmail.com"); details.setPassword("1808");
		 * details.setAddress("Delhi"); details.setStatus("Active");
		 * 
		 * 
		 * 
		 * UserDetails details2 = new UserDetails(); details2.setName("NIkhil");
		 * details2.setEmail("nikhil.kargeti@gmail.com"); details2.setPassword("9495");
		 * details2.setAddress("Mumbai"); details2.setStatus("Not-Active");
		 * 
		 * List<UserDetails> user = List.of(details,details2); Iterable<UserDetails>
		 * result = dao.saveAll(user); for(UserDetails r1:result) {
		 * System.out.println("Result is "+r1); }
		 */

		// Update Operation

		/*
		 * Optional<UserDetails> userDetails = dao.findById(1);
		 * 
		 * UserDetails detailsRecived = userDetails.get();
		 * System.out.println("Details Reviced "+detailsRecived);
		 * detailsRecived.setName("Ramesh"); UserDetails updateDetails =
		 * dao.save(detailsRecived);
		 * System.out.println("Updated Details Reviced "+updateDetails);
		 */

		// Select Operation

		/*
		 * Optional<UserDetails> details = dao.findById(1);
		 * 
		 * System.out.println("Details By Id " + details);
		 * 
		 * Iterable<UserDetails> details1 = dao.findAll(); for (UserDetails d :
		 * details1) { System.out.println("Details " + d); }
		 */

		// Delete Operation
		
		//dao.deleteById(1);
		/*
		 * Iterable<UserDetails> allData = dao.findAll();
		 * allData.forEach(user1->System.out.println(user1)); dao.deleteAll();
		 */
	}

}
