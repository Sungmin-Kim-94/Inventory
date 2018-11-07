<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.co.hk.model.*"%>
<%
	String searchType = request.getParameter("search");
	List<ProductVO> productList = (List<ProductVO>) request
			.getAttribute("productList");
	List<ImportVO> importList = (List<ImportVO>) request
			.getAttribute("importList");
	List<ExportVO> exportList = (List<ExportVO>) request
			.getAttribute("exportList");
%>
<section>
	<h3 class="section-title">${title}</h3>
	<form action="list" method="get">
		<select name="search">
			<option value="product"
				${param.search.equals('product')? 'selected' : ''}>물품</option>
			<option value="import"
				${param.search.equals('import')? 'selected' : ''}>입고</option>
			<option value="export"
				${param.search.equals('export')? 'selected' : ''}>출고</option>
		</select>
		<button type="submit">조회</button>
	</form>
	<%
		if (searchType.equals("product")) {
	%>
	<div class="product">
		<table>
			<thead>
				<tr>
					<th>물품 번호</th>
					<th>물품 이름</th>
					<th>수량</th>
					<th>등록일자</th>
					<th>입고</th>
					<th>출고</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (productList != null && productList.size() > 0) {
							for (ProductVO product : productList) {
				%>
				<tr>
					<td><%=product.getP_no()%></td>
					<td><%=product.getP_name()%></td>
					<td><%=product.getP_cnt()%></td>
					<td><%=product.getP_regdate()%></td>
					<td>
						<a href="importproduct?p_no=<%=product.getP_no()%>">
							<button>입고</button>
						</a>
					</td>
					<td>
						<a href="exportproduct?p_no=<%=product.getP_no()%>">
							<button>출고</button>
						</a>
					</td>
				</tr>
				<%
					}
						} else {
				%>
				<tr>
					<td colspan="6">등록된 물품이 없습니다.</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<%
		} else if (searchType.equals("import")) {
	%>
	<div class="import">
		<table>
			<thead>
				<tr>
					<th>입고 번호</th>
					<th>물품 이름</th>
					<th>입고 수량</th>
					<th>입고일자</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (importList != null && importList.size() > 0) {
							for (ImportVO importVo : importList) {
				%>
				<tr>
					<td><%=importVo.getI_no()%></td>
					<td><%=importVo.getProduct().getP_name()%></td>
					<td><%=importVo.getI_cnt()%></td>
					<td><%=importVo.getI_date()%></td>
				</tr>
				<%
					}
						}
				%>
			</tbody>
		</table>
	</div>
	<%
		} else if (searchType.equals("export")) {
	%>
	<div class="export">
		<table>
			<thead>
				<tr>
					<th>출고 번호</th>
					<th>물품 이름</th>
					<th>출고 수량</th>
					<th>출고일자</th>
				</tr>
			</thead>
			<tbody>
			<%
					if (exportList != null && exportList.size() > 0) {
							for (ExportVO exportVo : exportList) {
				%>
				<tr>
					<td><%=exportVo.getE_no()%></td>
					<td><%=exportVo.getProduct().getP_name()%></td>
					<td><%=exportVo.getE_cnt()%></td>
					<td><%=exportVo.getE_date()%></td>
				</tr>
				<%
					}
						}
				%>
			</tbody>
		</table>
	</div>
	<%
		}
	%>
</section>