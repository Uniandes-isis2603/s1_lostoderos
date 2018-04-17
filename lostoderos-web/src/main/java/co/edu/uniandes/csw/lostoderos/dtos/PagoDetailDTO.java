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
 * Clase que extiende de {@link PagoDetailDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del cliente vaya a la documentacion de {@link PagoDetailDTO}
 * @author s.rangel
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": Number,
 *      "codigoTarjeta": String,
 *      "comprobantePagoMedio": Boolean,
 *      "comprobantePagoTotal": Boolean,
 *      "descripcion": String,
 *      "fechaTarjeta": String,
 *      "numTarjeta": String
 *     
 *         
 *      
 * 
 *   }
 * </pre>
 * Por ejemplo una entidad de Servicio se representa asi:<br>
 * 
 * <pre>
 *
 *   {
 *      "id": 12390813,
 *      "codigoTarjeta": "123",
 *      "comprobantePagoMedio": true,
 *      "comprobantePagoTotal": false,
 *      "descripcion": "un pago correspondiente a tal servicio",
 *      "fechaTarjeta": "09/18",
 *      "numTarjeta": "123456629723"
 * 
 *   }
 *
 * </pre>
 *
 */
public class PagoDetailDTO extends PagoDTO {
    
   

    /**
     * Crea un objeto PagoDetailDTO a partir de un objeto PagoEntity
     * incluyendo los atributos de PagoDTO.
     *
     * @param entity Entidad PagoEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public PagoDetailDTO(PagoEntity entity) {
        super(entity);
        

        }
      public PagoDetailDTO() {
        super();
        

        }
/**
	 * Transformar un DTO a un Entity
	 *
	 * @return La entidad construida a partir del DTO.
	 */
	@Override
	public PagoEntity toEntity( )
	{
		PagoEntity pagoEntity = super.toEntity( );
		return pagoEntity;
	}
        
        
        
        
        
        
        
}
   


