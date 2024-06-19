<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nippon India MultiCap Fund</title>
 <link rel="stylesheet" href="style.css">
    <style >
        /* Additional styles for the mutual fund page */
        .mutual-fund-wrapper {
            position: relative;
            padding: 1.7rem 0 2rem;
            width: 100%;
            min-height: 100vh;
            overflow: hidden;
          background-color: #f1f8fc; 
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .mutual-fund-container {
            max-width: 600px;
            width: 100%;
            margin: 0 auto;
            padding: 2rem;
            z-index: 10;
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .logo {
            display: flex;
            align-items: center;
            cursor: pointer;
        }

        .logo img {
            width: 40px;
            margin-right: 0.6rem;
        }

        .logo h3 {
            color: #64bcf4;;
            font-size: 1.55rem;
            line-height: 1.2;
            font-weight: 700;
        }

        form.mutual-fund-form {
            width: 100%;
            padding: 2rem;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        form.mutual-fund-form label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: bold;
            width: 100%;
        }

        form.mutual-fund-form input,
        form.mutual-fund-form select {
            width: 100%;
            padding: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form.mutual-fund-form button {
            width: 100%;
            padding: 0.75rem;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 1rem;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        form.mutual-fund-form button:hover {
            background: #0056b3;
        }

        h1.mutual-fund-title {
            text-align: center;
            margin-bottom: 2rem;
            color: #333;
        }
    </style>
    <script>
        function showForm(type) {
            document.getElementById('mutual-fund-lumpsum-form').style.display = 'none';
            document.getElementById('mutual-fund-sip-form').style.display = 'none';
            if (type) {
                document.getElementById('mutual-fund-' + type + '-form').style.display = 'block';
            }
        }
    </script>
</head>
<body>
 <main>
        <div class="mutual-fund-wrapper">
            <header>
                <div class="mutual-fund-header-container">
                    <div class="logo">
                        <img src="./img/logo.png" alt="Logo" />
                        <a href="index.jsp"><h3>INVESTA</h3></a>
                    </div>
                </div>
            </header>

            <section>
                <div class="mutual-fund-container">
                
                    <h1 class="mutual-fund-title">Nippon India MultiCap Fund</h1>
                    <form class="mutual-fund-form" action="calculate" method="post">
                        <label>Select Investment Type:</label>
                        <select name="investmentType" onchange="showForm(this.value)">
                            <option value="">Select</option>
                            <option value="lumpsum">Lumpsum</option>
                            <option value="sip">SIP</option>
                        </select>
                        <br><br>

                        <div id="mutual-fund-lumpsum-form" style="display:none;">
                            <label>Principal Amount:</label>
                            <input type="number" name="principal" step="0.01"><br>
                        </div>

                        <div id="mutual-fund-sip-form" style="display:none;">
                            <label>SIP Contribution per period:</label>
                            <input type="number" name="sipContribution" step="0.01"><br>
                        </div>

                        <label>Estimated Rate of Return (%):</label>
                        <input type="number" name="rateOfReturn" value="23.91" step="0.01" readonly><br>

                        <label>Holding Period (in years for lumpsum, in months for SIP):</label>
                        <input type="number" name="holdingPeriod" required><br><br>

                        <button type="submit">Invest now</button>
                    </form>
                </div>
            </section>
        </div>
    </main>

</body>
</html>