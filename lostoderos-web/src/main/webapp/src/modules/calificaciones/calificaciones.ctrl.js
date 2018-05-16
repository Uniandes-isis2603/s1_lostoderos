/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.constant("contratistasContext", "contratista");
    mod.controller('calificacionesCtrl', ['$scope', '$http', 'contratistasContext', '$state', 'calificacionesContext', '$rootScope',
        function ($scope, $http, contratistasContext, $state, calificacionesContext, $rootScope) {
            if (($scope.currentContratista.calificaciones[0] !== undefined) && ($scope.currentContratista.calificaciones[0] !== null)) {
                $http.get(calificacionesContext + '/' + 'contratista' + '/' + $state.params.contratistaId).then(function (response) {
                    $scope.calificacionesRecords = response.data;
                });
            } else {
                $state.go('createCalificacion');
            }
            ;
            $scope.createCalificacion = function () {
                $scope.data.contratista = {id: $scope.currentContratista.id};
                $scope.data.cliente = {id: $rootScope.currentId};
                $http.post(calificacionesContext, $scope.data).then(function (response) {
                    $state.go('contratistaDetail', {contratistaId: response.data.contratista.id}, {reload: true});
                });
                
            };

        }
    ]);
}
)(window.angular);


