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

import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;
import java.util.List;

/**
 * Clase que extiende de {@link ServicioDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del servicio vaya a la documentacion de {@link ServicioDTO}
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": string,
 *      "categorias": string,
 *      "descripcion": string,
 *      "contratistas": 
 *      [
 *         {
 *           "id": number,
 *           "nombre": string,
 *           "categorias": string,
 *           "descripción": string
 *         },
 *         {
 *           "id": number,
 *           "nombre": string,
 *           "categorias": string,
 *           "descripción": string
 *         }
 *      ]
 *   }
 * </pre>
 * Por ejemplo una entidad de Servicio se representa asi:<br>
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "nombre": "Plomería",
 *      "categorias": "agua y tuberias",
 *      "descripción": "Aqui va una descripcion detallada del servicio",
 *      "contratistas": 
 *      [
 *         {
 *           "id": 91364,
 *           "nombre": "Sergio Yepes",
 *           "reputacion": "Muy buena",
 *           "disponibilidad" : true
 *         },
 *         {
 *           "id": 91359,
 *           "nombre": "Sergio Naranjo",
 *           "reputacion": "Muy buena",
 *           "disponibilidad" : true
 *         }
 *      ]
 *   }
 *
 * </pre>
 * @author s.naranjop1
 */
public class ServicioDetailDTO extends ServicioDTO
{
        private List contratistas;
        
        /**
	 * Constructor por defecto
	 */
	public ServicioDetailDTO( )
	{
            super();
	}
        
        public List getContratistas()
        {
                return contratistas;
        }

        public void setContratistas(List contratistas) 
        {
                this.contratistas = contratistas;
        }
        
        /**
	 * Transformar un DTO a un Entity
	 *
	 * @return La entidad construida a partir del DTO.
	 */
	@Override
	public ServicioEntity toEntity( )
	{
		ServicioEntity servicioEntity = super.toEntity( );
		return servicioEntity;
	}
}
