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

import dao.ToDoDAO;
import dao.ToDoDAOImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out= response.getWriter();
  HttpSession session=request.getSession();
  ServletContext context=getServletContext();
    
  String email=request.getParameter("email").trim();
  String pass=request.getParameter("pass").trim();
  
  boolean isValid=true;
  if(email.length()==0 || pass.isEmpty()) {
   request.setAttribute("loginError","Emai or password is Empty");
   isValid=false;
  }
  else {
   ToDoDAO dao=ToDoDAOImpl.getInstance();
   int regid=dao.login(email, pass);
   session.setAttribute("regid", regid);
   
   
   if(regid>0) {
    context.getRequestDispatcher("/ViewTasks.jsp").forward(request, response);
   }
   else {
    request.setAttribute("loginError","Emai or password is Wrong");
    isValid=false;
   }
  }
  if(!isValid) {
   context.getRequestDispatcher("/Login.jsp").forward(request, response);
  }  
 }

}