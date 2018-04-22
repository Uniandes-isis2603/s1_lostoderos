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
        'contratosModule',
        'calificacionesModule',
        'facturasModule',
        'pagosModule',
        'cotizacionModule',
        'registerModule'

    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);

