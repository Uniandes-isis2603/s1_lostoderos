/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("cotizacionModule");
    mod.constant("cotizacionContext", "api/cotizaciones");
    mod.controller('cotizacionDetailCtrl', ['$scope', '$http', 'cotizacionContext', '$state', '$filter',
        function ($scope, $http, cotizacionContext, $state, $filter) {
            
            if (($state.params.cotizacionId !== undefined) && ($state.params.cotizacionId !== null)) {
                $http.get(cotizacionContext+ '/'+$state.params.id).then(function (response) {
                    $scope.currentCotizacion = response.data;
                });
            }
        }
    ]);
}
)(window.angular);

