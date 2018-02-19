/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

/**
 * ContratoDTO Objeto de transferencia de datos de la entidad de
 * contrato. Los DTO contienen las representaciones de los JSON que se
 * transfieren entre el cliente y el servidor. 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 * {
 *  "id": number
 * }
 * </pre>
 Por ejemplo una entidad de contrato se representa asi:<br>
 * <pre>
 *
 *   {
 *      "id": 3
 *   }
 *
 * </pre>
 *
 *
 * @author s.blancoc
 */
public class ContratoDTO {
    
    /**
     * Atributo que define el número de identificación del contrato
     */
    private long id;
    
    /**
     * COnstructor de la clase
     */
    
    public ContratoDTO(){
         super();
    }
    /**
     * 
     * @return el id del contrato 
     */
    
    public long getID(){
        return id;
    }
    /**
     * 
     * @param id el nuevo id 
     */
    public void setID(long id){
        this.id = id;
    }
    
    
    
    
    
    
}
