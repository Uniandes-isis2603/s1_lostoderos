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

import co.edu.uniandes.csw.lostoderos.entities.FacturaEntity;
/**
 * ServicioDTO Objeto de transferencia de datos de la entidad de Factura. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": Integer,
 *      "producto": String,
 *      "subTotal": Integer,
 *      "total": Integer
 *   }
 * </pre>
 * Por ejemplo una entidad de Factura se representa asi:<br>
 * 
 * <pre>
 *
 *   {
 *     "id": 14654,
 *      "producto": Plomeria,
 *      "subTotal": 1000000,
 *      "total": 10005467
 *   }
 *
 * </pre>
 *
 * @author s.rangel
 */
public class FacturaDTO {
    private Long ID;
    private String producto;
    private Integer total;
    private Integer subtotal;
  /**
	 * construcor por defecto
	 */
    public FacturaDTO() {
      
    }
    /**
	 * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
	 * la entidad que viene de argumento.
	 *
	 * @param facturaEntity: Es la entidad que se va a convertir a DTO
	 */
    /** public FacturaDTO( FacturaEntity facturaEntity )
	{
		this.ID = facturaEntity.getId();
		this.producto = facturaEntity.getProducto();
		this.subtotal = facturaEntity.getSubtotal();
                this.total = facturaEntity.getTotal();

	}
    */
  /**
	 * @return el ID de la entidad Cliente
	 */
    public Long getID() {
        return ID;
    }
  /**
	 * @return el producto de la entidad Cliente
	 */
    public String getProducto() {
        return producto;
    }
  /**
	 * @return el total de la entidad Cliente
	 */
    public Integer getTotal() {
        return total;
    }
  /**
	 * @return el subtotal de la entidad Cliente
	 */
    public Integer getSubtotal() {
        return subtotal;
    }
/**
	 * @param ID El nuevo ID de la entidad Todero
	 */
    public void setID(Long ID) {
        this.ID = ID;
    }
/**
	 * @param producto El nuevo producto medio de la entidad Todero
	 */
    public void setProducto(String producto) {
        this.producto = producto;
    }
/**
	 * @param total El nuevo total de la entidad Todero
	 */
    public void setTotal(Integer total) {
        this.total = total;
    }
/**
	 * @param subtotal El nuevo subtotal de la entidad Todero
	 */
    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

      /**
	 * Convertir DTO a Entity
	 *
	 * @return Un Entity con los valores del DTO
	 */
    /**
	public FacturaEntity toEntity( )
	{
		FacturaEntity entity = new FacturaEntity( );
		entity.setId(this.ID );
		entity.setProducto(this.producto );
		entity.setSubtotal(this.subtotal );
		entity.setTotal(this.total);
		return entity;
	}
    */
   
    
}
