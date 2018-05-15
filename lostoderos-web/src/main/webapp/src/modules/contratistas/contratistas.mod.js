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
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('contratistasList', {
                url: '/list',
                parent:'contratistas',
                 views: {
                    'listView':{
                        templateUrl:basePath+'contratistas.list.html'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('contratistaDetail',{
                url: '/{contratistaId:int}',
                param: {contratistaId: null},
                parent:'contratistas',
                views:{
                    'detailView':{
                        templateUrl: basePath + 'contratistas.detail.html',
                        controller: 'contratistaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
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
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('informacionContratista',{
                url:'/informacion',
                parent:'contratistaDetail',
                views:{
                    'detailView':{
                        templateUrl: basePath + 'contratistas.detail.html',
                    },
                    'informacionView':{
                        templateUrl: basePath + 'contratistas.detail.informacion.html',
                        controller: 'contratistaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('ratingContratista',{
                url:'/rating',
                parent:'contratistaDetail',
                views:{
                    'detailView':{
                        templateUrl: basePath + 'contratistas.detail.html'
                    },
                    'ratingView':{
                        templateUrl: basePath + 'contratistas.detail.rating.html',
                        controller: 'contratistaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('serviciosContratista',{
                url:'/servicios',
                parent:'contratistaDetail',
                views:{
                    'detailView':{
                        templateUrl: basePath + 'contratistas.detail.html'
                    },
                    'serviciosView':{
                        templateUrl: basePath + 'contratistas.detail.servicios.html',
                        controller: 'contratistaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('serviciosContratistaList',{
                url:'/servicios/list',
                parent:'contratistaDetail',
                views:{
                    'detailView':{
                        templateUrl: basePath + 'contratistas.detail.html'
                    },
                    'serviciosListView':{
                        templateUrl: basePath + 'contratistas.detail.servicios.list.html',
                        controller: 'contratistaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            });
            
        }
    ]);
})(window.angular);

