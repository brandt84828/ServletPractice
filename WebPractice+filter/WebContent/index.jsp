<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<form ID="f1" name="form_one" method="POST" action="ServletPractice">
	Account：
	<input type="TEXT" name ="account">
	Password：
	<input type="TEXT"  name ="password">
	<button onclick="function1()">送出</button>
</form>
</body>
</html>

<script>

	function1() {
		document.getElementById("f1").submit();
	}
	

</script>