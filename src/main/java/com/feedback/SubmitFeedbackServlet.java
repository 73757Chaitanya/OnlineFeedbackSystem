package com.feedback;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SubmitFeedbackServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	 
	 String name = request.getParameter("name");
	 String email = request.getParameter("email");
	 String message = request.getParameter("message");
	 
	 //store feedback in session
	 HttpSession session = request.getSession();
	 session.setAttribute("username", name);
	 
	 //Write feedback to file(optional)
	 String path = getServletContext().getRealPath("/feedback.txt");
	 try(PrintWriter out = new PrintWriter(new FileWriter(path,true))){
		 out.println("Name: " + name);
		 out.println("Email: " + email);
		 out.println("Message: " + message);
		 out.println("-----");
	 }
	 
	 //Redirect to thank-you Page
	 response.sendRedirect("ThankYou.jsp");
 }
}
