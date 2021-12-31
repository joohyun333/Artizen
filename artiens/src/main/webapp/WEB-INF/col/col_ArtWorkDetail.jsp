<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<!-- Stylesheets
	============================================= -->
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap" rel="stylesheet" type="text/css" />
<script type="text/javascript" nonce="a4f84d226a5b4b17b010d07a1b5" src="//local.adguard.org?ts=1635669619739&amp;type=content-script&amp;dmn=themes.semicolonweb.com&amp;app=msedge.exe&amp;css=3&amp;js=1&amp;rel=1&amp;rji=1&amp;sbe=0"></script>
<script type="text/javascript" nonce="a4f84d226a5b4b17b010d07a1b5" src="//local.adguard.org?ts=1635669619739&amp;name=AdGuard%20Extra&amp;name=AdGuard%20Popup%20Blocker&amp;type=user-script"></script>
<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"></c:url>' type="text/css" />
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
<title>콜라보레이션 작품</title>
<style>

.mfp-close {
		display: none !important;
	}


@media ( min-width : 992px) {
	.block-nav-menu .menu-item .menu-link {
		position: relative;
	}
	.block-nav-menu .menu-item .menu-link::before {
		content: '';
		position: absolute;
		opacity: 0;
		top: 50%;
		left: 0;
		width: 100%;
		height: 50%;
		background-color: #1ABC9C;
		transform: translateY(-50%) skew(2deg) rotate(-2deg);
		transition: opacity .1s;
		z-index: 0;
	}
	.block-nav-menu .sub-menu-container .menu-item>.menu-link::before {
		top: 0;
		height: 100%;
		transform: translateY(0) skew(2deg) rotate(-2deg);
		background-color: #F5F5F5;
	}
	.dark .block-nav-menu .sub-menu-container .menu-item>.menu-link::before
		{
		background-color: rgba(0, 0, 0, 0.15);
	}
	.block-nav-menu .sub-menu-container .menu-item:hover>.menu-link {
		background-color: transparent;
	}
	.dark .block-nav-menu .menu-container>.menu-item:hover>.menu-link, .dark .block-nav-menu .menu-container>.menu-item.current>.menu-link,
		.block-nav-menu .menu-container>.menu-item:hover>.menu-link,
		.block-nav-menu .menu-container>.menu-item.current>.menu-link {
		color: #EEE;
	}
	.block-nav-menu .menu-item:hover>.menu-link::before, .block-nav-menu .menu-item.current>.menu-link::before
		{
		opacity: 1;
	}
	.block-nav-menu .menu-item>.menu-link>div {
		position: relative;
		z-index: 2;
	}
}
</style>
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

		<!-- 타이틀============================================= -->
		<section id="page-title" class="page-title-center"
			style="background-color: white; border: none; padding-bottom: 0px;">
			<div class="container clearfix" style="background-color: white;">
				<c:if test="${result.winner eq true}">
					<span class="fw-bold"
						  style="font-size:1.8em;
						  		 width:7em;
						  		 background-color:#13cc83; 
						  		 color:white; 
						  		 margin-bottom:1em;">수상작
					</span>
				</c:if>
				<h1><a href="<c:url value='/collaboration/${result.collaborationId}'/>">${result.collaborationTitle}</a></h1>
				<h3>- ${result.title} -</h3>
				<span style="margin-top: 20px;">
					<div class="d-flex align-items-center"
						style="justify-content: center;">
						<a href="#"><img src="${result.creatorImgName}" alt="Author"
							class="rounded-circle" width="35" height="35"></a>
						<div class="entry-meta mt-0">
							<div class="entry-meta"
								style="margin-bottom: 10px; padding-left: 10px;">
								<ul>
									<li><a href="/blog/${result.creatorId}">${result.creatorNickname}</a></li>
									<li><i class="icon-calendar3"></i>${result.registerDate}</li>
								</ul>
							</div>
						</div>
					</div>
				</span>


				<!-- Section Light -->
				
			</div>

		</section>
		<!-- 타이틀 끝 -->


		<!-- 상세내용
		============================================= -->
		<section id="content">
			<div class="content-wrap">
				<div class="container clearfix">

					<div class="single-post mb-0">

						<!-- Single Post
						============================================= -->
						<div class="entry clearfix">



							<!-- 이미지
							============================================= -->

							<div class="entry-image bottommargin">
								<img src="${result.contentImgName}" alt="Blog Single">
							</div>
							<!-- 아미지 끝 -->

							<!-- 내용
							============================================= -->
							<div class="entry-content mt-0">

								<blockquote>
									<p>${result.content}</p>
								</blockquote>
								<!-- 내용 끝 -->

								<div class="clear"></div>

							</div>
						</div>
						<!-- .entry end -->
						<!-->

						<!-- 댓글
						============================================= -->
						<div id="comments" class="clearfix" style="border: none;">

							<!-- 댓글작성
							============================================= -->
							<div id="respond">

								<h3>
									<span>댓글작성</span>
								</h3>

								<form class="row" action="" method="get" id="commentform"
									onsubmit="return commentAlert()">

									<div class="w-100"></div>
									<div>
										<input type="hidden" name="" value="">
									</div>

									<div class="col-12 form-group">
										<textarea name="" cols="58" rows="7" tabindex="4"
											class="sm-form-control" placeholder="댓글을 입력하세요."></textarea>
									</div>

									<div class="col-12 form-group" style="text-align: right;">
										<button type="submit" id="submit-button" tabindex="5" value=""
											class="button button-3d m-0">작성하기</button>
									</div>
								</form>
								<script type="text/javascript">
									function commentAlert() {
										alert("댓글 작성은 구현 중입니다.");
									}
								</script>

							</div>
							<!-- 댓글작성 끝-->


							<!-- 댓글목록
							============================================= -->
							<div class="line"></div>

							<h3 id="comments-title">
								<span>${result.commentCount}</span> 개의 댓글
							</h3>

							<!-- <ol class="commentlist clearfix" style="border: none;">

								<li class="comment even thread-even depth-1" id="li-comment-1">

									<div id="comment-1" class="comment-wrap clearfix">

										<div class="comment-meta">

											<div class="comment-author vcard">

												<span class="comment-avatar clearfix"> <img
													alt='Image'
													src='https://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=60'
													class='avatar avatar-60 photo avatar-default' height='60'
													width='60' /></span>

											</div>

										</div>

										<div class="comment-content clearfix">

											<div class="comment-author">
												John Doe<span><a href="#"
													title="Permalink to this comment">April 24, 2012 at
														10:46 am</a></span>
											</div>

											<p>Donec sed odio dui. Nulla vitae elit libero, a
												pharetra augue. Nullam id dolor id nibh ultricies vehicula
												ut id elit. Integer posuere erat a ante venenatis dapibus
												posuere velit aliquet.</p>

											<a class='comment-reply-link' href='#'><i
												class="icon-reply"></i></a>

										</div>

										<div class="clear"></div>

									</div>


									<ul class='children'>

										<li
											class="comment byuser comment-author-_smcl_admin odd alt depth-2"
											id="li-comment-3">

											<div id="comment-3" class="comment-wrap clearfix">

												<div class="comment-meta">

													<div class="comment-author vcard">

														<span class="comment-avatar clearfix"> <img
															alt='Image'
															src='https://1.gravatar.com/avatar/30110f1f3a4238c619bcceb10f4c4484?s=40&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D40&amp;r=G'
															class='avatar avatar-40 photo' height='40' width='40' /></span>

													</div>

												</div>

												<div class="comment-content clearfix">

													<div class="comment-author">
														<a href='#' rel='external nofollow' class='url'>SemiColon</a><span><a
															href="#" title="Permalink to this comment">April 25,
																2012 at 1:03 am</a></span>
													</div>

													<p>Nullam id dolor id nibh ultricies vehicula ut id
														elit.</p>

													<a class='comment-reply-link' href='#'><i
														class="icon-reply"></i></a>

												</div>

												<div class="clear"></div>

											</div>

										</li>

									</ul>

								</li>

								<li
									class="comment byuser comment-author-_smcl_admin even thread-odd thread-alt depth-1"
									id="li-comment-2">

									<div id="comment-2" class="comment-wrap clearfix">

										<div class="comment-meta">

											<div class="comment-author vcard">

												<span class="comment-avatar clearfix"> <img
													alt='Image'
													src='https://1.gravatar.com/avatar/30110f1f3a4238c619bcceb10f4c4484?s=60&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D60&amp;r=G'
													class='avatar avatar-60 photo' height='60' width='60' /></span>

											</div>

										</div>

										<div class="comment-content clearfix">

											<div class="comment-author">
												<a href='https://themeforest.net/user/semicolonweb'
													rel='external nofollow' class='url'>SemiColon</a><span><a
													href="#" title="Permalink to this comment">April 25,
														2012 at 1:03 am</a></span>
											</div>

											<p>Integer posuere erat a ante venenatis dapibus posuere
												velit aliquet.</p>

											<a class='comment-reply-link' href='#'><i
												class="icon-reply"></i></a>

										</div>

										<div class="clear"></div>

									</div>

								</li>

							</ol>
							댓글목록 끝 -->

							<!-- <div class="clear"></div> -->

						</div>
						<!-- 댓글 끝 -->

					</div>

				</div>
			</div>
		</section>
		<!-- 상세내용 끝 -->
</div>
<!-- #wrapper end-->
<!-- Footer ============================================= -->
<footer id="footer" class="dark">
	<%@ include file="../include/footer.jsp"%>
</footer>
<!-- #footer end -->

<!-- Go To Top
============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>
<!-- JavaScripts ============================================= -->
<script src='<c:url value="/js/jquery.js"/>'/></script>
<script src='<c:url value="/js/plugins.min.js"/>'/></script>

<!-- Date & Time Picker JS -->
<script src='<c:url value="/js/components/moment.js"/>'/></script>
<script src='<c:url value="/js/components/timepicker.js"/>'/></script>
<script src='<c:url value="/js/components/datepicker.js"/>'/></script>

<!-- Include Date Range Picker -->
<script src='<c:url value="/js/components/daterangepicker.js"/>'/></script>
<!-- Footer Scripts
============================================= -->
<script src='<c:url value="/js/functions.js"/>'/></script>
</body>
</html>