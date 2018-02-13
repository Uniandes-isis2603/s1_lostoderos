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
public class CotizacionDTO  {
    
    //atributos
    
    /**
     * ID del cotizante
     */
    private Long id;
    
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

    //constructor
    public CotizacionDTO() {
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
     * @return id
     */
    public Long getId() {
        return id;
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
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * establece el id nuaevo
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
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
    
    
    
}