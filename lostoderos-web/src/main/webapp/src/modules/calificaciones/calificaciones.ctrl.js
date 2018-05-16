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
            var context = calificacionesContext + '/contratista/'+ $state.params.contratistaId;
            var calificaciones = [];         
            $http.get(context).then(function (response) {
                if (response.data !== "") {
                    $scope.calificacionesRecords = response.data;
                    calificaciones = $scope.calificacionesRecords;
                } 
                ;
            });
            
            $scope.createCalificacion = function () {
                $scope.data.contratista = {id: $scope.currentContratista.id};
                $scope.data.cliente = {id: $rootScope.currentId};
                $http.post(calificacionesContext, $scope.data).then(function () {
                    $state.go('contratistaDetail', {contratistaId: $state.params.contratistaId}, {reload: true});
                });
                
            };
            
            $scope.deleteCalificacion = function(id){
                $http.delete(calificacionesContext+'/'+id).then(function () {
                    $state.go('calificacionesList', {contratistaId: $state.params.contratistaId}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


