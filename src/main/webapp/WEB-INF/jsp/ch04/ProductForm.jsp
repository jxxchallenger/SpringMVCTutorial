<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Insert title here</title>
<style type="text/css">
#global {
    text-align: left;
	border: 1px solid #dedede;
	background: #efefef;
	width: 560px;
	padding: 20px;
	margin: 100px auto;
}

form {
  font:100% verdana;
  min-width: 500px;
  max-width: 600px;
  width: 560px;
}

form fieldset {
  border-color: #bdbebf;
  border-width: 3px;
  margin: 0;
}

legend {
	font-size: 1.3em;
}

form label { 
	width: 250px;
	display: block;
	float: left;
	text-align: right;
	padding: 2px;
}

#buttons {
	text-align: right;
}
</style>
</head>
<body>
	<div id="global">
		<c:if test="${errors != null }">
			<p id="errors">
				Error(s)!
				<ul>
					<c:forEach var="error" items="${errors }">
						<li>${error }</li>
					</c:forEach>
				</ul>
			</p>
		</c:if>
		<form action="${ctx }/app04a/product_save" method="post">
			<fieldset>
				<legend>Add a product</legend>
				<p>
					<label for="name">Product Name:</label>
					<input id="name" name="name" tabindex="1">
				</p>
				<p>
					<label for="description">Description:</label>
					<input id="description" name="description" tabindex="2">
				</p>
				<p>
					<label for="price">Price:</label>
					<input id="price" name="price" tabindex="3">
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4">
					<input id="submit" type="submit" tabindex="5">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>