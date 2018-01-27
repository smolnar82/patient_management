<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<p style="color:red"><c:if test="${not empty error}">${error }</c:if></p>
<form name="loginForm" action="<c:url value='/j_spring_security_check' />" method="POST">
	<div>
		<label><spring:message code="label.username"/>:<br />
			<input type="text" name="username" />
		</label>
	</div>
	<div>
		<label><spring:message code="label.password"/>:<br />
			<input type="text" name="password" />
		</label>
	</div>
	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	<input type="submit" value="Login" />
</form>