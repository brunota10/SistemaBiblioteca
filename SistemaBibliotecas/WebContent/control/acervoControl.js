var app = angular.module('acervoModule',[]);

app.controller('acervoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaBibliotecas/rs/acervo';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (acervosRetorno) {
			$scope.acervos = acervosRetorno;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar clientes '+mensagemErro);
		});   
	}
	
	$scope.novo = function(){
		$scope.acervo = {};
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {
		if ($scope.acervo.codigo == undefined || $scope.acervo.codigo == '') {
			$http.post(url,$scope.acervo).success(function(acervo) {
				$scope.acervos.push($scope.acervo);
				$scope.novo();
				$scope.mensagens.push('Acervo salvo com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.acervo).success(function(acervo) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Acervo atualizado com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.acervo.codigo == '') {
			alert('Selecione um acervo');
		} else {
			urlExcluir = url+'/'+$scope.acervo.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Acervo excluído com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir acervo: '+erro);
			});
		}
	}
	
	$scope.seleciona = function(acervoTabela) {
		$scope.acervo = acervoTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();
});