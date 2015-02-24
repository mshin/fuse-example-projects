<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Fuse Starter Kit</title>

    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap-3.0.0-dist/dist/css/bootstrap.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/fsk.css">

</head>
<body>
<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/css/bootstrap-3.0.0-dist/dist/js/bootstrap.min.js"></script>
<h1>Fuse Starter Kit UI</h1>
<form:form class="" method="post" modelAttribute="viewObject">
    <table class="table table-condensed">
    	<tr>
             <td class="align-right">
                <label>Select a value driven by OSGi dynamic properties:</label>
            </td>   		
    	</tr>
    	<tr>
            <td class="align-right">
                <form:select class="input-sm" path="selectedValue" items="${viewObject.dynamicSelectMap}">
                </form:select>
            </td> 
            <td class="">
            	<button class="btn" name="submitForm" type="submit" value="">Submit</button>
            </td>   	
    	</tr>
    	<tr></tr>
    	<tr>
    		<td class="align-right">
                <label>Your Value:</label>
            </td>
            <td class="">
                <form:label path="yourValue">${viewObject.yourValue}</form:label>
            </td>
    	</tr>
    	<tr>
    		<td class="align-right">
                <label>From LDAP:</label>
            </td>
            <td class="">
                <form:label path="fromLDAP">${viewObject.fromLDAP}</form:label>
            </td>
    	</tr>    	
    	<tr>
    		<td class="align-right">
                <label>From DB:</label>
            </td>
            <td class="">
                <form:label path="fromDB">${viewObject.fromDB}</form:label>
            </td>
    	</tr>
    	<tr>
    		<td class="align-right">
                <label>From WS:</label>
            </td>
            <td class="">
                <form:label path="fromWS">${viewObject.fromWS}</form:label>
            </td>
    	</tr>    	
    </table>
    <br>
    <label class="version">Version: gumdrop</label>
</form:form>

</body>
</html>