<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<h2>上传多个文件 实例</h2>

	<form action="Eva/addEvaluation" method="post"
		enctype="multipart/form-data">
		<p>
			选择文件:<input type="file" name="files">
		<p>
			选择文件:<input type="file" name="files">
		<p>
			选择文件:<input type="file" name="files">
		<p>
			<input type="submit" value="提交">
	</form>
	<form action="item/addOnSaleSku" method="post"
		enctype="multipart/form-data">
		<p>
			选择文件:<input type="file" name="file">
		
		<p>
			<input type="hideden" name="price" value="100">
			<input type="hideden" name="skuId" value="213">
			<input type="hideden" name="type" value="2">
			<input type="submit" value="提交">
	</form>

</body>
</html>