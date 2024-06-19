<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ways to Invest - Investa</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>

   
  

	<main>
		<div class="big-wrapper light">
			

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
							
                        	<li><a href="login.jsp" class="btn">Sign out</a></li>
							
						</ul>
					</div>

					<div class="overlay"></div>

					<div class="hamburger-menu">
						<div class="bar"></div>
					</div>
				</div>
			</header>

			<section class="investment-section">
				<div class="investment-container">
			
					
				</div>
			</section>
			
				<section class="funds-section">
				<div class="funds-card">
					<div class="card-header">
						<h4 class="card-title">Top 5 Equity Mutual Funds</h4>
					</div>
					<div class="card-content">
						<div class="row header-row">
							<div class="col">Company</div>
							<div class="col returns-col">5Y Returns (Annualized) %</div>
						</div>
						<div class="row content-row">
							<div class="col logo-col">
								<img src="./img/nippon.png" alt="Fund Logo" class="fund-logo" />
							</div>
							<div class="col fund-info-col">
								<a href="NipponIndiaSmallCapFund.jsp" class="fund-link">Nippon India Small Cap Fund</a>
							</div>
							<div class="col returns-col">
								<p class="returns">34.01% p.a.</p>
							</div>
							<div class="col invest-btn-col">
								
									<input type="hidden" name="fundName" value="Nippon India Small Cap Fund">
								<a href="NipponIndiaSmallCapFund.jsp"><button  type="submit" class="invest-btn">Invest</button></a>
							
							</div>
						</div>
						<div class="row content-row">
							<div class="col logo-col">
								<img src="./img/motilal-oswal.png" alt="Fund Logo" class="fund-logo" />
							</div>
							<div class="col fund-info-col">
								<a href="MotilalOswalMidCapFund.jsp" class="fund-link">Motilal Oswal Midcap Fund</a>
							</div>
							<div class="col returns-col">
								<p class="returns">30.44% p.a.</p>
							</div>
							<div class="col invest-btn-col">
								
									<input type="hidden" name="fundName" value="Motilal Oswal Midcap Fund">
									<a href="MotilalOswalMidCapFund.jsp"><button type="submit" class="invest-btn">Invest</button></a>
							
							</div>
						</div>
						<div class="row content-row">
							<div class="col logo-col">
								<img src="./img/jm-flexicap.png" alt="Fund Logo" class="fund-logo" />
							</div>
							<div class="col fund-info-col">
								<a href="JmFlexiCapFund.jsp" class="fund-link">JM Felixicap Fund</a>
							</div>
							<div class="col returns-col">
								<p class="returns">26.82% p.a.</p>
							</div>
							<div class="col invest-btn-col">
								
									<input type="hidden" name="fundName" value="JM Felixicap Fund">
								<a href="JmFlexiCapFund.jsp"><button type="submit" class="invest-btn">Invest</button></a>
								
							</div>
						</div>
						<div class="row content-row">
							<div class="col logo-col">
								<img src="./img/icici.png" alt="Fund Logo" class="fund-logo" />
							</div>
							<div class="col fund-info-col">
								<a href="IcicPrudential.jsp" class="fund-link">ICIC Prudential Value Discovery Fund</a>
							</div>
							<div class="col returns-col">
								<p class="returns">24.05% p.a.</p>
							</div>
							<div class="col invest-btn-col">
								
									<input type="hidden" name="fundName" value="ICIC Prudential Value Discovery Fund">
								<a href="IcicPrudential.jsp"><button type="submit" class="invest-btn">Invest</button></a>
							
							</div>
						</div>
						<div class="row content-row">
							<div class="col logo-col">
								<img src="./img/nippon.png" alt="Fund Logo" class="fund-logo" />
							</div>
							<div class="col fund-info-col">
								<a href="NipponIndiaMultiCapFund.jsp" class="fund-link">Nippon India Multi Cap Fund</a>
							</div>
							<div class="col returns-col">
								<p class="returns">23.91% p.a.</p>
							</div>
							<div class="col invest-btn-col">
								
									<input type="hidden" name="fundName" value="Nippon India Multi Cap Fund">
							<a href="NipponIndiaMultiCapFund.jsp"><button type="submit" class="invest-btn">Invest</button></a>
								
							</div>
						</div>
						
					</div>
				</div>
			</section>
		</div>
	</main>
</body>
</html>
