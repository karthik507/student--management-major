package com.college.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.college.entity.User;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(User user, HttpServletRequest httpServletRequest,String subject) {
		String url = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":"
				+ httpServletRequest.getServerPort() + "/" + user.getToken() + "/activate/account";

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(user.getEmail());
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(url);
		javaMailSender.send(simpleMailMessage);
	}

}
