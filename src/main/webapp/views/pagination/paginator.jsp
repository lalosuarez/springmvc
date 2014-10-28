<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<body>

            
<c:if test="${not empty paginationItems}">
	<ul class="pagination">
		<c:set var="backwardItem" value="${page - 1}"/>
	  	<c:set var="lastItem" value="${paginationItems.size()}"/>
	  	<c:set var="forwardItem" value="${page + 1}"/>
			  	
		<c:choose>
			<c:when test="${backwardItem == 0}">
				<li><a href="">&laquo;</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value='list?page=${backwardItem}'/>">&laquo;</a></li>
			</c:otherwise>
		</c:choose>
							  	
		<c:forEach var="item" items="${paginationItems}">
	  		<c:choose>
	  			<c:when test="${page == item}">
	  				<li class="active">
	  					<a href="<c:url value='list?page=${item}'/>">${item}</a>
	  				</li>
	  			</c:when>
	  			<c:otherwise>
	  				<li>
	  					<a href="<c:url value='list?page=${item}'/>">${item}</a>
	  				</li>		  			
	  			</c:otherwise>
	  		</c:choose>			
		</c:forEach>
				
		<c:choose>
			<c:when test="${forwardItem == lastItem + 1}">
				<li><a href="">&raquo;</a></li> 
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value='list?page=${forwardItem}'/>">&raquo;</a></li>
			</c:otherwise>
		</c:choose>				
	</ul>
</c:if>  
</body>
</html>