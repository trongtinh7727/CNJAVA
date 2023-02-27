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
<%
  Student student = (Student) request.getAttribute("student");
%>
<div class="container">
  <div class="row">
    <h1>Student Registation System Crud using-JSP</h1>
    <form class="col-6 g-3" action="./student" method="post">

      <div class="mb-3">
        <input name="id" type="hidden" value="<%= student.getId()%>">
        <label for="student_name" class="form-label">Student name</label>
        <input type="text" name="student_name" class="form-control" id="student_name" value="<%= student.getName() %>">
      </div>

      <div class="mb-3">
        <label for="student_course" class="form-label">Course</label>
        <input value="<%= student.getCourse() %>" type="text" class="form-control" id="student_course" name="student_course">
      </div>
      <div class="mb-3">
        <label for="student_fee" class="form-label">Fee</label>
        <input value="<%= student.getFee() %>" type="text" class="form-control" id="student_fee" name="student_fee">
      </div>
      <div class="row">
        <div class="col-2">
          <button type="submit" class="btn btn-primary mb-3">Submit</button>
        </div>
        <div class="col-6">
          <button type="submit" id="btn_reset" class="btn btn-warning mb-3">Reset</button>
        </div>
      </div>

    </form>
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