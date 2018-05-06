(function (ng) {

    var mod = ng.module("serviciosModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/servicios/';

            $urlRouterProvider.otherwise("/serviciosList");

            $stateProvider.state('servicios', {
                url: '/servicios',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'servicios.html',
                        controller: 'serviciosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('serviciosList', {
                url: '/list',
                parent: 'servicios',
                views: {
                    'listView': {
                        templateUrl: basePath + 'servicios.list.html'
                    }
                }
            }).state('servicioDetail', {
                url: '/{servicioId:int}/detail',
                parent: 'servicios',
                param: {servicioId: null},
                views: {
                    'detailView': {
                        templateUrl: basePath + 'servicios.detail.html',
                        controller: 'servicioDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('serviciosCreate', {
                url: '/create',
                parent: 'servicios',
                views: {
                    'createView': {
                        templateUrl: basePath + '/new/servicios.new.html',
                        controller: 'servicioNewCtrl'
                    }
                }
            }).state('serviciosDelete', {
                url: '/delete/{servicioId:int}',
                parent: 'servicios',
                param: {
                    servicioId: null
                },
                views: {
                    'deleteView': {
                        templateUrl: basePath + '/delete/servicios.delete.html',
                        controller: 'servicioDeleteCtrl'
                    }
                }
            });

        }
    ]);
})(window.angular);

