<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
/* 빨간선-확인용 삭제 할겁니다!
div {
   border: 1px solid red;
}

table {
   border: 1px solid red;
}

tr {
   border: 1px solid red;
}

td {
   border: 1px solid red;
}
구간 확인용 삭제 할겁니다!*/




.mainSubTitle{
color: rgb(49, 100, 176);

}

.tr01{
	border-bottom: 2px dashed rgb(49, 100, 176);
}

/* 메인 중간의 테이블 */
.maintable{
	width: 450px;
	
}

.more{
	font: 1;

}


</style>

</head>
<body>
<div align="center">

<table>
<tr>

<td>

<table class="maintable">
<tr class="tr01">
<td class="mainSubTitle"><b>공지사항</b></td>
<td align="right" class="more"><a href="getNoticeBoardList.do">more</a></td>
</tr>
<tr>
				<td colspan="2"><c:forEach var="vo"
						items="${noticeList }" varStatus="status">
						&nbsp;<b>∙</b><a
							href="getNoticeBoard.do?seq=${vo.seq}&&id=${member.id}">
							${vo.title }</a>
						&nbsp;<br />
					</c:forEach></td>
</tr>					


<tr class="tr01">				
				<td class="mainSubTitle"><b>최근 제의</b></td><td align="right" class="more"><a href="getBoardList.do">more</a></td>
</tr>
<tr>
<td class="mainSubValue" colspan="2"><c:forEach var="vo"
						items="${recentList }" varStatus="status">
						&nbsp;<b>∙</b><a
							href="getBoard.do?seq=${vo.seq}&&id=${member.id}"> ${vo.title }</a>
						&nbsp;<br />
					</c:forEach></td>



</tr>					
</table>
</td>

<td>&nbsp;&nbsp;&nbsp;</td>

<td>
<table class="maintable">
			<tr class="tr01">
				<td class="mainSubTitle"><b>HOT 제의</b></td><td align="right" class="more"><a href="getBoardList.do">more</a></td>
			</tr>
			<tr>
				<td class="mainSubValue" colspan="2"><c:forEach var="vo"
						items="${hotList }" varStatus="status">
						&nbsp;<b>∙</b><a
							href="getBoard.do?seq=${vo.seq}&&id=${member.id}"> ${vo.title }</a>
						&nbsp;<br />
					</c:forEach></td>
			</tr>		
			
			
			
			<tr class="tr01">	
				<td class="mainSubTitle"><b>출발마감임박!!</b></td><td align="right" class="more"><a href="getBookBoardList.do">more</a></td>
			</tr>
			
			
	<tr>
	<td class="mainSubValue" colspan="2"><c:forEach var="vo"
						items="${finishTimeList }" varStatus="status">
						&nbsp;<b>∙</b><a
							href="getBookBoard.do?seq=${vo.seq}&&id=${member.id}">
							${vo.title }</a>
						&nbsp;<br />
					</c:forEach></td>

			</tr>
			
			
		</table>
		
		</td>
		</tr>





</table>





</div>
<br/>

</body>
</html>