(function (ng) {
var mod = ng.module("toderosModule", []);
    mod.constant("toderosContext", "api/toderos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/toderos/';
            $urlRouterProvider.otherwise("/toderosList");

            $stateProvider.state('toderosList', {
                url: '/toderos',
                views: {
                    'mainView': {
                        controller: 'toderosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'toderos.list.html'
                    }
                }
            }).state('toderosCreate', {
                url: '/toderos/create',
                views: {
                    'mainView': {
                        controller: 'toderosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'toderos.create.html'
                    }
                }

            }).state('toderosEdit', {
                url: '/toderos/:toderoId',
                param: {
                    toderoId: null
                },
                views: {
                    'mainView': {
                        controller: 'toderosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'toderos.create.html'
                    }
                }
            });
        }]);

})(window.angular);

