
<%--
	Document : layout
	Created on : 20 February, 2014, 2:59:35 PM
    Author     : MurthyK
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>    
    <head>    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	</head>
		<body>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />	
		</body>
</html>