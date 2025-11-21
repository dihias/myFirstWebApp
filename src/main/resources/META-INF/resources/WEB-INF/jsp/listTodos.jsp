<%@ include file="common/header.jspf" %>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<h1>Hey ${name}!!!</h1>
<div>Your Todos are</div>
<table class="table">
    <thead>
        <tr>

            <th>description</th>
            <th>target date</th>
            <th>username</th>
            <th>Is done ?</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${todos}" var="todo">
                <tr>

                    <th>${todo.description}</th>
                    <th>${todo.targetDate}</th>
                    <th>${todo.username}</th>
                    <th>${todo.done}</th>
                    <th><a href="update-todo?id=${todo.id}" class="btn btn-warning">update Todo</a></th>
                    <th><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete Todo</a></th>
                </tr>
        </c:forEach>
    </tbody>
</table>
<a href="add-todo" class="btn btn-success">Add Todo</a>
<%@ include file="common/footer.jspf" %>