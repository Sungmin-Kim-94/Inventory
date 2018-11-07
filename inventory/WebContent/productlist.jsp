<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.co.hk.model.*"%>
<%
	List<ProductVO> productList = (List<ProductVO>) request
			.getAttribute("productList");
%>
<script type="text/javascript">
	function goUpdate(p_no) {
		location.href = 'updateproduct?p_no=' + p_no
	}
</script>
<section>
	<h3 class="section-title">${title}</h3>	
	
	<div class="product">
		<table>
			<thead>
				<tr>
					<th>물품 번호</th>
					<th>물품 이름</th>
					<th>수량</th>
					<th>등록일자</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (productList != null && productList.size() > 0) {
							for (ProductVO product : productList) {
				%>
				<tr onclick="goUpdate(<%=product.getP_no()%>)">
					<td><%=product.getP_no()%></td>
					<td><%=product.getP_name()%></td>
					<td><%=product.getP_cnt()%></td>
					<td><%=product.getP_regdate()%></td>					
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