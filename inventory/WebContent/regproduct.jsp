<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
	<h3 class="section-title">${title}</h3>
	<form action="regproduct" method="post">
		<label for="p_name">물품 이름</label>
		<input type="text" id="p_name" name="p_name" />
		<br />
		<button type="submit">등록</button>
	</form>
</section>