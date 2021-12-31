<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Collaboration Alert</title>
<script type="text/javascript">
	<c:if test="${condition == 'noUser'}">
		alert("로그인을 하세요.");
		location.href = "<c:url value='/login'/>";
	</c:if>
	<c:if test="${condition == 'noCreator'}">
		alert("크리에이터가 아닙니다. 작품 등록을 하여 크리에이터 등록을 완료하세요.");
		location.href = "<c:url value='/upload'/>";
	</c:if>
	<c:if test="${condition == 'organizer'}">
		alert("본인이 등록한 콜라보레이션에는 참가할 수 없습니다.");
		location.href = "<c:url value='/collaboration/main'/>";
	</c:if>
	<c:if test="${condition == 'InvalidRequest'}">
		alert("유효한 요청이 아닙니다.");
		location.href = "<c:url value='/collaboration/main'/>";
	</c:if>
	<c:if test="${condition == 'already'}">
		alert("이미 참여한 콜라보레이션 입니다.");
		location.href = "<c:url value='/collaboration/main'/>";
	</c:if>
	<c:if test="${update == 'success'}">
		alert("참여가 완료 되었습니다.");
		location.href = "<c:url value='/collaboration/art/${updateValue}'/>";
	</c:if>
	<c:if test="${update == 'underway'}">
		alert("평가중입니다. 기다리세요.");
		location.href = "<c:url value='/collaboration/art/${artworkValue}'/>";
	</c:if>
	
	<c:if test="${msg == 'winnerComplete'}">
		alert("수상작 평가를 완료했습니다! 이제 수상작품에 뜹니다.");
		location.href = "<c:url value='/collaboration/main'/>";
	</c:if>
	<c:if test="${msg == 'winnerFail'}">
		alert("수상작 평가에 실패했습니다.");
		location.href = "<c:url value='/collaboration/main'/>";
	</c:if>
	<c:if test="${msg == 'winnerNotSelect'}">
		alert("선정작을 선택하지 않았습니다.");
		location.href = "<c:url value='/collaboration/main'/>";
	</c:if>
	
	
	<c:if test="${msg == 'colRegister'}">
		alert("콜라보레이션 등록을 완료했습니다.");
		location.href = "<c:url value='/collaboration/main'/>";
	</c:if>
	<c:if test="${msg == 'colFail'}">
		alert("콜라보레이션 등록에 실패했습니다.");
		location.href = "<c:url value='/collaboration/main'/>";
	</c:if>
</script>
</head>
</html>