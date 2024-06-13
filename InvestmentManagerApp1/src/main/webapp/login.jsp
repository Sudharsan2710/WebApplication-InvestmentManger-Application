<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <title>Investa</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
 <main>
        <div class="big-wrapper light">
            <img src="./img/shape.png" alt="" class="shape">

            <header>
                <div class="container">
                    <div class="logo">
                        <img src="./img/logo.png" alt="Logo">
                      <a href="index.jsp"><h3>INVESTA</h3></a>
                    </div>

                    <div class="links">
                        <ul>
                            <li><a href="#">Services</a></li>
                            <li><a href="#">Bank Account</a></li>
                            <li><a href="#">Portfolio</a></li>
                            <li><a href="#" class="btn">Sign In</a></li>
                        </ul>
                    </div>

                    <div class="overlay"></div>

                    <div class="hamburger-menu">
                        <div class="bar"></div>
                    </div>
                </div>
            </header>

            <section class="login-section">
                <div class="container">
                    <form class="login-form" method="post" action=LoginPageServlet>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="text" id="email" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" id="password" name="password" required>
                        </div>
                        <button type="submit" class="btn">Submit</button>
                        <a href="register.jsp">create a new Account?</a>
                         <% if (request.getParameter("error") != null) { %>
                        <p style="color:red;">Invalid username or password</p>
                    <% } %>
                    </form>
                </div>
            </section>
        </div>
    </main>

</body>
</html>