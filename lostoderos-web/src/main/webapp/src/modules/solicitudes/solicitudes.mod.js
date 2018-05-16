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
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'solicitudes.html',
                        controller: 'solicitudCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('solicitudesList', {
                url: '/list',
                parent: 'solicitudes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'solicitudes.list.html'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('soliictudDetail', {
                url: '/{solicitudId:int}/detail',
                parent: 'solicitudes',
                param: {servicioId: null},
                views: {
                    'listView': {
                        templateUrl: basePath + 'solicitudes.list.html'

                    },
                    'detailView': {
                        templateUrl: basePath + 'solicitudes.detail.html',
                        controller: 'solicitudDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }}).state('solicitudesCreate', {
                url: '/create',
                parent: 'solicitudes',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/solicitudes.new.html',
                        controller: 'solicitudNewCtrl'
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

