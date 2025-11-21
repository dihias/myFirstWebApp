<%@ include file="common/header.jspf" %>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h3>Hey ${name}!!!</h3>
<h1>Enter todo details : </h1>
<br>

<form:form method="post" modelAttribute="todo">
Descritpion: <form:input path="description" required="true"/>
<form:errors path="description" cssClass="text-warning"/>
Target date: <form:input path="targetDate" required="true" class="mb-3"/>
<form:input type="hidden" path="id" required="true"/>
<form:input type="hidden" path="done" required="true"/>
<input type="submit" name="btn" class="btn btn-success" />
</form:form>
<%@ include file="common/footer.jspf" %>