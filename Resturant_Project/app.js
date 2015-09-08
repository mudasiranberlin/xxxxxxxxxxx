/**
 * Created by Datta on 7/28/2015.
 */

$(document).ready(function() {
    $("#temp3").hide();
    $("#temp1").focus();
    var placeHolder = 0;
    var text_item= "Welcome to Swadh..... The Royal Court, over the centuries Indian cuisine has been influenced by many cultures.Swadh takes the best from the culinary extravaganza of the great Moguls and bring you a repast.Our welcome comes from deep within our heart. We will strive to make your dining experience a return to those golden times when every meal was a feast. Our guests are our friends.Enjoy your delightful experience at SWADH.";
    var d = new Date();
    var yyyy = d.getFullYear().toString();
    var mm = (d.getMonth()+1).toString(); // getMonth() is zero-based
    var dd  = d.getDate().toString();

    var x = yyyy + '-' + (mm[1]?mm:"0"+mm[0]) + '-' + (dd[1]?dd:"0"+dd[0]);
    console.log(x);
    document.getElementById("demo").setAttribute('min',x);

    var textAdder = setInterval(function(){
        document.getElementById('temp100').innerHTML += text_item.charAt(placeHolder);
        if (++placeHolder == text_item.length){
            clearInterval(textAdder);
        }
    }, 25);

});
$("#guest").click(function(){
    $("#temp1").show();
    $("#temp3").hide();


});

$("#owner").click(function(){
    $('#temp3').show();
    $('#temp1').hide();
    /*$('#temp3').css( 'background-color',' rgba(255, 255, 255, 0.75)');
    $('#temp4').css( 'background-color',' rgba(255, 255, 255, 0.25)');*/

});

