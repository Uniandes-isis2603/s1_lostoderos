(function (ng) {
    var mod = ng.module("contratosModule", ['ui.router', 'contratistasModule']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlProvider) {
            var basePath = 'src/modules/contratos/';
            $urlProvider.otherwise("contratistasList");
            $stateProvider.state('contrato', {
                param: {contratoId: null},
                url: '/contrato/{contratoId}',
                parent: 'contratistaDetail',
                
                views: {
                    'contratoView': {
                        templateUrl: basePath + 'contratos.html',
                        controller: 'contratosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('createContrato', {
                url: '/contratos',
                parent:'contratistaDetail',
                views: {
                    createContratoView: {
                        templateUrl: basePath + 'contratos.create.html',
                        controller: 'contratosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);

