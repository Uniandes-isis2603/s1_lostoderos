/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("ciudadModule");
    mod.constant("ciudadContext", "api");
    mod.controller('ciudadCtrl', ['$scope', '$http', 'ciudadContext',
        function ($scope, $http, ciudadContext) {
            
        }
    ]);
}
)(window.angular);


