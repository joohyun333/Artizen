<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>::: ARTIZEN | 업로드 :::</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<style>
	::placeholder {
		font-size: 15px; color:white; font-style:italic;
	}
	#logo {filter: brightness(0%)}
</style>
<body>
<div>
	
	<form name="frm" id="frm" action="<c:url value='/upload'/> " method="POST" enctype="multipart/form-data">
		<input type="hidden" value="${creator }" name="creatorId">
		<input type="hidden" value="${userid }" name="userProfileId"/>
		<table class="table text-center caption-top" style="width:1200px;'"> 
			<caption class="text-center fs-3 fw-bold" ><img id="logo" src="<c:url value='/images/logo_new/logo_D.png' />" alt="Artizen Logo"></caption>
			<colgroup>
				<col width="10%"/>
				<col width="*"/>
			</colgroup>
			<tr style="height:60px;">
				<th>제목<small>*</small></th>
				<td><input type="text" name="title" id="title" class="form-control" placeholder="제목을 입력해 주세요"></td>
			</tr>
			<tr>
				<th>닉네임<small>*</small></th>
				<th>
				<c:choose>
					<c:when test="${Nickname ne null }">					
						<input type="text" name="nickname" value="${Nickname }" class="form-control" readonly>
					</c:when>
					<c:when test="${Nickname eq null }">
						<input type="text" name="nickname" class="form-control" placeholder="첫 등록이시라면  닉네임을 작성해 주세요!">
					</c:when>
				</c:choose>
				</th>
			</tr>
			<tr>	
				<th>파일첨부<small>*</small></th>
				<td><input type="file" name="file" class="form-control" multiple></td>
			</tr>
			<tr>
				<th rowspan="2">태그</th>
				<td class="border-bottom-0">
					<div class="d-flex text-center" style="width:750px; margin-left:100px;">
						<select id="tag1" class="form-select col-4 mt-2 mb-2" style="width:250px;">
							<option value="">태그를 선택하세요</option>
							<option value="1">감성적인</option>
							<option value="1">분위기</option>
							<option value="1">장르</option>
							<option value="1"></option>
						</select><br>
						<select id="tag2" class="form-select mt-2 mb-2" style="width:250px; display:none;">
							<option>태그를 선택하세요</option>
							<option>수채화</option>
							<option>수묵화</option>
							<option>유화</option>
							<option>팝아트</option>
							<option>동양적인</option>
							<option>서양화</option>
						</select>
						<select id="tag3" class="form-select mt-2 mb-2" style="width:250px; display:none;">
							<option value="">태그를 선택하세요</option>
							<option value="#수묵화">수묵화</option>
							<option value="#채색화">채색화</option>
							<option value="#풍경화">풍경화</option>
							<option value="#추상화">추상화</option>
							<option value="#인물화">인물화</option>
							<option value="#팝아트">팝아트</option>
							<option value="#정물화">정물화</option>
						</select>
					</div>					
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="tagbox" id="tagBox" class="form-control" value="" 
					placeholder="#태그는 최대 5개까지 등록 가능합니다." readonly>
					<input type="hidden" id="hideTagBox" />
				</td>
			</tr>
			<tr>
				<th>주제</th>
				<td>
					<select name="subject" class="form-control" style="width:250px;">
						<option value="수묵화">수묵화</option>
						<option value="채색화">채색화</option>
						<option value="풍경화">풍경화</option>
						<option value="추상화">추상화</option>
						<option value="인물화">인물화</option>
						<option value="팝아트">팝아트</option>
						<option value="정물화">정물화</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>작가의 말</th>
				<td><textarea name="talk" id="talk" class="form-control" style="height:200px;" placeholder="최대 10000자까지 등록 가능합니다."></textarea></td>
			</tr>
			<tr class="border-borderless">
				<td colspan="2">
					<button type="submit" name="submit" id="submit" class="btn btn-primary m-3">작품 등록</button>
					<button type="button" onclick="window.close();" class="btn btn-primary ms-3">취소</button>
				</td>
			</tr>
		</table>
		<div class="text-center">
		</div>
	</form>
</div>

<script>
	
	$(document).change(function(){
		if($('#tag1 option:selected').text() != "태그를 선택하세요") {
			$('#tag2').css('display','block');
		} 
		if($('#tag2 option:selected').text() != "태그를 선택하세요" ) {
			$('#tag3').css('display','block');
		}
		var hideTagBox = document.getElementById('hideTagBox');
		if( $('#tag3 option:selected').text() != "태그를 선택하세요" ) {
			hideTagBox.value += $('#tag3 option:selected').val()+" ";
			var tagArray = hideTagBox.value.split(" ");
			if ( tagArray.length >= 1 ) {
				var result = [];
				$.each(tagArray,function(index,element){
					if($.inArray(element,result) == -1 ){
						result.push(element);
					}
				})
			}
			var tagbox = document.getElementById("tagBox");
			tagbox.value = result;
			
	 	}
	});
	
	$(function(){
		$('#submit').click(function(){
			if( confirm("이미지를 등록하시겠습니까?") == true ) {
				document.frm.method = "post"; 
				theForm.action = "<c:url value='/upload'/>";
				document.frm.submit();
			}else {
				window.close();
			}
		})
	})
	
</script>
</body>
</html>