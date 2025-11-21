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
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
</head>
<body>
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
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
    	$('#targetDate').datepicker({
    	    format: 'yyyy-mm-dd'
    	});
    </script>
    </div>
</body>
</html>