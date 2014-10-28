<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Línea</title>
</head>
<body>
    <div class="container" ng-controller="LineaCtrl">
        <div class="page-header">
        	<h1>${linea.nombre}</h1>
        	<div class="colorElementStrip" style="background-color: ${linea.color}"></div>
        </div>
        
		<form action="manageEstaciones" method="get" class="navbar-form navbar-left" role="search">
		  	<div><input type="hidden" name="i" id="i" value="${linea.id}" /></div>
		  
		  	<div><input type="hidden" name="action" value="add" /></div>

			<div class="form-group">
				<input type="hidden" name="e" id="selected" />
				<input type="text" id="autocomplete" class="form-control" placeholder="Nombre de la Línea" />
			</div>
		  
		    <div class="form-group">
		  		<button type="submit" class="btn btn-default">Agregar</button>
		  	</div>
		</form>
		
		<div><br /><br /></div>
		
		<c:choose>
			<c:when test="${not empty estaciones}">
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
						<td>${item.value.nombre}</td>
						<td>${item.value.tipo}</td>
						<td><a href="<c:url value='manageEstaciones?action=delete&e=${item.value.id}&i=${linea.id}'/>" class="btn btn-danger btn-xs"><b class="glyphicon glyphicon-trash"></b></a></td>
					</tr>
				</c:forEach>
                </tbody>
            </table>
         				
			</c:when>
			
			<c:otherwise>
				<h3>No hay estaciones asignadas a esta línea.</h3>
			</c:otherwise>
		</c:choose>
        
        <div><br /></div>
        
        <div class="form-group">
		  	<a href="<c:url value='manageEstaciones?action=save&i=${linea.id}'/>" class="btn btn-primary">Guardar</a>
		</div>
		 
        <div><br /></div>
    </div>     
</body>
</html>