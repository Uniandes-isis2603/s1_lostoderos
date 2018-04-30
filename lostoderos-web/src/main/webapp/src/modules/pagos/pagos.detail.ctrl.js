(function (ng) {
    var mod = ng.module("pagosModule");
    mod.constant("pagosContext", "api/pagos");
    mod.controller('pagosDetailCtrl', ['$scope', '$http', 'pagosContext', '$state', '$filter',
        function ($scope, $http, pagosContext, $state) {
            
            if (($state.params.pagoId !== undefined) && ($state.params.pagoaId !== null)) {
                $http.get(pagosContext + '/' + $state.params.pagoId).then(function (response) {
                    $scope.currentPago = response.data;
                    
                });
            }
        }
    ]);
}
)(window.angular);

