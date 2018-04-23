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
            
            $stateProvider.state('solicitudes', {
                
                url: '/solicitudes',
                abstract:true,
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'solicitudes.list.html',
                        controller: 'solicitudCtrl',
                        controllerAs: 'ctrl'
                    }
                }}).state('solicitudesList', {
                url: '/list',
                parent:'solicitudes',
                 views: {
                    'listView':{
                        templateUrl:basePath+'solicitudes.list.html'
                    }
                }
            }).state('soliictudDetail',{
                url: '/{solicitudId:int}/detail',
                parent:'solicitudes',
                param: {servicioId: null},
                views:{
                    'listView': {
                        templateUrl: basePath + 'solicitudes.list.html'
                        
                    },
                    'detailView':{
                        templateUrl: basePath + 'solicitudes.detail.html',
                        controller: 'solicitudDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            
        }
    ]);
})(window.angular);

