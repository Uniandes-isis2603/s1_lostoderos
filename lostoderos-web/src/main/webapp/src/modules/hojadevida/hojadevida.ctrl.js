(function (ng) {
    var mod = ng.module("hojadevidaModule");
    mod.constant("hojadevidaContext", "api/contratistas");
    mod.controller('hojadevidaCtrl', ['$scope', '$http', '$state',
        function ($scope, $http, $state) {
            var context = "api/contratistas/" + $scope.currentContratista.id + "/hojadevida";
            var hoja = {};
            $scope.data = {};
            if ($scope.currentContratista.hojaVida !== undefined && $scope.currentContratista.hojaVida !== null) {
                $http.get(context).then(function (response) {
                    $scope.hojadevida = response.data;
                    hoja = $scope.hojadevida;
                });
            } else {
                $state.go('createHojadevida');
            }

            $scope.updateHojadevida = function () {
                $scope.data.contratista = $scope.hojadevida.contratista;
                $scope.data.id=$scope.hojadevida.id;
                $http.put(context+'/'+$scope.data.id, $scope.data).then(function (response) {
                    $state.go('contratistaDetail', {contratistaId: response.data.contratista.id}, {reload: true});
                });
            };
            $scope.createHojadevida = function () {
                $scope.data.contratista = $scope.hojadevida.contratista;
                $scope.data.id=$scope.hojadevida.id;
                $http.post(context, $scope.data).then(function (response) {
                    $state.go('contratistaDetail', {contratistaId: response.data.contratista.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


