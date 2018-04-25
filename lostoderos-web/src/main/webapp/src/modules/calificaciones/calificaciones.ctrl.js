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
            if (($scope.currentContratista.calificaciones[0] !== undefined) && ($scope.currentContratista.calificaciones[0] !== null)) {
            $http.get(calificacionesContext + '/' + 'contratista' + '/' + $state.params.contratistaId).then(function (response) {
                $scope.calificacionesRecords = response.data;
            });
        }else{
            $state.go('createCalificacion');
        }
        this.createCalificacion = function(){
                calificacion = $scope.calificacion;
                calificacion.contratista={id:$scope.currentContratista.id};
                return $http.post(calificacionesContext,calificacion).then(function(){
                    $state.go('contratistasList');
        });
    };
   }
    ]);
}
)(window.angular);


