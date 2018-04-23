(function (ng) {
    var mod = ng.module("calificacionesModule", ['ui.router', 'contratistasModule']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlProvider) {
            var basePath = 'src/modules/calificaciones/';
            $urlProvider.otherwise("contratistasList");
            $stateProvider.state('calificacionesList', {
                url: '/calificaciones/list',
                parent: 'contratistaDetail',
                
                views: {
                    'listaView': {
                        templateUrl: basePath + 'calificaciones.list.html',
                        controller: 'calificacionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
