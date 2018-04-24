(function (ng) {

    var mod = ng.module("clientesModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/clientes/';

            $urlRouterProvider.otherwise("/clientesList");

            $stateProvider.state('clientes', {
                url: '/clientes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.html',
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('clientesList', {
                url: '/list',
                parent: 'clientes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
            }).state('clienteDetail', {
                url: '/{clienteId:int}/detail',
                parent: 'clientes',
                param: {servicioId: null},
                views: {
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html'

                    },
                    'detailView': {
                        templateUrl: basePath + 'clientes.detail.html',
                        controller: 'clienteDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('register', {
                url: '/create',
                parent: 'clientes',
                views: {
                    'detailView': {
                        templateUrl:'src/modules/register/register.html',
                        controller: 'registerCtrl'
                    }
                }
            });

        }
    ]);
})(window.angular);

