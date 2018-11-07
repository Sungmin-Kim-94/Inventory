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

@WebServlet("/exportlist")
public class ExportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ExportListServlet.doGet() [START]");
		
		List<ExportVO> exportList = ProductDAO.getExportList();
		request.setAttribute("exportList", exportList);
		
		Utils.dispatcher("exportlist", "출고 조회", request, response);
		
		System.out.println("ExportListServlet.doGet() [END]");
	}
}
