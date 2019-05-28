<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<div id="textf">
		<span id="ts" style="color:red"></span><br>
		<input type="text" id="username"><p> 
    	<input type="password" id="password"><p>
    	<input type="submit" id="submit"> 
	</div>   
<script>
$("#submit").click(function(){
	$.ajax({
		url:"login.do",
		type: "POST",
		data: {username:$("#username").val(),password:$("#password").val()},
		dataType: "json",
		async : true,
		success: function( data ) {
			if(data.status=="error"){
				$("#ts").text("用户名或密码错误");	
			}else if(data.status=="succeed"){
				$.ajax({
					url:"home.do",
					success: function( data ) {
						$("body").html(data);
					}
				});
			}
			console.log(data);
		}
	});
	
	});
</script>
</body>
</html>