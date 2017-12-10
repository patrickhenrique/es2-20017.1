<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Index</title>
	<!-- Import Google icon font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- materialize css-->
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

	<!-- parada do mobile-->
	<meta name="viewport" content="width=device-width,initial-scale=1.0"/>

	<style>
	    .item {
	     	width: 100%;
    		height: 100%;
    		overflow:auto;
    		margin: auto;
    		position: absolute;
  			top: 65; left: 0;bottom: 65px;right: 0;
  			display: flex;
  			align-items: center;
  			justify-content: center;
	    }
	</style>

</head>

<body background="images/back02.jpg" style="background-position: center;">

	<div class="navbar-fixed">
		<nav class="transparent" role="navigation" style="height: 60px">
			<div class="nav-wrapper container">
				
					<a href="#" class="brand-logo" style="font-size: 22px">UFAL Calendar</a>
					
					<ul class="right hide-on-med-and-down medium">
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(0)">Home</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(1)">Features</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(2)">About</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(3)">Login</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(4)">Register</a></li>
					</ul>

					<!-- barra lateral -->
					<ul id="nav-mobile" class="side-nav">
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(0)">Home</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(1)">Features</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(2)">About</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(3)">Login</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(4)">Register</a></li>
					</ul>

			<a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>

				</div>
			
		</nav>
	</div>


	<div class="carousel carousel-slider center" data-indicators="true" style="height: 100%">

		

		<div class="carousel-item transparent white-text" href="#one!">
		
				<c:if test="${erro!=null}">
					<div id="card-alert" class="card red lighten-5">
			            <div class="card-content red-text">
			              <p>${erro}</p>
			            </div>
		            </div>
	            </c:if>
	            
	         
	         	
	         
	            <c:if test="${success!=null}">
					<div id="card-alert" class="card green lighten-5">
						<div class="card-content green-text">
						  <p>${success}</p>
						</div>
					</div>
				</c:if>
             
			<div class="item">
				<div>
					<!-- <h1 class="bold white-text" style="text-shadow: 2px 2px 18px #3e2723;">PLAN ALL YOUR EVENTS</h1> -->
					<h1 class="bold white-text"">PLAN ALL YOUR EVENTS</h1>
					<p>
	  				<h4 class="thin white-text">MAKE THE MOST OF YOUR TIME</h4>
	  				<br><br>
  					<a class="waves-effect waves-light btn-large blue darken-2" style="width: 150px;border-radius: 4px;" onclick="goToPage(3)">LOGIN</a>
  					<a class="waves-effect waves-light btn-large transparent" onclick="goToPage(4)" style="width: 150px;border: 2px solid #FFFFFF;border-radius: 4px;">REGISTER</a>
				</div>
			</div>
		</div>
		<div class="carousel-item transparent white-text" href="#two!">
			<div class="item">

				<div style="width: 80%">
					<p class="thin" style="font-size: 28px">FEATURES</p>

					<p>
	  				<p>
	  				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquam, est sit amet venenatis pharetra, metus mauris fermentum sapien, a volutpat est massa eget lorem.
	  				</p>
	  				<p>
	  				Curabitur tincidunt et felis at pretium. Sed odio lorem, laoreet interdum bibendum ac, laoreet vitae diam. Donec vestibulum tortor vitae commodo sollicitudin. Vivamus dictum velit a tortor blandit semper. Suspendisse orci tortor, vulputate id tortor rutrum, lacinia tempus velit.</p>
	  				<p>
	  				Suspendisse mi eros, commodo ac arcu in, rutrum ornare velit. Suspendisse porta libero at arcu convallis elementum. Pellentesque in mauris a dolor tempor pretium eu porta ligula. Etiam dolor elit, eleifend sed hendrerit nec, elementum id dui. Praesent commodo nulla quis velit vulputate, efficitur elementum diam imperdiet. Cras vitae lectus vel mauris fermentum lacinia. Duis rutrum suscipit lacus sed scelerisque. In quis varius elit, ac scelerisque turpis.
	  				</p>
				</div>
			</div>

		</div>
		<div class="carousel-item transparent white-text" href="#three!">

			<div class="item">
				<div style="width: 80%">
					<p class="thin" style="font-size: 28px">ABOUT</p>
					<!-- <h1 class="bold white-text" style="text-shadow: 2px 2px 18px #3e2723;">PLAN ALL YOUR EVENTS</h1> -->
					<p>
	  				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquam, est sit amet venenatis pharetra, metus mauris fermentum sapien, a volutpat est massa eget lorem. Curabitur tincidunt et felis at pretium. Sed odio lorem, laoreet interdum bibendum ac, laoreet vitae diam. Donec vestibulum tortor vitae commodo sollicitudin. Vivamus dictum velit a tortor blandit semper. Suspendisse orci tortor, vulputate id tortor rutrum, lacinia tempus velit. Suspendisse mi eros, commodo ac arcu in, rutrum ornare velit. Suspendisse porta libero at arcu convallis elementum. Pellentesque in mauris a dolor tempor pretium eu porta ligula. Etiam dolor elit, eleifend sed hendrerit nec, elementum id dui. Praesent commodo nulla quis velit vulputate, efficitur elementum diam imperdiet. Cras vitae lectus vel mauris fermentum lacinia. Duis rutrum suscipit lacus sed scelerisque. In quis varius elit, ac scelerisque turpis.</p>
				</div>
			</div>

		</div>
		
		<div class="carousel-item transparent white-text" href="#four!">
			<div class="item">

				<div style="width: 350px">

					<p class="thin" style="font-size: 28px">LOGIN</p>

					<div class="row">
						<form class="col s12" method="POST" action="/UfalAgenda/Auth">

							<div class="row">
								<div class="input-field col s12">
									<input name="email" id="email" type="email" class="validate">
									<label for="email">Email</label>
								</div>
							</div>
							
							<div class="row">
								<div class="input-field col s12">
									<input name="password" id="password" type="password" class="validate">
									<label for="password">Password</label>
								</div>
							</div>

							<div class="row">
								<button type="submit" class="waves-effect waves-light btn-large blue" style="width: 150px;">LOGIN</button>
	  							<a class="waves-effect waves-light btn-large transparent" onclick="goToPage(4)" style="width: 150px;border: 2px solid #FFFFFF;">REGISTER</a>
							</div>
							
							<div class="row">
	  							<a id="facebook-login"  class="waves-effect waves-light btn-large transparent"style="width: 90%;border: 2px solid #FFFFFF;">ENTRAR COM FACEBOOK</a>
							</div>
						
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="carousel-item transparent white-text" href="#five!">

			<div class="item">
				<div>
					<br>
					<p class="thin" style="font-size: 20px">REGISTER</p>
					<div class="row">
						<form class="col s12" method="POST" action="/UfalAgenda/Register">

							<div class="row">

								<div class="input-field col s6">
									<input name="first_name" id="first_name" type="text" class="validate">
									<label for="first_name">First Name</label>
								</div>

								<div class="input-field col s6">
									<input name="last_name" id="last_name" type="text" class="validate">
									<label for="last_name">Last Name</label>
								</div>
							
							</div>
							
							<div class="row">
								<div class="input-field col s12">
									<input name="email" id="email" type="email" class="validate">
									<label for="email">Email</label>
								</div>
							</div>
							
							<div class="row">
								<div class="input-field col s12">
									<input name="password" name="password" id="password" type="password" class="validate">
									<label for="password">Password</label>
								</div>
							</div>

							<div class="row">
	  							<button type="submit" class="waves-effect waves-light btn-large transparent modal-trigger" style="width: 90%;border: 2px solid #FFFFFF;">REGISTER</button>
							</div>
							
							<div class="row">
	  							<a id="facebook-register" class="waves-effect waves-light btn-large transparent"style="width: 90%;border: 2px solid #FFFFFF;">REGISTRAR COM FACEBOOK</a>
							</div>
						
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Modal Agree Structure -->
	<div id="modalAgree" class="modal">
		<div class="modal-content">
			<h4>Accept agreement</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
		</div>
		<div class="modal-footer">
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Decline</a>
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
		</div>
	</div>

	


	<!--Import jQuery before materialize.js-->
    
    <script type="text/javascript" src="./js/facebook.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script type="text/javascript" src="js/configs.js"></script>

	<script>
		//function goToPage(index){
		//	$('.carousel').carousel('set', index);
		//}
		//$(".button-collapse").sideNav();

		$(document).ready(function(){
			$('.carousel.carousel-slider').carousel({fullWidth: true});
			var winH = $(window).height();
			var carousel = $(".carousel")
			carousel.css('height', winH - 65);
			$('.modal').modal();
			$(".button-collapse").sideNav();
		});
	</script>

</body>
</html>