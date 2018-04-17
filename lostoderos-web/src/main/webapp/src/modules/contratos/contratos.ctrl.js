/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("contratosModule");
    mod.constant("contratosContext", "api/contratos");
    mod.controller('contratosCtrl', ['$scope', '$http', 'contratosContext',
        function ($scope, $http, contratosContext) {
            $http.get('data/contratos.json').then(function (response) {
                $scope.contratosRecords = response.data;
            });
        }
    ]);
}
)(window.angular);


