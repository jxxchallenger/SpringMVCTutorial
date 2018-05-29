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
    width: 960px;
    padding: 20px;
    margin: 100px auto;
}

form {
  font:100% verdana;
  min-width: 500px;
  max-width: 960px;
  /* width: 560px; */
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
    width: 200px;
    display: inline-flex;
    float: none;
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
		<h1>Form List</h1>
		<a href="<c:url value='/app05a/form_input' />">Add Form</a>
		<table>
			<tr>
				<th>Input</th>
				<th>Password</th>
				<th>textArea</th>
				<th>checkbox</th>
				<th>checkboxs</th>
				<th>radiobutton</th>
				<th>radiobuttons</th>
				<th>select</th>
				<th></th>
			</tr>
			<c:forEach items="${formList }" var="form">
				<tr>
					<td>${form.input }</td>
					<td>${form.password }</td>
					<td>${form.textArea }</td>
					<td>${form.checkbox }</td>
					<td>
						<c:forEach items="${form.checkboxs }" var="box">${box }</c:forEach>
					</td>
					<td>${form.radiobutton }</td>
					<td>${form.radiobuttons }</td>
					<td>${form.select }</td>
					<td><a href="<c:url value='/app05a/form_edit'/>/${form.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>