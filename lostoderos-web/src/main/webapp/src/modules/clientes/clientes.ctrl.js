(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesCtrl', ['$scope', '$http', 'clientesContext',
        function ($scope, $http, clientesContext) {
            $http.get(clientesContext).then(function (response) {
                $scope.clientesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);