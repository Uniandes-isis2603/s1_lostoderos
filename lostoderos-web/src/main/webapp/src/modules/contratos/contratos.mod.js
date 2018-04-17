(function (ng) {
    
    var mod = ng.module("contratosModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/contratos/';
            
            $urlRouterProvider.otherwise("/contratosList");
            
            $stateProvider.state('contratosList', {
                
                url: '/contratos/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'contratos.list.html',
                        controller: 'contratosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

