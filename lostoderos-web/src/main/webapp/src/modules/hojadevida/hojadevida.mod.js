(function (ng) {
    var mod = ng.module("hojadevidaModule", ['ui.router', 'contratistasModule']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlProvider) {
            var basePath = 'src/modules/hojadevida/';
            $urlProvider.otherwise("contratistasList");
            $stateProvider.state('hojadevida', {
                param: {hojadevidaId: null},
                url: '/hojadevida/{hojadevidaId}',
                parent: 'contratistaDetail',
                
                views: {
                    'hojaView': {
                        templateUrl: basePath + 'hojadevida.html',
                        controller: 'hojadevidaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);


