package kr.co.hk.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils {
	private Utils() {
	}
	
	public static void dispatcher(String target, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dispatcher(target, null, request, response);
	}

	public static void dispatcher(String target, String title, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("target", target);
		request.setAttribute("title", title);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
		System.out.println(target + "으로 이동");
	}
}
