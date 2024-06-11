<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body class=class="light">
<main>
		<div class="big-wrapper light">
			<img src="./img/shape.png" alt="" class="shape" />

			<header>
				<div class="container">
					<div class="logo">
						<img src="./img/logo.png" alt="Logo" /> <a href="index.jsp"><h3>INVESTA</h3></a>
					</div>

					<div class="links">
						<ul>
							<li><a href="#">Services</a></li>
							<li><a href="#">Bank Account</a></li>
							<li><a href="#">Portfolio</a></li>
							<li><a href="#"> <i class="fas fa-user"></i> <%=session.getAttribute("username")%>
							</a></li>
							<li><a href="login.jsp" class="btn">Sign out</a></li>
							
						</ul>
					</div>

					<div class="overlay"></div>

					<div class="hamburger-menu">
						<div class="bar"></div>
					</div>
				</div>
			</header>
			 <div class="big-wrapper light"> <!-- Or "dark" for dark mode -->
        <div class="container">
            <section class="login-section">
                <form class="login-form" action="BankAccountServletPage" method="post">
                    <div class="form-group">
                        <label for="bankName">Bank Name</label>
                        <input type="text" id="bankName" name="bankName" required>
                    </div>

                    <div class="form-group">
                        <label for="userPan">User PAN</label>
                        <input type="text" id="userPan" name="userPan" required>
                    </div>

                    <div class="form-group">
                        <label for="accountNumber">Account Number</label>
                        <input type="text" id="accountNumber" name="accountNumber" required>
                    </div>

                    <div class="form-group">
                        <label for="accountType">Account Type</label>
                        <select id="accountType" name="accountType" required>
                            <option value="current">Current</option>
                            <option value="savings">Savings</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="amountInvesting">Amount Investing</label>
                        <input type="number" id="amountInvesting" name="amountInvesting" required>
                    </div>

                    <button type="submit" class="btn">Link Account</button>
                </form>
            </section>
        </div>
    </div>
			
			
			



</body>
</html>