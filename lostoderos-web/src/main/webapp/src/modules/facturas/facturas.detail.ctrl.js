(function (ng) {
    var mod = ng.module("facturasModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturasDetailCtrl', ['$scope', '$http', 'facturasContext', '$state', '$filter',
        function ($scope, $http, facturasContext, $state) {
            
            if (($state.params.facturaId !== undefined) && ($state.params.facturaId !== null)) {
                $http.get(facturasContext + '/' + $state.params.facturaId).then(function (response) {
                    $scope.currentFactura = response.data;
                    
                });
            }
        }
    ]);
}
)(window.angular);

