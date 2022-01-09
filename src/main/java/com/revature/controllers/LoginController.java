package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Authentication;
import com.revature.models.User;
import com.revature.services.LoginService;

import io.javalin.http.Handler;

public class LoginController {
	
	public Handler loginHandler = (ctx) -> {
		System.out.println("inside login handler");

		if(ctx.req.getSession() != null) {
			
			String body = ctx.body();
			System.out.println(body);
			
			Gson gson = new Gson();
			
			Authentication authentication = gson.fromJson(body, Authentication.class);
			System.out.println(authentication.getUsername());
			System.out.println(authentication.getPassword());
			
			LoginService loginService = new LoginService();
			User user = loginService.authenticateUser(authentication.getUsername(),authentication.getPassword());
			System.out.println(user);
			
			if (user != null) {
				ctx.result("Login successfull");
				ctx.status(201);
			}
			else {
				ctx.result("Authentication Failed!!!!");
				ctx.status(401);
			}
		} else {
			ctx.result("Authentication Failed!!!!");
			ctx.status(401);
		}
		
		
	};
	

}
