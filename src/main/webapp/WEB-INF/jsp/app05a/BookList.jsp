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
		<h1>Book List</h1>
		<a href="<c:url value='/app05a/book_input' />">Add Book</a>
		<table>
			<tr>
				<th>Category</th>
				<th>Title</th>
				<th>ISBN</th>
				<th>Author</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${books }" var="book">
				<tr>
					<td>${book.category.name }</td>
					<td>${book.title }</td>
					<td>${book.isbn }</td>
					<td>${book.author }</td>
					<td><a href="<c:url value='/app05a/book_edit'/>/${book.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>