(function (ng) {
    var mod = ng.module("pagosModule");
    mod.constant("pagosContext", "api/pagos");
    mod.controller('pagosNewCtrl', ['$scope', '$http', 'pagosContext', '$state', '$rootScope',
        
        function ($scope, $http, pagosContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};

        
            $scope.createPago = function () {
                $http.post(pagosContext, {
                    codigoTarjeta: $scope.codigoTarjeta,
                    numTarjeta: $scope.numTarjeta,
                    comprobantePagoMedio: $scope.comprobantePagoMedio,
                    comprobantePagoTotal: $scope.comprobantePagoTotal,
                    descripcion: $scope.descripcion,
                    fechaTarjeta: $scope.fechaTarjeta,
                    comprobantePagoTotal: $scope.comprobantePagoTotal
                }).then(function (response) {
                    $state.go('pagosList', {pagoId: response.data.id}, {reload: true});
                });
            };
  
        }
    ]);
}
)(window.angular);