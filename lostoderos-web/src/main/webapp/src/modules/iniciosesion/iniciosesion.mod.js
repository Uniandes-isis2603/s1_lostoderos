(function (ng) {
    var mod = ng.module("iniciosesionModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/iniciosesion/';

            $urlRouterProvider.otherwise("");


            $stateProvider.state('iniciosesion', {
                url: '/login',
                data: {
                    requireLogin: false
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'iniciosesion.html',
                        controller: 'iniciosesionCtrl'
                    }
                }
            }).state('logout', {
                url: '/logout',
                data: {
                    requireLogin: false,
                    roles: []
                }
                ,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'logout.html',
                        controller: 'logoutCtrl'
                    }
                }
            }).state('profile', {
                url: '/profile',
                data: {
                    requireLogin: true,
                    roles: []
                }
                ,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'profile.html',
                        controller: 'iniciosesionCtrl'
                    }
                }
            });

        }
    ]);
})(window.angular);



