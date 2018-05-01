(function (ng) {
    var mod = ng.module("contratosModule");
    mod.controller('contratosCtrl', ['$scope', '$http', '$state', '$filter',
        function ($scope, $http, $state) {
            var context = "api/contratistas/" + $scope.currentContratista.id + "/contrato";
            if (($scope.currentContratista.contrato !== undefined) && ($scope.currentContratista.contrato !== null)) {
                $http.get(context).then(function (response) {
                    $scope.contrato = response.data;
                    
                });
            } else {
                $state.go('createContrato');
            }
            this.createContrato = function(){
                contrato = $scope.contrato;
                contrato.contratista={id:$scope.currentContratista.id};
                return $http.post(context,contrato).then(function(){
                    $state.go('contratistasList');
            });
        };
    }
    ]);
}
)(window.angular);


