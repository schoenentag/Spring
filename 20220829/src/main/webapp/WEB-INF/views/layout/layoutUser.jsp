<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

<div>

        <!-- header -->
	    <tiles:insertAttribute name="header" />
	    <!-- body -->
	    <tiles:insertAttribute name="body" />
	    <!-- footer -->
	    <tiles:insertAttribute name="footer" />
	</div>

</body>
</html>