(function (ng) {
    
    var mod = ng.module("pagosModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/pagos/';
            
            $urlRouterProvider.otherwise("/pagosList");
            
            $stateProvider.state('pagosList', {
                
                url: '/pagos/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'pagos.list.html',
                        controller: 'pagosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('pagosCreate', {
                url: '/create',
                parent: 'pagos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/pagos.new.html',
                        controller: 'pagosNewCtrl'
                    }
                }});
        }
    ]);
})(window.angular);

