(function (ng) {
    var mod = ng.module("facturasModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturasCtrl', ['$scope', '$state', '$http','facturasContext',
        function ($scope, $state, $http, facturasContext) {
            $http.get(facturasContext).then(function (response) {
                $scope.facturasRecords = response.data;
                $scope.list=response.data;
            });
            this.createFactura = function () {
                factura = $scope.pago;
                return $http.post(facturasContext, factura).then(function () {
                    $state.go('facturasList');
                });
            };
        }
    ]);
}
)(window.angular);

