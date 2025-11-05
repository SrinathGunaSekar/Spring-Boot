package edu.jsp.user_application.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.user_application.Entity.User;
import edu.jsp.user_application.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository repository;
	
	public User saveUser(User u){
		return repository.save(u);
	}
	
	public User getById(int id) {
		Optional<User> o =repository.findById(id);
		return o.isPresent()?o.get():null;
	}
	
	public List<User> getAll() {
		return repository.findAll();
	}
	
	public String deleteById(int id) {
		Optional<User> o =repository.findById(id);
		if(o.isPresent()) {
			User u = o.get();
			repository.delete(u);
			
			return "data deleted";
		}
		return "Id Not Found ";
	}
	
	public String updateUser(int id,User newUser) {
		Optional<User> o = repository.findById(id);
		
		if(o.isPresent()) {
			User existingUser = o.get();
			existingUser.setName(newUser.getName());
			existingUser.setEmail(newUser.getEmail());
			existingUser.setGender(newUser.getGender());
			existingUser.setDob(newUser.getDob());
			existingUser.setPhone(newUser.getPhone());
			
			repository.save(existingUser);
			
			return "Data updated";
			
		}
		return "Id Not Found";
	}
	
	public User fetchByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public List<User> getAllUserByDob(LocalDate st, LocalDate end){
		//return repository.fetchByDob(st,end);
		return repository.findByDobBetween(st, end);
	}
}
