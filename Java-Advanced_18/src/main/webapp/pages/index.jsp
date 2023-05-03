<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Lesson_18</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">All participants</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="new">Add new participant</a></li>
        </ul>
    </div>
</nav>

<div class="container">

    <c:choose>
        <c:when test="${mode == 'P_VIEW'}">
            <table class="table table-dark">
                <thead>
                <tr class="bg-primary">
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Level</th>
                    <th>Primary Skill</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="participant" items="${participants}">
                    <tr>
                        <td>${participant.id}</td>
                        <td>${participant.name}</td>
                        <td>${participant.email}</td>
                        <td>${participant.level}</td>
                        <td>${participant.primarySkill}</td>
                        <td><a href="update?id= ${participant.id}" class="btn btn-warning">edit</a></td>
                        <td><a href="delete?id= ${participant.id}" class="btn btn-danger">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:when test="${mode == 'P_EDIT' || mode == 'P_CREATE'}">
            <c:set var="p" value="${participant}"/>
            <form action="save" method="POST">

                <input type="hidden" value="${p.id}" class="form-control" id="id" name="id">

                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="name" class="form-control" id="name" name="name" value="${p.name}">
                </div>
                <div class="form-group">
                    <label for="email">Email address:</label>
                    <input type="email" class="form-control" id="email" name="email" value="${p.email}">
                </div>
                <div class="form-group">
                    <label for="level">Level:</label>
                    <select class="form-control" id="level" name="level" value="${p.level}">
                        <option value="L1" ${p.level == 'L1' ? 'selected' : ''}>Level 1</option>
                        <option value="L2" ${p.level == 'L2' ? 'selected' : ''}>Level 2</option>
                        <option value="L3" ${p.level == 'L3' ? 'selected' : ''}>Level 3</option>
                        <option value="L4" ${p.level == 'L4' ? 'selected' : ''}>Level 4</option>
                        <option value="L5" ${p.level == 'L5' ? 'selected' : ''}>Level 5</option>
                    </select>
                </div>
                <div class="form-group ">
                    <label for="primarySkill">Primary skill:</label>
                    <input type="text" class="form-control" id="primarySkill" name="primarySkill"
                           value="${p.primarySkill}">
                </div>
                <button type="submit" class="btn btn-default">Create</button>
            </form>
        </c:when>

    </c:choose>
</div>

</body>
</html>