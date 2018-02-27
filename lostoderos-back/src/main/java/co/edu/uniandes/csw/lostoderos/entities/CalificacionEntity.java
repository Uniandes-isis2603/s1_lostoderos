/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author s.blancoc
 */
@Entity
public class CalificacionEntity extends BaseEntity implements Serializable {
    
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
    
    @ManyToOne
    private ContratistaEntity contratista;
    
    @ManyToOne
    private ClienteEntity cliente;
    
    @OneToOne(mappedBy = "calificacion")
    private SolicitudEntity solicitud;

    /**
     * @return the numEstrellas
     */
    public Integer getNumEstrellas() {
        return numEstrellas;
    }

    /**
     * @param numEstrellas the numEstrellas to set
     */
    public void setNumEstrellas(Integer numEstrellas) {
        this.numEstrellas = numEstrellas;
    }

    /**
     * @return the tipoServicio
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * @param tipoServicio the tipoServicio to set
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the contratista
     */
    public ContratistaEntity getContratista() {
        return contratista;
    }

    /**
     * @param contratista the contratista to set
     */
    public void setContratista(ContratistaEntity contratista) {
        this.contratista = contratista;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the solicitud
     */
    public SolicitudEntity getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(SolicitudEntity solicitud) {
        this.solicitud = solicitud;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
