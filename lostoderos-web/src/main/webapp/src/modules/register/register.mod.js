(function (ng) {
    var mod = ng.module("registerModule", ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/register/';

            $urlRouterProvider.otherwise("/register");


            $stateProvider.state('register', {
                url: '/register',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'register.html',
                        controller: 'registerCtrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

