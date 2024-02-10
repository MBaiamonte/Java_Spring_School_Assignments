package com.matthewbaiamonte.javaexam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.matthewbaiamonte.javaexam.models.LoginUser;
import com.matthewbaiamonte.javaexam.models.User;
import com.matthewbaiamonte.javaexam.repositories.UserRepository;



@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User register(User newUser, BindingResult result) {     // This method will be called from the controller whenever a user submits a registration form.
    	// Reject values or register if no errors:
        Optional<User> potentialUser=userRepository.findByEmail(newUser.getEmail());
        if (potentialUser.isPresent()) {  // Reject if email is taken (present in database)
        	result.rejectValue("email", "Matches", "Choose a different Email");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) { // Reject if password doesn't match confirmation
        	result.rejectValue("confirm", "Matches", "Passwords Must Match");
        }
        if(result.hasErrors()) {  // Return null if result has errors
        	return null;
        }
        String hashed=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());  // Hash and set password, save user to database
        newUser.setPassword(hashed);
        return this.userRepository.save(newUser);
    }//end registration

    public User login(LoginUser newLoginObject, BindingResult result) { // This method will be called from the controller whenever a user submits a login form.
        Optional<User> potentialUser=userRepository.findByEmail(newLoginObject.getEmail()); // Find user in the DB by email
        if (potentialUser.isPresent()) {  // Reject if NOT present
        	User user = potentialUser.get();//set to pull password for email entered from db to compare
        	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
        		result.rejectValue("email", "Matches", "Invalid Password or Email"); // Reject if BCrypt password match fails
        	}
        	return user;  // Otherwise, return the user object
        }//end first authentication if block
        else {
        	result.rejectValue("email", "Matches", "Invalid Password or Email");
        	return null;  // Return null if result has errors
        }
    }//end login
        
        public User findById(Long id) {
        	return this.userRepository.findById(id).orElse(null);
        }

 
}//End Service
