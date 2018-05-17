/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    // Definición del módulo
    var mod = ng.module("principalModule", ['ui.router']);
    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/principal/';
            // Mostrar la lista de autores será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/principalList");
            // Definición del estado 'authorsList' donde se listan los autores
            $stateProvider.state('principalList', {
                // Url que aparecerá en el browser
                url: '/principal/list',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'principal.list.html',
                        controller: 'principalCtrl',
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

