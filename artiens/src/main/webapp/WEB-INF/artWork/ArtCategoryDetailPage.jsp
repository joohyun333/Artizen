<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="SemiColonWeb" />

<!-- Stylesheets
	============================================= -->
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/style.css' />"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/dark.css' />"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/font-icons.css' />"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/animate.css' />"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/magnific-popup.css' />"
	type="text/css" />

<link rel="stylesheet" href="<c:url value='/css/custom.css' />" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- Document Title
	============================================= -->
<title>${page }페이지</title>

</head>

<body class="stretched">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Header
		============================================= -->
		<header id="header"
			class="full-header transparent-header semi-transparent dark">
			<c:choose>
				<c:when test="${user eq 0 }">
					<c:import url="../include/noneLoginHeader.jsp" />
				</c:when>
				<c:when test="${user ne 0 }">
					<c:import url="../include/header.jsp" />
				</c:when>
			</c:choose>
		</header>
		<!-- #header end -->

		<!-- Page Title
		============================================= -->
		<section id="page-title">
			<div class="container clearfix">
				<h1>${page }</h1>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">최신순</a></li>
					<li class="breadcrumb-item active"><a href="#">인기순</a></li>
				</ol>
			</div>
		</section>
		<!-- #page-title end -->

		<!-- Content
		============================================= -->
		<section id="content">
			<div class="content-wrap">
				<div class="container clearfix">

					<!-- Posts
				============================================= -->
					<div id="posts" class="post-grid grid-container row gutter-40 mx-3">
						<c:forEach var="store" items="${store }">
							<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
								<div class="grid-inner">
									<div class="entry-image">
										<a href="${store.storefilename }" data-lightbox="image"><img
											src="${store.storefilename }" alt="Standard Post with Image">
										</a>
									</div>
									<div class="entry-title">
										<h2>
											<a href="<c:url value='/artwork/detail/${store.imageId }' /> ">${store.title }</a>
										</h2>
									</div>
									<div class="author-image" style="margin-top: 15px;">
										<a href="<c:url value='/blog/${store.creatorId }' />">
											<c:choose>
												<c:when test="${store.profileimage eq null }">
													<img src="https://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=60" alt="image" class="rounded-circle">
												</c:when>
												<c:when test="${store.profileimage ne null }">
													<img src="${store.profileimage }" alt="image" class="rounded-circle">
												</c:when>
											</c:choose>
										</a>
									</div>
									<div class="entry-meta"
										style="margin-top: 55px; padding-left: 10px;">
										<ul>
											<li><a href="blog-single.html#comments"><i
													class="icon-comments"></i> 13</a></li>
											<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
										</ul>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- #posts end -->
					<ul class="pagination mt-5 pagination-circle pagination-lg justify-content-center" id="pagingNumbers">
						<c:choose>
							<c:when test="${nowpage < 5 }">
							</c:when>
							<c:when test="${nowpage > 5 }">
								<li class="page-item"><a class="page-link" href="?page=${spage-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
							</c:when>
						</c:choose>
						<c:forEach var="i" begin="${spage }" end="${endpage }">
							<li id="pagenumber" class="page-item <c:if test='${nowpage == i }'>active</c:if> "><a class="page-link" href="?page=${i }">${i }</a></li>								
						</c:forEach> 
						<c:choose>
							<c:when test="${nowpage >= totalpage -3 }">
							</c:when>						
							<c:when test="${nowpage < totalpage }">
								<li class="page-item"><a class="page-link" href="/artwork/${catepage }/?page=${endpage+1 }" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							</c:when>						
						</c:choose>
					</ul>
					<div class="page-load-status">
						<div class="css3-spinner infinite-scroll-request">
							<div class="css3-spinner-ball-pulse-sync">
								<div></div>
								<div></div>
								<div></div>
							</div>
						</div>
						<div
							class="alert alert-warning center infinite-scroll-last mx-auto"
							style="max-width: 20rem;">End of content</div>
						<div
							class="alert alert-warning center infinite-scroll-error mx-auto"
							style="max-width: 20rem;">No more pages to load</div>
					</div>

					<!-- Pagination
					============================================= -->
					<div class="center d-none">
						<a href="blog-masonry-page-2.html"
							class="button button-3d button-dark button-large button-rounded load-next-posts">Load
							more..</a>
					</div>

				</div>
			</div>
		</section>
		<!-- #content end -->

		<!-- Footer
		============================================= -->
		<footer id="footer" class="dark" style="margin-top: 0px;">
			<%@ include file="../include/footer.jsp"%>
		</footer>
		<!-- #footer end -->

	</div>
	<!-- #wrapper end-->



	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- JavaScripts
	============================================= -->
	<script src="/js/jquery.js"></script>
	<script src="/js/plugins.min.js"></script>

	<!-- Footer Scripts
	============================================= -->
	<script src="/js/functions.js"></script>

	<script>
		$(document).ready(
				function() {
					jQuery('.block-expand-categories').find('.expand-category')
							.on('click', function() {
								let category = $(this);

								category.siblings().removeClass('active');
								category.addClass('active');
							});

				});
	</script>

</body>
</html>
