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
		<form:form commandName="form" action="${ctx }/app05a/form_update" method="post">
			<fieldset>
				<legend>Add a form</legend>
				<form:hidden path="id"/>
				<p>
					<label for="input">Input:</label>
					<form:input path="input" id="input"/>
				</p>
				<p>
					<label for="password">Password:</label>
					<form:password path="password" id="password"/>
				</p>
				<p>
					<label for="textarea">Text Area:</label>
					<form:textarea path="textArea" id="textarea"/>
				</p>
				<p>
					<label for="checkbox">Check Box:</label>
					<form:checkbox path="checkbox" id="checkbox" value="check box tag" label="check box tag"/>
				</p>
				<p>
					<label for="checkboxs">Check Box group:</label>
					<form:checkboxes items="${checklist }" path="checkboxs" id="checkboxs" itemLabel="label" itemValue="value" />
				</p>
				<p>
					<label for="radiobutton">Radio Button:</label>
					<form:radiobutton path="radiobutton" label="Computing new" value="0"/>
					<form:radiobutton path="radiobutton" label="Modern Health" value="1"/>
				</p>
				<p>
					<label for="radiobuttons">Radion Button group:</label>
					<form:radiobuttons path="radiobuttons" items="${radioList }" itemLabel="label" itemValue="value"/>
				</p>
				<p>
					<label for="select">Select:</label>
					<form:select path="select" items="${selectMap }" itemLabel="label"></form:select>
				</p>
				<p id="buttons">
					<input type="reset">
					<input type="submit">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>