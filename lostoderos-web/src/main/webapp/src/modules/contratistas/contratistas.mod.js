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
            }).state('contratistaDetail',{
                url: '/contratistas/id/detail',
                views:{
                    'mainView': {
                        templateUrl: basePath + 'contratistas.list.html',
                        controller: 'contratistasCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView':{
                        templateUrl: basePath + 'contratistas.detail.html',
                        controller: 'contratistasDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            
        }
    ]);
})(window.angular);

