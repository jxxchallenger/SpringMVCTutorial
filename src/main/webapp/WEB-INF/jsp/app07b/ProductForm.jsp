<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    width: 585px;
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

table td {
	border: 1px solid #dedede;
	background: MistyRose;
	/* for web colors visit http://en.wikipedia.org/wiki/Web_colors */
}

#buttons {
    text-align: right;
}
#errors, li {
	color: red;
}
.error {
    color: red;
    font-size: 9pt;	
}
</style>
</head>
<body>
	<div id="global">
		<form:form commandName="product" action="${ctx }/app07b/product_save" method="post">
			<fieldset>
				<legend>Add a Product</legend>
				<p class="errorLine">
		            <form:errors path="name" cssClass="error"/>
		        </p>
		        <p>
		            <label for="name">*Product Name: </label>
		            <form:input id="name" path="name" tabindex="1"/>
		        </p>
		        <p>
		            <label for="description">Description: </label>
		            <form:input id="description" path="description" tabindex="2"/>
		        </p>
		        <p class="errorLine">
		            <form:errors path="price" cssClass="error"/>
		        </p>
		        <p>
		            <label for="price">*Price: </label>
		            <form:input id="price" path="price" tabindex="3"/>
		        </p>
		        <p class="errorLine">
		            <form:errors path="productionDate" cssClass="error"/>
		        </p>
		        <p>
		            <label for="productionDate">*Production Date: </label>
		            <form:input id="productionDate" path="productionDate" tabindex="4"/>
		        </p>
		        <p id="buttons">
		            <input id="reset" type="reset" tabindex="5">
		            <input id="submit" type="submit" tabindex="6">
		        </p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>