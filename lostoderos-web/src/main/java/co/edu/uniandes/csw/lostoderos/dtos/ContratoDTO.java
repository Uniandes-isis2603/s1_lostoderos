/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;
import java.io.Serializable;
import java.util.Date;

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
     * fecha de inicio del contrato
     */
    private Date fechaInicio;
    
    /**
     * descripcion del contrato
     */
    private String descripcion;

    /**
     * COnstructor de la clase
     */
    public ContratoDTO() {
        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.

    }

    public ContratoDTO(ContratoEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.fechaInicio = entity.getFechaInicio();
            this.descripcion = entity.getDescripcion();
        }

    }

    public ContratoEntity toEntity() {
        ContratoEntity entity = new ContratoEntity();
        entity.setId(this.id);
        entity.setFechaInicio(getFechaInicio());
        entity.setDescripcion(getDescripcion());
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

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
