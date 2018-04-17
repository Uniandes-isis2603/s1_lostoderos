(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesCtrl', ['$scope', '$http', 'clientesContext',
        function ($scope, $http, clientesContext) {
            $http.get('data/clientes.json').then(function (response) {
                $scope.contratistasRecords = response.data;
            });
        }
    ]);
}
)(window.angular);

