<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Líneas</title>
</head>
<body>
    <div class="container">
        <div class="page-header"><h1>Líneas</h1></div>
        
        <div class="btn-toolbar">
            <a href="<c:url value='add'/>" class="btn btn-success">Agregar</a>
        </div>
        
        <div><br /></div>
        <c:choose> 
			<c:when test="${not empty lineas}">
	            <table class="table">
	                <thead>
	                    <tr>
	                        <th>Línea</th>
	                        <th>Color</th>
	                        <th></th>
	                        <th></th>
	                    </tr>
	                </thead>
	                <tbody>
					<c:forEach var="item" items="${lineas}">
						<tr>
							<td>${item.nombre}</td>
							<td><div class="colorElement" style="background-color: ${item.color}"></div></td>
							<td>
								<a href="<c:url value='manageEstaciones?i=${item.id}'/>">Estaciones</a>
							</td>							
							<td>
								<a href="<c:url value='edit?i=${item.id}'/>" class="btn btn-default btn-xs"><b class="glyphicon glyphicon-pencil"></b></a>
								<a href="<c:url value='delete?i=${item.id}'/>" class="btn btn-danger btn-xs"><b class="glyphicon glyphicon-trash"></b></a>
							</td>
						</tr>
					</c:forEach>
	                </tbody>
	            </table>
			</c:when>
	    	<c:otherwise><h3>Sin líneas.</h3></c:otherwise>  		
		</c:choose>
    </div>     
</body>
</html>