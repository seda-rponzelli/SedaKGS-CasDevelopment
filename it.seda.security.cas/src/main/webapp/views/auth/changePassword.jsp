<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="x" uri="http://template.seda.it/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<div id="divChangePassword">
    <c:if test="${!changePassword.esito}">
		<div id="divErrors" class="seda-ui-error" style="color:red">
		  Aggiornamento non riuscito, reinserisci i dati.
		</div>
	</c:if>
	<c:if test="${changePassword.esito}">
		<div id="divErrors">
		  Aggiornamento effettuato
		</div>
	</c:if>
   <form:form method="POST" commandName="changePassword" class="seda-ui-form width">
		<table>

		    <tr>
		      <td>
		         <form:errors path="NewOldError" class="seda-ui-error" cssStyle="color:red"/>       
		      </td>
		    </tr>
		    <tr>
				<td>Username :</td>
				<td><form:input path="username" class="inputSignIn"/>
				</td>
				<td><form:errors path="username" class="seda-ui-error" cssStyle="color:red" />
				</td>
			</tr>
			<tr>
				<td>Nuova password :</td>
				<td><form:input path="newPassword" class="inputSignIn"/>
				</td>
				<td><form:errors path="newPassword" class="seda-ui-error" cssStyle="color:red" />
				</td>
			</tr>
			<tr>
				<td>Conferma la nuova password :</td>
				<td><form:input path="confirm" class="inputSignIn"/>
				</td>
				<td><form:errors path="confirm" class="seda-ui-error" cssStyle="color:red" />
				</td>
			</tr>
			<tr>
				<td height="101px" colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
<a href="<c:url value="/login" />">${x:i18n('login.form.change.password.back')}</a>
<script>
$('#username').removeAttr('value');
$('#username').attr('placeholder', 'USERNAME');
$('#newPassword').removeAttr('value');
$('#newPassword').attr('placeholder', 'NEW_PASSWORD');
$('#confirm').removeAttr('value');
$('#confirm').attr('placeholder', 'CONFIRM_NEW_PASSWORD');
</script>
 </div>