(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clienteDeleteCtrl', ['$scope', '$http', 'clientesContext', '$state',
        function ($scope, $http, clientesContext, $state) {
            var idCliente = $state.params.clienteId;
            $scope.deleteCliente = function () {
                $http.delete(clientesContext + '/' + idCliente, {}).then(function (response) {
                    $state.go('clientesList', {authorId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);