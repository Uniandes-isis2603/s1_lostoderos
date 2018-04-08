/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.CotizacionEntity;
import java.io.Serializable;

/**
 *  * DTO Objeto de transferencia de datos de la entidad de Cotizacion. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 * 
 * {
 * "id": Long,
 * "servicio": String,
 * "descripcion": String,
 * "valor": Integer
 * }
 * </pre> La cotizacion se representa asi:
 * 
 * <pre>
 *  {
 *  "id": 201405258,
 *  "servicio": "electricidad",
 *  "descripcion": "Arreglo de toedos los bombillos de la casa",
 *  "valor": 75100
 * }</pre> 
 * 
 * 
 * @author m.saravia
 */
public class CotizacionDTO implements Serializable {
    
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

    //constructores
    public CotizacionDTO(CotizacionEntity cotizacionEntity) {
        
                this.id = cotizacionEntity.getId( );
		this.descripcion = cotizacionEntity.getDescripcion();
		this.servicio = cotizacionEntity.getServicio( );
                this.valor = cotizacionEntity.getValor();
        
    }
    
    public CotizacionDTO(){
        
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
     * @param descripcion descripcion que se desea cambiar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * establece el id nuaevo
     * @param id id que se desa cambiar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * establece el servicio a tomar
     * @param servicio servicio a cambiar
     */
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    /**
     * establece el valor de la cotizacion
     * @param valor valor a cambiar
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public CotizacionEntity toEntity(){
        
                CotizacionEntity entity = new CotizacionEntity( );
		entity.setId( this.id );
		entity.setDescripcion(this.descripcion);
		entity.setServicio(this.servicio);
                entity.setValor(this.valor);
		return entity;
    }
    
    
}