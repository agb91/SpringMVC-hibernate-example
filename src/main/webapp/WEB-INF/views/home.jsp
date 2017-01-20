<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  I read ${read}. </P>

<form:form action="${url}" method="post" modelAttribute="person">
	<label>Nome:</label>
	<form:input path="name" />
	<input type="submit" />
</form:form>


</body>
</html>
