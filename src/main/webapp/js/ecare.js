/**
 * Created by Kolia on 06.07.2015.
 */

function get_contracts() {
    var username=$('#user').text();
    $.get('client_lobby',{user:username, action:"get_contracts"},function(responseText) {
        $('#contracts').html(responseText);
    });
}

function get_current_contract() {
    var username=$('#user').text();

    $.get('client_lobby',{user:username, action:"get_current_contract"},function(responseText) {
        $('#current_contract').text(responseText);
    });
}

function get_options() {
    var username=$('#user').text();

    $.get('client_lobby',{user:username, action:"get_options"},function(responseText) {
        $('#options').html(responseText);
    });
}

function get_tariffs() {
    var username=$('#user').text();

    $.get('client_lobby',{user:username, action:"get_tariffs"},function(responseText) {
        $('#tariffs').html(responseText);
    });
}

function get_contract_info() {
    var username=$('#user').text();

    $.get('client_lobby',{user:username, action:"get_contract_info"},function(responseText) {
        $('#contract_info').html(responseText);
    });
}

$('#logout').click(function() {
    $.get('client_lobby',{action:"sign_out"},function(responseText) {
        window.location = "login.jsp";
    });
});



$( ".contracts" ).click(function(e) {
    var phoneNumber = $(e.target).text();
    $.get('client_lobby',{action:"select_contract", phoneNumber:phoneNumber},function(responseText) {
        var elements = $(responseText);
        var found = $('#content', elements);
        $('#content').replaceWith(found);
        $('#current_contract').text(phoneNumber);
    });
});


$( "#search" ).click(function(e) {
    var email = $("#email").text();
    $.get('admin_lobby',{action:"find_user", email:email},function(responseText) {
        var elements = $(responseText);
        var found = $('#content', elements);
        $('#content').replaceWith(found);
        $('#current_contract').text(email);
    });
});


$('#clients tbody > tr').click(function() {
    $(this).addClass("danger");
});

$('#contracts tbody > tr').click(function() {
    $('#editContract').modal('show');
});

$('#tariffs tbody > tr').click(function() {
    $('#editTariff').modal('show');
});

$('#options tbody > tr').click(function() {
    $('#editOption').modal('show');
});


$('#searchUser').click(function() {
    var email = $('#searchEmail').text();

    var tableRow = $("td").filter(function() {
        return $(this).text() == email;
    }).closest("tr");

    $(tableRow).addClass("info");
    $(tableRow).removeClass("info", 2000);
});