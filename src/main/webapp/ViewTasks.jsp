<%@page import="bean.Task"%>
<%@page import="java.util.List"%>
<%@ page import="dao.ToDoDAO" %>
<%@ page import="dao.ToDoDAOImpl" %>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />

<!-- Welcome strip -->
<p align='right'>
  Welcome 
  <% 
  ToDoDAO dao = ToDoDAOImpl.getInstance();
  int regId = Integer.parseInt(session.getAttribute("regid").toString());
  String fname = dao.findFname(regId);
  %>
  <%= fname %>,
  <a href="./LogoutServlet">Logout</a>
</p>

<!-- Add Task Form -->
<div class="container mt-4">
  <h3 class="text-center">Add Task</h3>
  <form method="post" action="./AddTaskServlet">
    <table class="table table-bordered table-striped">
      <tr>
        <th>Task Name</th>
        <td><input type="text" name="taskName" class="form-control" required></td>
      </tr>
      <tr>
        <th>Task Date</th>
        <td><input type="text" name="taskDate" placeholder="dd-mm-yyyy" class="form-control" required></td>
      </tr>
      <tr>
        <th>Task Status</th>
        <td>
          <select name="taskStatus" class="form-select">
            <option value="1">Not Yet Started</option>
            <option value="2">In Progress</option>
            <option value="3">Completed</option>
          </select>
        </td>
      </tr>
      <tr>
        <th><input type="submit" name="submit" value="Add Task" class="btn btn-primary"></th>
        <td><input type="reset" name="reset" value="Clear" class="btn btn-secondary"></td>
      </tr>    
    </table>
  </form>
</div>

<!-- View Tasks Page -->
<%
  List<Task> tasks = dao.findAllTasksByRegid(regId);
%>

<div class="container mt-5">
  <h3 class="text-center">Your Tasks</h3>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>TaskID</th>
        <th>TaskName</th>
        <th>TaskDate</th>
        <th>TaskStatus</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <%
      for(Task task : tasks) {
        int taskId = task.getTaskid();
        String taskName = task.getTaskname();
        String taskDate = task.getTaskdate();
        int taskStatus = task.getTaskstatus();
    %>
      <%
        if(taskStatus != 3) {
      %>
      <tr>
        <td><%= taskId %></td>
        <td><%= taskName %></td>
        <td><%= taskDate %></td>
        <td>
          <%= (taskStatus == 1) ? "Not Yet Started" : "In Progress" %>
        </td>
        <td>
          <a href="./CompletedServlet?regId=<%= regId %>&taskId=<%= taskId %>" class="btn btn-success btn-sm">Mark as Completed</a>
        </td>
      </tr>
      <%
        } else {
      %>
      <tr style="text-decoration:line-through;">
        <td><%= taskId %></td>
        <td><%= taskName %></td>
        <td><%= taskDate %></td>
        <td>Completed</td>
        <td>Completed</td>
      </tr>
      <%
        }
      }
      %>
    </tbody>
  </table>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>