<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common/header.jsp"/>
	
	<div class="outer">
		<div class="inner-area">
			<table id="topList" class="table table-hover" align="center">
	                <thead>
	                    <th>글번호</th>
	                    <th>제목</th>
	                    <th>작성자</th>
	                    <th>조회수</th>
	                    <th>작성일</th>
	                    <th>첨부파일</th>
	                </thead>
	
	                <tbody>
	                                                           
	                </tbody>
	            </table>
		</div>
		
		<script>
			$(function() {
				boardTopList();
			});
			
			function boardTopList() {
				$.ajax({
					url: 'board/top5',
					success:function(result) {
						let value="";
						console.log(result);
						if(result.length > 0){
							for(let r of result){
								value += '<tr><td class="bno">'+  r.boardNo +'</td>'
				                        +'<td>'+  r.boardTitle +'</td>'
				                        +'<td>'+ r.boardWriter+'</td>'
				                        +'<td>'+ r.count +'</td>'
				                        +'<td>'+ r.createDate +'</td>'+'<td>'
				                       if(r.originName != null) {
				                    	   value += '■'
				                       }
				                       +'</td></tr>'
							}
							$("#topList tbody").html(value);
							
						} else {
							alert('조회실패');
						}
						
						
					
					},
					error: function(err) {
						
					}
				});
			};
		</script>
	</div>
	
	<jsp:include page="common/footer.jsp"/>
</body>
</html>