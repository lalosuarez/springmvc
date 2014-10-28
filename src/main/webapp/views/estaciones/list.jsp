<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Estaciones</title>
</head>
<body>
    <div class="container">
        <div class="page-header"><h1>Estaciones</h1></div>
        
        <div class="btn-toolbar">
            <a href="<c:url value='add'/>" class="btn btn-success">Agregar</a>
        </div>
        
        <div><br /></div>
        <c:choose> 
			<c:when test="${not empty estaciones}">
			
			<form action="<c:url value='search'/>" method="get" theme="simple" class="navbar-form navbar-left">
				<div class="form-group">
			    	<input type="text" name="q" class="form-control" placeholder="Buscar"/>
			  	</div>
			  	<div class="form-group">
			  		<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
			  	</div>
			</form>
					
            <table class="table">
                <thead>
                    <tr>
                        <th>Estación</th>
                        <th>Tipo</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
				<c:forEach var="item" items="${estaciones}">
					<tr>
						<td>${item.nombre}</td>
						<td>${item.tipo}</td>
						<td>
							<a href="<c:url value='edit?i=${item.id}'/>" class="btn btn-default btn-xs"><b class="glyphicon glyphicon-pencil"></b></a>
                               <a href="<c:url value='delete?i=${item.id}'/>" class="btn btn-danger btn-xs"><b class="glyphicon glyphicon-trash"></b></a>								
						</td>
					</tr>
				</c:forEach>
                </tbody>
            </table>
            
			<jsp:include page="../pagination/paginator.jsp" />
			
			</c:when>
	    	<c:otherwise><h3>Sin estaciones.</h3></c:otherwise>  		
		</c:choose>
    </div>     
</body>
</html>