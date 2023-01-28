function addCurso() {

    var cursoPrueba = { imagen : "aaaa",
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
            alert("Curso incorporado.");
            document.getElementById('uploadImagen').src;
        }
    });
}

function vote(asd) {

    var cursoPrueba = { imagen : "aaaa",
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
            alert("Curso incorporado.");
            document.getElementById('uploadImagen').src;
        }
    });
}

$(document).ready( function () {
    
} );