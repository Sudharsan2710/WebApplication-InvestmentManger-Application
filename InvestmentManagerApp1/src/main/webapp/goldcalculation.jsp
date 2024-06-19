<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gold Investment</title>
<link rel="stylesheet" href="style.css">

<script>
    function calculateGramsPurchased() {
        var goldRate = parseFloat(document.getElementById("gold_rate").value);
        var investmentAmount = parseFloat(document.getElementById("investment_amount_gold").value);
        var gramsPurchased = investmentAmount / goldRate;
        document.getElementById("grams_purchased").value = gramsPurchased.toFixed(2);
    }
</script>
</head>
<body class="light">
<%
    User currentUser = (User) session.getAttribute("currentUser");

    if (currentUser == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div class="big-wrapper light">
    <header>
        <div class="container">
            <div class="logo">
                <img src="./img/logo.png" alt="Logo" /> 
                <a href="index.jsp"><h3>INVESTA</h3></a>
            </div>

            <div class="links">
                <ul>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">Bank Account</a></li>
                    <li><a href="#">Portfolio</a></li>
                    <li><a href="#"><i class="fas fa-user"></i> <%= currentUser.getUsername() %></a></li>
                    <li><a href="login.jsp" class="btn">Sign out</a></li>
                </ul>
            </div>

            <div class="overlay"></div>

            <div class="hamburger-menu">
                <div class="bar"></div>
            </div>
        </div>
    </header>

    <section class="account-info">
        <div class="container">
            <h1>Welcome, <%= currentUser.getUsername() %></h1>
            <p>User ID: <%= currentUser.getUserid() %></p>
            <p>Email: <%= currentUser.getEmail() %></p>
        </div>
    </section>

    <section class="gold-investment">
        <div class="container">
            <h1>Gold Investment</h1>
            <div class="gold-form-container">
                <form action="goldServlet" method="post">
                <input type="hidden" value= <%= currentUser.getUserid() %> name="user_id">
                    <div class="form-group">
                        <label for="gold_rate">Today's Gold Rate (INR/gram):</label>
                        <input type="number" id="gold_rate" name="gold_rate" step="0.01" required oninput="calculateGramsPurchased()">
                    </div>
                    
                    <div class="form-group">
                        <label for="investment_amount_gold">Investment Amount (INR):</label>
                        <input type="number" id="investment_amount_gold" name="investment_amount_gold" step="0.01" required oninput="calculateGramsPurchased()">
                    </div>
                    
                    <div class="form-group">
                        <label for="grams_purchased">Grams Purchased:</label>
                        <input type="number" id="grams_purchased" name="grams_purchased" step="0.01" readonly>
                    </div>
                    
                    <button type="submit" class="btn">Invest</button>
                     <% if (request.getParameter("error") != null) { %>
                        <p style="color:red;">Failed to link bank account. Please try again.</p>
                    <% } %>
                </form>
            </div>
            <p id="investment-result"></p>
        </div>
    </section>
</div>

<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
