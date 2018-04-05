/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.PersonaNaturalEntity;

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

public class PersonaNaturalDTO extends ClienteDTO {
    
    private String Cedula;
    
        /**
	 * Constructor por defecto
	 */
        public PersonaNaturalDTO() {
            
            super();
    }
        
                    /**
	 * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
	 * la entidad que viene de argumento.
	 *
	 * @param PersonaNaturalEntity: Es la entidad que se va a convertir a DTO
	 */
         public PersonaNaturalDTO(PersonaNaturalEntity personanaturalentity) {
            
            super();
            if(personanaturalentity != null)
            {
                this.Cedula = personanaturalentity.getCedula();
            }
    }
         


    /**
     * @return la Cedula de la Persona Natural
     */
    public String getCedula() {
        return Cedula;
    }

    /**
    * @param Cedula La nueva cedula
    */
    public void setCedula(String cedula) {
        this.Cedula = cedula;
    }

    
            /**
	 * Convertir DTO a Entity
	 *
	 * @return Un Entity con los valores del DTO
	 */
	public PersonaNaturalEntity toEntity( )
	{
		PersonaNaturalEntity entity = new PersonaNaturalEntity();
                super.toEntity(entity);
                entity.setCedula(this.Cedula);
                return entity;
	}    
    
    
}
