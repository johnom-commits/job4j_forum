<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <title>Topic</title>
</head>
<body class="bg-light">
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
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">
                <c:out value="${topic.name}"/>
            </h5>
            <span class="badge badge-info my-2">
               <c:out value="${topic.author.username}"/>
            </span>
            <span class="badge badge-dark">
               <fmt:formatDate value="${topic.created.time}" pattern="dd.MM.yyyy HH:mm:ss"/>
            </span>
            <p class="card-text">
                <c:out value="${topic.description}"/>
            </p>
        </div>
    </div>

    <c:forEach var="answer" items="${topic.answers}">
        <div class="card my-2">
            <div class="card-body">
                <span class="badge badge-info my-2">
                   <c:out value="${answer.author.username}"/>
                </span>
                <span class="badge badge-dark">
                   <fmt:formatDate value="${answer.created.time}" pattern="dd.MM.yyyy HH:mm:ss"/>
                </span>
                <p class="card-text">
                    <c:out value="${answer.content}"/>
                </p>
            </div>
        </div>
    </c:forEach>

    <div class="card my-2">
        <div class="card-body">
            <form action="/save_answer" method="post">
                <div class="form-group">
                    <textarea rows="7" class="form-control mb-2" name="content" required></textarea>
                    <c:set var="tid" value="${topic.id}" scope="session"/>
                    <input type="hidden" name="topic_id" value="${tid}">
                    <input type="submit" class="btn btn-primary" value="Answer">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</body>
</html>
