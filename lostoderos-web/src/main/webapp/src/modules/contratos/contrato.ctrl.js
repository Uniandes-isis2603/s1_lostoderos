(function (ng) {
    var mod = ng.module("contratoModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratoCtrl', ['$scope', '$http', '$state', 'contratistasContext',
        function ($scope, $http, $state, $contratistasContext) {

            var context = $contratistasContext + '/' + $state.params.contratistaId + "/contrato";
            var contrato = {};
            $scope.data = {};
            var contratista = {};

            $http.get(context).then(function (response) {
                if (response.data === "") {
                    if($scope.hasPermissions()){
                        $state.go('createContrato', {contratistaId: $scope.currentContratista.id});
                    }
                    else{
                        $state.go('contratistaDetail', {contratistaId: $scope.currentContratista.id});
                    }
                } else {
                    $scope.contrato = response.data;
                    contrato = $scope.contrato;
                    contratista = contrato.contratista;
                }
                ;
            });
            $scope.updateContrato = function () {
                $scope.data.id = contrato.id;
                $http.put(context, $scope.data).then(function () {
                    $state.go('contrato', {contratistaId: $state.params.contratistaId}, {reload: true});
                });
            };
            $scope.createContrato = function () {
                
                $http.post(context, $scope.data).then(function () {
                   $state.go('contrato', {contratistaId: $state.params.contratistaId}, {reload: true});
                });
            };
            $scope.deleteContrato = function () {
                $scope.data.id = contrato.id;
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


