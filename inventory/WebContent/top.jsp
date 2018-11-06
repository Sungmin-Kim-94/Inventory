<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
	<h1>물품 재고 관리 ver1.0</h1>
</header>
<nav class="top-nav">
	<ul class="tn-menu">
		<li class="tn-item">
			<a href="regproduct" class="${target.equals('regproduct')? 'active' : '' }">물품 등록</a>
		</li>
		<li class="tn-item">
			<a href="list" class="${target.equals('list')? 'active' : '' }">조회</a>
		</li>
		<li class="tn-item">
			<a href="home" class="${target.equals('home')? 'active' : '' }">홈으로</a>
		</li>
	</ul>
</nav>