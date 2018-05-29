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
		pageContext:
		<table>
			<tr>
				<td>pageContext.servletConfig.servletName</td>
				<td>${pageContext.servletConfig.servletName }</td>
			</tr>
			<tr>
				<td>pageContext.servletConfig.initParameterNames</td>
				<td><c:forEach items="${pageContext.servletConfig.initParameterNames }" var="paramn">${paramn }<br></c:forEach></td>
			</tr>
			<tr>
				<td>pageContext.servletContext.contextPath</td>
				<td>${pageContext.servletContext.contextPath }</td>
			</tr>
			<tr>
				<td>pageContext.servletContext.effectiveMajorVersion</td>
				<td>${pageContext.servletContext.effectiveMajorVersion }</td>
			</tr>
			<tr>
				<td>pageContext.servletContext.effectiveMinorVersion</td>
				<td>${pageContext.servletContext.effectiveMinorVersion }</td>
			</tr>
			<tr>
				<td>pageContext.servletContext.serverInfo</td>
				<td>${pageContext.servletContext.serverInfo }</td>
			</tr>
			<tr>
				<td>pageContext.servletContext.servletContextName</td>
				<td>${pageContext.servletContext.servletContextName }</td>
			</tr>
			<tr>
				<td>pageContext.servletContext.virtualServerName</td>
				<td>${pageContext.servletContext.virtualServerName }</td>
			</tr>
			<tr>
				<td>pageContext.servletContext.attributeNames</td>
				<td><c:forEach items="${pageContext.servletContext.attributeNames }" var="attr">${attr }<br></c:forEach></td>
			</tr>
			<tr>
				<td>pageContext.servletContext.servletNames</td>
				<td><c:forEach items="${pageContext.servletContext.servletNames }" var="servlet">${servlet }<br></c:forEach></td>
			</tr>
			<tr>
				<td>pageContext.servletContext.servlets</td>
				<td><c:forEach items="${pageContext.servletContext.servlets }" var="serv">
					${serv }<br>
				</c:forEach></td>
			</tr>
			<tr>
				<td>pageContext.session.creationTime</td>
				<td>${pageContext.session.creationTime }</td>
			</tr>
			<tr>
				<td>pageContext.session.id</td>
				<td>${pageContext.session.id }</td>
			</tr>
			<tr>
				<td>pageContext.session.lastAccessedTime</td>
				<td>${pageContext.session.lastAccessedTime }</td>
			</tr>
			<tr>
				<td>pageContext.session.maxInactiveInterval</td>
				<td>${pageContext.session.maxInactiveInterval }</td>
			</tr>
			<tr>
				<td>pageContext.session.attributeNames</td>
				<td><c:forEach items="${pageContext.session.attributeNames }" var="sattr">${sattr }<br></c:forEach></td>
			</tr>
			<tr>
				<td>pageContext.request.authType</td>
				<td>${pageContext.request.authType }</td>
			</tr>
			<tr>
				<td>pageContext.request.characterEncoding</td>
				<td>${pageContext.request.characterEncoding }</td>
			</tr>
			<tr>
				<td>pageContext.request.contentLength</td>
				<td>${pageContext.request.contentLength }</td>
			</tr>
			<tr>
				<td>pageContext.request.contentType</td>
				<td>${pageContext.request.contentType }</td>
			</tr>
			<tr>
				<td>pageContext.request.contextPath</td>
				<td>${pageContext.request.contextPath }</td>
			</tr>
			<tr>
				<td>pageContext.request.localAddr</td>
				<td>${pageContext.request.localAddr }</td>
			</tr>
			<tr>
				<td>pageContext.request.localName</td>
				<td>${pageContext.request.localName }</td>
			</tr>
			<tr>
				<td>pageContext.request.localPort</td>
				<td>${pageContext.request.localPort }</td>
			</tr>
			<tr>
				<td>pageContext.request.locale</td>
				<td>${pageContext.request.locale }</td>
			</tr>
			<tr>
				<td>pageContext.request.method</td>
				<td>${pageContext.request.method }</td>
			</tr>
			<tr>
				<td>pageContext.request.pathInfo</td>
				<td>${pageContext.request.pathInfo }</td>
			</tr>
			<tr>
				<td>pageContext.request.pathTranslated</td>
				<td>${pageContext.request.pathTranslated }</td>
			</tr>
			<tr>
				<td>pageContext.request.protocol</td>
				<td>${pageContext.request.protocol }</td>
			</tr>
			<tr>
				<td>pageContext.request.remoteAddr</td>
				<td>${pageContext.request.remoteAddr }</td>
			</tr>
			<tr>
				<td>pageContext.request.remoteHost</td>
				<td>${pageContext.request.remoteHost }</td>
			</tr>
			<tr>
				<td>pageContext.request.remotePort</td>
				<td>${pageContext.request.remotePort }</td>
			</tr>
			<tr>
				<td>pageContext.request.requestedSessionId</td>
				<td>${pageContext.request.requestedSessionId }</td>
			</tr>
			<tr>
				<td>pageContext.request.requestURI</td>
				<td>${pageContext.request.requestURI }</td>
			</tr>
			<tr>
				<td>pageContext.request.requestURL</td>
				<td>${pageContext.request.requestURL }</td>
			</tr>
			<tr>
				<td></td>
				<td>${pageContext.request.servletPath }</td>
			</tr>
			<tr>
				<td>pageContext.request.scheme</td>
				<td>${pageContext.request.scheme }</td>
			</tr>
			<tr>
				<td>pageContext.request.serverName</td>
				<td>${pageContext.request.serverName }</td>
			</tr>
			<tr>
				<td>pageContext.request.serverPort</td>
				<td>${pageContext.request.serverPort }</td>
			</tr>
			<tr>
				<td>pageContext.request.headerNames</td>
				<td><c:forEach items="${pageContext.request.headerNames }" var="hn">${hn }</c:forEach></td>
			</tr>
		</table>
		
		initParam:
		<table>
		<c:forEach items="${initParam }" var="init">
			<tr>
				<td>${init.key }</td>
				<td>${init.value }</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>