<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kickstarter: Ask a question</title>
</head>
<body>
	<h1>Ask a question:</h1>
	<h2>
		Project:
		<c:out value="${project.name}" />
	</h2>

	<form method="POST"
		action="/kickstarter/ask_question?project=${project.id}">
		<p>
			<input type="text" name="question">
		</p>
		<p>
			<input type="submit" value="Send">
		</p>
	</form>

	<br />
	<br />
	<h3>
		<a
			href="/kickstarter/project?project=${project.id}">
			<c:out value="<- back to project" />
		</a>
	</h3>
</body>
</html>