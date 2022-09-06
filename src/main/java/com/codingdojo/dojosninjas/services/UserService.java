package com.codingdojo.dojosninjas.services;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.dojosninjas.repositories.UserRepository;
import com.codingdojo.dojosninjas.models.LoginUser;
import com.codingdojo.dojosninjas.models.User;


@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;

	public void login(LoginUser loginUser) {
	}
	
	public User login(LoginUser loginUser,BindingResult res)
	{

		User db_user=userRepository.findByEmail(loginUser.getEmail());
		if(db_user==null)
		{
			res.rejectValue("email","email_not_found","Invalid Email");
			return null;
		}
		boolean ismatch=BCrypt.checkpw(loginUser.getPassword(), db_user.getPassword());
		if(!ismatch)
		{
			res.rejectValue("password","invalid_password","Password is invalid.");
			return null;
		}
		return db_user;
	}

	public void register() {
		
	}
	
	public User register(User user, BindingResult res)
	{

		if(userRepository.findByEmail(user.getEmail())!=null)
		{
			res.rejectValue("email","email_invalid","A user with this email already exists.");
			return null;
		}
		if(!user.getPassword().equals(user.getConfirm()))
		{
			res.rejectValue("password","pass_no_match","Password and Password Confirmation must match.");
			res.rejectValue("confirm","pass_no_match","Password and Password Confirmation must match.");
			return null;
		}
		
		String form_password=user.getPassword();		
		String hash=BCrypt.hashpw(form_password,BCrypt.gensalt(8));
		user.setPassword(hash);
		userRepository.save(user);
		return user;
	}

//	public User findByEmail(String email) {
//		return userRepository.findByEmail("email");
//	}
	
	public void logout(HttpSession session) {
		if(session.getAttribute("user")!=null)
		{
			session.removeAttribute("user");			
		}
	}
}

    
