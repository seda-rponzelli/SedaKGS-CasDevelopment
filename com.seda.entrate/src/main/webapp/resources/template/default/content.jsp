<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://template.seda.it/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<sec:authentication var="user" property="principal" />

<table>
	<tr>
		<td style="width: 42%">
			<sec:authorize access="hasAnyRole('A_FORMULARI','entrate')" var="authenticated"/>
			<c:if test="${authenticated}">
				<div id="formulari" class="applicazione" >
					<div  class="text">
						<a href="<c:url value="www.google.it" />">${x:i18n('application.formulari')}</a>
					</div>
				</div>
			</c:if>
		</td>
		<td style="width: 42%">
		    <sec:authorize access="hasAnyRole('A_ANAGRAFICA','M-ADMIN')" var="authenticated"/>
			<c:if test="${authenticated}">
				<div id="anagrafica" class="applicazione">
					<div  class="text">
						<a href="<c:url value="www.google.it" />">${x:i18n('application.anagrafica')}</a>						
					</div>
				</div>
			</c:if>
		</td>
	</tr>
	<tr>
		<td style="width: 42%">
		    <sec:authorize access="hasAnyRole('A_CARICHI','F-ADMIN')" var="authenticated"/>
			<c:if test="${authenticated}">
				<div id="carichi" class="applicazione">
					<div  class="text">
						<a href="<c:url value="www.google.it" />">${x:i18n('application.carichi')}</a>
					</div>
				</div>
			</c:if>			
		</td>
		<td style="width: 42%">
		    <sec:authorize access="hasAnyRole('A_RENDICONTAZIONE','S-ADMIN')" var="authenticated"/>
			<c:if test="${authenticated}">
				<div id="rendicontazione" class="applicazione">
					<div  class="text">
						<a href="<c:url value="www.google.it" />">${x:i18n('application.rendicontazione')}</a>
					</div>
				</div>
			</c:if>			
		</td>
	</tr>	
	<tr>
		<td style="width: 42%">
		    <sec:authorize access="hasAnyRole('A_UTILITIES','entrate')" var="authenticated"/>
			<c:if test="${authenticated}">
				<div id="utilities" class="applicazione">
					<div  class="text">
						<a href="<c:url value="www.google.it" />">${x:i18n('application.utilities')}</a>
					</div>
				</div>
			</c:if>			
		</td>
		<td style="width: 42%">
		    <sec:authorize access="hasAnyRole('A_MANAGER','A_ADMIN')" var="authenticated"/>
			<c:if test="${authenticated}">
				<div id="manager" class="applicazione">
					<div  class="text">
						<a href="<c:url value="www.google.it" />">${x:i18n('application.manager')}</a>
					</div>
				</div>
			</c:if>					
		</td>
	</tr>
</table>


