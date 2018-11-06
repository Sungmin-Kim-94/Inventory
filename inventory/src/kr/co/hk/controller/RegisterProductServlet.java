package kr.co.hk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hk.common.Utils;
import kr.co.hk.model.ProductDAO;
import kr.co.hk.model.ProductVO;

@WebServlet("/regproduct")
public class RegisterProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegisterProductServlet.doGet() [START]");
		
		Utils.dispatcher("regproduct", "물품 등록", request, response);
		
		System.out.println("RegisterProductServlet.doGet() [END]");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegisterProductServlet.doPost() [START]");
		request.setCharacterEncoding("UTF-8");
		
		String p_name = request.getParameter("p_name");
		
		System.out.println("p_name=" + p_name);
		
		ProductVO vo = new ProductVO();
		vo.setP_name(p_name);
		ProductDAO.registerProduct(vo);
		
		response.sendRedirect("list?search=product");
		
		System.out.println("RegisterProductServlet.doPost() [END]");
	}

}
