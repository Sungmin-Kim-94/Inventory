<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function chkValid() {
		var frm = document.reg_frm
		
		if (frm.p_name.value == '') {
			alert("물품 이름을 입력하세요.")
			return false
		} else {
			return true
		}
		
		return false
	}
</script>
<section>
	<h3 class="section-title">${title}</h3>
	<form name="reg_frm" action="regproduct" method="post" onsubmit="return chkValid();">
		<label for="p_name">물품 이름</label>
		<input type="text" id="p_name" name="p_name" />
		<button type="submit">등록</button>
	</form>
</section>