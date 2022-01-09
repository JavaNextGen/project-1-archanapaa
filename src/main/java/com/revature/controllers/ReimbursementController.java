package com.revature.controllers;
import com.google.gson.Gson;
import com.revature.models.ReimbursementRequest;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	public Handler submissionHandler = (ctx) -> {
		System.out.println("inside submissionHandler  handler");

		if(ctx.req.getSession() != null) {
			
			String body = ctx.body();
			System.out.println(body);
			
			Gson gson = new Gson();
			
			ReimbursementRequest reimbRequest = gson.fromJson(body, ReimbursementRequest.class);
			System.out.println(reimbRequest);
			
			ReimbursementService reimbursementService = new ReimbursementService();
			int  reimbursementId = reimbursementService.submitReimbursement(reimbRequest);
			System.out.println(reimbursementId);
			
			ctx.result("Reimbursement submission  successfull");
			ctx.status(201);
			
		} else {
			ctx.result("Reimbursement submission Failed!!!!");
			ctx.status(401);
		}
		
		
	};
	

}
