$(document).ready(function(){
  $('#refreshButton').click(function() {
    alert('hoge');
    refresh();
  });
});

function refresh() {
  $.ajax({
    type: 'get', url: 'index', 
    success: function(json) {
      if (json.status === 'OK') {
        $('#message').children('span').remove();
        $('<span/>').appendTo('#message').text(json.message);
      } else {
        alert(json.errorMessage);
      }
    }
  });
}