<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="SemiColonWeb" />
<!-- Stylesheets ============================================= -->
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/style.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/dark.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/font-icons.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/animate.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/magnific-popup.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/custom.css"></c:url>' type="text/css"/>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Document Title	============================================= -->
<title>대상자 선정 페이지</title>
</head>

<body class="stretched">
	<!-- Document Wrapper ============================================= -->
	<div id="wrapper">

		<!-- Header
		============================================= -->
		<header id="header" class="full-header transparent-header semi-transparent dark">
			<c:choose>
				<c:when test="${userid eq null }">
					<c:import url="../include/noneLoginHeader.jsp" />
				</c:when>
				<c:when test="${userid ne null }">
					<c:import url="../include/header.jsp" />
				</c:when>
			</c:choose>
		</header><!-- #header end -->

		<!-- 타이틀 ============================================= -->
		<section id="page-title" class="page-title-center"
			style="background-color: white; border: none; padding-bottom: 0px;">
			<div class="container clearfix" style="background-color: white;">
 
				<h1>${collaborator.title }</h1>
				<span style="margin-top: 20px;">
					<div class="d-flex align-items-center"
						style="justify-content: center;">
						<a href="<c:url value='/blog/${collaborator.creatorId }'/>"> <img src="<c:url value='${collaborator.creatorimage }'/> "
							alt="Author" class="rounded-circle" width="35" height="35">
						</a>
						<div class="entry-meta mt-0">
							<div class="entry-meta" style="margin-bottom: 10px; padding-left: 10px;">
								<ul>
									<li><a href="<c:url value='/blog/${collaborator.creatorId }'/> ">${collaborator.onenickname }</a></li>
									<li><i class="icon-calendar3"></i>${collaborator.registerdate }</li>
								</ul>
							</div>
						</div>
					</div>
				</span>

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
										href="<c:url value='/collaboration/${collaborator.collaborationId}'/> "><div>콜라보레이션 소개</div></a></li>
						
									<li class="menu-item"><a class="menu-link" href="<c:url value = '/collaboration/${collaborator.collaborationId}/art' />"><div>참여작품</div></a></li>
						
									<li class="menu-item col-sm-6 col-12"></li>
								</ul>
							</nav>
							<!-- #primary-menu end -->
						</div>
						
						</section>
				<!-- 서브메뉴 끝 -->
			</div>

		</section>
		<!-- 타이틀 끝 -->

		<!-- 대상자 선정 리스트 ============================================= -->
		<section id="content">
			<div class="content-wrap">
				<div class="container">
					<form name="frm" method="POST" action="<c:url value='/collaboration/choice'/> " >
					<table class="table cart mb-5">
						<colgroup>
							<col width="30%">
							<col width="30%">
							<col width="30%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr class="fs-4">
								<th class="cart-product-remove">image</th>
								<th class="cart-product-thumbnail">title</th>
								<th class="cart-product-thumbnail">creator</th>
								<th class="cart-product-subtotal">choice</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="result" items="${result}">
								<tr class="cart_item">
									<td class="cart-product-thumbnail">
										<a href="<c:url value='${result.image }'/> " data-lightbox="image">
											<img width="240" height="128" src="<c:url value='${result.image }'/> ">
										</a>
									</td>

									<td class="cart-product-name">
										<a href="<c:url value='/collaboration/art/${result.colArtworkId }'/> ">${result.title }</a>
									</td>

									<td class="cart-product-name">
										<a href="<c:url value='/blog/${result.creatorId }'/> ">${result.nickname }</a>
									</td>

									<td class="cart-product-subtotal">
										<input type="checkbox" name="checkeds" value="${result.colArtworkId }"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="row">
						<div class="col" style="text-align: right">
							<button type="submit" name="submit" id="btn_save"
									class="button button-3d mt-2 mt-sm-0 me-0 ">대상자 선정</button>
						</div>
					</div>
					</form>
				</div>
			</div>
		</section>
		<!-- #content end -->

		<!-- Footer ============================================= -->
		<footer id="footer" class="dark">
			<%@ include file="../include/footer.jsp"%>
		</footer>
		<!-- #footer end -->

	</div>
	<!-- #wrapper end -->
	
	

	<!-- Go To Top ============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- JavaScripts ============================================= -->
	<script src="<c:url value='/js/jquery.js'/> "/>
	<script src="<c:url value='/js/plugins.min.js'/>"/>
	<!-- Footer Scripts
	============================================= -->
	<script src="<c:url value='/js/functions.js'/>"/>
</body>
</html>