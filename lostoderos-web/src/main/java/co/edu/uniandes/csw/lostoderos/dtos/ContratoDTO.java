/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;
import java.io.Serializable;

/**
 * ContratoDTO Objeto de transferencia de datos de la entidad de contrato. Los
 * DTO contienen las representaciones de los JSON que se transfieren entre el
 * cliente y el servidor. Al serializarse como JSON esta clase implementa el
 * siguiente modelo: <br>
 * <pre>
 * {
 *  "id": number
 * }
 * </pre> Por ejemplo una entidad de contrato se representa asi:<br>
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
public class ContratoDTO implements Serializable {

    /**
     * Atributo que define el número de identificación del contrato
     */
    private Long id;

    /**
     * COnstructor de la clase
     */
    public ContratoDTO() {
        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.

    }

    public ContratoDTO(ContratoEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
        }

    }

    public ContratoEntity toEntity() {
        ContratoEntity entity = new ContratoEntity();
        entity.setId(this.id);
        return entity;
    }

    /**
     *
     * @return el id del contrato
     */

    public Long getID() {
        return id;
    }

    /**
     *
     * @param id el nuevo id
     */
    public void setID(Long id) {
        this.id = id;
    }

}
