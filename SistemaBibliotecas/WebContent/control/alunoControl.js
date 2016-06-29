var app = angular.module('alunoModule',[]);

app.controller('alunoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaBibliotecas/rs/aluno';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (alunosRetorno) {
			$scope.alunos = alunosRetorno;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar aluno '+mensagemErro);
		});   
	}
	
	$scope.novo = function(){
		$scope.aluno = {};
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
		if ($scope.aluno.codigo == undefined || $scope.aluno.codigo == '') {
			$http.post(url,$scope.aluno).success(function(alunoRetornado) {
				$scope.alunos.push($scope.alunoRetornado);
				$scope.novo();
				$scope.mensagens.push('Aluno salvo com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.aluno).success(function(aluno) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Aluno atualizado com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.aluno.codigo == '') {
			alert('Selecione um aluno');
		} else {
			urlExcluir = url+'/'+$scope.aluno.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Aluno excluído com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir aluno: '+erro);
			});
		}
	}
	
	$scope.seleciona = function(alunoTabela) {
		$scope.aluno = alunoTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();
});