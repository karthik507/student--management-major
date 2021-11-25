package com.college.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.college.entity.User;
import com.college.repo.UserRepo;
import com.college.service.UserService;

@Controller
public class CollegeUIController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserService userService;

	@GetMapping({ "/", "/login" })
	public String getLogin() {
		return "index";
	}

	@GetMapping("/forget")
	public String getforget() {
		return "forget";
	}

	@GetMapping("/signup")
	public String getSignupPage() {
		return "signup";
	}

	@GetMapping("/success")
	public String getSuccess() {
		return "signupCompletion";
	}

	@GetMapping("/reset")
	public String getReset() {
		return "reset";
	}

	@GetMapping("/{token}/activate/account")
	public String getSuccessPage(@PathVariable("token") String token) {
		Optional<User> user = userRepo.findByToken(token);
		if (user.isPresent()) {
			User user1 = user.get();
			user1.setIsActive(true);
			user1.setToken(null);
			userRepo.save(user1);
			return "success";
		}
		return "errorPage";
	}

	@GetMapping("/signupCompletion")
	public String saveUserInfo() {
		return "signupCompletion";
	}

}
