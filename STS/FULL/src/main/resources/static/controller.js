var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
	
	$scope.manutencoes = new Object();

	$scope.salvar = function() {
		$http.post("http://localhost:8080/pagina/post1", {
			'id' : $scope.id,
			'nome' : $scope.nome,
			'categoria' : $scope.categoria,
			'data' : $scope.data

		})
	};
	$scope.buscarTodos = function() {
		$http.get("http://localhost:8080/pagina/getAll1").then(function(resposta) {
			$scope.manutencoes = resposta.data;
		});
	}
	$scope.buscarTodos();

	$scope.delete = function(){
		$http.delete("http://localhost:8080/pagina/delete/"+$scope.id);
	}
	
	$scope.put = function(){
		$http.put("http://localhost:8080/pagina/put1/" + $scope.id , {
			
			'nome' : $scope.nome,
			'categoria' : $scope.categoria
			})
	}
});