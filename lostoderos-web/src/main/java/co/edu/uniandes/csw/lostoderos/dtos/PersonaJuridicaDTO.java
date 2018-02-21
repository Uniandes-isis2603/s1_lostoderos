/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

/**
 * PersonaJuridicaDTO Objeto de transferencia de datos de la entidad de PersonaJuridica. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * 
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": Number,
 *      "NIT": String,
 *   }
 * </pre>
 * Por ejemplo una entidad de PersonaJuridica se representa asi:<br>
 * <p>
 * <pre>
 *
 *   {
 *      "id": 15453,
 *      "NIT": "900642461-4",
 *   }
 *
 * </pre>
 * 
 * @author na.morenoe
 */
public class PersonaJuridicaDTO extends ClienteDTO{
    
    private long ID;
    private String NIT;
    
        /**
	 * Constructor por defecto
	 */
        public PersonaJuridicaDTO() {
            
            super();
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    /**
    * @return El NIT de la entidad PersonaJuridica
     */
    public String getNIT() {
        return NIT;
    }

        /**
    * @param NIT El nuevo NIT
    */
    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
    
}


