(function (ng) {
    var mod = ng.module("serviciosModule");
    mod.constant("serviciosContext", "api/servicios");
    mod.controller('serviciosCtrl', ['$scope', '$http', 'serviciosContext',
        function ($scope, $http, serviciosContext) {
            $http.get('data/servicios.json').then(function (response) {
                $scope.serviciosRecords = response.data;
            });
        }
    ]);
}
)(window.angular);

