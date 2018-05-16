(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        // Internal modules dependencies       
        'toderosModule',
        'contratistasModule',
        'clientesModule',
        'serviciosModule',
        'contratoModule',
        'calificacionesModule',
        'facturasModule',
        'pagosModule',
        'cotizacionModule',
        'hojadevidaModule',
        'pagosModule',
        'solicitudModule',
        'iniciosesionModule',
        'principalModule',
        'solicitudNuevaModule'

    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);

    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

            $transitions.onSuccess({to: '*'}, function (trans) {

                var $state = trans.router.stateService;
                var requireLogin = $state.current.data.requireLogin;


                /**
                 * @ngdoc function
                 * @name isAuthenticated
                 * @methodOf mainApp.module:mainApp
                 * @description Esta función define si el usuario se encuentra
                 * dentro de su cuenta.
                 * @returns {Boolean} Verdadero si está dentro de su cuenta.
                 */
                $rootScope.isAuthenticated = function () {

                    if (sessionStorage.getItem("username") !== null) {
                        $rootScope.currentUser = sessionStorage.getItem("name");
                        $rootScope.currentUsername = sessionStorage.getItem("username");
                        $rootScope.currentDireccion = sessionStorage.getItem("direccion");
                        $rootScope.currentFechaNac = sessionStorage.getItem("fecha_nacimiento");
                        $rootScope.currentId = sessionStorage.getItem("id");
                        return true;
                    } else {
                        return false;
                    }
                };
                /**
                 * Se usa para comprobar qué elementos puede ver el usuario actual.
                 * @param {type} id Identificador del usuario loggeado.
                 * @returns {Boolean} True si es el mismo usuario, false en caso contrario.
                 */
                $rootScope.isUsuarioId = function (id) {
                    if (id !== undefined && id !== null && $rootScope.isAuthenticated) {
                        if (id.toString()===$rootScope.currentId.toString()) {
                            return true;
                        } else {
                            return false;
                        }
                    }



                };
                $rootScope.isContratista = function () {
                    if (($rootScope.isAuthenticated) && (sessionStorage.getItem("rol") === "contratista")) {
                        return true;
                    } else {
                        return false;
                    }
                };
                $rootScope.isCliente = function () {
                    if (($rootScope.isAuthenticated) && (sessionStorage.getItem("rol") === "cliente")) {
                        return true;
                    } else {
                        return false;
                    }
                };

                /**
                 * @ngdoc function
                 * @name hasPermissions
                 * @methodOf mainApp.module:mainApp
                 * @description Esta función define si el usuario tiene permisos
                 * para acceder a la aplicación.
                 * @returns {Boolean} Verdadero si el usuario tiene permisos.
                 */
                $rootScope.hasPermissions = function () {
                    if (($rootScope.isAuthenticated) && (sessionStorage.getItem("rol") === "admin")) {
                        return true;
                    } else {
                        return false;
                    }
                };

                if (requireLogin && (sessionStorage.getItem("username") === null)) {
                    event.preventDefault();
                    $state.go('login', $state.params);
                }

            });

        }]);
})(window.angular);

