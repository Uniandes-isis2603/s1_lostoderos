/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    
    var mod = ng.module("contratoModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/contratos/';
            
            $urlRouterProvider.otherwise("/contratosList");
            
            $stateProvider.state('contratosList', {
                
                url: '/contratos/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'contratos.list.html',
                        controller: 'contratoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

