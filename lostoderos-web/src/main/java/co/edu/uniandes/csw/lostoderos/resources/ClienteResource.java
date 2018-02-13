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

import co.edu.uniandes.csw.lostoderos.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.mappers.BusinessLogicExceptionMapper;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * <pre>Clase que implementa el recurso "cliente".
 * URL: /api/clientes
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "clientes".</i>
 * <p>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author s.naranjop1
 * @version 1.0
 */
@Path( "clientes" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class ClienteResource 
{
    /**
	 * <h1>POST /api/clientes : Crear una entidad de Cliente.</h1>
	 * <p>
	 * <pre>Cuerpo de petición: JSON {@link UusarioDetailDTO}.
	 *
	 * Crea una nueva entidad de Cliente con la informacion que se recibe en el cuerpo
	 * de la petición y se regresa un objeto identico con un id auto-generado
	 * por la base de datos.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Creó la nueva entidad de Cliente.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 412 Precodition Failed: Ya existe la entidad de Cliente.
	 * </code>
	 * </pre>
	 *
	 * @param cliente {@link ClienteDetailDTO} - La entidad de Cliente que se desea guardar.
	 * @return JSON {@link ClienteDetailDTO}  - La entidad de Cliente guardada con el atributo id autogenerado.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la entidad de Cliente.
	 */
	@POST
	public ClienteDetailDTO createUusario( ClienteDetailDTO cliente ) throws BusinessLogicException
	{
		return cliente;
	}
        
        /**
	 * <h1>GET /api/clientes : Obtener todas las entidadese de Cliente.</h1>
	 * <p>
	 * <pre>Busca y devuelve todas las entidades de Cliente que existen en la aplicacion.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve todas las entidades de Cliente de la aplicacion.</code>
	 * </pre>
	 *
	 * @return JSONArray {@link ClienteDetailDTO} - Las entidades de Cliente encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
	 */
	@GET
	public List<ClienteDetailDTO> getClientes( )
	{
		return new ArrayList<>( );
	}
        
        /**
	 * <h1>GET /api/os/{id} : Obtener una entidad de Cliente por id.</h1>
	 * <p>
	 * <pre>Busca la entidad de Cliente con el id asociado recibido en la URL y la devuelve.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve la entidad de Cliente correspondiente al id.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found No existe una entidad de Cliente con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Cliente que se esta buscando. Este debe ser una cadena de dígitos.
	 * @return JSON {@link ClienteDetailDTO} - La entidad de Cliente buscada
	 */
	@GET
	@Path( "{id: \\d+}" )
	public ClienteDetailDTO getCliente( @PathParam( "id" ) Long id )
	{
		return null;
	}

	/**
	 * <h1>PUT /api/clientes/{id} : Actualizar una entidad de Cliente con el id dado.</h1>
	 * <pre>Cuerpo de petición: JSON {@link ClienteDetailDTO}.
	 *
	 * Actualiza la entidad de Cliente con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Actualiza la entidad de Cliente con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Cliente con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Cliente que se desea actualizar.Este debe ser una cadena de dígitos.
	 * @param detailDTO {@link ClienteDetailDTO} La entidad de Cliente que se desea guardar.
	 * @return JSON {@link ClienteDetailDTO} - La entidad de Cliente guardada.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la entidad de Cliente porque ya existe una con ese nombre.
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public ClienteDetailDTO updateCliente( @PathParam( "id" ) Long id, ClienteDetailDTO detailDTO ) throws BusinessLogicException
	{
		return detailDTO;
	}

	/**
	 * <h1>DELETE /api/clientes/{id} : Borrar una entidad de Cliente por id.</h1>
	 * <p>
	 * <pre>Borra la entidad de Cliente con el id asociado recibido en la URL.
	 *
	 * Códigos de respuesta:<br>
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Elimina la entidad de Cliente correspondiente al id dado.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Cliente con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Cliente que se desea borrar. Este debe ser una cadena de dígitos.
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deleteCliente( @PathParam( "id" ) Long id )
	{
		// Void
	}
}
