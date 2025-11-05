package edu.jsp.user_application.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.user_application.Entity.User;
import edu.jsp.user_application.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User u){
		return service.saveUser(u);
	} 
	
	@GetMapping("/getById")
	public User getById(@RequestParam int id) {
		return service.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		return service.getAll();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestParam int id,@RequestBody User u) {
		return service.updateUser(id, u);
	}
	
	@GetMapping("/getByEmail/{email}")
	public User fetchByEmail(@PathVariable String email) {
		return service.fetchByEmail(email);
	}
	
	@GetMapping("/getDob")
	public List<User> getAllUserByDob(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate st,@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate end){
		return service.getAllUserByDob(st, end);
	}
}
