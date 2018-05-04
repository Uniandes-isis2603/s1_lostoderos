(function (ng) {
    
    var mod = ng.module("contratistasModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/contratistas/';
            
            $urlRouterProvider.otherwise("/contratistasList");
            
            $stateProvider.state('contratistas', {
                url: '/contratistas',
                abstract:true,
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'contratistas.html',
                        controller: 'contratistasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('contratistasList', {
                url: '/list',
                parent:'contratistas',
                 views: {
                    'listView':{
                        templateUrl:basePath+'contratistas.list.html'
                    }
                }
            }).state('contratistaDetail',{
                url: '/{contratistaId:int}/detail',
                parent:'contratistasList',
                param: {contratistaId: null},
                views:{
                    'listView':{
                        templateUrl:basePath+'contratistas.list.html'
                    },
                    'detailView':{
                        templateUrl: basePath + 'contratistas.detail.html',
                        controller: 'contratistaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('createContratista',{
                url:'/create',
                parent:'contratistas',
                views:{
                    'createContratistaView':{
                        templateUrl:basePath+'contratistas.create.html',
                        controller: 'contratistasCtrl',
                        controllerAs:'ctrl'
                    }
                }
            });
            
        }
    ]);
})(window.angular);

