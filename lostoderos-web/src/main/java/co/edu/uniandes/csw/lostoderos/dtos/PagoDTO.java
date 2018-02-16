/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.PagoEntity;

/**
 * ServicioDTO Objeto de transferencia de datos de la entidad de Pago. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": Integer,
 *      "codigoTarjeta": String,
 *      "comprobantePagoMedio": Boolean,
 *      "comprobantePagoTotal": Boolean
 *      "descripcion": String,
 *      "fechaTarjeta": String,
 *      "numTarjeta": String,
 * 
 *   }
 * </pre>
 * Por ejemplo una entidad de Servicio se representa asi:<br>
 * 
 * <pre>
 *
 *   {
 *      "id": 12390813,
 *      "codigoTarjeta": 123,
 *      "comprobantePagoMedio": true,
 *      "comprobantePagoTotal": false,
 *      "descripcion": un pago correspondiente a tal servicio,
 *      "fechaTarjeta": 10/09/2018,
 *      "numTarjeta": 123456629723,
 * 
 *   }
 *
 * </pre>
 *
 * @author s.rangel
 */
public class PagoDTO {
    private Long ID;
    private String numTarjeta;
    private String codigoTarjeta;
    private String fechaTarjeta;
    private String descripcion;
    private Boolean comprobantePagoMedio;
    private Boolean comprobantePagoTotal;
  /**
	 * Constructor por defecto
	 */
    public PagoDTO() {
    }
/**
	 * @param ID El nuevo ID de la entidad Todero
	 */
    public void setID(Long ID) {
        this.ID = ID;
    }
    
    /**
	 * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
	 * la entidad que viene de argumento.
	 *
	 * @param pagoEntity: Es la entidad que se va a convertir a DTO
	 */
   /**  public PagoDTO( PagoEntity pagoEntity )
	{
		this.ID = pagoEntity.getId( );
		this.codigoTarjeta = pagoEntity.getCodigoTarjeta();
		this.comprobantePagoMedio = pagoEntity.getComprobantePagoMedio();
                this.comprobantePagoTotal = pagoEntity.getComprobantePagoTotal();
		this.descripcion = pagoEntity.getDescripcion();
		this.fechaTarjeta = pagoEntity.getFechaTarjeta();
		this.numTarjeta = pagoEntity.getNumTarjeta();

	}
        * 
/**
 * 
	 * @param numTarjeta El nuevo numero de tarjeta de la entidad Todero
	 */
    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
/**
	 * @param codigoTarjeta El nuevo cndigo de la tarjeta de la entidad Todero
	 */
    public void setCodigoTarjeta(String codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }
/**
	 * @param fechaTarjeta La nueva fecha de la tarjeta de la entidad Todero
	 */
    public void setFechaTarjeta(String fechaTarjeta) {
        this.fechaTarjeta = fechaTarjeta;
    }
/**
	 * @param descripcion La nueva descripcion de la entidad Todero
	 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
/**
	 * @param comprobantePagoMedio El nuevo comprobante medio de la entidad Todero
	 */
    public void setComprobantePagoMedio(Boolean comprobantePagoMedio) {
        this.comprobantePagoMedio = comprobantePagoMedio;
    }
/**
	 * @param comprobantePagoTotal El nuevo comprobante total de la entidad Todero
	 */
    public void setComprobantePagoTotal(Boolean comprobantePagoTotal) {
        this.comprobantePagoTotal = comprobantePagoTotal;
    }
        
    

   
    //entity
/**
	 * @return El ID de la entidad Pago
	 */
    public Long getID() {
        return ID;
    }
/**
	 * @return El numero de la tarjeta de la entidad Pago
	 */
    public String getNumTarjeta() {
        return numTarjeta;
    }
/**
	 * @return El codigo de la tarjeta de la entidad Pago
	 */
    public String getCodigoTarjeta() {
        return codigoTarjeta;
    }
/**
	 * @return El codigo de la tarjeta de la entidad Pago
	 */
    public String getFechaTarjeta() {
        return fechaTarjeta;
    }
/**
	 * @return El desripcion de la tarjeta de la entidad Pago
	 */
    public String getDescripcion() {
        return descripcion;
    }
/**
	 * @return El comprobante medio de la tarjeta de la entidad Pago
	 */
    public Boolean getComprobantePagoMedio() {
        return comprobantePagoMedio;
    }
/**
	 * @return El comprobante de pago final de la tarjeta de la entidad Pago
	 */
    public Boolean getComprobantePagoTotal() {
        return comprobantePagoTotal;
    }
   /**
	 * Convertir DTO a Entity
	 *
	 * @return Un Entity con los valores del DTO
	 */
	/**public PagoEntity toEntity( )
	{
		PagoEntity entity = new PagoEntity( );
		entity.setId(this.ID );
		entity.setCodigoTarjeta(this.codigoTarjeta );
		entity.setComprobantePagoMedio(this.comprobantePagoMedio );
		entity.setComprobantePagoTotal(this.comprobantePagoTotal );
		entity.setDescripcion(this.descripcion );
                entity.setFechaTarjeta(this.fechaTarjeta );
                entity.setNumTarjeta(this.numTarjeta ); 
		return entity;
	}
        *  */
}
