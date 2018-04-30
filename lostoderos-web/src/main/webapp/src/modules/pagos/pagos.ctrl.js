(function (ng) {
    var mod = ng.module("pagosModule");
    mod.constant("pagosContext", "api/pagos");
    mod.controller('pagosCtrl', ['$scope', '$state', '$http','pagosContext',
        function ($scope, $state, $http, pagosContext) {
            $http.get(pagosContext).then(function (response) {
                $scope.pagosRecords = response.data;
                $scope.list=response.data;
            });
            this.createPago = function () {
                pago = $scope.pago;
                return $http.post(pagosContext, pago).then(function () {
                    $state.go('pagosList');
                });
            };
        }
    ]);
}
)(window.angular);

