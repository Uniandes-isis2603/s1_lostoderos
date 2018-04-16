/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("contratoModule");
    mod.constant("contratoContext", "api/contratos");
    mod.controller('contratoCtrl', ['$scope', '$http', 'contratoContext',
        function ($scope, $http, contratoContext) {
            $http.get('data/contratos.json').then(function (response) {
                $scope.contratosRecords = response.data;
            });
        }
    ]);
}
)(window.angular);


