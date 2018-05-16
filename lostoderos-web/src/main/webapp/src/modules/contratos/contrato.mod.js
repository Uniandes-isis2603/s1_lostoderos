(function (ng) {
    var mod = ng.module("contratoModule", ['ui.router', 'contratistasModule']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlProvider) {
            var basePath = 'src/modules/contratos/';
            $urlProvider.otherwise("contratistasList");
            $stateProvider.state('contrato', {
                param: {contratoId: null},
                url: '/contrato',
                parent: 'contratistaDetail',
                views: {
                    detailView: {
                        templateUrl: 'src/modules/contratistas/contratistas.detail.html'
                    },
                    'contratoView': {
                        templateUrl: basePath + 'contrato.html',
                        controller: 'contratoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('createContrato', {
                url: '/contrato',
                parent: 'contratistaDetail',
                views: {
                    detailView: {
                        templateUrl: 'src/modules/contratistas/contratistas.detail.html',
                    },
                    createContratoView: {
                        templateUrl: basePath + 'contrato.create.html',
                        controller: 'contratoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('updateContrato', {
                url: '/contrato',
                parent: 'contratistaDetail',
                views: {
                    'detailView':{
                        templateUrl:'src/modules/contratistas/contratistas.detail.html'
                    },
                    updateContratoView: {
                        templateUrl: basePath + 'contrato.update.html',
                        controller: 'contratoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);

