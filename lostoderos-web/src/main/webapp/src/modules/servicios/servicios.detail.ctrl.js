(function (ng) {
    var mod = ng.module("serviciosModule");
    mod.constant("serviciosContext", "api/servicios");
    mod.controller('servicioDetailCtrl', ['$scope', '$http', 'serviciosContext', '$state', '$filter',
        function ($scope, $http, serviciosContext, $state) {           
            if (($state.params.servicioId !== undefined)&& ($state.params.servicioId!== null)) 
            {
                $http.get(serviciosContext + '/' + $state.params.servicioId).then(function (response) {
                    $scope.currentServicio = response.data;
                });
            }
        }
    ]);
}
)(window.angular);

