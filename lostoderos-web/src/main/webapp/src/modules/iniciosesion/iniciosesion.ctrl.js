(function (ng) {
    var mod = ng.module("iniciosesionModule");
    mod.controller('iniciosesionCtrl', ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {

            $scope.user = {};
            $scope.data = {};
            
            $http.get('data/users.json').then(function (response) {
                $scope.users = response.data;
            });

            $scope.autenticar = function () {
                var flag = false;
                $http.post('api/login',$scope.data).then(function(){

                for (var item in $scope.users) {
                    if ($scope.users[item].user === $scope.data.username && $scope.users[item].password === $scope.data.password && $scope.users[item].rol === $scope.data.rol) {
                        flag = true;
                        $scope.user = $scope.users[item];
                        $state.go('serviciosList', {}, {reload: true});
                        break;
                    }
                }
                if (!flag) {
                    $rootScope.alerts.push({type: "danger", msg: "Incorrect username or password."});
                } else {
                    sessionStorage.token = $scope.user.token;
                    sessionStorage.setItem("username", $scope.user.user);
                    sessionStorage.setItem("name", $scope.user.name);
                    sessionStorage.setItem("rol", $scope.user.rol);
                    sessionStorage.setItem("direccion", $scope.user.direccion);
                    sessionStorage.setItem("fecha_nacimiento", $scope.user.fecha_nacimiento);
                    sessionStorage.setItem("id", $scope.user.id);
                    $rootScope.currentUser = $scope.user.name;
                    $rootScope.currentUsername = $scope.user.user;
                    $rootScope.currentDireccion = $scope.user.direccion;
                    $rootScope.currentFechaNac = $scope.user.fecha_nacimiento;
                    $rootScope.currentId = $scope.user.id;
                }
                });
            };
        }
    ]);
}
)(window.angular);


