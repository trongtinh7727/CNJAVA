<%@ page import="Pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="row">
        <h1>Student Registation System Crud using-JSP</h1>
        <form class="col-6 g-3" action="./" method="post">
            <div class="mb-3">
                <label for="student_name" class="form-label">Student name</label>
                <input type="text" name="student_name" class="form-control" id="student_name">
            </div>

            <div class="mb-3">
                <label for="student_course" class="form-label">Course</label>
                <input type="text" class="form-control" id="student_course" name="student_course">
            </div>
            <div class="mb-3">
                <label for="student_fee" class="form-label">Fee</label>
                <input type="text" class="form-control" id="student_fee" name="student_fee">
            </div>
            <%
                // Lấy thông báo thành công từ request object
                String successMessage = (String) request.getAttribute("successMessage");
            %>

            <!-- Hiển thị thông báo thành công -->
            <% if (successMessage != null) { %>
            <div class="alert alert-success">
                <%= successMessage %>
            </div>
            <% } %>
            <%
                // Lấy thông báo lỗi từ request object
                String errorMessage = (String) request.getAttribute("errorMessage");
            %>

            <!-- Hiển thị thông báo lỗi -->
            <% if (errorMessage != null) { %>
            <div class="alert alert-danger">
                <%= errorMessage %>
            </div>
            <% } %>

            <div class="row">
                <div class="col-2">
                    <button type="submit" class="btn btn-primary mb-3">Submit</button>
                </div>
                <div class="col-6">
                    <button type="submit" id="btn_reset" class="btn btn-warning mb-3">Reset</button>
                </div>
            </div>

        </form>

        <div class="col-6">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Course</th>
                    <th scope="col">Fee</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Student> students = (List<Student>) request.getAttribute("students");
                %>
                <% for (Student student : students) { %>
                <tr>
                    <td><%= student.getName() %></td>
                    <td><%= student.getCourse() %></td>
                    <td><%= student.getFee() %></td>
                    <td><a href="student?action=edit&id=<%= student.getId() %>">Edit</a></td>
                    <td><a href="student?action=delete&id=<%= student.getId() %>">Delete</a></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>

</div>

<script>
    $(document).ready(function () {
        $("#btn_reset").on('click', function () {
            $("#student_name").val("");
            $("#student_course").val("");
            $("#student_fee").val("");
        })
    })
</script>

</body>

</html>