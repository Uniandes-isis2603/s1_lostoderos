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

import co.edu.uniandes.csw.lostoderos.entities.ClienteEntity;
import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link ClienteDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del cliente vaya a la documentacion de {@link ClienteDTO}
 * 
 * * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": string,
 *      "usuario": string,
 *      "contraseña": string,
 *      "correo": string,
 *      "fecha_nacimiento" string,
 *      "forma_pago" number,
 *      "direccion": string,
 *      "solicitudes":
 *      [
 *         {
 *           "id": Long,
 *           "requermiemientos": String,
 *           "tipo_servicio": String,
 *           "calificacion": Integer,
 *           "cantidad_contratistas": Integer,
 *           "cod_seguridad": Integer,
 *           "descripcion": String,
 *           "fecha_inicio": String
 *         },
 *         {
 *           "id": Long,
 *           "requermiemientos": String,
 *           "tipo_servicio": String,
 *           "calificacion": Integer,
 *           "cantidad_contratistas": Integer,
 *           "cod_seguridad": Integer,
 *           "descripcion": String,
 *           "fecha_inicio": String
 *         }
 *      ]
 *   }
 * </pre>
 * Por ejemplo una entidad de Servicio se representa asi:<br>
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "nombre": "Juan Perez",
 *      "usuario": "Jperez",
 *      "contraseña": "enero1999",
 *      "correo":"Jperez@gmail.com"
 *      "fecha_nacimiento" "14/01/1999",
 *      "forma_pago" 1,
 *      "direccion": "Carrera 5 #62-08"
 *      "solicitudes":
 *      [
 *         {
 *           "id": 3859,
 *           "requerimientos": "Cambiar la tuberia de la casa",
 *           "tipo_servicio": "Plomería",
 *           "calificacion": 7,
 *           "cantidad_contratistas": 1,
 *           "cod_seguridad": 358,
 *           "descripcion": "Se daño la tubería en la casa y se desea cambiarla",
 *           "fecha_inicio": "15/02/2018"
 *         },
 *         {
 *           "id": 3654,
 *           "requerimientos": "Cambiar los bombillos de la casa",
 *           "tipo_servicio": "Electricidad",
 *           "calificacion": 6,
 *           "cantidad_contratistas": 1,
 *           "cod_seguridad": 324,
 *           "descripcion": "Se fundieron los bombillos en la casa y se desea cambiarlos",
 *           "fecha_inicio": "15/01/2018"
 *         }
 *      ]
 *   }
 *
 * </pre>
 * @author s.naranjop1
 */
public class ClienteDetailDTO extends ClienteDTO 
{
        private List<SolicitudDTO> solicitudes;    
    
         /**
	 * Constructor por defecto
	 */
	public ClienteDetailDTO( )
	{
            super();
	}
        
         /**
	 * Constructor para transformar un Entity a un DTO
	 *
	 * @param entity La entidad de Cliente a partir de la cual se construye el objeto
	 */
	public ClienteDetailDTO( ClienteEntity entity )
	{
		super( entity );
                if(entity != null)
                {
                    if(entity.getSolicitudes() != null)
                    {
                        solicitudes = new ArrayList<>();
                        for(SolicitudEntity entitySolicitud: entity.getSolicitudes())
                        {
                            solicitudes.add(new SolicitudDTO(entitySolicitud));
                        }
                    }
                }
	}
        
        public List<SolicitudDTO> getSolicitudes()
        {
                return solicitudes;
        }

        public void setSolicitudes(List<SolicitudDTO> solicitudes) 
        {
                this.solicitudes = solicitudes;
        }
        
        /**
	 * Transformar un DTO a un Entity
	 *
	 * @return La entidad construida a partir del DTO.
	 */
	@Override
	public ClienteEntity toEntity( )
	{
		ClienteEntity servicioEntity = super.toEntity( );
                if(solicitudes != null)
                {
                    List<SolicitudEntity>solicitudesEntity = new ArrayList<>();
                    for (SolicitudDTO dtoSolicitud : solicitudes)
                    {
                        solicitudesEntity.add(dtoSolicitud.toEntity());
                    }
                    servicioEntity.setSolicitudes(solicitudesEntity);
                }
		return servicioEntity;
	}
}
