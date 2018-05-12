(function (ng) {
    var mod = ng.module("iniciosesionModule");
    mod.controller('logoutCtrl', ['$rootScope', '$state',
        function ($rootScope, $state) {
            if (sessionStorage.getItem("username")) {
                sessionStorage.clear();
            } else {
                $state.go('serviciosList', {}, {reload: true});
            }
        }
    ]);
}
)(window.angular);

