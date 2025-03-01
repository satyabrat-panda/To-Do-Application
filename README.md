# Todo List Application

## Project Overview

This is a **To-Do List Application** built using **Java (Servlets, JSP, JDBC) and XAMPP (MySQL)**. It allows users to register, log in, add tasks, mark tasks as completed, and log out.

## Folder Structure

```
project-root/
├── src/
│   ├── bean/            # Contains Java Beans
│   │   ├── Register.java
│   │   ├── Task.java
│   │
│   ├── dao/             # Data Access Layer
│   │   ├── ToDoDAO.java (Interface)
│   │   ├── ToDoDAOImpl.java (Implementation)
│   │
│   ├── factory/         # Database Connection
│   │   ├── DBCon.java
│   │
│   ├── servlet/         # Servlet Controllers
│   │   ├── AddTaskServlet.java
│   │   ├── CompletedServlet.java
│   │   ├── LoginServlet.java
│   │   ├── LogoutServlet.java
│   │   ├── RegisterServlet.java
│
├── webapp/
│   ├── Register.html    # Registration Page
│   ├── Login.jsp        # Login Page
│   ├── ViewTasks.jsp    # Display User Tasks
│
├── README.md            # Project Documentation
```

## Setup Instructions

### **1. Install Required Software**

- **Java JDK 8+**
- **Apache Tomcat (9 or later)**
- **XAMPP (MySQL, Apache)**

### **2. Configure Database**

1. Start **XAMPP** and enable **Apache & MySQL**.

2. Open `phpMyAdmin` and create a new database:

   ```sql
   CREATE DATABASE sbb7_todo;
   ```

3. Select the database and create the `register` table:

   ```sql
   CREATE TABLE register (
       regid INT PRIMARY KEY AUTO_INCREMENT,
       fname VARCHAR(50),
       lname VARCHAR(50),
       email VARCHAR(100) UNIQUE,
       pass VARCHAR(100),
       mobile BIGINT,
       address TEXT
   );
   ```

4. Create the `tasks` table:

   ```sql
   CREATE TABLE tasks (
       taskid INT PRIMARY KEY AUTO_INCREMENT,
       taskname VARCHAR(255),
       taskdate DATE,
       taskstatus INT,
       regid INT,
       FOREIGN KEY (regid) REFERENCES register(regid)
   );
   ```

5. Create the `taskid_pks` table:

   ```sql
   CREATE TABLE taskid_pks (
       regid INT PRIMARY KEY,
       taskid INT,
       FOREIGN KEY (regid) REFERENCES register(regid)
   );
   ```

   *This table is used to keep track of the last task ID assigned to each user.*

6. Start **XAMPP** and enable **Apache & MySQL**.

### **3. Configure Tomcat & Deploy the Project**

1. Place the project inside `webapps/` folder of Tomcat.
2. Start Tomcat and access the application at:
   ```
   http://localhost:8080/TodoListApp/
   ```

## Features

✅ **User Registration** (RegisterServlet)\
✅ **User Login** (LoginServlet)\
✅ **Add Tasks** (AddTaskServlet)\
✅ **View Tasks** (ViewTasks.jsp)\
✅ **Mark Tasks as Completed** (CompletedServlet)\
✅ **Logout** (LogoutServlet)

## Usage

1. Open `http://localhost:8080/TodoListApp/`.
2. **Register** a new user.
3. **Login** with registered credentials.
4. **Add tasks** with a name, date, and status.
5. **View & manage tasks** (Mark completed, delete, etc.).
6. **Logout** when done.

## Authors

Developed by **Satyabrat Panda** 🚀

## Copyright

© 2024 Satyabrat Panda. All rights reserved. This project is licensed for personal and educational use only. Unauthorized distribution or modification without prior permission is prohibited.

