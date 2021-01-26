<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <title>Форум job4j</title>
</head>
<body>
<div class="container-fluid mb-4">
    <nav class="navbar navbar-expand-lg navbar-light bg-info text-white">
        <a class="navbar-brand" href="/index">job4j</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <span class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">FAQ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">User: ${user.username}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="/logout">Sign out</a>
                </li>
            </ul>
        </span>
    </nav>
</div>
<div class="container">
    <div>
        <h5>New topic</h5>
    </div>
    <form action='save' method='POST'>
        <div class="form-group">
            <label for="formName">Title:</label>
            <input type="text" class="form-control" id="formName" name="name" placeholder="Title input" required>
        </div>
        <div class="form-group">
            <label>Description:</label>
            <textarea class="form-control" name="description" placeholder="Description input" rows="10"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</body>
</html>