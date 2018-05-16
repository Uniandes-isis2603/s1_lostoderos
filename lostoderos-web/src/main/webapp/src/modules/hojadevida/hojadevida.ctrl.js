(function (ng) {
    var mod = ng.module("hojadevidaModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('hojadevidaCtrl', ['$scope', '$http', '$state', 'contratistasContext',
        function ($scope, $http, $state, $contratistasContext) {

            var context = $contratistasContext + '/' + $state.params.contratistaId + "/hojadevida";
            var hoja = {};
            $scope.data = {};
            var contratista = {};

            $http.get(context).then(function (response) {
                if (response.data === "") {
                    $state.go('createHojadevida');
                } else {
                    $scope.hojadevida = response.data;
                    hoja = $scope.hojadevida;
                    contratista = hoja.contratista;
                }
                ;
            });
            $scope.updateHojadevida = function () {
                $scope.data.contratista = {"id": $state.params.contratistaId};
                $http.put(context, $scope.data).then(function () {
                    $state.go('hojadevida', {contratistaId: $state.params.contratistaId}, {reload: true});
                });
            };
            $scope.createHojadevida = function () {
                $scope.data.contratista = {"id": $state.params.contratistaId};
                $http.post(context, $scope.data).then(function () {
                   $state.go('hojadevida', {contratistaId: $state.params.contratistaId}, {reload: true});
                });
            };
            $scope.deleteHojadevida = function () {
                $scope.data.contratista = {"id": $state.params.contratistaId};
                $scope.data.id = hoja.id;
                $http.delete(context).then(function () {
                    $state.go('contratistaDetail', {contratistaId: $state.params.contratistaId}, {reload: true});
                });
            };
            $scope.volver = function () {
                $state.go('contratistaDetail', {contratistaId: $state.params.contratistaId}, {reload: true});
            };
        }
    ]);
}
)(window.angular);


