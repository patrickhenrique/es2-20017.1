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

	login=(()=>{
		FB.login(function(response) {
			if (response.authResponse) {
				FB.api('/me?fields=id,name,email,picture{url}', function(response) {
					console.log('Good to see you, ' + response.name + '.');

					document.getElementById("perfil-img").innerHTML="<img src='"+response.picture.data.url+"'/>";
				});
			} else {
				console.log('User cancelled login or did not fully authorize.');
			}
		});
	});
};


onload=(()=>{
	for(i=0;i<3;i++){
		document.getElementsByClassName("facebook-login")[i].addEventListener("click",()=>{
			login();
		});
	}
});