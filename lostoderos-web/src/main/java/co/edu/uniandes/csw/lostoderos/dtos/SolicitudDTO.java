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
     * @param calificacion calificacion que se desea
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * establece la cantidad de contratistas
     * @param cantidad_contratistas numero de contratistas que se desean
     */
    public void setCantidad_contratistas(Integer cantidad_contratistas) {
        this.cantidad_contratistas = cantidad_contratistas;
    }

    /**
     * establece el codigo de seguridad
     * @param cod_seguridad codigo que se desea
     */
    public void setCod_seguridad(Integer cod_seguridad) {
        this.cod_seguridad = cod_seguridad;
    }

    /**
     * establece la descripcion
     * @param descripcion descripcion que se desea
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * establece la fecha de inicio
     * @param fecha_inicio fecha que se desea
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * establece el id
     * @param id que necesite
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @param tipo_servicio servicio que se desea
     */
    public void setTipo_servicio(Integer tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}