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
            
            $stateProvider.state('cotizaciones', {
                
                url: '/cotizaciones/list',
                abstract:true,
                data: {
                    requireLogin: false,
                    roles: []
                },
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'cotizaciones.html',
                        controller: 'cotizacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('cotizacionesList', {
                url: '/list',
                parent:'cotizaciones',
                data: {
                    requireLogin: false,
                    roles: []
                },
                 views: {
                    'listView':{
                        templateUrl:basePath+'cotizaciones.list.html'
                    }
                }
            }).state('cotizacionesCreate', {
                url: '/create',
                parent: 'cotizaciones',
                data: {
                    requireLogin: false,
                    roles: []
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/cotizaciones.new.html',
                        controller: 'cotizacionNewCtrl'
                    }
                }
            });
        }]);
})(window.angular);

