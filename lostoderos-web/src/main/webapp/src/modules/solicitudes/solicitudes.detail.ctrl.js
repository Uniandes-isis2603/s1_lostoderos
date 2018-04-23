/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("solicitudModule");
    mod.constant("solicitudContext", "api/solicitudes");
    mod.controller('solicitudDetailCtrl', ['$scope', '$http', 'solicitudContext', '$state', '$filter',
        function ($scope, $http, solicitudContext, $state, $filter) {
            
            if (($state.params.solicitudId !== undefined) && ($state.params.solicitudId !== null)) {
                $http.get(solicitudContext+ '/'+$state.params.id).then(function (response) {
                    $scope.currentSolicitud = response.data;
                });
            }
        }
    ]);
}
)(window.angular);

