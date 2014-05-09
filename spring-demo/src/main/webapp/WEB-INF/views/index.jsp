<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Home</title>
<script src="${ctx}/static/jquery/jquery-1.9.1.min.js"
	type="text/javascript"></script>
<script>
	    var url = 'http://localhost/spring-demo/listConvert';  
	    $.ajax({
	    	url : url,
	    	type : "get",
	    	dataType : "json",
	    	success : function(data) {  
	    		console.log("success");
	    		console.log(data);
	       		//console.log(eval("[" + data + "]"));
	    	},
	    	error : function(msg) {  
	    		console.log("error");
	       		console.log(msg);
	    	}
	    });
	</script>
</head>
<body>
	<h1>Welcome to my world.</h1>
	<p style="padding: 15px;">用Spring来整合所有好玩的东西.</p>

	<h1>This version is ?</h1>
	<h2>3.2.8版</h2>
	<ul>
		<li>展示MVC框架</li>
		<li>其他整合</li>
	</ul>
</body>
</html>