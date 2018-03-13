package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
	
	@Autowired
	UsersRepository usersRepository;
	
	//get all users
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users")
	public List<Users> getAllNames(){
    	List<Users> allUsers = usersRepository.findAll();
		return allUsers;
    }
	
	//add a new user
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/signup")
    public boolean createGreeting(@RequestBody Users user) {
    	return usersRepository.save(user) != null;
    }
		
	//check for log in
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public boolean checkUser(@RequestBody Users new_user) {
		Users user = usersRepository.findByUsername(new_user.getUsername());
		if(user.getPassword().equals(new_user.getPassword())) return true;
		else return false;
	}

	//get data about single user
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user/{name}")
	public Users getUser(@PathVariable String name) {
		Users user = usersRepository.findByUsername(name);
		return user;
	}
	
	//update data of one single user
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/changePwd")
	public Users updateUser(@RequestBody Users new_user) {
		Users user = usersRepository.findByUsernameAndEmail(new_user.getUsername(), new_user.getEmail());
		if(user != null) usersRepository.updateById(new_user.getPassword(),user.getEmail());
		return user;
	}
	
}
