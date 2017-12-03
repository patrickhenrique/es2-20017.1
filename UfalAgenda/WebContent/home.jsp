<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<!-- Import Google icon font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- materialize css-->
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

	<!-- parada do mobile-->
	<meta name="viewport" content="width=device-width,initial-scale=1.0"/>


	<style>
	    .item2 {
	     	width: 100%;
    		height: 100%;
    		overflow:auto;
    		overflow-y:scroll;
    		
    		position: absolute;
  			top: 120; left: 0;bottom: 20px;right: 0;
  			display: flex;
  			align-items: top;
  			justify-content: center;
	    }
	</style>

</head>
<body background="images/back02.jpg" style="background-position: center;">
	<!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>

    <div class="navbar-fixed">
		<nav class="transparent" style="height: 60px">
			<div class="container">
				<div class="nav-wrapper">
					<a href="#" class="brand-logo">PLANNING</a>
					
					<ul class="right hide-on-med-and-down medium" id="nav-mobile">
						<li class="tab"><a href="#" style="font-size: 12px;"><i class="material-icons">exit_to_app</i></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	
	<div class="center">
		<ul class="tabs tabs-transparent">
			<li class="tab col s3"><a href="#home" style="font-size: 12px;">Home</a></li>
			<li class="tab col s3"><a href="#events" style="font-size: 12px;">Events</a></li>
			<li class="tab col s3"><a href="#preferences" style="font-size: 12px;">Preferences</a></li>
		</ul>
	</div>

	<div class="item2">
		<div id="home" class="col s12">

			<div class="row" id="cards">

			<!-- isso é um dia-->
			<div class="col" style="width: 300px;">
				<div class="col s6 m6">
					<div class="card white">
						<div class="card-content">
							<span class="card-title">DAY</span>
						</div>
					</div>
					<div class="card white">
						<div class="card-content" style="min-height: 400px; padding:0px;">
							<!-- conteudo do dia -->
							<div class="row teal white-text" style="padding:10px;">
								<p>hadgjadj jafk jdafk djs jsdhka</p>
							</div>

							<!-- mais conteudos aqui ....... -->

						</div>
					</div>
				</div>
			</div>

			<!-- isso é outro dia-->
			<div class="col" style="width: 300px;">
				<div class="col s6 m6">
					<div class="card white">
						<div class="card-content">
							<span class="card-title">DAY</span>
						</div>
					</div>
					<div class="card white">
						<div class="card-content" style="min-height: 400px; padding:0px;">
							<!-- conteudo -->
								<div class="row teal white-text" style="padding:10px;">
							
									<p>hadgjadj jafk jdafk djs jsdhka</p>

								</div>
						</div>
					</div>
				</div>
			</div>

			</div><!-- final dos dias -->

		</div>
	</div>
	<!-- ================================================================== -->

	<div id="events" class="col s12">
		
		<div class="item2">

		<ul class="collapsible" data-collapsible="accordion">
			<li>
      			<div class="collapsible-header"><i class="material-icons">filter_drama</i>First</div>
      			<div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
    		</li>
    		
    		<li>
      			<div class="collapsible-header"><i class="material-icons">filter_drama</i>First</div>
      			<div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
    		</li>

    		<li>
      			<div class="collapsible-header"><i class="material-icons">filter_drama</i>First</div>
      			<div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
    		</li>

  		</ul>

  		</div>

	</div>
	<div id="preferences" class="col s12">preferences</div>


	<script>

		$(document).ready(function(){
			
			var winH = $(window).height();
			var home = $(".item2")
			home.css('height', winH - 180);

			$('.modal').modal();
		});

		$(document).ready(function(){
    $('.collapsible').collapsible();
  });
	</script>

</body>
</html>