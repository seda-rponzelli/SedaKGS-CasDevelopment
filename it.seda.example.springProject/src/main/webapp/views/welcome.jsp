<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:url value="somma" var="url"> 
	
	<c:param name="add1" value="1"></c:param>	
	<c:param name="add2" value="2"></c:param>

</c:url>


<ul>
	<li> <a href="${url}">somma 1 + 2  </a> </li>
	<li>
		<c:choose>
			<c:when test="${!(empty somma)}"></c:when>
			<c:otherwise><em>clicca sul link oer vedere il risultato</em>
			</c:otherwise>
		
		</c:choose>
	
		<c:if test="${!(empty somma)}">
			risultato della somma ${somma}
		</c:if>
	</li>
</ul>

<form method="post" action="luca">
	<input type="submit" name="button" value="clicca" style="border: solid thin #882d13;-webkit-border-radius: .7em;-moz-border-radius: .7em;border-radius: .7em;"><br>
</form> 

