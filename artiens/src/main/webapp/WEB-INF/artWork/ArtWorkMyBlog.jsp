<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta name="author" content="SemiColonWeb" />
<!-- Stylesheets
    ============================================= -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
	  rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet" href="<c:url value='/style.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/swiper.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/dark.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/font-icons.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/animate.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/magnific-popup.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/linkAnimation.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/button.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/sticky.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/css/custom.css' />" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<c:set var="profile" value="${profile }"/>
<c:set var="recent" value="${recent }"/>
<title>::: ARTIZEN | ${profile.nickname }님의 블로그 :::</title>

<style>
	
</style>

</head>
<body class="stretched">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- HEADER
============================================= -->
		<header id="header"
			class="full-header transparent-header semi-transparent dark">
			<jsp:include page="../include/header.jsp"></jsp:include>
		</header>

		<!-- Page Title
		============================================= -->
		<section id="page-title">

			<div class="container text-center">
				
				<!-- banner start -->
				<div class="fslider" data-pagi="false" data-animation="fade">
					<div class="flexslider">
						<div class="slider-wrap">
							<div style="background: url('<c:url value="/images/artwork/3.jpg"/>')no-repeat center center/cover; height: 500px;"></div>
						</div>
					</div>
				</div>		
				<!-- banner end -->
				
			</div>

		</section>
		<!-- #page-title end -->
					
		<section id="content">
			<div class="content-wrap">
				<div class="container clearfix">
					
					<!-- social icon -->
					<div class="si-sticky si-sidebar">
						<a href="#" class="social-icon si-colored si-facebook">
							<span>Facebook</span>
							<i class="icon-facebook"></i>
						</a>
						<a href="#" class="social-icon si-colored si-instagram">
							<span>Instagram</span>
							<i class="icon-instagram"></i>
						</a>
						<a href="#" class="social-icon si-colored si-youtube">
							<span>Youtube</span>
							<i class="icon-youtube"></i>
						</a>
					</div>
										
					<div class="row gutter-40 col-mb-80">
					<!-- social icon end -->
					
					
						<!-- Post Content
						============================================= -->
						<div class="postcontent col-lg-9 order-lg-last">

							<div class="single-post mb-0">
							
								<!-- Content
								============================================= -->
								<section id="content">
											<!-- Grid row -->
									<div class="tabs mb-0 clearfix" id="sidebar-tabs">
									
										<ul class="tab-nav clearfix mb-3">
											<li>
												<a href="#tabs-3" class="link link-6 bg-light">작품</a>
											</li>
										</ul>
										
										<div class="tab-container" id="slider-tab">
										
											<div class="tab-content clearfix" id="tabs-3">
												<div class="posts-sm row col-mb-30">										
													<div class="card-columns" data-lightbox="gallery">
														<c:forEach var="imageURL" items="${store}">
														<a href="<c:url value='/artwork/detail/${imageURL.imageId}'/>">
															<img class="img-fluid mb-4 h-op-07 op-ts cursor-hover" src="${imageURL.storeFileName }" alt="Image"/>
														</a>
														</c:forEach>
													</div>
													<!-- Grid row -->
												</div>
											</div>
											<!-- #tab-content #tab-3 -->
		
										</div>
										<!-- #tab-container end -->
									</div> <!-- sidebar-tab end  -->
								</section><!-- #content end -->
								
							</div>
						</div>
						<!-- Postcontent end -->

						<!-- Sidebar
						============================================= -->
						<div class="sidebar col-lg-3">
							<div class="sidebar-widgets-wrap">

								<div class="widget clearfix">

									<div class="d-flex mt-3">
										<a href="#">
											<c:choose>
												<c:when test="${profile.images eq null}">
													<img class="rounded-circle m-2" style="width: 100px; height: 100px;" src="https://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=60" alt="Image">
										 		</c:when>
												<c:when test="${profile.images ne null}">
													<img class="rounded-circle m-2" style="width: 100px; height: 100px;" src="${profile.images }" alt="Image">
										 		</c:when>
										 	</c:choose>
										 </a>
										<div class="m-3">
											<div>${profile.nickname }</div> 
											<div>팔로워 49.2만명</div> 
											<div>팔로잉 40명</div>
										</div>
									</div>
									<script>
									
									</script>
									<div class="text-center mt-2">
										<a href="#" id="btn_follow" class="button button-xlarge button-circle button-dark button-reveal nott ls0 bg-dark text-start" style="padding: 0px 60px 0px 60px;">
											<i class="icon-line-check" id="btn_followicon"></i>
											<span>팔로우 하기</span>
										</a>											
									</div>
									<div class="border m-3 p-3">
										<c:choose>
											<c:when test="${profile.content eq null }" >
												<div>
													<i>한 줄 이야기를 등록해 주세요.<br><small>(최대 50자까지 입력 가능합니다. )</small></i>
												</div>
											</c:when>
											<c:when test="${profile.content ne null }" >
												<div>
													${profile.content }
												</div>
											</c:when>
										</c:choose>
									</div>
									<div class="clearfix"></div>

								</div>

								<div class="widget clearfix">

									<div class="tabs mb-0 clearfix" id="sidebar-tabs">

										<ul class="tab-nav clearfix">
											<li><a href="#tabs-1">최근 작품</a></li>
										</ul>

										<div class="tab-container">

										
											<div class="tab-content clearfix" id="tabs-1">
												
												<div class="posts-sm row col-mb-30"
													id="recent-post-list-sidebar">
													<c:forEach var="recent" items="${recent }">
													<div class="entry col-12">
														<div class="grid-inner row g-0">
															<div class="col-auto">
																<div class="entry-image">
																	<a href="#"><img src="<c:url value='${recent.storeFileName }' />" alt="Image"></a>
																</div>
															</div>
															<div class="col ps-3">
																<div class="entry-title">
																	<h4>
																		<a href="#">${recent.title }</a>
																	</h4>
																</div>
																<div class="entry-meta">
																	<ul>
																		<li>${recent.register }</li>
																	</ul>
																</div>
															</div>
														</div>
													</div>
													</c:forEach>
												</div>
											</div>
										
										</div>

									</div>

								</div>

							</div>
						</div>
						<!-- .sidebar end -->				
					</div>
				</div>
			</div>
		</section>
		<!-- #content end -->

		<!-- Footer
		============================================= -->
		<footer id="footer" class="dark">
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</footer>

	</div>
	<!-- #wrapper end -->

	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up rounded-circle bg-primary" style="left: 30px; right: auto;"></div>

	<!-- JavaScripts
	============================================= -->
	<script src="<c:url value='/js/jquery.js' />"></script>
	<script src="<c:url value='/js/plugins.min.js' />"></script>	

	<!-- Footer Scripts
	============================================= -->
	<script src="<c:url value='/js/functions.js' />"></script>

</body>
</html>