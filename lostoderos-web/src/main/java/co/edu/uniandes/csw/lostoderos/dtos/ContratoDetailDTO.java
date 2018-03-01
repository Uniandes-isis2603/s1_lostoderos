/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;

/**
 * Clase que extiende de {@link ContratoDTO} para manejar la transformacion 
 * entre los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la entidad de Contrato vaya a la documentacion de {@link ContratoDTO}
 *
 *  * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "contratista": 
 *         {
 *           "id": number,
 *           "nombre": string,
 *           "reputacion": string,
 *           "disponibilidad": boolean
 *         }
 *   }
 * </pre>
 * Por ejemplo una entidad de contrato se representa asi:<br>
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "contratista": 
 *         {
 *           "id": 91852,
 *           "nombre": "Plomería",
 *           "reputacion": "Muy puntual",
 *           "disponibilidad": true
 *         }
 *   }
 *
 * </pre>
 *
 * @author s.blancoc
 */
public class ContratoDetailDTO extends ContratoDTO {
    
    private ContratistaDTO contratista;
    
    
    
/**
 * Constructor vacio
 */
public ContratoDetailDTO(){
    super();
}

public ContratoDetailDTO(ContratoEntity entity){
   super(entity);
   if(entity.getContratista()!= null){
       this.contratista = new ContratistaDTO(entity.getContratista());
   }
   else{
       entity.setContratista(null);
   }
}
public ContratoEntity toEntity(){
    ContratoEntity entity = new ContratoEntity();
    if(this.getContratista()!= null){
        entity.setContratista(this.contratista.toEntity());
    }
    return entity;
}

    /**
     * @return the contratista
     */
    public ContratistaDTO getContratista() {
        return contratista;
    }

    /**
     * @param contratista the contratista to set
     */
    public void setContratista(ContratistaDTO contratista) {
        this.contratista = contratista;
    }
        
}
