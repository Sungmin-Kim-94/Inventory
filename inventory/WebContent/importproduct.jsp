<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	function chkValid() {
		var frm = document.import_frm
		
		if (frm.i_cnt.value == "") {
			alert("숫자를 입력하세요.")
			return false
		} else if (frm.i_cnt.value <= 0) {
			alert("0 이상의 숫자만 입력하세요")
			return false
		} else {
			return true
		}
	}
	
	function goList() {
		location.href = "list?search=import";
	}
</script>
<section>
	<h3 class="section-title">${title}</h3>
	<form name="import_frm" action="importproduct" method="post" onsubmit="return chkValid();">
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
						<label for="i_cnt">입고 수량</label>
					</th>
					<td>
						<input type="number" id="i_cnt" name="i_cnt" value="0" />
					</td>
				</tr>
			</tbody>
		</table>
		<button type="submit">입고</button>
		<button type="button" onclick="goList()">조회</button>
	</form>
</section>