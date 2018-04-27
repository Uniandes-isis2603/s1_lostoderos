/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("cotizacionModule");
    mod.constant("cotizacionContext", "api/cotizaciones");
    mod.controller('cotizacionCtrl', ['$scope', '$http', 'cotizacionContext',
        function ($scope, $http, cotizacionContext) {
            $http.get(cotizacionContext).then(function (response) {
                $scope.cotizacionesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);