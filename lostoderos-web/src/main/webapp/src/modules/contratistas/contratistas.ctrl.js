    (function (ng) {
    var mod = ng.module("contratistasModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistasCtrl', ['$scope', '$http', 'contratistasContext',
        function ($scope, $http, contratistasContext) {
            $http.get(contratistasContext).then(function (response) {
                $scope.contratistasRecords = response.data;
            });
        }
    ]);
}
)(window.angular);

