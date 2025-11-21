<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <H1>
        welcome , you are logged in
    </H1>
    <h2 style="display:flex;padding:10px;"> your name is :<nav class="mb-3 btn btn-warning" style="color:green;padding:10px;margin-top:-10px;font-size:30px;" > ${name}<nav/></h2>
    <div><a href="list-todos">Manage</a> your todos !</div>
<%@ include file="common/footer.jspf" %>