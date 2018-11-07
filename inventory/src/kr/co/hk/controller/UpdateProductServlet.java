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

@WebServlet("/updateproduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateProductServlet.doGet() [START]");
		
		String p_no = request.getParameter("p_no");
		int intP_no = Integer.parseInt(p_no);
		
		ProductVO vo = ProductDAO.getProduct(intP_no);
		request.setAttribute("vo", vo);

		Utils.dispatcher("updateproduct", "물품 정보 수정", request, response);

		System.out.println("UpdateProductServlet.doGet() [END]");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateProductServlet.doPost() [START]");
		request.setCharacterEncoding("UTF-8");
		
		String p_no = request.getParameter("p_no");
		String p_name = request.getParameter("p_name");
		int intP_no = Integer.parseInt(p_no);
		
		ProductDAO.updateProductName(intP_no, p_name);
		
		response.sendRedirect("productlist");
		
		System.out.println("UpdateProductServlet.doPost() [END]");
	}
}
