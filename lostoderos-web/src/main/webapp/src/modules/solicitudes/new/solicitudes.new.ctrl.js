/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("solicitudModule");
    mod.constant("solicitudesContext", "api/solicitudes");
    mod.controller('solicitudNewCtrl', ['$scope', '$http', 'solicitudesContext', '$state', '$rootScope',
        
        function ($scope, $http, solicitudesContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};

            
            $scope.createSolicitud = function () {
                $http.post(solicitudesContext, $scope.data).then(function (response) {
                    $state.go('solicitudesList', {solicitudId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);