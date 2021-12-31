<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Stylesheets================== -->
<script type="text/javascript" nonce="a4f84d226a5b4b17b010d07a1b5" src="//local.adguard.org?ts=1635669619739&amp;type=content-script&amp;dmn=themes.semicolonweb.com&amp;app=msedge.exe&amp;css=3&amp;js=1&amp;rel=1&amp;rji=1&amp;sbe=0"></script>
<script type="text/javascript" nonce="a4f84d226a5b4b17b010d07a1b5" src="//local.adguard.org?ts=1635669619739&amp;name=AdGuard%20Extra&amp;name=AdGuard%20Popup%20Blocker&amp;type=user-script"></script>
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap" rel="stylesheet" type="text/css" />
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
<title>콜라보레이션</title>

<style>
.mfp-close {
	display: none !important;
}

.font-style {
	padding: 5px;
	padding-left: 8px;
	padding-right: 8px;
	letter-spacing:-1px;
	border-radius: 3px;
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

		<!-- content -->
		<section id="content">
			<div class="content-wrap">
				<div class="container clearfix" style="width: 1250px;">
					<div style="height: 50px;">
						<h3 style="display: inline-block;">진행중인 콜라보레이션</h3>
						<input type="hidden" name="userId" id="userId" value="${userId }">
						<input type="hidden" name="creatorId" id="creatorId" value="${creatorId }">
						<button type="button" onclick="fn_check();return false;" style="float: right; border-color: #00d084; border-radius: 25px; width: 190px; Height: 50px; color: #00d084; background-color: #ffffff">콜라보레이션 기획</button>
					</div>
					<hr>
					

					
					<div class="post-grid row col-mb-30">
						<!-- 콘텐츠 나열해주는 감싸기-->
					<c:forEach var="result" items="${result }">
						<c:if test = "${result.deadLineDateCompare > 0}">
						<!-- 콘텐츠 1 시작-->
						<div class="entry col-lg-4 col-md-6">
							<div class="grid-inner shadow-sm card rounded-5">
								<div class="entry-image mb-3">
									<div class="fslider" data-arrows="false" ata-lightbox="gallery">
										<div class="flexslider">
											<div class="slider-wrap">
												<div style="height: 230px; overflow: hidden">
													<a href="<c:url value='./${result.collaborationId}'/>">
													<img src="${result.storedFileName}"/>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="p-4">
									<div style="height:54px; margin-bottom: 20px;">
										<h4 class="center">
											<a href="<c:url value='./${result.collaborationId}'/>">${result.title }</a>
										</h4>
									</div>

										<div class="row justify-content-center" style="width:300px;margin:0 auto;">
												<div class="d-flex flex-row align-items-center rounded" style="margin-bottom: 15px;">
													<div id="countdown" class="countdown flex-fill"
														data-year="${result.deadLineYear }" data-month="${result.deadLineMonth }" data-day="${result.deadLineDay }"
														data-format="dHMS"></div>
												</div>
										</div>									

									<hr class="my-4">
									<div class="d-flex align-items-center">
										<c:choose>
											<c:when test="${result.creatorProfileStoredFileName eq null}">
											<a href="<c:url value='/blog/${result.creatorId}'/>"><img src="https://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=60"
												class="rounded-circle" width="38" height="38"></a>
											</c:when>
											<c:when test="${result.creatorProfileStoredFileName ne null}">
											<a href="<c:url value='/blog/${result.creatorId}'/>"><img src="${result.creatorProfileStoredFileName}"
												class="rounded-circle" width="38" height="38"></a>
											</c:when>
										</c:choose>
										<div class="entry-meta mt-0">
											<div class="entry-meta" style="margin-bottom: 10px; padding-left: 10px;">
												<ul>
													<li><a href="<c:url value='/blog/${result.creatorId}'/>"><h6 class="mb-1 h6" style="display: inline;">${result.creatorNickName }</h6></a></li>
													<li><i class="icon-calendar3"></i>${result.registerDate }</li>
													<!-- <li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li> -->
													<li>${result.artworkcount}명 참여</li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 콘텐츠 1 끝-->
						</c:if>
						</c:forEach>
						<ul class="pagination mt-5 pagination-circle justify-content-center" id="pagingNumbers">
			              <li class="page-item disabled"><a class="page-link" href="#"><i class="icon-angle-left"></i></a></li>
			              <li class="page-item active"><a class="page-link" href="#">1</a></li>
			              <li class="page-item"><a class="page-link" href="#"><i class="icon-angle-right"></i></a></li>
			            </ul>
						
					</div>

					

				</div>



				<div class="container clearfix"
					style="margin-top: 200px; width: 1250px;">
					<h3>지난 콜라보레이션</h3>
					<hr>

					<div class="post-grid row col-mb-30">
						<!-- 콘텐츠 나열해주는 감싸기-->
						
					<c:forEach var="result" items="${result }">
						<c:if test = "${result.deadLineDateCompare <= 0}">
						<!-- 콘텐츠 1 시작-->
						<div class="entry col-lg-4 col-md-6">
							<div class="grid-inner shadow-sm card rounded-5">
								<div class="entry-image mb-3">
									<div class="fslider" data-arrows="false"
										data-lightbox="gallery">
										<div class="flexslider">
											<div class="slider-wrap">
												<div style="height: 230px; overflow: hidden">
													<a href="<c:url value='./${result.collaborationId}'/>">
													<img src="${result.storedFileName}"/>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="p-4" style="padding-top:12px;">

										<div class="row justify-content-center">
											<div class="d-flex flex-row align-items-center rounded"
												style="margin-bottom: 10px;">
												<c:choose>
												<c:when test="${result.evaluate eq true}">
												<div class="font-style"
															style="border: #404040 solid 1px; text-align: center; background-color: #666666; color: white;margin:0 auto; font-size:13px;">당선작  &nbsp;&nbsp;발표</div>
												</c:when>
												<c:when test="${result.evaluate eq false}">
												<div class="font-style"
															style="border: #404040 solid 1px; text-align: center; background-color: #666666; color: white;margin:0 auto; font-size:13px;">당선작  &nbsp;&nbsp;선정중</div>
												</c:when>
												</c:choose>
											</div>
										</div>
										<h4 class="center" style="margin-bottom: 30px;">
												<a href="<c:url value='./${result.collaborationId}'/>">${result.title }</a>
											</h4>
										
									<hr class="my-4">
									<div class="d-flex align-items-center">
										<c:choose>
											<c:when test="${result.creatorProfileStoredFileName eq null}">
											<a href="<c:url value='/blog/${result.creatorId}'/>"><img src="https://0.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=60"
												class="rounded-circle" width="38" height="38"></a>
											</c:when>
											<c:when test="${result.creatorProfileStoredFileName ne null}">
											<a href="<c:url value='/blog/${result.creatorId}'/>"><img src="${result.creatorProfileStoredFileName}"
												class="rounded-circle" width="38" height="38"></a>
											</c:when>
										</c:choose>
										<div class="entry-meta mt-0">
											<div class="entry-meta"
												style="margin-bottom: 10px; padding-left: 10px;">
												<ul>
													<li><a href="<c:url value='/blog/${result.creatorId}'/>"><h6 class="mb-1 h6" style="display: inline;">${result.creatorNickName }</h6></a></li>
													<li><i class="icon-calendar3"></i>${result.registerDate }</li>
													<!-- <li><a href="blog-single.html#comments"><i class="icon-comments"></i> 13</a></li> -->
													<li>${result.artworkcount}명 참여</li>
												</ul>
												
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 콘텐츠 1 끝-->
						</c:if>
						</c:forEach>
						
						<ul class="pagination mt-5 pagination-circle justify-content-center" id="pagingNumbers">
			              <li class="page-item disabled"><a class="page-link" href="#"><i class="icon-angle-left"></i></a></li>
			              <li class="page-item active"><a class="page-link" href="#">1</a></li>
			              <li class="page-item"><a class="page-link" href="#"><i class="icon-angle-right"></i></a></li>
			            </ul>
					</div>

				</div>
		
				
				
			</div>
		</section>
		<!--Content End-->


		<!-- Go To Top ============================================= -->
		<div id="gotoTop" class="icon-angle-up"></div>

		<!-- JavaScripts  ============================================= -->
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


		<script>
			jQuery(document).ready(function($) {
				$('.videoplay-on-hover').hover(function() {
					if ($(this).find('video').length > 0) {
						$(this).find('video').get(0).play();
					}
				}, function() {
					if ($(this).find('video').length > 0) {
						$(this).find('video').get(0).pause();
					}
				});
			});
			
			jQuery(document).ready(function() {

				var element = $(".custom-file");

				element.find('input[type="file"]').change(function(e) {
					var fileName = e.target.files[0].name;
					element.find('.custom-file-label').html(fileName);
				});

				$('#template-contactform').on('formSubmitSuccess', function() {
					setTimeout(function() {
						$('#block-modal-request').magnificPopup('close');
					}, 500);
				});

			});
			
			$(function() {
				
				$('.component-datepicker.default').datepicker({					
					autoclose: true,
					startDate: "today",
					format: "yyyy-mm-dd"
				});

			});

		</script>
		<script>
		function fn_check() {
			var userId = document.getElementById('userId');
			var creatorId = document.getElementById('creatorId');
			
			if(userId.value == "" || userId.value == null) {
				alert("로그인 후 이용가능합니다.");
				location.href="<c:url value='/login' />";
				return false;
			}
			if(creatorId.value == "" || creatorId.value == null) {
				alert("작품을 최소 1개이상 등록해주세요.");
				window.open("<c:url value='/upload'/>","fileUpload","width=1250,height=700");
				return false;
			}
			location.href = "<c:url value='./planning/${creatorId}' />"
			
		}
		
		</script>

		<!-- Footer
         ============================================= -->
		<footer id="footer" class="dark">

			<%@ include file="../include/footer.jsp"%>

		</footer>
		<!-- #footer end -->



		<!-- Go To Top
   ============================================= -->
		<div id="gotoTop" class="icon-angle-up"></div>
	</div>
	<!-- #wrapper end -->


</body>
</html>