<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.co.hk.model.*"%>
<%
	List<ProductVO> productList = (List<ProductVO>) request
	.getAttribute("productList");
%>
<script type="text/javascript">
	function chkValid() {
		var frm = document.export_frm

		if (frm.e_cnt.value == "") {
			alert("숫자를 입력하세요.")
			return false
		} else if (frm.e_cnt.value <= 0) {
			alert("0 이상의 숫자만 입력하세요")
			return false
		} else if ((frm.p_cnt.value - frm.e_cnt.value) < 0) {
			alert("수량이 0보다 작을 수 없습니다.")
			return false
		} else {
			return true
		}
		
		return false
	}

	function goList() {
		location.href = "exportlist";
	}
</script>
<section>
	<h3 class="section-title">${title}</h3>
	<form name="export_frm" action="exportproduct" method="post"
		onsubmit="return chkValid();">
		<table>
			<tbody>
				<tr>
					<th>물품 목록</th>
					<td>
						<select name="p_no">
							<%
								if (productList != null && productList.size() > 0) {
									for (ProductVO product : productList) {
							%>
							<option value="<%=product.getP_no()%>"><%=product.getP_name()%></option>
							<%
								}
								} else {
							%>
							<option disabled>등록된 물품이 없습니다.</option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						<label for="e_cnt">출고 수량</label>
					</th>
					<td>
						<input type="number" id="e_cnt" name="e_cnt" value="0" />
					</td>
				</tr>
			</tbody>
		</table>
		<button type="submit">출고</button>
		<button type="button" onclick="goList()">조회</button>
	</form>
</section>