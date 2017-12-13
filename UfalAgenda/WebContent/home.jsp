

<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido"%>
<%@page import="br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario"%>
<%@page import="br.ufal.aracomp.ufalagenda.controladorDeDialogo.Dialogo"%>
<%@page import="br.ufal.aracomp.ufalagenda.operacoesAgendamento.IAgendamento"%>
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
    		margin: auto;
    		position: absolute;
  			top: 65; left: 0;bottom: 65px;right: 0;
  			display: flex;
  			align-items: top;
  			justify-content: left;

	    }

	    .colItem{
	    	opacity: .9;
	    }

	</style>

</head>


<%
	Dialogo dialogo = new Dialogo((Usuario ) session.getAttribute("user"));
%>




<body background="images/back02.jpg" style="background-position: center;">
    <div class="navbar-fixed">
		<nav class="transparent" style="height: 60px">
			<div class="container">
				<div class="nav-wrapper">
					<a href="#" class="brand-logo" style="font-size: 22px">UFAL Calendar</a>
					
					<ul class="right hide-on-med-and-down medium">
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(0)">Eventos</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(1)">Notificações<span class="new badge">4</span></a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(2)">Configurações</a></li>
						<li><a href="#" style="font-size: 12px;">Sair</a></li>
						<li><img src="images/02.jpeg" style="margin: 10px;width: 40px;height: 40px" class="circle"></li>
					</ul>

					<!-- barra lateral -->
					<ul id="nav-mobile" class="side-nav">
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(0)">Eventos</a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(1)">Notificações<span class="new badge">4</span></a></li>
						<li><a href="#" style="font-size: 12px;" onclick="goToPage(2)">Configurações</a></li>
						<li><a href="#" style="font-size: 12px;">Sair</a></li>
						
					</ul>

					<a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>

				</div>
			</div>
		</nav>
		
	</div>

	<div class="carousel carousel-slider center" data-indicators="true" style="height: 100%">
		<!-- ==================================================================================== -->
		<!-- ===================== ISSO EH A PAGINA DE EVENTOS ================================== -->
		<!-- ==================================================================================== -->
		<div class="carousel-item transparent white-text" href="#one!">
			EVENTOS
			<div class="item2">

				<!-- ================================================================= -->
				<!-- =================== ESSA DIV CONTEM OS EVENTOS ================== -->
				<!-- ================================================================= -->
				<div class="col" id ="cards">
					
					<!-- ====================================================================== -->
					<!-- ================== CARD DE UM EVENTO ================================== -->
					<!-- ======================================================================= -->
					
					<div style="width: 200px; float: left;margin: 5px;">
						<div class="card black-text modal-trigger" href="#modal1">
							<div class="card-content" style="text-align: justify;">
								<!-- ===================== TITULO DO CARD (DATA) ========================-->
								<span class="card-title"><b class="blue-grey-text text-darken-2">May 07</b></span>
								<!-- ======================== TEXTO DO CARD =============================-->
								<p>I am a very simple card. I am good at containing small bits of information.
								I am convenient because I require little markup to use effectively.</p>
							</div>
							<a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">search</i></a>
						</div>
					</div>	
					
					
					
					<% //List <Definido> eventos = dialogo.listaEventos(); %>
					<!--  
					<c:forEach items="${eventos}" var="evento">
					
						<div style="width: 200px; float: left;margin: 5px;">
							<div class="card black-text modal-trigger" href="#modal1">
								<div class="card-content" style="text-align: justify;">
									
									<span class="card-title"><b class="blue-grey-text text-darken-2">
										${ evento.getHorarios().getDtHoraInicio()} - ${ evento.getHorarios().getDtHoraFim()}
									</span>
									
									<p>${ evento.getCompromisso().getDescricao()}</p> <br>
									<h4>Local:</h4><br>
									<p>${ evento.getCompromisso().getLocal()}
								</div>
								<a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">search</i></a>
							</div>
						</div>
						
					</c:forEach>
					
					-->
					
					<!-- ==================================================================================== -->

				</div>
			</div>

		</div>

		<div class="carousel-item transparent white-text" href="#two!">
			<div class="item2">
				<div class="row" style="width: 95%;text-align: left;">

					<ul class="collection">
						<li><a href="#modalNotificacao" class="collection-item colItem modal-trigger">Aconteceu alguma coisa jaidiajoie eiahdaebc</a></li>
						<li><a href="#modalNotificacao" class="collection-item colItem modal-trigger">Abc</a></li>
						<li><a href="#modalNotificacao" class="collection-item colItem modal-trigger">Abc</a></li>
						<li><a href="#modalNotificacao" class="collection-item colItem modal-trigger">Abc</a></li>
					</ul>

				</div>
			</div>
		</div>

		<div class="carousel-item transparent white-text" href="#three!">
			<div class="item2">
				<!-- ================ -->
				<div class="row">
					<div class="row">
						<form class="col s12">

							<div class="row">
								<div class="col" id="perfil" style="width: 100px; height: 100px">
									<img src="images/02.jpeg" style="width: 100px;height: 100px">
								</div>
								<div class="col" id="envia-foto">
									<div class="file-field input-field">
										<div class="btn" style="margin: 10px">
											<i class="material-icons">add_a_photo</i>
											<input type="file">
										</div>
										<div class="file-path-wrapper">
											<input class="file-path validate" type="text">
										</div>
									</div>
								</div>
							</div>

							<div class="row">

								<div class="input-field col s6">
									<input id="first_name" type="text" class="validate">
									<label for="first_name">First Name</label>
								</div>

								<div class="input-field col s6">
									<input id="last_name" type="text" class="validate">
									<label for="last_name">Last Name</label>
								</div>
							
							</div>
							
							<div class="row">
								<div class="input-field col s12">
									<input id="email" type="email" class="validate">
									<label for="email">Email</label>
								</div>
							</div>
							
							<div class="row">
								<div class="input-field col s12">
									<input id="password" type="password" class="validate">
									<label for="password">Password</label>
								</div>
							</div>
						
						</form>
						<a class="btn-floating btn-large waves-effect waves-light teal" style="float: right"><i class="material-icons">edit</i></a><!-- check -->
					</div>
				</div>
				<!-- ================ -->
			</div>
		</div>

		<!-- ==================================================================================== -->
		<!-- ========================== BOTAO DE CRIAR EVENTO ================================== -->
		<!-- ==================================================================================== -->
		<a class="btn-floating btn-large waves-effect waves-light teal modal-trigger" href="#modalCriaEvento" style="float:right;position:absolute;bottom:30px;right:60px;clear:right"><i class="material-icons">add</i></a>
		<!-- ====================================================================================== -->
	</div>


	<!-- ==================================================================================== -->
	<!-- ============================= MODAIS DOS EVNTOS ================================== -->
	<!-- =========== cada carde de evento deve ter um modal de id corrspondente aqui ====== -->
	<div id="modais">

		<!-- ESTE MODAL EH DAS ONTIFICACOES -->
		<div id="modalNotificacao" class="modal">
			<div class="modal-content">
				<h4>Titulo de alguma notificacao</h4>
				<p>Aconteceu alguma coisa bla bla bla</p>
			</div>
			<div class="modal-footer">
				<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Recusar</a>
				<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Confirmar</a>
			</div>
		</div>
		<!-- ================ MODAL DE CRIACAO DE EVENTO ==================== -->
		<div id="modalCriaEvento" class="modal modal-fixed-footer modalCriar" style="max-height: 90%;width: 90%;height: 80%">
			<div class="modal-content">
				
				<!-- titulo do modal -->
				<h4>Novo Evento</h4>

				<div class="row">
					<form class="col s12">
						<div class="row">
							<div class="input-field col s12">
 								<textarea id="textarea1" class="materialize-textarea"></textarea>
								<label for="textarea1">Sobre:</label>
							</div>
						</div>
						<div class="row">
							
							<div class="col">
								<label for="data">Data</label>
								<input id="data" type="text" class="datepicker" style="size: 50%" />
							</div>

							<div class="col">
								<label for="hora">Horário</label>
								<input id="hora" type="text" class="timepicker" />
							</div>

							<div class="col">
								<div class="row">
									<form action="#">
										<p>
											<input name="group1" type="radio" id="selecionado" checked/>
											<label for="selecionado">Horário Selecionado</label>
										</p>
										<p>
											<input name="group1" type="radio" id="agendado" />
											<label for="agendado">Agendar Horário</label>
										</p>
									</form>

								</div>
							</div>
						</div>
						
						<div class="row">

							<ul class="tabs blue-grey-text">
								<li class="tab col s3"><a class="active blue-grey-text" href="#Part">Participantes</a></li>
								<li class="tab col s3"><a class="blue-grey-text" href="#Adiciona">Adicionar</a></li>
							</ul>

							<div id="Part">

								<br>

								<div class="col">
									<a class="btn-floating waves-effect waves-light teal modal-trigger" href="#modalAdicionaPessoa"><i class="material-icons">add</i></a>
								</div>

								<div id="participantesNovoEvento" class="col">
									
									<!-- ISSO EH UM PARTICIPANTE -->
									<div class="chip">
										<!-- IMAGEM -->
										<img src="images/02.jpeg" alt="Contact Person">
										<!-- nome -->
										Jane Doe
										<!-- icone de remover -->
										<i class="close material-icons">close</i>
									</div>

									<div class="chip">
										<!-- IMAGEM -->
										<img src="images/02.jpeg" alt="Contact Person">
										<!-- nome -->
										Joao Doe
										<!-- icone de remover -->
										<i class="close material-icons">close</i>
									</div>

								</div>

							</div>


							<div id="Adiciona">
								
								<br>

								<div style="width: 200px; float: left;margin: 5px;">
									<div class="card black-text">
										<div class="card-content" style="text-align: justify;">
											<img src="images/02.jpeg" style="width: 30px;height: 30px" class="circle">
											<p>Fulano de tal</p>
										</div>
										<a class="btn-floating halfway-fab waves-effect waves-light teal"><i class="material-icons">add</i></a>
									</div>
								</div>


							</div>


						</div>

					</form>

				</div>
				
				
			</div>
			<div class="modal-footer">
				<a class="btn-floating modal-action modal-close waves-effect waves-light red"><i class="material-icons">close</i></a>
				<!-- botao de criar -->
				<a class="btn-floating waves-effect waves-light teal"><i class="material-icons">check</i></a>
			</div>
		</div>
		<!-- ========================================================================= -->

		<div id="modal1" class="modal modal-fixed-footer">
			<div class="modal-content">
				
				<!-- titulo do modal -->
				<h4>May 7</h4>

				<!-- secao de detalhes -->
				<p><b>Detalhes:</b></p>

				<!-- texto de detalhes -->
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquam, est sit amet venenatis pharetra, metus mauris fermentum sapien, a volutpat est massa eget lorem.</p>
				
				<!-- div com a lista de participantes -->
				<div id="modal1-p">

					<b>Participantes:</b><br><br>
					
					<!-- ISSO EH UM PARTICIPANTE -->
					<div class="chip">
						<!-- IMAGEM -->
						<img src="images/02.jpeg" alt="Contact Person">
						<!-- nome -->
						Jane Doe
						<!-- icone de remover -->
						<i class="close material-icons">close</i>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<!-- botao de editar -->
				<a class="btn-floating fab waves-effect waves-light red"><i class="material-icons">edit</i></a>
			</div>
		</div>
	</div>

	<!--Importar jQuery antes do materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script type="text/javascript" src="js/configs.js"></script>

	<script>
	
		$(document).ready(function(){
			
			var winH = $(window).height();
			var home = $(".item2");
			home.css('height', winH - 180);

			$('.carousel.carousel-slider').carousel({fullWidth: true});
			var winH = $(window).height();
			var carousel = $(".carousel")
			carousel.css('height', winH - 65);

			$('.modal').modal();

			Materialize.updateTextFields();
			$('#textarea1').val('');
			$('#textarea1').trigger('autoresize');

			 $('.datepicker').pickadate({
				selectMonths: true, // Creates a dropdown to control month
				selectYears: 15, // Creates a dropdown of 15 years to control year,
				today: 'Hoje',
				clear: 'Limpar',
				close: 'Ok',
				closeOnSelect: false // Close upon selecting a date,
			});

			 $('.timepicker').pickatime({
				default: 'now', // Set default time: 'now', '1:30AM', '16:30'
				fromnow: 0,       // set default time to * milliseconds from now (using with default = 'now')
				twelvehour: false, // Use AM/PM or 24-hour format
				donetext: 'OK', // text for done-button
				cleartext: 'Limpar', // text for clear-button
				canceltext: 'Cancelar', // Text for cancel-button
				autoclose: false, // automatic close timepicker
				ampmclickable: true, // make AM PM clickable
				aftershow: function(){} //Function for after opening timepicker
			});

			$(".button-collapse").sideNav();

		});

	</script>

</body>
</html>