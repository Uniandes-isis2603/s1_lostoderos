(function (ng) {
    var mod = ng.module("pagosModule");
    mod.constant("pagosContext", "api/pagos");
    mod.controller('pagosCtrl', ['$scope', '$http', 'pagosContext',
        function ($scope, $http, pagosContext) {
            $http.get('data/pagos.json').then(function (response) {
                $scope.pagosRecords = response.data;
                
            });
            
        }
    ]);
}
)(window.angular);

