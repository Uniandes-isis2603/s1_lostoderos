(function (ng) {
    var mod = ng.module("hojadevidaModule", ['ui.router', 'contratistasModule']);
    mod.constant("contratistasContext", "api/contratistas");
    mod.constant("hojadevidaContext", "api/hojasdevida");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlProvider) {
            var basePath = 'src/modules/hojadevida/';
            $urlProvider.otherwise("contratistasList");
            $stateProvider.state('hojadevida', {
                url: '/hojadevida',
                parent: 'contratistaDetail',
                views: {
                    'hojaView': {
                        templateUrl: basePath + 'hojadevida.html',
                        controller: 'hojadevidaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('createHojadevida',{
                url: '/hojadevida',
                parent:'contratistaDetail',
               
                views: {
                    'createHojaView': {
                        templateUrl: basePath + 'hojadevida.create.html',
                        controller: 'hojadevidaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('updateHojadevida',{
                url:'/hojadevida/update',
                parent:'contratistaDetail',
                views:{
                    'detailView':{
                        templateUrl:'src/modules/contratistas/contratistas.detail.html'
                    },
                    'updateHojaView':{
                        templateUrl: basePath + 'hojadevida.update.html',
                        controller: 'hojadevidaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);


