/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionContext", "api/calificaciones");
    mod.controller('calificacionesCtrl', ['$scope', '$http', 'calificacionContext',
        function ($scope, $http, calificacionContext) {
            $http.get('data/calificaciones.json').then(function (response) {
                $scope.calificacionesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);


