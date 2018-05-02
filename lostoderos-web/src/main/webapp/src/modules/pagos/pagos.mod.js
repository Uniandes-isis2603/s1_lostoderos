(function (ng) {
    
    var mod = ng.module("pagosModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/pagos/';
            
            $urlRouterProvider.otherwise("/pagosList");
            
            $stateProvider.state('pagos', {
                url: '/pagos',
                abstract:true,
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'pagos.html',
                        controller: 'pagosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('pagosList', {
                
                url: '/pagos/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'pagos.list.html',
                        controller: 'pagosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('pagosCreate',{
                url:'/create',
               // parent:'pagos',
                views:{
                    
                    
                    'detailView':{
                        templateUrl:basePath+'pagos.create.html',
                        controller: 'pagosCtrl',
                        controllerAs:'ctrl'
                    }
                }
            }).state('pagosInfo',{
                url:'info',
                parent:'pagosDetail',
                views:{
                    'listView': {
                        templateUrl: basePath + 'pagos.list.html'
                        
                    },
                    'detailView':{
                        templateUrl: basePath + 'pagos.detail.html'
                    },
                    'infoPagosView':{
                        templateUrl:basePath+'pagos.detail.info.html',
                        controller: 'pagosCtrl',
                        controllerAs:'ctrl'
                    }
                }
            });
            
             
        }
    ]);
})(window.angular);

