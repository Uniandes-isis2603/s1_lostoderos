(function (ng) {
    var mod = ng.module("calificacionesModule", ['ui.router', 'contratistasModule']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlProvider) {
            var basePath = 'src/modules/calificaciones/';
            $urlProvider.otherwise("contratistasList");
            $stateProvider.state('calificacionesList', {
                url: '/calificaciones/list',
                parent: 'contratistaDetail',
                views: {
                    'detailView':{
                        templateUrl:'src/modules/contratistas/contratistas.detail.html'
                    },
                    'listaView': {
                        templateUrl: basePath + 'calificaciones.list.html',
                        controller: 'calificacionesCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('createCalificacion', {
                url: '/calificaciones',
                parent:'contratistaDetail',
                views: {
                    'detailView':{
                        templateUrl:'src/modules/contratistas/contratistas.detail.html'
                    },
                    createCalificacionView: {
                        templateUrl: basePath + 'calificaciones.create.html',
                        controller: 'calificacionesCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            });
        }]);
})(window.angular);
