<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 서브메뉴============================================= -->
<section id="content">
			<div class="content-wrap py-0">
<!-- Section Light -->
<div class="d-lg-flex flex-column justify-content-lg-center min-vh-20 min-vh-lg-10 ">

	<!-- Primary Navigation icon in mobile
        ============================================= -->
	<div id="primary-menu-trigger">
		<svg class="svg-trigger" viewBox="0 0 100 100">
			<path
				d="m 30,33 h 40 c 3.722839,0 7.5,3.126468 7.5,8.578427 0,5.451959 -2.727029,8.421573 -7.5,8.421573 h -20"></path>
			<path d="m 30,50 h 40"></path>
			<path
				d="m 70,67 h -40 c 0,0 -7.5,-0.802118 -7.5,-8.365747 0,-7.563629 7.5,-8.634253 7.5,-8.634253 h 20"></path></svg>
	</div>

	<!-- Primary Navigation
        ============================================= -->
	<nav class="primary-menu with-arrows block-nav-menu">

		<ul class="menu-container justify-content-center">
			<!-- justify-content-center class for center menu-->

			<li class="menu-item"><a class="menu-link"
				href="<c:url value="/collaboration/${result.collaborationId}"/>"><div>콜라보레이션 소개</div></a></li>

			<c:if test="${result.colEvaluate eq true}">
				<li class="menu-item"><a class="menu-link" href="<c:url value = "/collaboration/${result.collaborationId}/art/winner"/>"><div>당선작품</div></a></li>
			</c:if>

			<li class="menu-item"><a class="menu-link" href="<c:url value = "/collaboration/${result.collaborationId}/art"/>"><div>참여작품</div></a></li>

			<li class="menu-item col-sm-6 col-12"></li>
		</ul>
	</nav>
	<!-- #primary-menu end -->
</div>
</section>