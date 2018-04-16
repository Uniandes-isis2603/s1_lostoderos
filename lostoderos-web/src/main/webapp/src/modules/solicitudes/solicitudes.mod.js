/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    
    var mod = ng.module("solicitudModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/solicitudes/';
            
            $urlRouterProvider.otherwise("/solicitudesList");
            
            $stateProvider.state('solicitudesList', {
                
                url: '/solicitudes/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'solicitudes.list.html',
                        controller: 'solicitudCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);