(function (ng) {
    var mod = ng.module("facturasModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturasCtrl', ['$scope', '$state', '$http','facturasContext',
        function ($scope, $state, $http, facturasContext) {
            $http.get(facturasContext).then(function (response) {
                $scope.facturasRecords = response.data;
                $scope.list=response.data;
            });
           /* this.createPago = function () {
                pago = $scope.pago;
                return $http.post(pagosContext, pago).then(function () {
                    $state.go('pagosList');
                });
            }*/;
        }
    ]);
}
)(window.angular);

