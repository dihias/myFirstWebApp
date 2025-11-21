<!-- jstl taglib -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>list todos</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
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
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </div>
</body>
</html>