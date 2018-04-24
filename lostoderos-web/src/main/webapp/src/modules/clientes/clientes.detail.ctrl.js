(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clienteDetailCtrl', ['$scope', '$http', 'clientesContext', '$state', '$filter',
        function ($scope, $http, clientesContext, $state) {           
            if (($state.params.clienteId !== undefined)&& ($state.params.clienteId!== null)) 
            {
                $http.get(clientesContext + '/' + $state.params.clienteId).then(function (response) {
                    $scope.currentCliente = response.data;
                });
            }
        }
    ]);
}
)(window.angular);

