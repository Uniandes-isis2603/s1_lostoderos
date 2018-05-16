/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("solicitudNuevaModule");
    mod.constant("solicitudNuevaContext", "api/principal");
    mod.controller('solicitudNuevaCtrl', ['$scope', '$http', 'solicitudNuevaContext',

        function ($scope, $http, solicitudNuevaContext) {
          
        }
    ]);
}
)(window.angular);



