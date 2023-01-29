function addCurso() {

    var img = document.getElementById('dragger').innerHTML

    var cursoPrueba = { imagen : img.substring(10, img.length - 9),
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

function updatePerfil() {

    var usuario = { username : document.getElementById("username").innerText,
        nombre : $('#fullName').val(),
        email : $('#eMail').val(),
        edad : $('#age').val(),
        descripcion: $('#text').val(),
        password4: $('#inputPassword4').val(),
        password5: $('#inputPassword5').val(),
        password6: $('#inputPassword6').val()
    };

    $.ajax({
        type: 'POST',
        url: '/updatePerfil',
        data: usuario,
        cache: false,
        success: function() {
        }
    });
}

$(document).ready( function () {
    
} );