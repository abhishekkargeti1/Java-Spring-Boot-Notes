package com.springBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.entities.UserDetails;

@Service
public class UserService {

	private static List<UserDetails> list = new ArrayList<>();

	static {
		list.add(new UserDetails(1, "Abhishek Kargeti", 23, "abhishek.kargeti@gmail.com", "1808", "Not Active"));
		list.add(new UserDetails(2, "Nikhil Kargeti", 18, "nikhil.kargeti@gmail.com", "0258", "Active"));
		list.add(
				new UserDetails(3, "Meenakshi Kargeti", 53, "meenakshi.kargeti@gmail.com", "minu1234", "Super Active"));
		list.add(new UserDetails(4, "R.P Kargeti", 55, "raj.kargeti@gmail.com", "one12345@", "Super Active"));
	}

	public List<UserDetails> getAllUser() {
		System.out.println("All User Details");
		return list;
	}

	public UserDetails getUserById(int id) {

		UserDetails details = null;
		for (UserDetails d : list) {
			if (id == d.getId()) {
				details = d;
			}
		}
		return details;

	}
	
	public UserDetails addNewUser(UserDetails details) {
		
		list.add(details);
		return details;
	}
	
	
	public void updateUserDetailsById(int id,String name) {
		for(UserDetails d:list) {
			if(id == d.getId()) {
				d.setName(name);
			}
		}
	}
	
	
	
	public UserDetails updateDetailsById(int id,UserDetails details) {
		for(UserDetails d:list) {
			if(id==d.getId()) {
				d.setName(details.getName());
				d.setStatus(details.getStatus());
			}
		}
		return details;
	}
	
	
	public void deleteUser() {
			list.clear();
	}
	
	
	public void getUserDeleteById(int id) {
		list.removeIf(user -> user.getId() == id);
	}

}
