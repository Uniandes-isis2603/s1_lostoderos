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
            }).state('facturasDetail', {
                url: '/{idFactura:int}/detail',
                parent: 'facturas',
                param: {
                    facturaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'facturas.list.html',
                        controller: 'facturasDetailCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'facturas.detail.html',
                        controller: 'facturasDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            });
        }
    ]);
})(window.angular);

