/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    
    var mod = ng.module("cotizacionModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/cotizaciones/';
            
            $urlRouterProvider.otherwise("/cotizacionesList");
            
            $stateProvider.state('cotizacionesList', {
                
                url: '/cotizaciones/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'cotizaciones.list.html',
                        controller: 'cotizacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

