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
        //var success =  $(responseText).filter("#content");
        var elements = $(responseText);
        var found = $('#content', elements);
        //alert(found.html())
        //alert(found.text())
        //alert(responseText)
        $('#content').replaceWith(found);
        $('#current_contract').text(phoneNumber);
    });

    /*console.log("selected " + $(this).val());
    var phoneNumber = $(e.target).text();
    var sendData = {action:"select_contract", phoneNumber:phoneNumber}
    $.ajax({
        url: "client_lobby",
        method: "POST",
        data: sendData,
        async: false,
        success: function (result) {
            $('#content').load('/WEB-INF/jsp/client_lobby.jsp #content');
        }
    });*/
});



$("#selectContract").on('change', function () {
    console.log("selected " + $(this).val());
    var sendData = {type: "selectContract", number: $(this).val()}
    $.ajax({
        url: "/UserUpdateServlet",
        method: "POST",
        data: sendData,
        async: false,
        success: function (result) {
            $('#content').load('user.jsp #content');
        }
    });
});