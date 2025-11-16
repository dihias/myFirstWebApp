<!-- jstl taglib -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
<h1>Hey ${name}!!!</h1>
<div>Your Todos are</div>
<table class="table">
    <thead>
        <tr>
            <th>id</th>
            <th>description</th>
            <th>target date</th>
            <th>Is done ?</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${todos}" var="todo">
                <tr>
                    <th>${todo.id}</th>
                    <th>${todo.description}</th>
                    <th>${todo.targetDate}</th>
                    <th>${todo.done}</th>
                </tr>
        </c:forEach>
    </tbody>
</table>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </div>
</body>
</html>