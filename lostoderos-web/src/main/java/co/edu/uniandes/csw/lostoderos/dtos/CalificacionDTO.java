/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.CalificacionEntity;
import java.io.Serializable;

/**
 * CalificacionDTO Objeto de transferencia de datos de la entidad de
 * calificacion. Los DTO contienen las representaciones de los JSON que se
 * transfieren entre el cliente y el servidor. Al serializarse como JSON esta
 * clase implementa el siguiente modelo: <br>
 * <pre>
 * {
 *  "numEstrellas": number
 *  "comentario": String
 *  "tipoServicio": String
 *  "id": number
 * }
 * </pre> Por ejemplo una entidad de Calificacion se representa asi:<br>
 * <pre>
 *
 *   {
 *      "numEstrellas": 3,
 *      "comentario": "Llego despues de la hora programada",
 *      "tipoServicio": "plomeria"
 *      "id": "4563"
 *   }
 *
 * </pre>
 *
 * @author s.blancoc
 */
public class CalificacionDTO implements Serializable {

    /**
     * Numero de estrellas dadas por la calificación
     */
    private Integer numEstrellas;

    /**
     * tipo de servicio que está siendo calificado
     */
    private String tipoServicio;

    /**
     * comentario asociado a la calificacion del servicio
     */
    private String comentario;
    /**
     * numero de identificacion de la calificacion
     */
    private Long id;

    /**
     * Constructor vacio
     */
    public CalificacionDTO() {
        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.
    }

    /**
     * Constructor de calificaion
     * @param entity entidad que pasa a ser dto que se muestra en el front
     */
    public CalificacionDTO(CalificacionEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.comentario = entity.getComentario();
            this.numEstrellas = entity.getNumEstrellas();
            this.tipoServicio = entity.getTipoServicio();
        }
    }

    /**
     * Metodo que convierte en una entidad a la calificacion que esta en el front
     * @return entidad que fue transformada
     */
    public CalificacionEntity toEntity() {
        CalificacionEntity entity = new CalificacionEntity();
        entity.setId(this.id);
        entity.setComentario(this.comentario);
        entity.setNumEstrellas(this.numEstrellas);
        entity.setTipoServicio(this.tipoServicio);

        return entity;
    }

    /**
     * Comentario de la calificacion
     * @return el comentario de la calificacion
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Tipo de servicio que fue ofrecido
     * @return el tipo de servicio que está siendo calificado
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Estrellas obtenidas
     * @return el numero de estrellas dadas en la calificacion
     */
    public Integer getNumEstrellas() {
        return numEstrellas;
    }

    /**
     * 
     * @param numEstrellas numero de estrellas para la calificacion
     */
    public void setNumEstrellas(Integer numEstrellas) {
        this.numEstrellas = numEstrellas;
    }

    /**
     *
     * @param comentario el comentario para la calificacion
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     *
     * @param tipoServicio el tipo de servicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     *
     * @return la identificacion de la calificacion
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id identificacion nueva de la calificacion
     */
    public void setId(Long id) {
        this.id = id;
    }

}
