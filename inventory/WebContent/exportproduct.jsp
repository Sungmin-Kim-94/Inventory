<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		}
	}
	
	function goList() {
		location.href = "list?search=export";
	}
</script>
<section>
	<h3 class="section-title">${title}</h3>
	<form name="export_frm" action="exportproduct" method="post" onsubmit="return chkValid();">
		<input type="hidden" name="p_no" value="${vo.p_no}" />
		<table>
			<tbody>
				<tr>
					<th>물품 번호</th>
					<td>${vo.p_no}</td>
				</tr>
				<tr>
					<th>물품 이름</th>
					<td>${vo.p_name}</td>
				</tr>
				<tr>
					<th>현재 수량</th>
					<td>${vo.p_cnt}</td>
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