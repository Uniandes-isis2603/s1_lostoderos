/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;


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
     * numero de contratistas que se requieren
     */
    private Integer cantidad_contratistas;
    
    
    @OneToOne
    private ServicioEntity servicio;
    
    /**
     * 
     */
    @OneToOne
    private FacturaEntity factura;
    
    /**
     * 
     */
    @OneToOne
    private CotizacionEntity cotizacion;
    
    /**
     * 
     */
    @ManyToOne
    private ContratistaEntity cotratista;
    
    /**
     * 
     */
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * 
     */
    @OneToOne
    private CalificacionEntity calificacion;
    
    //constructor
    public SolicitudEntity() {
        
    }

    /**
     * 
     * @return calificacion
     */
    public CalificacionEntity getCalificacion() {
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
     * establece la calificacion
     * @param calificacion 
     */
    public void setCalificacion(CalificacionEntity calificacion) {
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
    public ServicioEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioEntity servicio) {
        this.servicio = servicio;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    public CotizacionEntity getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(CotizacionEntity cotizacion) {
        this.cotizacion = cotizacion;
    }

    public ContratistaEntity getCotratista() {
        return cotratista;
    }

    /**
     * 
     * @param contratista 
     */
    public void setCotratista(ContratistaEntity cotratista) {
        this.cotratista = cotratista;
    }
    
    public ClienteEntity getCliente() {
        return cliente;
    }
    
    
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }    
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
