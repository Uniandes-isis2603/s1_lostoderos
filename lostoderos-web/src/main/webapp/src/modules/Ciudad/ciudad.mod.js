/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    
    var mod = ng.module("ciudadModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/Ciudad/';
            
            $urlRouterProvider.otherwise("/ciudadList");
            
            $stateProvider.state('ciudadList', {
                
                url: '/ciudad/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'ciudad.list.html',
                        controller: 'ciudadCtrl',
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

