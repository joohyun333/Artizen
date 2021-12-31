<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- Stylesheets
	============================================= -->
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href='<c:url value="/css/swiper.css"></c:url>' type="text/css" />
	<link rel="stylesheet" href='<c:url value="/style.css"></c:url>' type="text/css" />
	<link rel="stylesheet" href='<c:url value="/css/dark.css"></c:url>' type="text/css" />
	<link rel="stylesheet" href='<c:url value="/css/font-icons.css"></c:url>' type="text/css" />
	<link rel="stylesheet" href='<c:url value="/css/animate.css"></c:url>' type="text/css" />
	<link rel="stylesheet" href='<c:url value="/css/magnific-popup.css"></c:url>' type="text/css" />
	<link rel="stylesheet" href='<c:url value="/css/components/datepicker.css"></c:url>' type="text/css" />
	<link rel="stylesheet" href='<c:url value="/css/components/timepicker.css"></c:url>' type="text/css" />
	<link rel="stylesheet" href='<c:url value="/css/components/daterangepicker.css"></c:url>' type="text/css" />
	<link rel="stylesheet" href='<c:url value="/css/custom.css"></c:url>' type="text/css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<!-- Document Title
	============================================= -->
	<title>콜라보레이션</title>

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






		<!-- 타이틀
		============================================= -->
		<section id="page-title" class="page-title-center" style="border:none; background-color:white; margin-top:140px; padding-bottom:0px;">

			<div class="container clearfix" style="background-color:white;">
				<h1>콜라보레이션 타이틀</h1>
				<span style="margin-top:20px;">
					<div class="d-flex align-items-center" style="justify-content: center;">
                       <a href="#"><img src="/images/collaboration/author.jpg" alt="Author" class="rounded-circle" width="35" height="35"></a>
                       <div class="entry-meta mt-0">
                         <div class="entry-meta" style=" margin-bottom:10px; padding-left: 10px;">
                             <ul>
                                <li><a href="#">Author</a></li>
                                <li><i class="icon-calendar3"></i>2021.11.21</li>
                             </ul>
                         </div>
                       </div>
                     </div>
				</span>

				<div style=" width:1600px; margin-left: -125px;">
					<!-- 서브메뉴
					============================================= -->
					<nav class="primary-menu" style="margin-top:150px; border-top:2px solid #f3f3f3; border-bottom:2px solid #f3f3f3">

						<ul class="menu-container" style="margin-Left:150px;">
							<li class="menu-item">
								<a class="menu-link" href="col_detail"><div style="font-size:20px; font-weight:normal;">콜라보레이션 소개</div></a>
							</li>
							<li class="menu-item">
								<a class="menu-link" href="col_worklist"><div style="font-size:20px; font-weight:normal;">참여작품</div></a>
							</li>
							<div style="margin-left:750px;">
								<li>
									<button class="button m-3" onclik="">접수하기</button>
								</li>
							</div>
						</ul>

					</nav><!-- 서브메뉴 끝 -->
					</div>
				</div>
		
		</section><!-- 타이틀 끝 -->


		<!-- 상세내용
		============================================= -->
		<section id="content">
			<div class="content-wrap">
				<div class="container clearfix">
			 <!-- Posts
            ============================================= -->
            <div id="posts" class="post-grid grid-container row gutter-40 mx-3">

				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/8.jpg" data-lightbox="image"><img src="/images/blog/small/8.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
 
				   </div>
				</div>
 
		   <div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/9.jpg" data-lightbox="image"><img src="images/blog/small/9.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
 
		   <div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/10.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
 
		   <div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/11.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
 
		   <div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/12.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
 
		   <div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
				   <div class="grid-inner">
					  <div class="entry-image">
						 <a href="/images/blog/full/17.jpg" data-lightbox="image"><img src="/images/blog/small/13.jpg" alt="Standard Post with Image"></a>
					  </div>
					  <div class="entry-title">
						 <h2><a href="blog-single.html">작품 타이틀</a></h2>
					  </div>
					  <div class="author-image" style="margin-top: 15px;">
				 <img src="/images/author/1.jpg" alt="image" class="rounded-circle">              
			   </div>
			   <div class="entry-meta" style="margin-top: 55px; padding-left: 10px;">
						 <ul>
							<li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li>
							<li><a href="#"><i class="icon-thumbs-up2"></i> 20</a></li>
						 </ul>
					  </div>
 
				   </div>
				</div>
				
 
 
			 </div><!-- #posts end -->			
		</section>
		
		<!-- Footer ============================================= -->
		<footer id="footer" class="dark">
			<%@ include file="../include/footer.jsp"%>
		</footer>
		<!-- #footer end -->

	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>
	</div><!-- #wrapper end-->

</body>
</html>
