package kr.co.hk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hk.common.Utils;
import kr.co.hk.model.DBConnector;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeServlet.doGet() [START]");
		DBConnector.getConnection();
		
		Utils.dispatcher("home", request, response);
		
		System.out.println("HomeServlet.doGet() [END]");
	}

}
