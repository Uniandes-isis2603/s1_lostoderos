/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author m.saravia
 */
@Entity
public class SolicitudEntity extends BaseEntity implements Serializable{
    
    //atributos
    
    /**
     * servicio solicitado
     */
    private Integer tipo_servicio;
    
    /**
     * codigo de seguridad del servicio
     */
    private Integer cod_seguridad;
    
    /**
     * descripcion del la solicitud
     */
    private String descripcion;
    
    /**
     * fecha que se hizo la solicitud
     */
    private String fecha_inicio;
    
    /**
     * requerimientos para la solicitud
     */
    private String requerimientos;
    
    /**
     * calificacion que tiene el todero
     */
    private Integer calificacion;
    
    /**
     * numero de contratistas que se requieren
     */
    private Integer cantidad_contratistas;
    
    /**
     * informacion del pago
     */
    private PagoEntity info_pago;

    
    
    //constructor
    public SolicitudEntity() {
        
    }

    /**
     * 
     * @return calificacion
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * 
     * @return cantidad de contratistas
     */
    public Integer getCantidad_contratistas() {
        return cantidad_contratistas;
    }

    /**
     * 
     * @return codigo de seguridad
     */
    public Integer getCod_seguridad() {
        return cod_seguridad;
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
     * @return fecha de inicio
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * 
     * @return requerimientos
     */
    public String getRequerimientos() {
        return requerimientos;
    }

    /**
     * 
     * @return el tipo de servicio
     */
    public Integer getTipo_servicio() {
        return tipo_servicio;
    }
    
    /**
     * pago que se realiza para la solicitud
     * @return pago a realizar
     */
    public PagoEntity getInfo_pago() {
        return info_pago;
    }

    /**
     * cambia la informacion de pago por la que se desea
     * @param info_pago informacion que se desea cambiar
     */
    public void setInfo_pago(PagoEntity info_pago) {
        this.info_pago = info_pago;
    }

    /**
     * establece la calificacion
     * @param calificacion 
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * establece la cantidad de contratistas
     * @param cantidad_contratistas 
     */
    public void setCantidad_contratistas(Integer cantidad_contratistas) {
        this.cantidad_contratistas = cantidad_contratistas;
    }

    /**
     * establece el codigo de seguridad
     * @param cod_seguridad 
     */
    public void setCod_seguridad(Integer cod_seguridad) {
        this.cod_seguridad = cod_seguridad;
    }

    /**
     * establece la descripcion
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * establece la fecha de inicio
     * @param fecha_inicio 
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * establece los requerimientos
     * @param requerimientos 
     */
    public void setRequerimientos(String requerimientos) {
        this.requerimientos = requerimientos;
    }

    /**
     * establece el tipo de servicio
     * @param tipo_servicio 
     */
    public void setTipo_servicio(Integer tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
