<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div align="center">
      <form id="commentForm" name="commentForm" action="insertComment.do"
         method="POST">
         <input type="hidden" id="id" name="id" value="${member.id }" /> <input
            type="hidden" id="name" name="name" value="${member.name } " /> <input
            type="hidden" id="seq" name="seq" value="${vo.seq }" /> <input
            type="hidden" id="state" name="state" value="${member.statecount }" />
         <table>
            <tr>
               <td align="left"><span><strong>댓글</strong></span> <span
                  id="commentCount"></span></td>
            </tr>
            <tr>
               <td><textarea rows="3" cols="60" id="content" name="content"
                     placeholder="댓글을 입력하세요."></textarea></td>
            </tr>
            <tr>
               <td align="right" width="60"><input type="button"
                  id="insertCommentbt" class="contentbt" value="등록"></td>
            </tr>
         </table>
         <input type="hidden" id="seq" name="seq" value="" />
      </form>
   </div>
   <div align="center">
      <form id="commentListForm" name="commentListForm" method="post">
         <c:set var="check" value="" />

         <div id="commentList" align="center"></div>
      </form>
   </div>

   <script>
      var updateCheck = 0;
      var updateCheckCno = 0;
      var getComment = "";
      //댓글 등록하기(ajax)
      $("#insertCommentbt").click(function() {
         if (document.commentForm.content.value == "") {
            alert("댓글을 입력해주세요.");
            return;
         }
         $.ajax({
            type : "POST",
            url : "<c:url value='insertComment.do'/>",
            data : $("#commentForm").serialize(),
            success : function(data) {
               if (data == "success") {

                  getCommentList();
                  document.commentForm.content.value = "";
               }
            },
            error : function(request, status, error) {
               alert("로그인 후 이용해주세요.");
            }

         });
      });

      //초기 페이지 로딩시 댓글 불러오기
      $(function() {
         getCommentList();
      });

      //댓글 불러오기(ajax)
      function getCommentList() {
         $
               .ajax({
                  type : "POST",
                  url : "<c:url value='commentList.do'/>",
                  dataType : "json",
                  data : $("#commentForm").serialize(),
                  contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                  success : function(data) {
                     var html = "";
                     var cCnt = data.length;
                     var sid = document.commentForm.id.value;
                     var state = document.commentForm.state.value;
                     if (data.length > 0) {
                        for (i = 0; i < data.length; i++) {

                           html += "<table width='500'><tr><td align='left'colspan='2'><h6><strong>"
                                 + data[i].name
                                 + "</strong></td><td align='left'>"
                                 + data[i].regdate;
                           if (sid == data[i].cid) {
                              html += "</h6></td><td align='right'>"
                                    + "<a href='#' onclick='updateComment("
                                    + data[i].cno
                                    + ")'>수정</a>&nbsp;"
                                    + "<a href='#' onclick='deleteComment("
                                    + data[i].cno + ")'>삭제</a>"
                                    + "</td></tr>";
                           } else if (state == 4) {
                              html += "<a href='#' onclick='deleteAdminComment("
                                    + data[i].cno
                                    + ")'>관리자 삭제</a>"
                                    + "</td></tr>";
                           } else {
                              html += "<td></td>";
                           }
                           if (data[i].cno == updateCheckCno
                                 && updateCheck == 1) {
                              html += "<tr><td colspan='3'>";
                              html += "<textarea rows='2' cols='50' id='updateContent' name='content'>"
                                    + getComment
                                    + "</textarea></td><td align='right'><input type='button' value = '확인'  class='contentbt' onclick='updateCommentCheck("
                                    + data[i].cno
                                    + ")'/>"
                                    + "</td></tr>";
                              html += "</table>";
                           } else {
                              html += "<tr><td colspan='4'>";
                              html += data[i].content + "</td></tr>";
                              html += "</table>";
                           }
                        }

                     } else {
                        html += "<div>";
                        html += "<div><table><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                        html += "</table></div>";
                        html += "</div>";
                     }
                     $("#commentCount").html(cCnt);
                     $("#commentList").html(html);

                  },
                  error : function(request, status, error) {

                  }
               });
      }

      function updateComment(cno) {
         $
               .ajax({
                  type : "POST",
                  url : "getComment.do",
                  dataType : "json",
                  data : {
                     "cno" : cno
                  },
                  contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                  success : function(data) {
                     updateCheck = 1;
                     updateCheckCno = cno;
                     getComment = data.content;
                     getCommentList();
                  }
               });
      }
      function updateCommentCheck(cno) {
         if (document.commentListForm.updateContent.value == "") {
            alert("댓글을 입력해주세요.");
            return;
         }
         $.ajax({
            type : "POST",
            url : "updateCommentCheck.do",
            data : {
               "cno" : cno,
               "content" : $("#updateContent").val()
            },
            success : function(data) {
               if (data == "success") {
                  updateCheck = 0;
                  getCommentList();
               }

            }
         });
      }
      function deleteAdminComment(cno) {
         if (confirm("정말 삭제하시겠습니까 ? ")) {
            $.ajax({
               type : "POST",
               url : "deleteAdminComment.do",
               data : {
                  "cno" : cno
               },
               success : function(data) {
                  if (data == "success") {
                     getCommentList();
                  }
               },
               error : function(request, status, error) {
                  alert("비정상적인 요청입니다.");
               }

            });
         }
      }

      function deleteComment(cno) {
         if (confirm("정말 삭제하시겠습니까 ? ")) {
            $.ajax({
               type : "POST",
               url : "deleteComment.do",
               data : {
                  "cno" : cno
               },
               success : function(data) {
                  if (data == "success") {
                     getCommentList();
                  }
               },
               error : function(request, status, error) {
                  alert("비정상적인 요청입니다.");
               }

            });
         }
      }
   </script>


</body>
</html>