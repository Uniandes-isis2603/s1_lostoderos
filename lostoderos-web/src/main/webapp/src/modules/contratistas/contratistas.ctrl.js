(function (ng) {
    var mod = ng.module("contratistasModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistasCtrl', ['$scope', '$state', '$http','contratistasContext',
        function ($scope, $state, $http, contratistasContext) {
            $http.get(contratistasContext).then(function (response) {
                $scope.contratistasRecords = response.data;
                $scope.list=response.data;
            });
            this.createContratista = function () {
                contratista = $scope.contratista;
                return $http.post(contratistasContext, contratista).then(function () {
                    $state.go('contratistasList');
                });
            };
        }
    ]);
}
)(window.angular);

