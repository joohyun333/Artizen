<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<!-- Stylesheets
	============================================= -->
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Poppins:300,400,500,600,700|PT+Serif:400,400i&display=swap" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/bootstrap.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/style.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/dark.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/font-icons.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/animate.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/magnific-popup.css"></c:url>' type="text/css" />

 <!-- Bootstrap File Upload CSS -->
<link rel="stylesheet" href='<c:url value="/css/components/bs-filestyle.css"></c:url>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/css/components/select-boxes.css"></c:url>' type="text/css" />

<link rel="stylesheet" href='<c:url value="/css/custom.css"></c:url>' type="text/css"/>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Document Title
	============================================= -->
<title>콜라보레이션</title>
<style>
.file-caption.icon-visible .file-caption-name {
            font-family: 'Lato', sans-serif;
            color: #666;
        }
        /* .form-process {
            position: absolute;
            -webkit-transition: all .3s ease;
            -o-transition: all .3s ease;
            transition: all .3s ease;
            background-image: none;
        }

        .form-process > div { background-color: #999;  }

        .form-process,
        #template-contactform-submitted,
        .template-contactform-complete .form-process {
            display: none;
            opacity: 0;
            background-color: rgba(255,255,255,0.7);
        }

        .template-contactform-processing .form-process {
            display: block;
            opacity: 1;
        } */

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
		
		
		<!-- Content ============================================= -->
	    <section id="content">
	
	        <div class="content-wrap" style="background: linear-gradient(90deg, #fdfcfb 0%, #e2d1c3 100%)">
	
	            <div class="container">
	
	                <div class="row justify-content-center">
	                    <div class="col-lg-7 col-md-10">
	                        <div class="card shadow-sm">
	                            <div class="card-header">
	                                <h4 class="mb-0">${collaborationTitle}에 참여 작품 신청</h4>
	                            </div>
	                            <div class="card-body">
	
	                               <!--  <div class="form-widget"> -->
	
	                                    <!-- <div class="form-result"></div>
	
	                                    <div class="form-process">
	                                        <div class="css3-spinner">
	                                            <div class="css3-spinner-double-bounce1"></div>
	                                            <div class="css3-spinner-double-bounce2"></div>
	                                        </div>
	                                    </div> -->
	
	                                    <form action='<c:url value="/collaboration/art/register"></c:url>' method="post" enctype="multipart/form-data">
											<input type="hidden" name="collaborationId" value="${collaborationId}">
	                                        <div class="row">
	
	                                            <div class="col-12 bottommargin-sm">
	                                                <label for="template-contactform-name">제목<small class="text-danger">*</small></label>
	                                                <input type="text" id="template-contactform-name" name="title" value="" class="form-control required" placeholder="참여작품의 제목" />
	                                            </div>
	
	                                            <div class="col-12 bottommargin-sm">
	                                                <label for="template-contactform-upload">참여 작품:</label><br>
	                                                <input id="template-contactform-upload" type="file" name="file" multiple class="file file-loading" data-show-preview="false">
	                                            </div>
	
	                                            <div class="col-12 bottommargin-sm">
	                                                <label for="template-contactform-message">참여 작품 설명:</label>
	                                                <textarea class="required form-control textarea-message" id="template-contactform-message" name="content" rows="6" cols="30"></textarea>
	                                            </div>
	
	                                            <div class="col-12 d-none">
	                                                <input type="text" id="template-contactform-botcheck" name="template-contactform-botcheck" value="" />
	                                            </div>
	                                            <div class="col-12">
	                                                <button type="submit"  name="submit" id="submit" class="btn btn-dark w-100 btn-lg">제출</button>
	                                            </div>
	
	                                            <input type="hidden" name="prefix" value="template-contactform-">
	
	                                        </div>
	
	                                    </form>
	                                </div>
	                            </div>
	                        <!-- </div> -->
	                    </div>
	                </div>
	
	            </div>
	        </div>
	    </section><!-- #content end -->
		
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
<!-- JavaScripts  ============================================= -->
<script src='<c:url value="/js/jquery.js"/>'/></script>
<script src='<c:url value="/js/plugins.min.js"/>'/></script>


<!-- Bootstrap File Upload Plugin -->
<script src='<c:url value="/js/components/bs-filestyle.js"/>'/></script>

<!-- TinyMCE Plugin -->
<script src='<c:url value="/js/components/tinymce/tinymce.min.js"/>'/></script>

<!-- Footer Scripts
============================================= -->
<script src='<c:url value="/js/functions.js"/>'/></script>
<script>

    jQuery(document).ready( function(){

        tinymce.init({
            selector: '.textarea-message',
            menubar: false,
            setup: function(editor) {
                editor.on('change', function(e) {
                    editor.save();
                });
            }
        });

    });


</script>
</body>
</html>