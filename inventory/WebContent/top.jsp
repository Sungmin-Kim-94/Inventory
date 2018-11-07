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
			<a href="importproduct" class="${target.equals('importproduct')? 'active' : '' }">입고</a>
		</li>
		<li class="tn-item">
			<a href="exportproduct" class="${target.equals('exportproduct')? 'active' : '' }">출고</a>
		</li>
		<li class="tn-item">
			<a href="productlist" class="${target.equals('productlist')? 'active' : '' }">물품 조회</a>
		</li>
		<li class="tn-item">
			<a href="importlist" class="${target.equals('importlist')? 'active' : '' }">입고 조회</a>
		</li>
		<li class="tn-item">
			<a href="exportlist" class="${target.equals('exportlist')? 'active' : '' }">출고 조회</a>
		</li>
		<li class="tn-item">
			<a href="home" class="${target.equals('home')? 'active' : '' }">홈으로</a>
		</li>
	</ul>
</nav>