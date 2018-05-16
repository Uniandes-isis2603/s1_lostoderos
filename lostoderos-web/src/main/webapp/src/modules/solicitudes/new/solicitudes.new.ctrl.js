/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("solicitudModule");
    mod.constant("solicitudesContext", "api/solicitudes");
    mod.constant("serviciosContext", "servicio")
    mod.controller('solicitudNewCtrl', ['$scope', '$http', 'solicitudesContext', '$state', '$rootScope',
        function ($scope, $http, serviciosContext, $state, solicitudesContext, $rootScope) {
            

            $http.get(solicitudesContext).then(function (response) {
                if (response.data !== "") {
                    $scope.solicitudesRecords = response.data;
                    solicitudes = $scope.solicitudesRecords;
                } 
                ;
            });

            //$scope.data = {};

            
            $scope.createSolicitud = function () {
                $scope.data.cliente = {id: $rootScope.currentId};
                $http.post(solicitudesContext, $scope.data).then(function (response) {
                    $state.go('solicitudesList', {solicitudId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);