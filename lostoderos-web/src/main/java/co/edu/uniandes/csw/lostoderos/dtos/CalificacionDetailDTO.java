/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;
/**
 * Clase que extiende de {@link CalificacionDTO} para manejar la transformacion
 * entre los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la entidad de Calificacion vaya a la documentacion 
 * de{@link CalificacionDTO}
 *
 *  * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "numEstrellas": number,
 *      "comentario": string,
 *      "tipoServicio": string,
 *      "cliente": 
 *         {
 *           "id": number,
 *           "fecha_nacimiento": string,
 *           "forma_pago": number,
 *           "direccion": string
 *         }
 *   }
 * </pre>
 * Por ejemplo una entidad de calificacion se representa asi:<br>
 * <pre>
 *
 *   {
 *      "id": 134,
 *      "numEstrellas": 3,
 *      "comentario": "Muy buen servicio",
 *      "tipoServicio": "Plomeria",
 *      "cliente": 
 *         {
 *           "id": 1232,
 *           "fecha_nacimiento": "12/21/1981",
 *           "forma_pago": 1,
 *           "direccion": "CR 64 # 123-54"
 *         }
 *   }
 *
 * </pre>
 *
 * @author s.blancoc
 */
public class CalificacionDetailDTO extends CalificacionDTO {
    /**
     * Cnstructor vacio
     */
    public CalificacionDetailDTO(){
        
    }
    
}
