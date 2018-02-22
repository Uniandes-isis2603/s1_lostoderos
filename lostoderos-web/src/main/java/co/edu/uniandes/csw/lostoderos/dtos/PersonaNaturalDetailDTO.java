/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

/**
 * PersonaNaturalDTO Objeto de transferencia de datos de la entidad de PersonaNatural. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * 
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": Number,
 *      "Cedula": String,
 *   }
 * </pre>
 * Por ejemplo una entidad de PersonaNatural se representa asi:<br>
 * <p>
 * <pre>
 *
 *   {
 *      "id": 15453,
 *      "Cedula": "1022434817",
 *   }
 *
 * </pre>
 * 
 * @author na.morenoe
 */
public class PersonaNaturalDetailDTO extends PersonaNaturalDTO {


    /**
    * Constructor por defecto
    */
    public PersonaNaturalDetailDTO() {
        
        super();
    }
    
    
    
}
