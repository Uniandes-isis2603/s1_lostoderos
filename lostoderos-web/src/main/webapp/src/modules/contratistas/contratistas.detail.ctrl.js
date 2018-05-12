(function (ng) {
    var mod = ng.module("contratistasModule");
    mod.constant("contratistaContext", "api/contratistas");
    mod.controller('contratistaDetailCtrl', ['$scope', '$http', 'contratistaContext', '$state', '$filter',
        function ($scope, $http, contratistaContext, $state) {
            
            if (($state.params.contratistaId !== undefined) && ($state.params.contratistaId !== null)) {
                $http.get(contratistaContext + '/' + $state.params.contratistaId).then(function (response) {
                    $scope.currentContratista = response.data;
                    
                });
            }
            
        }
    ]);
}
)(window.angular);

