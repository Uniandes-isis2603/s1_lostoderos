/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;
import java.io.Serializable;

/**
 *
 * SolicitudDTO Objeto de transferencia de datos de la entidad de
 * solicitud. Los DTO contienen las representaciones de los JSON que se
 * transfieren entre el cliente y el servidor. 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 * {
 *  "id": Long,
 *  "requermiemientos": String,
 *  "tipo_servicio": String,
 *  "calificacion": Integer,
 *  "cantidad_contratistas": Integer,
 *  "cod_seguridad": Integer,
 *  "descripcion": String,
 *  "fecha_inicio": String
 *  
 * }
 * </pre>
 Por ejemplo una entidad de solicitud se representa asi:<br>
 * <pre>
 *
 *   {
 *      "id": 3654,
 *      "requerimientos": "Cambiar los bombillos de la casa",
 *      "tipo_servicio": "Electricidad",
 *      "calificacion": 6,
 *      "cantidad_contratistas": 1,
 *      "cod_seguridad": 324,
 *      "descripcion": "Se fundieron los bombillos en la casa y se desea cambiarlos",
 *      "fecha_inicio": "15/01/2018"
 *   }
 *
 * </pre>
 * @author m.saravia
 */
public class SolicitudDTO implements Serializable{
    
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
    private Long id;
    
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
    
    //constructor
    public SolicitudDTO() {
    }
    
    public SolicitudDTO(SolicitudEntity entity){
        if (entity != null){
            this.cantidad_contratistas= entity.getCantidad_contratistas();
            this.cod_seguridad= entity.getCod_seguridad();
            this.descripcion= entity.getDescripcion();
            this.fecha_inicio= entity.getFecha_inicio();
            this.id= entity.getId();
            this.requerimientos= entity.getRequerimientos();
            this.tipo_servicio= entity.getTipo_servicio();
        }
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
    public Long getId() {
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
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * establece los requerimientos
     * @param requerimientos requerimientos deseados 
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
    
    public SolicitudEntity toEntity(){
        
        SolicitudEntity entity= new SolicitudEntity();
        
        entity.setCantidad_contratistas(cantidad_contratistas);
        entity.setCod_seguridad(cod_seguridad);
        entity.setDescripcion(descripcion);
        entity.setFecha_inicio(fecha_inicio);
        entity.setId(id);
        entity.setRequerimientos(requerimientos);
        entity.setTipo_servicio(tipo_servicio);
        
        return entity;
    }
    
    
    
}