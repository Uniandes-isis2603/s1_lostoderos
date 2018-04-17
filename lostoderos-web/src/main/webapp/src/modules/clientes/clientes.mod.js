(function (ng) {
    
    var mod = ng.module("clientesModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/clientes/';
            
            $urlRouterProvider.otherwise("/clientesList");
            
            $stateProvider.state('clientesList', {
                
                url: '/clientes/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.list.html',
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

