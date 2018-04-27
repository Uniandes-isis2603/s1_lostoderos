(function (ng) {
    var mod = ng.module("hojadevidaModule");
    mod.constant("hojadevidaContext", "api/contratistas");
    mod.controller('hojadevidaCtrl', ['$scope', '$http', '$state',
        function ($scope, $http, $state) {
            var context = "api/contratistas/" + $scope.currentContratista.id + "/hojadevida";
            if ($scope.currentContratista.hojaVida !== undefined && $scope.currentContratista.hojaVida !== null) {
                $http.get(context).then(function (response) {
                    $scope.hojadevida = response.data;
                });
            } else {
                $state.go('createHojadevida');
            }
            this.createHojadevida = function () {
                hojadevida = $scope.hojadevida;
                hojadevida.contratista = {id: $scope.currentContratista.id};
                return $http.post(context, hojadevida).then(function () {
                    $state.go('contratistasList');
                });
            };
        }
    ]);
}
)(window.angular);


