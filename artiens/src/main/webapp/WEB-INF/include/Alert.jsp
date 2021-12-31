<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <c:set var="creator" value="${creator }" />
   <c:set var="message" value="${message }" />
   <c:set var="msg" value="${msg }" />

<script language="javaScript">
   <c:choose>
      <c:when test="${ message == '크리에이터로 등록되지 않은 아이디 입니다' }">
         alert("첫 작품을 게시하고 크리에이터 등록을 해주세요.");
         location.href="<c:url value='/' />";
         window.open("<c:url value='/upload'/>","fileUpload","width=1250,height=700");
      </c:when>
      <c:when test="${creator == '크리에이터를 등록해 주세요.'}">
         alert("크리에이터를 등록해 주세요.");
         location.href="<c:url value='/' />";
      </c:when>
      <c:when test="${ message == 'Success image upload' }">
         alert("이미지 업로드가 완료되었습니다.");
         opener.location.reload();
         window.close();
      </c:when>
      <c:when test= "${ message == '잘못된 접근입니다' }">
         alert("잘못된 접근입니다.");
         location.href="<c:url value='/' />";
      </c:when>
      <c:when test="${ message == 'fail' }">
         alert("이미지 업로드에 실패하였습니다.");
         opener.location.reload();
         window.close();
      </c:when>
      <c:when test="${ message == 'Success insert creator' }">
         alert("크리에이터 등록 및 작품 등록에 성공하였습니다.");
         opener.location.reload();
         window.close();
      </c:when>
      <c:when test="${ message == '크리에이터로 등록된 아이디입니다'}">
         location.href="<c:url value='/blog/my/${creator_id}' />";
      </c:when>
      <c:when test="${ message == '댓글등록성공'}">
         alert("댓글을 등록하였습니다.");
         location.href="<c:url value='/artwork/detail/${imageURL}' />";
      </c:when>
      <c:when test="${ message == '댓글등록실패'}">
         alert("댓글 등록에 실패하였습니다.");
         location.reload();
      </c:when>

   </c:choose>
</script>