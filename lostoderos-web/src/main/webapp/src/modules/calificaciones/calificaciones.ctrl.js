/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.constant("contratistasContext", "contratista");
    mod.controller('calificacionesCtrl', ['$scope', '$http','contratistasContext','$state', 'calificacionesContext',
        function ($scope, $http,contratistasContext,$state, calificacionesContext) {
            $http.get(calificacionesContext + '/' + 'contratista' + '/' + $state.params.contratistaId).then(function (response) {
                $scope.calificacionesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);


