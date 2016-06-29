var app = angular.module('emprestimoModule',[]);

app.controller('emprestimoControl',function($scope,$http){
	
	var urlAluno = 'http://localhost:8080/SistemaBibliotecas/rs/aluno';;
	
	var url = 'http://localhost:8080/SistemaBibliotecas/rs/emprestimo';
	
	
	$scope.pesquisarAluno = function(){
		$http.get(urlAluno).success(function (alunos) {
			$scope.alunos = alunos;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar aluno '+mensagemErro);
		});   
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (emprestimosRetorno) {
			$scope.emprestimos = emprestimosRetorno;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar emprestimo '+mensagemErro);
		});   
	}
	
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	
    $scope.salvar = function() {
		if ($scope.emprestimo.codigo == undefined || $scope.emprestimo.codigo == '') {
			$http.post(url,$scope.emprestimo).success(function(emprestimo) {
				$scope.emprestimos.push($scope.emprestimo);
				$scope.novo();
				$scope.mensagens.push('Emprestimo salvo com sucesso')
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.emprestimo).success(function(emprestimo) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Emprestimo atualizado com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.emprestimo.codigo == '') {
			alert('Selecione um emprestimo');
		} else {
			urlExcluir = url+'/'+$scope.emprestimo.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Emprestimo excluído com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir emprestimo: '+erro);
			});
		}
	}
	
	$scope.seleciona = function(emprestimoTabela) {
		//alert(JSON.stringify(emprestimoTabela));
		$scope.emprestimo = emprestimoTabela;
	}
	
	$scope.selecionaAluno = function(aluno) {
		$scope.aluno = aluno;
	}
		
	$scope.novo = function(){
		$scope.emprestimo = "";
		$scope.mensagens = [];
	}
	
	$scope.pesquisar();
	$scope.pesquisarAluno();
});