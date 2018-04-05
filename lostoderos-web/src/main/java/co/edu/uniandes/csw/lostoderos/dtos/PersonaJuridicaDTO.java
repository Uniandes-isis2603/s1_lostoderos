/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.PersonaJuridicaEntity;

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
    
    private String NIT;
    
        /**
	 * Constructor por defecto
	 */
 	public PersonaJuridicaDTO( )
	{
            super();
	}  
        
            /**
	 * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
	 * la entidad que viene de argumento.
	 *
	 * @param PersonaJuridicaEntity: Es la entidad que se va a convertir a DTO
	 */
         public PersonaJuridicaDTO(PersonaJuridicaEntity personajuridicaentity) {
            
            super();
            if(personajuridicaentity != null)
            {
                this.NIT = personajuridicaentity.getNit();
            }
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
    
            /**
	 * Convertir DTO a Entity
	 *
	 * @return Un Entity con los valores del DTO
	 */
	public PersonaJuridicaEntity toEntity( )
	{
                super.toEntity();
		PersonaJuridicaEntity entity = new PersonaJuridicaEntity();
                
                entity.setNit(this.NIT);
                
                return entity;
	}
}


