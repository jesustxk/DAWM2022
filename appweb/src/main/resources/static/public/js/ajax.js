function addCurso() {

    var img = document.getElementById('dragger').innerHTML

    var cursoPrueba = { imagen : img.substring(27, img.length - 9),
        titulo : $('#titulo').val(),
        enlace : $('#enlace').val(),
        descripcion: $('#descripcion').val()
    };

    $.ajax({
        type: 'POST',
        url: '/addCurso',
        data: cursoPrueba,
        cache: false,
        success: function() {
        }
    });
}

$(document).ready( function () {
    
} );