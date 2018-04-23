(function (ng) {
    var mod = ng.module("contratosModule");
    mod.constant("contratosContext", "api/contratos");
    mod.controller('contratosCtrl', ['$scope', '$http', 'contratosContext', '$state', '$filter',
        function ($scope, $http, contratosContext, $state) {
            
            if (($state.params.contratoId !== undefined) && ($state.params.contratoId !== null)) {
                $http.get(contratosContext + '/' + $state.params.contratoId).then(function (response) {
                    $scope.contrato = response.data;
                    
                });
            }
        }
    ]);
}
)(window.angular);


