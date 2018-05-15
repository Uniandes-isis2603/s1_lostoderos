/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.saravia
 */
@Entity
public class CotizacionEntity extends BaseEntity implements Serializable{
    //atributos
    
    /**
     * tipo de servicio
     */
    private String servicio;
    
    /**
     * descripcion de la cotizacion
     */
    private String descripcion;
    
    /**
     * Valor de la cotizacion
     */
    private Integer valor;
    
    @PodamExclude
    @OneToOne(mappedBy = "cotizaciones", cascade=CascadeType.PERSIST)
    private SolicitudEntity solicitud;

    //constructor
    public CotizacionEntity() {
        
    }

    /**
     * 
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * 
     * @return servicio
     */
    public String getServicio() {
        return servicio;
    }
    
    /**
     * 
     * @return  valor
     */
    public Integer getValor() {
        return valor;
    }
    
    /**
     * establece la descripcion dada
     * @param descripcion descripcion que se desea modificar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * establece el servicio a tomar
     * @param servicio 
     */
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    /**
     * establece el valor de la cotizacion
     * @param valor 
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
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
