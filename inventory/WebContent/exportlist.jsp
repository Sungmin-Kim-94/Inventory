<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.co.hk.model.*"%>
<%
	List<ExportVO> exportList = (List<ExportVO>) request
			.getAttribute("exportList");
%>
<section>
	<h3 class="section-title">${title}</h3>	
	
	<div class="export">
		<table>
			<colgroup>
				<col class="e_no" />
				<col class="p_name" />
				<col class="e_cnt" />
				<col class="e_date" />
			</colgroup>
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
							for (ExportVO exportVO : exportList) {
				%>
				<tr>
					<td><%=exportVO.getE_no()%></td>
					<td><%=exportVO.getProduct().getP_name()%></td>
					<td><%=exportVO.getE_cnt()%></td>
					<td><%=exportVO.getE_date()%></td>					
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