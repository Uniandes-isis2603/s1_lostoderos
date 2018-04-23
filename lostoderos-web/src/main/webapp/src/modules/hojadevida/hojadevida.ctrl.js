(function (ng) {
    var mod = ng.module("hojadevidaModule");
    mod.constant("hojadevidaContext", "api/hojasdevida");
    mod.controller('hojadevidaCtrl', ['$scope', '$http', 'hojadevidaContext', '$state', '$filter',
        function ($scope, $http, hojadevidaContext, $state) {
            
            if (($state.params.hojadevidaId !== undefined) && ($state.params.hojadevidaId !== null)) {
                $http.get(hojadevidaContext + '/' + $state.params.hojadevidaId).then(function (response) {
                    $scope.hojadevida = response.data;
                    
                });
            }
        }
    ]);
}
)(window.angular);


