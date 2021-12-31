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
<title>콜라보레이션 | 참여 작품</title>

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
				<h1>${result.collaborationTitle}</h1>
				
				<span style="margin-top: 20px;">
					<div class="d-flex align-items-center" style="justify-content: center;">
						<a href="#"><img src="${result.collaborationCreatorImage}" alt="Author"
							class="rounded-circle" width="25" height="25"></a>
						<div class="entry-meta mt-0">
							<div class="entry-meta"
								style="margin-bottom: 10px; padding-left: 10px;">
								<ul>
									<li><a href="<c:url value='/blog/${result.collaborationCreatorId}'/>">${result.collaborationCreatorName}</a></li>
									<li><i class="icon-calendar3"></i>${result.colRegisterDateTime} ~ ${result.colDeadlineDateTime}</li>
								</ul>
							</div>
						</div>
					</div>
				</span>


				<div>
					<!-- 서브메뉴 ============================================= -->
						<%@ include file="../include/colArtWorkNav.jsp"%>
					<!-- 서브메뉴 끝 -->
				</div>
				<!-- Section Light -->
				
			</div>

		</section>
		<!-- 타이틀 끝 -->


	<!-- 상세내용
		============================================= -->
	<section id="content">
		<div class="content-wrap">
			<div class="container clearfix">
				<!-- Posts  ============================================= -->
				<div id="posts" class="post-grid grid-container row gutter-40 mx-3">
					<!--FORM-->
					<c:forEach var="artwork" items="${result.artWorks.content}">
						<div class="entry col-lg-3 col-md-4 col-sm-6 col-12">
							<div class="grid-inner">
								<div class="entry-image">
									<a href="<c:url value="${artwork.colArtWorkImage}"/>"
										data-lightbox="image"><img
										src="<c:url value="${artwork.colArtWorkImage}"/>"
										alt="Standard Post with Image"></a>
								</div>
								<div class="entry-title">
									<h2>
										<a href="<c:url value="/collaboration/art/${artwork.colArtWorkId}"/>">${artwork.colArtWorkTitle}</a>
									</h2>
								</div>
								<div class="author-image" style="margin-top: 15px;">
									<img src="${artwork.colArtWorkCreatorImage}" alt="image" class="rounded-circle">
								</div>
								<div class="entry-meta"
									style="margin-top: 55px; padding-left: 10px;">
									<ul>
										<li><a href="#"><i class="icon-user"></i>${artwork.colArtWorkCreatorName}</a></li>
										<li><a href="#"><i class="icon-pencil"></i>${artwork.colArtWorkregiseDateTime}</a></li>
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>
					<!--FORM end-->
				</div>
				<!-- #posts end -->
				<ul class="pagination mt-5 pagination-circle justify-content-center" id="pagingNumbers">
                <!-- <li class="page-item disabled"><a class="page-link" href="#"><i class="icon-angle-left"></i></a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item"><a class="page-link" href="#"><i class="icon-angle-right"></i></a></li> -->
            	</ul>
	</section>
	
	<!-- Footer
		============================================= -->
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
		<!-- Footer Scripts
		============================================= -->
		<script src='<c:url value="/js/functions.js"/>'/></script>
	</div>
	<!-- #wrapper end-->	
<script>
function pageAlgo(totalPageSize, bottomSize, cursor){
   	
    let pageNumList = []
    for (let i = cursor - (bottomSize - 1) ; i <= cursor + (bottomSize - 1); i++ ){
    	if (i >= 1 && i <= totalPageSize){
    		pageNumList.push(i);
    	}
    }
    console.log(pageNumList.toString());
    
    if (pageNumList.length > bottomSize){
    	let modifyPageNumList = []; 
    	let cursorIndex = pageNumList.indexOf(cursor);
    	
    	modifyPageNumList.push(pageNumList[cursorIndex]);
    	let front = cursorIndex - 1;
    	let end = cursorIndex + 1;
    	
    	while (modifyPageNumList.length != bottomSize){
    		if (front >= 0){
    			modifyPageNumList.push(pageNumList[front]);
    		} 
			if (end < pageNumList.length){
        		modifyPageNumList.push(pageNumList[end]);
			}	
      		front -= 1;
      		end += 1;
    	}
    	pageNumList = modifyPageNumList.sort();
    }

    console.log(pageNumList.toString());
    
    var pageNumForm = document.querySelector('#pagingNumbers');
    
    if (cursor > 1) pageNumForm.innerHTML += '<li class="page-item"><a class="page-link" href="?page='+ (cursor - 2) +'" aria-label="Previous"><i class="icon-angle-left"></i></a></li>';	
    
    for (let i = 0 ; i < pageNumList.length; i++){
    	let pageNumber =  pageNumList[i];
    	if (pageNumber == cursor){
    		pageNumForm.innerHTML += '<li class="page-item active"><a class="page-link" href="?page=' + (pageNumber-1) +'">'+ pageNumber +'</a></li>';
    	} else{
    		pageNumForm.innerHTML += '<li class="page-item"><a class="page-link" href="?page=' + (pageNumber - 1) +'">'+ pageNumber + '</a></li>';
    	}
    }
    
    if (cursor < totalPageSize) pageNumForm.innerHTML += '<li class="page-item"><a class="page-link" href="?page=' + cursor + '" aria-label="Next"><i class="icon-angle-right"></i></a></li>';	
    
}
const totalPageSize = ${result.artWorks.totalPages}
// 하단크기
const bottomSize = 5
//  현재 나의 페이지
const cursor = ${result.artWorks.number} + 1

pageAlgo(totalPageSize, bottomSize, cursor)
</script>
</body>
</html>