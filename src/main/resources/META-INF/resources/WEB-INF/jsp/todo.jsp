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
<h3>Hey ${name}!!!</h3>
<h1>Enter todo details : </h1>
<br>

<form method="post">
Descritpion: <input type="text" name="description" required/>
Descritpion: <input type="submit" name="btn" class="btn btn-success" />
</form>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </div>
</body>
</html>