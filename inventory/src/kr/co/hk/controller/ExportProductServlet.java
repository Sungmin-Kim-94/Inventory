package kr.co.hk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hk.common.Utils;
import kr.co.hk.model.ExportVO;
import kr.co.hk.model.ProductDAO;
import kr.co.hk.model.ProductVO;

@WebServlet("/exportproduct")
public class ExportProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ExportProductServlet.doGet() [START]");

		List<ProductVO> productList = ProductDAO.getProductList();
		request.setAttribute("productList", productList);
		
		Utils.dispatcher("exportproduct", "물품 출고", request, response);

		System.out.println("ExportProductServlet.doGet() [END]");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ExportProductServlet.doPost() [START]");
		request.setCharacterEncoding("UTF-8");
		
		String p_no = request.getParameter("p_no");
		String e_cnt = request.getParameter("e_cnt");
		System.out.println("p_no=" + p_no);
		System.out.println("e_cnt=" + e_cnt);
		
		int intP_no = Integer.parseInt(p_no);
		int intE_cnt = Integer.parseInt(e_cnt);
		
		ProductVO productVo = ProductDAO.getProduct(intP_no);
		
		ExportVO exportVO = new ExportVO();
		exportVO.setProduct(productVo);
		exportVO.setE_cnt(intE_cnt);
		
		ProductDAO.insertExport(exportVO);
		
		response.sendRedirect("exportlist");
		
		System.out.println("ExportProductServlet.doPost() [END]");
	}
}
