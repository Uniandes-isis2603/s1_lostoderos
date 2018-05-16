/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("solicitudModule");
    mod.constant("solicitudesContext", "api/solicitudes");
    mod.constant("serviciosContext", "api/servicios");
    mod.controller('solicitudNewCtrl', ['$scope', '$http', 'serviciosContext','solicitudesContext', '$state', '$rootScope',
        function ($scope, $http, serviciosContext,  solicitudesContext, $state,$rootScope) {
            
            var servicios = [];
            
            $http.get(serviciosContext).then(function (response) {
                if (response.data !== "") {
                    $scope.serviciosRecords = response.data;
                    servicios = $scope.serviciosRecords;
                } 
                ;
            });
            
            $http.get(solicitudesContext).then(function (response) {
                if (response.data !== "") {
                    $scope.solicitudesRecords = response.data;
                    solicitudes = $scope.solicitudesRecords;
                } 
                ;
            });

            //$scope.data = {};
            $scope.createSolicitud = function () {
                console.log($rootScope.currentId);
                $scope.data.cliente = {id: $rootScope.currentId};
                $scope.data.servicio={id:$scope.data.tipo_servicio};
                
                $http.post(solicitudesContext, $scope.data).then(function (response) {
                    $state.go('solicitudesList', {solicitudId: response.data.id}, {reload: true});
                });
                
            };
        }
    ]);
}
)(window.angular);