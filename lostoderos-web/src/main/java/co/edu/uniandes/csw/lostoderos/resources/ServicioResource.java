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
CITYS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.ServicioDetailDTO;
import co.edu.uniandes.csw.lostoderos.ejb.ServicioLogic;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.mappers.BusinessLogicExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * <pre>Clase que implementa el recurso "servicio".
 * URL: /api/servicios
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "servicios".</i>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 * @author s.naranjop1
 * @version 1.0
 */
@Path( "servicios" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class ServicioResource 
{
     @Inject
    private ServicioLogic servicioLogic;
    /**
	 * <h1>POST /api/servicios : Crear una entidad de Servicio.</h1>
	 * <pre>Cuerpo de petición: JSON {@link ServicioDetailDTO}.
	 *
	 * Crea una nueva entidad de Servicio con la informacion que se recibe en el cuerpo
	 * de la petición y se regresa un objeto identico con un id auto-generado
	 * por la base de datos.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Creó la nueva entidad de Servicio.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 412 Precodition Failed: Ya existe la entidad de Servicio.
	 * </code>
	 * </pre>
	 * @param servicio {@link ServicioDetailDTO} - La entidad de Servicio que se desea guardar.
	 * @return JSON {@link ServicioDetailDTO}  - La entidad de Servicio guardada con el atributo id autogenerado.
	 * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe la entidad de Servicio.
	 */
	@POST
	public ServicioDetailDTO createServicio( ServicioDetailDTO servicio ) throws BusinessLogicException
	{
		return new ServicioDetailDTO(servicioLogic.create(servicio.toEntity()));
	}
        
        /**
	 * <h1>GET /api/servicios : Obtener todas las entidadese de Servicio.</h1>
	 * <pre>Busca y devuelve todas las entidades de Servicio que existen en la aplicacion.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve todas las entidades de Servicio de la aplicacion.</code>
	 * </pre>
	 * @return JSONArray {@link ServicioDetailDTO} - Las entidades de Servicio encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
	 */
	@GET
	public List<ServicioDetailDTO> getServicios( )
	{
		return new ArrayList<>( );
	}
        
        /**
	 * <h1>GET /api/os/{id} : Obtener una entidad de Servicio por id.</h1>
	 * <pre>Busca la entidad de Servicio con el id asociado recibido en la URL y la devuelve.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve la entidad de Servicio correspondiente al id.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found No existe una entidad de Servicio con el id dado.
	 * </code>
	 * </pre>
	 * @param id Identificador de la entidad de Servicio que se esta buscando. Este debe ser una cadena de dígitos.
	 * @return JSON {@link ServicioDetailDTO} - La entidad de Servicio buscada
	 */
	@GET
	@Path( "{id: \\d+}" )
	public ServicioDetailDTO getServicio( @PathParam( "id" ) Long id )
	{
		return null;
	}

	/**
	 * <h1>PUT /api/servicios/{id} : Actualizar una entidad de Servicio con el id dado.</h1>
	 * <pre>Cuerpo de petición: JSON {@link ServicioDetailDTO}.
	 *
	 * Actualiza la entidad de Cliente con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Actualiza la entidad de Servicio con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Servicio con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Cliente que se desea actualizar.Este debe ser una cadena de dígitos.
	 * @param detailDTO {@link ServicioDetailDTO} La entidad de Cliente que se desea guardar.
	 * @return JSON {@link ServicioDetailDTO} - La entidad de Cliente guardada.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la entidad de Servicio porque ya existe una con ese nombre.
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public ServicioDetailDTO updateServicio( @PathParam( "id" ) Long id, ServicioDetailDTO detailDTO ) throws BusinessLogicException
	{
		return detailDTO;
	}

	/**
	 * <h1>DELETE /api/servicios/{id} : Borrar una entidad de Servicio por id.</h1>
	 * <pre>Borra la entidad de Servicio con el id asociado recibido en la URL.
	 *
	 * Códigos de respuesta:<br>
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Elimina la entidad de Servicio correspondiente al id dado.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Servicio con el id dado.
	 * </code>
	 * </pre>
	 * @param id Identificador de la entidad de Servicio que se desea borrar. Este debe ser una cadena de dígitos.
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deleteServicio( @PathParam( "id" ) Long id )
	{
		// Void
	}
}
