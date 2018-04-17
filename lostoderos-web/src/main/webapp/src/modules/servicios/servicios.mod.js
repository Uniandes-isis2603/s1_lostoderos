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
            });
        }
    ]);
})(window.angular);

