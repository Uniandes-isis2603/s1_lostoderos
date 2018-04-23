(function (ng) {
    var mod = ng.module("serviciosModule");
    mod.constant("serviciosContext", "api/servicios");
    mod.controller('servicioNewCtrl', ['$scope', '$http', 'serviciosContext', '$state', '$rootScope',
        function ($scope, $http,serviciosContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
          
            $scope.createServicio = function () {
                $http.post(serviciosContext, $scope.data).then(function (response) {
                    $state.go('serviciosList', {servicioId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

