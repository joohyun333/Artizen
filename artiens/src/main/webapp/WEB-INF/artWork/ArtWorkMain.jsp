<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- Stylesheets
	============================================= -->
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />" type="text/css" />
	<link rel="stylesheet" href="<c:url value='/style.css' /> " type="text/css" />
	<link rel="stylesheet" href="<c:url value='/css/swiper.css' />" type="text/css" />
	<link rel="stylesheet" href="<c:url value='/css/dark.css' />" type="text/css" />
	<link rel="stylesheet" href="<c:url value='/css/font-icons.css'/>" type="text/css" />
	<link rel="stylesheet" href="<c:url value='/css/animate.css'/>" type="text/css" />
	<link rel="stylesheet" href="<c:url value='/css/magnific-popup.css'/>" type="text/css" />
	<link rel="stylesheet" href="<c:url value='/css/main.css'/>" type="text/css" />
	<link rel="stylesheet" href="<c:url value='/css/custom.css'/>" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Document Title
============================================= -->
<title>::: ARTIZEN | Main :::</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>var $j351 = jQuery.noConflict();</script>


</head>
<body class="stretched">
    	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">
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

        <!--Banner img-->
        <!-- Hero Section
		============================================= -->
		<section id="slider" class="slider-element include-header block-slider-1">

			<div class="swiper_wrapper overflow-visible min-vh-60" data-loop="true">

				<div class="swiper-container swiper-parent">
					<div class="swiper-wrapper">

						<div class="swiper-slide dark">
							<div class="container">
								<div class="slider-caption">
									<p class="mb-4 text-white-50 text-smaller" data-animate="fadeInUpSmall">인물화</p>
									<h4 data-animate="fadeInUpSmall" data-delay="200">영국 여성화가</h4>
									<h2 data-animate="fadeInUpSmall" data-delay="200">Jenny Savile</h2>
									<div>
										<a href="#" class="button button-border button-light button-rounded button-large ms-0 topmargin-sm" data-animate="fadeInUpSmall" data-delay="400">더 보기</a>
									</div>
								</div>
							</div>
							<div class="swiper-slide-bg" style="background:linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('<c:url value='/images/artwork/category/13.jpg'/>')no-repeat; background-size:cover;"></div>
						</div>

						<!-- Slide 2 -->
						<div class="swiper-slide dark">
							<div class="container">
								<div class="slider-caption slider-caption-right" style="max-width: 650px;">
									<p class="mb-4 text-white-50 text-smaller" data-animate="fadeInUpSmall">Shop for Women</p>
									<h2 data-animate="fadeInUpSmall" data-delay="200">You will be able to go anywhere.</h2>
									<div>
										<a href="#" class="button button-border button-light button-rounded button-large ms-0 topmargin-sm" data-animate="fadeInUpSmall" data-delay="400">Shop Now</a>
									</div>
								</div>
							</div>
							<div class="swiper-slide-bg" style="background-image: url('<c:url value='/images/artwork/category/11.jpg'/>');"></div>
						</div>

						<!-- Slide 3 -->
						<div class="swiper-slide dark">
							<div class="container">
								<div class="slider-caption slider-caption-center">
									<p class="mb-4 text-white-50 text-smaller" data-animate="fadeInUpSmall">Shop for Kids</p>
									<h2 data-animate="fadeInUpSmall" data-delay="200">Bring power to your steps</h2>
									<div>
										<a href="#" class="button button-border button-light button-rounded button-large ms-0 topmargin-sm" data-animate="fadeInUpSmall" data-delay="400">Shop Now</a>
									</div>
								</div>
							</div>
							<div class="swiper-slide-bg" style="background-image: linear-gradient(rgba(0,0,0,.3), rgba(0,0,0,.5)), url('<c:url value='/images/artwork/category/10.jpg'/>');"></div>
						</div>

					</div>
				</div>

				<div class="slider-arrow-left"><i class="icon-angle-left"></i><span>Prev</span></div>
				<div class="slider-arrow-right"><span>Next</span> <i class="icon-angle-right"></i></div>
				<div class="slide-number font-secondary"><div class="slide-number-current"></div><span></span><div class="slide-number-total op-05"></div></div>
			</div>

		</section>
		
		<!-- Content
		============================================= -->
		<section id="content">
			<div class="content-wrap">

				<div class="container">

					<h1> CATEGORY</h1>
					<hr>
					<div class="block-expand-categories flex-column flex-lg-row d-flex justify-content-center">
						<div class="expand-category bg-light" onclick="location.href='<c:url value="/artwork/ink" />'" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('https://sunminki.s3.ap-northeast-2.amazonaws.com/76332500-b8b4-42f4-a2c6-7ec756d14d25.jpg')no-repeat; background-size: cover;">
							<h4><a href="<c:url value='/artwork/ink' />" class="text-light">수묵화</a></h4>
						</div>

						<div class="expand-category bg-light" onclick="location.href='<c:url value="/artwork/color" />'" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('https://sunminki.s3.ap-northeast-2.amazonaws.com/fdc3dfe6-9742-4af7-b308-906c115e863b.jpg')no-repeat; background-size: cover;">
							<h4><a href="<c:url value='/artwork/color' />" class="text-light">채색화</a></h4>
						</div>

						<div class="expand-category bg-light" onclick="location.href='<c:url value="/artwork/landscape" />'" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('https://sunminki.s3.ap-northeast-2.amazonaws.com/b8e903f4-2e56-4c55-af2c-5daa398bad4b.jpg')no-repeat; background-size: cover;;">
							<h4><a href="<c:url value='/artwork/landscape' />" class="text-light">풍경화</a></h4>
						</div>

						<div class="expand-category bg-light" onclick="location.href='<c:url value="/artwork/figure" />'" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('https://sunminki.s3.ap-northeast-2.amazonaws.com/1d687c4b-2b29-459e-996d-25b7df947391.jpg')no-repeat; background-size:cover">
							<h4><a href="<c:url value='/artwork/figure' />" class="text-light">인물화</a></h4>
						</div>

						<div class="expand-category bg-light" onclick="location.href='<c:url value="/artwork/abstract" />'" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('https://sunminki.s3.ap-northeast-2.amazonaws.com/14c1801b-f038-41ad-a4a8-ae5d811940f5.jpg')no-repeat; background-size:cover;">
							<h4><a href="<c:url value='/artwork/abstract' />" class="text-light">추상화</a></h4>
						</div>

						<div class="expand-category bg-light" onclick="location.href='<c:url value="/artwork/still" />'" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('https://sunminki.s3.ap-northeast-2.amazonaws.com/f05707e3-1ea0-48de-aef1-1adad22512fe.jpg')no-repeat; background-size:cover;;">
							<h4><a href="<c:url value='/artwork/still' />" class="text-light">정물화</a></h4>
						</div>

						<div class="expand-category bg-light" onclick="location.href='<c:url value="/artwork/pop" />'" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('https://sunminki.s3.ap-northeast-2.amazonaws.com/91819c20-ab24-46eb-a7c2-3dfdb93e7327.jpg')no-repeat; background-size:cover;;">
							<h4><a href="<c:url value='/artwork/pop' />" class="text-light">팝아트</a></h4>
						</div>
					</div>

					<div class="line"></div>

				</div>

			</div>
		</section>
        <!-- Content
		============================================= -->
		<section id="content">

			<div class="content-wrap" style="margin-top: -200px;">
                <div class="container">
					<h1>ART WORK</h1>
                    <hr>
                    <div class="grid-filter-wrap">
						
						<!-- Portfolio Filter
                            ============================================= -->
						</div>
                        
                        <!-- Portfolio Items
                            ============================================= -->
							<div class="masonry-thumbs grid-container grid-1 grid-md-2 grid-lg-3 block-gallery-9 masonry-gap-lg">
								<c:set var="count" value="1"/>
								<c:forEach var="content" items="${result }">
									<div class="grid-item">
										<div class="grid-inner" style="background: linear-gradient(to bottom, transparent, rgba(0,0,0,.3) 75%, rgba(0,0,0,0.9) 100%), url('${content.artworkImgName }') no-repeat center center / cover; height: 400px">
											<div class="bg-overlay position-relative">
												<div class="bg-overlay-content flex-column justify-content-end align-items-start px-5 py-4 dark">
													<div class="entry-meta mb-3">
														<ul>
															<li>1 day ago</li>
															<li><a href="blog-single-thumbs.html#comments"><i class="icon-comments"></i> 15</a></li>
														</ul>
													</div>
													<div class="entry-title title-sm">
														<h3><a href="<c:url value='/artwork/detail/${content.imageId }' />">${content.title }</a></h3>
													</div>
													<a href="<c:url value='/blog/${content.id }' />">BLOG<i class="icon-line-arrow-right btn-more"></i></a>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								</div><!-- #portfolio end -->
							<div class="container mt-4">
						</div>
					</div>
					<ul class="pagination mt-5 pagination-circle pagination-lg justify-content-center" id="pagingNumbers">
						<c:choose>
							<c:when test="${page < 6 }">
							</c:when>
							<c:when test="${page >= 6 }">
								<li class="page-item"><a class="page-link" href="?page=${spage-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
							</c:when>
						</c:choose>
						<c:forEach var="i" begin="${spage }" end="${endpage }">
							<li id="pagenumber" class="page-item <c:if test='${page == i }'>active</c:if> "><a class="page-link" href="?page=${i }">${i }</a></li>								
						</c:forEach> 
						<c:choose>
							<c:when test="${page >= totalpage -3 }">
							</c:when>						
							<c:when test="${page < totalpage }">
								<li class="page-item"><a class="page-link" href="?page=${endpage+1 }" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							</c:when>						
						</c:choose>
					</ul>
				</div>
				
		</section><!-- #content end -->
	</div>	
	 <!-- Footer
    ============================================= -->
	<footer id="footer" class="dark" style="margin-top: 0px;">
		<c:import url="../include/footer.jsp"/>
	</footer>
	<!-- #footer end -->

<!-- Go To Top
============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>
<!-- JQeryScript 
============================================= -->
<!-- JavaScripts
============================================= -->
<script src="<c:url value='/js/jquery.js' />"></script>
<script src="<c:url value='/js/plugins.min.js' />"></script>
<script src="<c:url value='/js/jquery.hotspot.js' />"></script>
<script>
	
</script>
<!-- Footer Scripts
============================================= -->
<script src="<c:url value='/js/functions.js' />"></script>
</body>