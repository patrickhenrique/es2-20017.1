(function(d, s, id){
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {return;}
	js = d.createElement(s); js.id = id;
	js.src = "https://connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
fbAsyncInit = function() {	
	FB.init({
		appId      : '877556605702264',
		cookie     : true,
		xfbml      : true,
		version    : 'v2.11'
	});	      
	loginRegister=((opcao)=>{
		FB.login(function(response) {
			if (response.authResponse) {
				FB.getLoginStatus(function(r) {
					location.href=(opcao=="login") ? "http://localhost:8080/UfalAgenda/Auth?token="+r.authResponse.accessToken:"http://localhost:8080/UfalAgenda/Register?token="+r.authResponse.accessToken;
					console.log(r.authResponse.accessToken);
				});
			} else {
			}
		});
	});
};
onload=(()=>{
	document.getElementById("facebook-login").addEventListener("click",()=>{
		loginRegister("login");
	});
	document.getElementById("facebook-register").addEventListener("click",()=>{
		loginRegister("register");
	});
});