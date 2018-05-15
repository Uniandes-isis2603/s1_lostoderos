(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('registerCtrl', ['$scope', '$http', 'clientesContext', '$state', '$rootScope',
        function ($scope, $http,clientesContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
          
            $scope.createCliente = function () {
                $http.post(clientesContext, $scope.data).then(function (response) {
                    $state.go('serviciosList', {clienteId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

