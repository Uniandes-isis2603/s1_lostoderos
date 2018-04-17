(function (ng) {
    
    var mod = ng.module("facturasModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/facturas/';
            
            $urlRouterProvider.otherwise("/facturasList");
            
            $stateProvider.state('facturasList', {
                
                url: '/facturas/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'facturas.list.html',
                        controller: 'facturasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

