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
				href="<c:url value="/collaboration/${result.id}"/>"><div>콜라보레이션 소개</div></a></li>

			<c:if test="${result.pastDateBoolean eq true}">
				<li class="menu-item"><a class="menu-link" href="<c:url value = "/collaboration/${result.id}/art/winner"/>"><div>당선작품</div></a></li>
			</c:if>

			<li class="menu-item"><a class="menu-link" href="<c:url value = "/collaboration/${result.id}/art"/>"><div>참여작품</div></a></li>

			<li class="menu-item col-sm-6 col-12"></li>

			<c:choose>
				<c:when test="${result.pastDateBoolean eq false}">
					<!-- Button trigger modal -->
					<div>
						<a href="#" class="button button-border button-border-thin button-red" data-bs-toggle="modal" data-bs-target="#registerModal"><i class="icon-pencil"></i>접수하기</a>
					</div>
				</c:when>
				<c:when test="${result.pastDateBoolean eq true && result.evaluate eq false && result.creatorId ne null && result.creatorId eq creatorId}">
					<div>
						<a href="#" class="button button-border button-border-thin button-brown" data-bs-toggle="modal" data-bs-target="#evaluateModal"><i class="icon-pencil"></i>평가하기</a>
					</div>
				</c:when>
				<c:when test="${result.pastDateBoolean eq true}">
					<button class="button m-3 button-rounded button-red d-none d-xl-flex my-4 ms-3" id="modalbtn" disabled="disabled" style="cursor:default">마감된 콜라보레이션</button>
				</c:when>
			</c:choose>
		</ul>
	</nav>
	<!-- #primary-menu end -->
</div>

<!-- Modal - registerModal -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">공모전 접수</h4>
                <button type="button" class="btn-close btn-sm" data-bs-dismiss="modal" aria-hidden="true"></button>
            </div>
            <div class="modal-body">
                <h4>${result.title}</br> 에 참가하시겠습니까?</h4>
            </div>
            <div class="modal-footer">
            	<a href="#" class="button button-3d button-rounded button-red" data-bs-dismiss="modal"><i class="icon-line-arrow-left-circle"></i>취소하기</a>
                <a href="<c:url value='/collaboration/art/register/${result.id}'></c:url>" class="button button-3d button-rounded button-green"><i class="icon-hand-right"></i>참여하기</a>
            </div>
        </div>
    </div>
</div>

<!-- modal -->

<!-- Modal - evaluateModel -->
<div class="modal fade" id="evaluateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">공모전 작품 평가하기</h4>
                <button type="button" class="btn-close btn-sm" data-bs-dismiss="modal" aria-hidden="true"></button>
            </div>
            <div class="modal-body">
                <h4>${result.title}</br> 참가작품을 평가하시겠습니까?</h4>
            </div>
            <div class="modal-footer">
                <a href="#" class="button button-3d button-rounded button-red" data-bs-dismiss="modal"><i class="icon-line-arrow-left-circle"></i>취소하기</a>
                <a href="<c:url value='/collaboration/winner/${result.id}'></c:url>" class="button button-3d button-rounded button-black"><i class="icon-hand-right"></i>평가하기</a>
            </div>
        </div>
    </div>
</div>
<!-- modal -->
</section>