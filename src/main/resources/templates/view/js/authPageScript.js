//
//var link = document.querySelector('link[rel=import]');
//var content = link.import.querySelector('#header_element');
//document.body.appendChild(content.cloneNode(true));

// Work with js isn't finish
$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };

    $("#registerbutton").click(function() {
        var body = validateForm();
        if (body) {
            return $.ajax({
                type: 'GET',
                url: '/',
                data: JSON.stringify(body),
                success: function(data) {
                    localStorage.setItem('status', 'success');
                    location.reload();

                },
                error: function(jqXHR, textStatus, errorThrown) {
                    showError(jqXHR.responseJSON.message, jqXHR.responseText);
                },
                contentType: "text/html;charset=UTF-8",
                dataType: 'text/html'
            });
        }
    }
});


function validateForm() {
    var body = {
        login: $("#login-input").val(),
        password: $("#password-input").val()
    };
    if (body.login == "" || body.password == "") {
        showError('Please fill all fields', 'All fields must be populated');
        return false;
    }
    return body;
}

