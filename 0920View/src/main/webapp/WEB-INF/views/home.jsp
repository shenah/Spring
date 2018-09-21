<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다양한 뷰 출력</title>
<style>
	h3:hover{color:blue}
	span{
	margin:10px;
	border:3px Solid Green;
	border-radius:15px;
	float:left;
	width:200px;
	height:80px;
	text-align:center
	}
	span:hover{
	margin:10px;
	border:3px Solid Blue;
	float:left;
	width:200px;
	height:80px;
	text-align:center
	}
	#msg{color: red}
</style>
</head>
<body>
	<form>
		<div id="msg"></div>
		아이디: <input type="text" id="id"/><br/>
		비밀번호: <input type="password" id="pw"/><br/>
	</form>
	<a href="excel.xls">엑셀 출력</a><br/>
	<a href="data.pdf">PDF 출력</a><br/>
	<a href="jsonview.json">JSON 출력</a><br />
	<a href="data.csv">@RestController로 csv 출력</a><br />  
	<a href="data.json">@RestController로 json 출력</a><br />  
	<a href="#" id="ajaxsend">ajax로 JSON 출력</a><br /> 
	<div id="disp"/>
	
</body>

<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script>
	document.getElementById("ajaxsend").addEventListener("click", function(){
		$.ajax({
			url:"data.json",
			data:{},
			dataType:"json",
			success:function(data){
				var output = "";
				for(imsi in data){
					output += "<span><h3>";
					output += data[imsi].name + "</h3>";
					output += "<p>" + data[imsi].phone + "</p></span>";
				}
			$('#disp').html(output);

			}
		})
	})
	
	//아이디 중복 체크 
	
	var ids = document.getElementById("id");
	var msg = document.getElementById("msg");
	
	ids.addEventListener("blur", function(){
		$.ajax({
			url:"idcheck",
			data:{"id": ids.value},
			dataType:"json",
			success:function(data){
				if(data.result == "true"){
					msg.innerHTML="사용 가능한 아이디입니다."
				}else{
					msg.innerHTML="사용 불가능한 아이디입니다."
				}
				
			}
		})
	})
</script>

</html>