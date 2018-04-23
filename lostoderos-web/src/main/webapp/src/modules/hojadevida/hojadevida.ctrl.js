(function (ng) {
    var mod = ng.module("hojadevidaModule");
    mod.constant("hojadevidaContext", "api/hojasdevida");
    mod.controller('hojadevidaCtrl', ['$scope', '$http', 'hojadevidaContext', '$state',
        function ($scope, $http, hojadevidaContext, $state) {
            if ($scope.currentContratista.hojaVida !== undefined && $scope.currentContratista.hojaVida !== null) {
                $http.get(hojadevidaContext + '/' + $scope.currentContratista.hojaVida.id).then(function (response) {
                    $scope.hojadevida = response.data;
                });
            } else {
                $state.go('createHojadevida');
            }
            this.createHojadevida = function(){
                hojadevida = $scope.hojadevida;
                hojadevida.contratista={id:$scope.currentContratista.id};
                return $http.post(hojadevidaContext,hojadevida).then(function(){
                    $state.go('contratistasList');
                });
            };
        }
    ]);
}
)(window.angular);


