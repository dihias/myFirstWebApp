<%@ include file="common/header.jspf" %>
<body>

<%@ include file="common/navigation.jspf" %>
<div class="container">
<h3>Hey ${name}!!!</h3>
<h1>Edit todo details : </h1>
<br>

<form:form method="post" modelAttribute="todo">
Descritpion: <form:input path="description" required="true" class="mb-3"/>
<form:errors path="description" cssClass="text-warning"/>
<br/>
Username: <form:input path="username" required="true" class="mb-3"/>
<br/>
Target date: <form:input path="targetDate" required="true" class="mb-3"/>
<br/>
<form:input type="hidden" path="id"  required="true"/>
done ? :<form:input  path="done" required="true" class="mb-3"/>
<br/>
<input type="submit" name="btn" class="btn btn-success" class="mb-3"/>
</form:form>
<%@ include file="common/footer.jspf" %>