package edu.jsp.user_application.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jsp.user_application.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//save(User u);
	//findById(Integer i);
	//findAll();
	//delete(user u);
	//deleteById(Integer i);
	
	User findByEmail(String email);
	
	//Named Parameter
	//@Query(value = "select u from User u where u.dob between :st and :end")
	//List<User> fetchByDob(@Param("st") LocalDate start,@Param("end") LocalDate end);
	
	//Positional parameter
	//@Query(value = "select u from User u where u.dob between ?1 and ?2")
	//List<User> fetchByDob(LocalDate start, LocalDate end);
	
	List<User> findByDobBetween(LocalDate st,LocalDate end);
}
