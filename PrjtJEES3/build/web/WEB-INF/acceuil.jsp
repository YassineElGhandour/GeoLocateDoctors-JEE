<!DOCTYPE HTML>

<html>
        <c:remove var="currentSessionUser" scope="session"  /> 
	<head>
		<title>DocLoc | Portail commun pour les doctorants</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="css/main.css" />
                <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.css"/>-->
		<noscript><link rel="stylesheet" href="css/noscript.css" /></noscript>
	</head>
	<body>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<!--<div class="logo">
							<span class="icon fa-diamond"></span>
						</div>-->
						<div class="content">
							<div class="inner">
								<h1>DocLoc</h1>
                                                                <p> 
                                                                    <p>Vos recherches sont accessibles pour tout, partout</p> 
							</div>
						</div>
						<nav>
							<ul>
                                                            <li><a href="#login">Login</a></li>
                                                            <li><a href="#sinscrire">S'inscrire</a></li>
                                                            <li><a href="#about">About</a></li>
                                                            <li><a href="#contact">Contact</a></li>
                                                            <li><a href="simpleresearch">Recherche</a></li>
                                                    
							</ul>

						</nav>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Login -->
							<article id="login">
								<h2 class="major">Login</h2>
								<%@ include file="login.jsp" %>
							</article>

						<!-- S'inscrire -->
							<article id="sinscrire">
								<h2 class="major">S'inscrire</h2>
                                                                <%@ include file="sinscrire.jsp"%>
								</article>

						<!-- About -->
							<article id="about">
								<h2 class="major">About</h2>
								<span class="image main"><img src="images/pic03.jpg" alt="" /></span>
                                                                <p><i class="glyphicon glyphicon-user"></i>EL OUASSAA Zineb et Yassine EL GHANDOUR.</p>
								<p><i class="glyphicon glyphicon-education"></i> Software Engineering à ENSIAS</p>
								<p><i class="glyphicon glyphicon-education"></i> MIP à FST SETTAT/MP à CPGE Mohamed V</p>
								<p><i class="glyphicon glyphicon-education"></i> Lycée Mohammed VI/Lycée Ben M'sik</p>
								<p><i class="glyphicon glyphicon-home"></i> Rabat, Maroc</p>
								<p><i class="glyphicon glyphicon-home"></i> Casablanca, Maroc</p>
							</article>

						<!-- Contact -->
							<article id="contact">
								<h2 class="major">Contact</h2>
								<form method="post" action="#">
									<div class="field half first">
										<label for="name">Name</label>
										<input type="text" name="name" id="name" />
									</div>
									<div class="field half">
										<label for="email">Email</label>
										<input type="text" name="email" id="email" />
									</div>
									<div class="field">
										<label for="message">Message</label>
										<textarea name="message" id="message" rows="4"></textarea>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send Message" class="special" /></li>
										<li><input type="reset" value="Reset" /></li>
									</ul>
								</form>
								<ul class="icons">
									<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
									<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
									<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
									<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
								</ul>
							</article>
                                                


					</div>

				<!-- Footer -->
					<footer id="footer">
                                            <p > © Responsable du site: WEBMASTER. </p>
					</footer>

			</div>

		<!-- BG -->
			<div id="bg"></div>

		<!-- Scripts -->
			<script src="js/jquery.min.js"></script>
			<script src="js/skel.min.js"></script>
			<script src="js/util.js"></script>
			<script src="js/main.js"></script>

	</body>
</html>
