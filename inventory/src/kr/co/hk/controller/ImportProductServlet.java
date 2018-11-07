package kr.co.hk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hk.common.Utils;
import kr.co.hk.model.ImportVO;
import kr.co.hk.model.ProductDAO;
import kr.co.hk.model.ProductVO;

@WebServlet("/importproduct")
public class ImportProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ImportProductServlet.doGet() [START]");		
		
		List<ProductVO> productList = ProductDAO.getProductList();
		request.setAttribute("productList", productList);
		
		Utils.dispatcher("importproduct", "물품 입고", request, response);

		System.out.println("ImportProductServlet.doGet() [END]");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ImportProductServlet.doPost() [START]");
		request.setCharacterEncoding("UTF-8");
		
		String p_no = request.getParameter("p_no");
		String i_cnt = request.getParameter("i_cnt");
		System.out.println("p_no=" + p_no);
		System.out.println("i_cnt=" + i_cnt);
		
		int intP_no = Integer.parseInt(p_no);
		int intI_cnt = Integer.parseInt(i_cnt);
		
		ProductVO productVo = ProductDAO.getProduct(intP_no);
		ImportVO importVO = new ImportVO();
		importVO.setProduct(productVo);
		importVO.setI_cnt(intI_cnt);
		
		ProductDAO.insertImport(importVO);
		
		response.sendRedirect("importlist");
		
		System.out.println("ImportProductServlet.doPost() [END]");
	}
}
