(function (ng) {
    var mod = ng.module("contratistasModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistasCtrl', ['$scope', '$state', '$http', '$filter','contratistasContext',
        function ($scope, $state, $http, $filter, contratistasContext) {
            
            $http.get(contratistasContext).then(function (response) {
                $scope.contratistasRecords = response.data;
                $scope.list=response.data;
            });

            this.createContratista = function () {
                contratista = $scope.contratista;
                return $http.post(contratistasContext, contratista).then(function () {
                    $state.go('contratistasList');
                });
            };

            this.filtroContratistas =function(){
              nombre = $scope.nombre;
              
              $scope.contratistasRecords.forEach(function(element){
                  if(element.nombre === nombre){
                      $scope.list.add(element);
                  }
              });
              
            };

            
        }

    ]);
}
)(window.angular);

