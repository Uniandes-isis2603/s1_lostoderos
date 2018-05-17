(function (ng) {
    var mod = ng.module("pagosModule");
    mod.constant("pagosContext", "api/pagos");
    mod.controller('pagosDetailCtrl', ['$scope', '$http', 'pagosContext', '$state', '$filter',
        
        function ($scope, $http, pagosContext, $state) {
            var context = 'api/facturas/'+$state.params.facturaId+'/pago';
            
            if (($state.params.facturaId !== undefined) && ($state.params.facturaId !== null)) {
                $http.get(context).then(function (response) {
                    $scope.currentPago = response.data;                
                });
            }
            
            $scope.createPago = function () {
                $scope.data.factura = {"id": $state.params.facturaId};
                $http.post(context, $scope.data).then(function () {
                   $state.go('facturasDetail', {facturaId: $state.params.facturaId}, {reload: true});
                });
            };
        }
        
        
    ]);
}
)(window.angular);

