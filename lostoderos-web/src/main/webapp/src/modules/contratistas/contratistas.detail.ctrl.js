(function (ng) {
    var mod = ng.module("contratistasModule");
    mod.constant("contratistaContext", "api/contratistas");
    mod.controller('contratistaDetailCtrl', ['$scope', '$http', 'contratistaContext', '$state', '$filter',
        function ($scope, $http, contratistaContext, $state, $filter) {
            
            if (($state.params.contratistaId !== undefined) && ($state.params.contratistaId !== null)) {
                $http.get('data/contratistas.json').then(function (response) {
                    $scope.contratistasRecords = response.data;
                    $scope.currentContratista = $filter('filter')($scope.contratistasRecords, {id: $state.params.contratistaId}, true)[0];
                });
            }
        }
    ]);
}
)(window.angular);

