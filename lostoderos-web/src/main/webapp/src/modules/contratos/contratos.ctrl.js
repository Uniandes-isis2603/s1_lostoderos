(function (ng) {
    var mod = ng.module("contratosModule");
    mod.constant("contratosContext", "api/contratos");
    mod.controller('contratosCtrl', ['$scope', '$http', 'contratosContext', '$state', '$filter',
        function ($scope, $http, contratosContext, $state) {
            
            if (($scope.currentContratista.contrato !== undefined) && ($scope.currentContratista.contrato !== null)) {
                $http.get(contratosContext + '/' + $state.params.contratoId).then(function (response) {
                    $scope.contrato = response.data;
                    
                });
            } else {
                $state.go('createContrato');
            }
            this.createContrato = function(){
                contrato = $scope.contrato;
                contrato.contratista={id:$scope.currentContratista.id};
                return $http.post(contratosContext,contrato).then(function(){
                    $state.go('contratistasList');
            });
        };
    }
    ]);
}
)(window.angular);


