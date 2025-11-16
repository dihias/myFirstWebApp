<!-- jstl taglib -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>list todos</title>
</head>
<body>
<h1>Hey ${name}!!!</h1>
<div>Your Todos are</div>
<table>
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
</body>
</html>