/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("principalModule");
    mod.constant("principalContext", "api/principal");
    mod.controller('principalCtrl', ['$scope', '$http', 'principalContext',

        function ($scope, $http, principalContext) {
          
        }
    ]);
}
)(window.angular);


