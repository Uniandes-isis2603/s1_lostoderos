/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

/**
 *
 * @author m.saravia
 */
public class SolicitudDTO {
    
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
     * id de la solicitud
     */
    private Integer id;
    
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
     * informacion del pago a realizar
     */
    private PagoDTO info_pago;
    
    /**
     * calificacion que tiene el todero
     */
    private Integer calificacion;
    
    /**
     * numero de contratistas que se requieren
     */
    private Integer cantidad_contratistas;
    
    //constructor
    public SolicitudDTO() {
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
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @return informacion del pago
     */
    public PagoDTO getInfo_pago() {
        return info_pago;
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
     * establece el id
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * establece la informacion del pago
     * @param info_pago 
     */
    public void setInfo_pago(PagoDTO info_pago) {
        this.info_pago = info_pago;
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