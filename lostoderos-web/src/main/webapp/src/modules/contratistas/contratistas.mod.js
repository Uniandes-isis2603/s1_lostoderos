(function (ng) {
    
    var mod = ng.module("contratistasModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/contratistas/';
            
            $urlRouterProvider.otherwise("/contratistasList");
            
            $stateProvider.state('contratistasList', {
                
                url: '/contratistas/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'contratistas.list.html',
                        controller: 'contratistasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

