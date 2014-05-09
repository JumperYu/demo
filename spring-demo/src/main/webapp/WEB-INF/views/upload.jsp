<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src="${ctx}/static/js/app/upload.js"></script>
<title>上传管理</title>
</head>
<body>
	<form class="form" action="${ctx}/upload" method="post"
		enctype="multipart/form-data">
		<input type="text" name="name" /> 
		<input type="file" name="file" /> 
		<input type="submit" />
	</form>
	<script>
		
	</script>
</body>
</html>
