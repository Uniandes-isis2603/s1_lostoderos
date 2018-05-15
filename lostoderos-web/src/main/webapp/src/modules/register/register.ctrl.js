(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('registerCtrl', ['$scope', '$http', 'clientesContext', 'contratistasContext', '$state', '$rootScope',
        function ($scope, $http,clientesContext, contratistasContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};
          
            $scope.createUsuario = function () {
                if($scope.data.rol === 'cliente')
                {
                    $http.post(clientesContext, $scope.data).then(function (response) {
                    $state.go('serviciosList', {clienteId: response.data.id}, {reload: true});
                });
                }
                else if($scope.data.rol === 'contratista')
                {
                    $http.post(contratistasContext, $scope.data).then(function (response) {
                    $state.go('serviciosList', {contratistaId: response.data.id}, {reload: true});
                });    
                }
            };
        }
    ]);
}
)(window.angular);

