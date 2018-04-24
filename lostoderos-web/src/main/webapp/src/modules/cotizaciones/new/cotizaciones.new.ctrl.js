/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("cotizacionModule");
    mod.constant("cotizacionesContext", "api/cotizaciones");
    mod.controller('cotizacionNewCtrl', ['$scope', '$http', 'cotizacionesContext', '$state', '$rootScope',
        
        function ($scope, $http, cotizacionesContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};

            
            $scope.createCotizacion = function () {
                $http.post(cotizacionesContext, $scope.data).then(function (response) {
                    $state.go('cotizacionesList', {cotizacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);