(function (ng) {
    
    var mod = ng.module("serviciosModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/servicios/';
            
            $urlRouterProvider.otherwise("/serviciosList");
            
            $stateProvider.state('serviciosList', {
                
                url: '/servicios/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'servicios.list.html',
                        controller: 'serviciosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('servicioDetail',{
                url: '/servicio/id/detail',
                views:{
                    'mainView': {
                        templateUrl: basePath + 'servicios.list.html',
                        controller: 'serviciosCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView':{
                        templateUrl: basePath + 'servicios.detail.html',
                        controller: 'serviciosDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

