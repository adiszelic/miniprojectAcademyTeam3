package com.example.bankapp;

import com.example.demo.Bank;
import com.example.demo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class BankappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/customer")
	public ModelAndView customer(HttpSession session) {
		if(session.getAttribute("user")!= null) {
			return new ModelAndView("customer");
		}
		else
			return new ModelAndView("login");
	}

	@PostMapping("/loggedin")
	public String post(HttpSession session, @RequestParam String username, @RequestParam String password) {
		Bank thebank = getBank(session);



		List<User> users = thebank.getUsers();
		for (User u : users) {
			if (u.firstname.equals(username) && u.password.equals(password)) {
				session.setAttribute("user", username);
				return "customer";
			}
		} return "login";
	}

	private Bank getBank(HttpSession session) {
		Bank thebank = (Bank)session.getAttribute("bank");
		if (thebank == null){
			thebank = new Bank();
			session.setAttribute("bank", thebank);
		}
		return thebank;
	}


	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("login");
	}

	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@PostMapping("/registered")
	public String registered(HttpSession session, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String password){
		User newUser = new User(firstname, lastname, password);
		Bank thebank = getBank(session);
		boolean exist=false;

		for(User u: thebank.getUsers()){
			if(u.firstname.equals(newUser.firstname)){
				exist=true;
			}
		}

		if(!exist){
			thebank.addUser(newUser);
			return "login";
		}
		return  "register";

	}

}

