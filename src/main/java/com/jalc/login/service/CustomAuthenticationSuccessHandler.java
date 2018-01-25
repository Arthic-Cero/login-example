package com.jalc.login.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	private static final String JSESSIONID_COOKIE_NAME = "JSESSIONID";
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		System.out.println("IM INSIDE THE CUSTOMAUTHENTICATIONSUCCESSHANDLER!!");
//		Cookie sessionCookie = findCookie(JSESSIONID_COOKIE_NAME, request.getCookies());
//		response.addCookie(sessionCookie);
		
		HttpSession session = request.getSession();
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		session.setAttribute("username", principal.getUsername());
		session.setAttribute("authorities", principal.getAuthorities());
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect("welcome");
	}
	
	private Cookie findCookie(String cookieName, Cookie[] cookies) {
		for(int i = 0; i < cookies.length; i++) {
			if(JSESSIONID_COOKIE_NAME.equals(cookies[i].getName())) {
				return cookies[i];
			}
		}
		
		return null;
	}

}
