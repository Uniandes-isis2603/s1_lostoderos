(function (ng) {
    var mod = ng.module("contratistasModule");
    mod.constant("contratistaContext", "api/contratistas");
    mod.controller('contratistaDetailCtrl', ['$scope', '$http', 'contratistaContext', '$state', '$filter',

        function ($scope, $http, contratistaContext, $state) {

            var contratista = {};
            var estrellas = {};
            if (($state.params.contratistaId !== undefined) && ($state.params.contratistaId !== null)) {
                $http.get(contratistaContext + '/' + $state.params.contratistaId).then(function (response) {
                    $scope.currentContratista = response.data;
                    contratista = $scope.currentContratista;
                });
            }

            this.calcularEstrellasContratista = function () {
                if ($scope.currentContratista !== null && $scope.currentContratista !== undefined) {
                    var instruccion = document.getElementById("rating");
                    
                    var rating = calcularPromedio($scope.currentContratista.calificaciones);
                    //Porcentaje
                    var porcentaje = (rating / 5) * 100;
                    var html = '';
                    //Rating redondeado
                    var guarda = 5;
                    var redondeado = `${Math.round(porcentaje / 10) * 10}` / 2;
                    var half = false;
                    while (guarda > 0) {
                        if (redondeado < 0.5) {
                            if (half === true) {
                                half = false;
                                html = html + '<i class="glyphicon glyphicon-star half" ></i>';
                            }
                            html = html + '<i class="glyphicon glyphicon-star empty"></i>';
                        } else if ((redondeado % 2) === 0) {
                            html = html + '<i class="glyphicon glyphicon-star full"></i>';
                            redondeado = redondeado - 10;
                        } else {
                            half = true;
                            redondeado = redondeado - 5;
                        }
                        guarda = guarda - 1;
                    }
                    
                    if(instruccion !== null && instruccion !== undefined){
                        instruccion.innerHTML = html;
                    }
                    
                }

            };

            function calcularPromedio(calificaciones) {
                if (calificaciones !== undefined) {
                    if (calificaciones.length === 0) {
                        return 0;
                    }
                    var total = 0;
                    calificaciones.forEach(function (calificacion) {
                        total = total + calificacion.numEstrellas;
                    });
                    var resp = total / calificaciones.length;
                    return resp;
                }

            }
            ;

        }
    ]);
}
)(window.angular);

