<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
form.jsp
<br /><br />

<form action="form_ok.do" method="post" enctype="multipart/form-data">
파일 <input type="file" name="upload" />
<input type="submit" value="파일 업로드">
</form>

<br /><hr /><br />

<form action="form_ok2.do" method="post" enctype="multipart/form-data">
파일 <input type="file" name="upload" />
/
데이터 <input type="text" name="data" />
<input type="submit" value="파일 업로드">
</form>

<br /><hr /><br />

<form action="form_ok3.do" method="post" enctype="multipart/form-data">
파일 <input type="file" name="uploads" multiple="multiple"/>
<input type="submit" value="파일 업로드">
</form>

</body>
</html>