function goToPage(index){
    $('.carousel').carousel('set', index);
}

function adicionaEvento(titulo, texto, data, id) {
    document.getElementById("cards").innerHTML += (

      '<div style="width: 200px; float: left;margin: 5px;">' +
          '<div class="card black-text modal-trigger" href="#modal' + id + '">' +
              '<div class="card-content" style="text-align: justify;">' +
                  '<span class="card-title"><b class="blue-grey-text text-darken-2">' + data + '</b></span>' +
                  '<p>' + titulo + '</p>' +
              '</div>' +
              '<a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">search</i></a>' +
          '</div>' +
      '</div>'
    );

    document.getElementById("modais").innerHTML += (

      '<div id="modal' + id + '" class="modal modal-fixed-footer">' +
        '<div class="modal-content">' +
          '<h4>' + titulo + '</h4>' +
          '<p>' + 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquam, est sit amet venenatis pharetra, metus mauris fermentum sapien, a volutpat est massa eget lorem.' + '</p>' +
        '</div>' +
        '<div class="modal-footer">'+
        '<a href="#" class="modal-action modal-close waves-effect waves-green btn-flat ">Ok</a>'+
      '</div>'+
    '</div>'
      
    );

    $(document).ready(function(){
      $('.modal').modal();
    });
}