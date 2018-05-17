(function (ng) {
    
    var mod = ng.module("pagosModule", ['ui.router','facturasModule']);
    
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
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('pagosList', {
                url: '/list',
                parent:'pagos',
                 views: {
                    'listView':{
                        templateUrl:basePath+'pagos.list.html'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('pagosDetail',{
                url: '/pago',
                parent:'pagos',
                param: {pagoId: null},
                views:{
                    'listView': {
                        templateUrl: basePath + 'pagos.list.html'
                        
                    },
                    'detailView':{
                        templateUrl: basePath + 'pagos.detail.html',
                        controller: 'pagosDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('createPagos',{
                url:'/pago/create',
                parent:'facturasDetail',
                views:{
                    'detailView':{
                        templateUrl: 'src/modules/facturas/facturas.detail.html'
                    },
                    'createPagosView':{
                        templateUrl:basePath+'pagos.create.html',
                        controller: 'pagosDetailCtrl',
                        controllerAs:'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
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
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            });
            
        }
    ]);
})(window.angular);

