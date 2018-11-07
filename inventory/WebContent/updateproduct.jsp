<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	function chkValid() {
		var frm = document.update_frm
		
		if (frm.p_name.value == '') {
			alert("물품 이름을 입력하세요.")
			return false
		} else {
			return true
		}
		
		return false
	}
	
	function goList() {
		location.href = 'productlist'
	}
</script>
<section>
	<h3 class="section-title">물품 정보 수정</h3>
	<form name="update_frm" action="updateproduct" method="post"
		onsubmit="return chkValid();">
		<input type="hidden" name="p_no" value="${vo.p_no}" />
		<table>
			<tbody>
				<tr>
					<th>물품 번호</th>
					<td>${vo.p_no}</td>
				</tr>
				<tr>
					<th>
						<label for="p_name">물품 이름</label>
					</th>
					<td>
						<input type="text" id="p_name" name="p_name" value="${vo.p_name}" />
					</td>
				</tr>
				<tr>
					<th>수량</th>
					<td>${vo.p_cnt}</td>
				</tr>
				<tr>
					<th>등록일자</th>
					<td>${vo.p_regdate}</td>
				</tr>
			</tbody>
		</table>
		<button type="submit">수정</button>
		<button type="button" onclick="goList()">조회</button>
	</form>
</section>