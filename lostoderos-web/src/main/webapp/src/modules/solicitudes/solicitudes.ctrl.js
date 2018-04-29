/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("solicitudModule");
    mod.constant("solicitudContext", "api/solicitudes");
    mod.controller('solicitudCtrl', ['$scope', '$http', 'solicitudContext',
        function ($scope, $http, solicitudContext) {
            $http.get(solicitudContext).then(function (response) {
                $scope.solicitudesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);
