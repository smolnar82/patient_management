<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div <c:if test="${not empty cls}">class='${cls }'</c:if> >${message }</div>