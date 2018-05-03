(function (ng) {
    var mod = ng.module("facturasModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturasNewCtrl', ['$scope', '$http', 'facturasContext', '$state', '$rootScope',
        function ($scope, $http,facturasContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
          
            $scope.createFactura1 = function () {
                $http.post(facturasContext, $scope.data).then(function (response) {
                    $state.go('facturasList', {facturaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

