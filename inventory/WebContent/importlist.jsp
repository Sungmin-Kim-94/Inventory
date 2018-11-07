<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.co.hk.model.*"%>
<%
	List<ImportVO> importList = (List<ImportVO>) request
			.getAttribute("importList");
%>
<section>
	<h3 class="section-title">${title}</h3>	
	
	<div class="product">
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
							for (ImportVO importVO : importList) {
				%>
				<tr>
					<td><%=importVO.getI_no()%></td>
					<td><%=importVO.getProduct().getP_name()%></td>
					<td><%=importVO.getI_cnt()%></td>
					<td><%=importVO.getI_date()%></td>					
				</tr>
				<%
					}
						} else {
				%>
				<tr>
					<td colspan="4">등록된 물품이 없습니다.</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</section>