<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Estación</title>
</head>
<body>
    <div class="container">
        <div class="page-header"><h1>Estación</h1></div>

        <div><br /></div>

		<form:form action="save" method="post" commandName="estacion" cssClass="col-md-4 form-horizontal">
			
			<form:hidden path="id" />
			
			<div class="form-group">
				<label class="col-sm-3">Nombre</label>
				<div class="col-sm-9">
					<form:input path="nombre" cssClass="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3">Tipo</label>
				<div class="col-sm-9">
					<form:select path="tipo" cssClass="form-control">
						<form:option value="De paso">De paso</form:option>
						<form:option value="De correspondencia">De correspondencia</form:option>
						<form:option value="Terminal">Terminal</form:option>
					</form:select>
				</div>
			</div>
				
			<div class="btn-toolbar">
				<button type="submit" class="btn btn-primary pull-right">Guardar</button>
			</div>
		</form:form>

    </div>     
</body>
</html>