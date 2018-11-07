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
import kr.co.hk.model.ImportVO;
import kr.co.hk.model.ProductDAO;
import kr.co.hk.model.ProductVO;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ListServlet.doGet() [START]");
		
		String searchType = request.getParameter("search");
		System.out.println("search=" + searchType);
		
		if (searchType == null) {
			response.sendRedirect("list?search=product");
			return;
		}
		
		if (searchType.equals("import")) {
			List<ImportVO> importList = ProductDAO.getImportList();
			request.setAttribute("importList", importList);
		} else if (searchType.equals("export")) {
			List<ExportVO> exportList = ProductDAO.getExportList();
			request.setAttribute("exportList", exportList);
		} else {
			List<ProductVO> productList = ProductDAO.getProductList();
			request.setAttribute("productList", productList);
		}
		
		Utils.dispatcher("list", "조회", request, response);
		
		System.out.println("ListServlet.doGet() [END]");
	}
}
