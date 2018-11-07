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

@WebServlet("/importlist")
public class ImportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ImportListServlet.doGet() [START]");
		
		List<ImportVO> importList = ProductDAO.getImportList();
		request.setAttribute("importList", importList);
		
		Utils.dispatcher("importlist", "입고 조회", request, response);
		
		System.out.println("ImportListServlet.doGet() [END]");
	}
}
