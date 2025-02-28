package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Task;
import dao.ToDoDAO;
import dao.ToDoDAOImpl;

/**
 * Servlet implementation class AddTaskServlet
 */
@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out=response.getWriter();
  HttpSession session=request.getSession();
  ServletContext context=getServletContext();
  
  String taskName=request.getParameter("taskName").trim();
  String taskDate=request.getParameter("taskDate").trim();
  int taskStatus=Integer.parseInt(request.getParameter("taskStatus").trim());
  int regid=Integer.parseInt(session.getAttribute("regid").toString());
  
  Task task =new Task(0,taskName,taskDate,taskStatus,regid);
  
  ToDoDAO dao=ToDoDAOImpl.getInstance();
  boolean flag=dao.addTask(task, regid);
  
  if(flag) {
   context.getRequestDispatcher("/ViewTasks.jsp").forward(request, response);
  }
  else {
   out.println("! Error : Add Task Failed");
  }
 }

}