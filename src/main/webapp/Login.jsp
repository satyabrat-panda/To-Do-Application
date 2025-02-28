<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <!-- Bootstrap CSS Link -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Login Form</h2>
        <form method="post" action="./LoginServlet">
            <div class="row mb-3">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="pass" class="col-sm-2 col-form-label">Pass</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="pass" name="pass" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-2"></div>
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary" name="submit">Login</button>
                    <button type="reset" class="btn btn-secondary" name="reset">Clear</button>
                </div>
            </div>
        </form>
    </div>
 <div class="text-center mt-3">
        <p>New User? <a href="Register.html">SignUp</a></p>
    </div>
    <% 
  Object o=request.getAttribute("loginError");
 %>
 <p align="center" style="background-color:yellow;color:red">
    <%=(o==null)?"":o.toString()%>
 </p>    <!-- Bootstrap JS & Popper.js Link -->
    <script src="popper.min.js"></script>
    <script src="bootstrap.min.js"></script>
</body>
</html>