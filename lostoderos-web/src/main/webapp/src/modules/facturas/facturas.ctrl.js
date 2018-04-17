(function (ng) {
    var mod = ng.module("facturasModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturasCtrl', ['$scope', '$http', 'facturasContext',
        function ($scope, $http, facturasContext) {
            $http.get('data/facturas.json').then(function (response) {
                $scope.contratistasRecords = response.data;
                
            });
            
        }
    ]);
}
)(window.angular);

