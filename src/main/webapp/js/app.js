var app = angular.module('app',[]);

app.controller('LineaCtrl', function($scope, $http, $filter) {
  
	$scope.loadEstaciones = function() {
		console.log("Loading...")
		var uri = "../../rest/json/estaciones";
	    $.ajax({
	        url: uri,
	        type: 'GET',
	        dataType: 'json',
	        success: function(data) {

	          var json = [];

	          /*
	           * Genera el json con el formato de jquery para el autocomplete.
	           */
	/*          $.each(data["leagues"], function(key, value) {
	            json.push({"label":value['name'], "id":value['id']});
	          });*/
	          
	          $.each(data, function(key, value) {
	              json.push({"label":value['nombre'], "id":value['id']});
	          });          
	          
	          var input = document.getElementById("autocomplete");   

	          $(input).autocomplete({
	              source: json,
	              minLength: 2,
	              select: function(event, ui) {
	                  seleccionado = ui.item.id;
	                  $('#selected').val(seleccionado);
	              }                          
	          });

	        }
	    });    
	  }
	  
	  $scope.loadEstaciones();
});

/*app.config(function($interpolateProvider){
  $interpolateProvider.startSymbol('[[').endSymbol(']]');
});*/