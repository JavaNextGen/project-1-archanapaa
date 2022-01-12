package com.revature;

import java.sql.Connection;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.models.Menu;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		

		//Testing Database Connectivity
		Connection conn = ConnectionFactory.getInstance().getConnection();
		System.out.println(conn);
		
		//Here is the actual functionality of our application-------------------
		
		//spoiler alert... there will only be two lines of codes here
		
		
		//Instantiate a menu object
		//Menu menu = new Menu();
		
		//Use the Menu Class's displayMenu() method to give the user the menu
		//menu.displayMenu();
		
		
		//start Javalin server on port 7000
		
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> {
        	
        ctx.result("Javalin successfully set");
        ctx.status(200);
        });
        
        LoginController loginController = new LoginController();
        app.post("/login", loginController.loginHandler);
        
        ReimbursementController reimbController = new ReimbursementController();
        app.post("/reimbursesubmit",reimbController.submissionHandler );
        
      
        app.get("/search/author/{id}",reimbController.searchHandler );
		
		//all of the complicated menu logic is hidden in the Menu class... this is power of abstraction!!!!!
	}
}
