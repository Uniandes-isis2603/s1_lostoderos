(function (ng) {
    var mod = ng.module("contratistasModule");
    mod.constant("contratistasContext", "api/contratistas");
    mod.controller('contratistasCtrl', ['$scope', '$state', '$http', 'contratistasContext',
        function ($scope, $state, $http, contratistasContext) {
            var records = [];
            $http.get(contratistasContext).then(function (response) {
                records = $scope.contratistasRecords = response.data;
            });
            this.createContratista = function () {
                contratista = $scope.contratista;
                return $http.post(contratistasContext, contratista).then(function () {
                    $state.go('contratistasList');
                });
            };

            this.calcularCalificaciones = function () {
                records.forEach(function (contratista) {
                    var instruccion = document.getElementById("rating" + contratista.id);
                    if (instruccion !== null) {
                        
                        var rating = calcularPromedio(contratista.calificaciones);
                        //Porcentaje
                        var porcentaje = (rating/5)*100;
                        var html = '';
                        //Rating redondeado
                        var guarda=5;
                        var redondeado = `${Math.round(porcentaje/10)*10}`/2;
                        var half = false;
                        while(guarda>0){
                            
                            if(redondeado<0.5){
                                if(half===true){
                                    half=false;
                                    html = html+'<i class="glyphicon glyphicon-star half" ></i>';
                                }  
                               html = html +  '<i class="glyphicon glyphicon-star empty"></i>';
                            }
                            else if((redondeado%2)===0){
                                html = html+'<i class="glyphicon glyphicon-star full"></i>';
                                redondeado = redondeado-10;
                            }
                            else{
                                half=true;
                                redondeado = redondeado-5;
                            }
                            guarda= guarda-1;
                        }
                        html = html+'<i class="ratingNum">'+rating+'</i>';
                       instruccion.innerHTML = html;
                    }
                });

            };

            function calcularPromedio(calificaciones) {
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
            ;

        }
    ]);
}
)(window.angular);

