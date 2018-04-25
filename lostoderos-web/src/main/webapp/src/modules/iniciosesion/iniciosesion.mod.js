(function (ng) {
    var mod = ng.module("iniciosesionModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/iniciosesion/';

            $urlRouterProvider.otherwise("/iniciosesion");


            $stateProvider.state('iniciosesion', {
                url: '/iniciosesion',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'iniciosesion.html',
                        controller: 'iniciosesionCtrl'
                    }
                }
            });
        }
    ]);
})(window.angular);



