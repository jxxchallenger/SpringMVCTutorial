<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<h4>The product has been saved.</h4>
		<p>
			<h5>Details:</h5>
			Product Name: ${product.name }<br>
			Description: ${product.description }<br>
			Price: $${product.price }
		</p>
	</div>
</body>
</html>