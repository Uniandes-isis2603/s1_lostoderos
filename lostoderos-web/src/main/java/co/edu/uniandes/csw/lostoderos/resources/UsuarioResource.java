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

import co.edu.uniandes.csw.lostoderos.dtos.UsuarioDetailDTO;
import co.edu.uniandes.csw.lostoderos.ejb.UsuarioLogic;
import co.edu.uniandes.csw.lostoderos.entities.UsuarioEntity;
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
 * <pre>Clase que implementa el recurso "usuario".
 * URL: /api/usuarios
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "usuarios".</i>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (usuario).
 * </pre>
 * @author s.naranjop1
 * @version 1.0
 */
@Path( "usuarios" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class UsuarioResource 
{
    @Inject
    private UsuarioLogic usuarioLogic;
    
    /**
     * Convierte una lista de AuthorEntity a una lista de AuthorDetailDTO.
     *
     * @param entityList Lista de AuthorEntity a convertir.
     * @return Lista de AuthorDetailDTO convertida.
     * 
     */
    private List<UsuarioDetailDTO> listEntity2DTO(List<UsuarioEntity> entityList) {
        List<UsuarioDetailDTO> list = new ArrayList<>();
        for (UsuarioEntity entity : entityList) {
            list.add(new UsuarioDetailDTO(entity));
        }
        return list;
    }
    /**
	 * <h1>POST /api/usuarios : Crear una entidad de Usuario.</h1>
	 * <pre>Cuerpo de petición: JSON {@link UsuarioDetailDTO}.
	 *
	 * Crea una nueva entidad de Usuario con la informacion que se recibe en el cuerpo
	 * de la petición y se regresa un objeto identico con un id auto-generado
	 * por la base de datos.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Creó la nueva entidad de Usuario.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 412 Precodition Failed: Ya existe la entidad de Usuario.
	 * </code>
	 * </pre>
	 * @param usuario {@link UsuarioDetailDTO} - La entidad de Usuario que se desea guardar.
	 * @return JSON {@link UsuarioDetailDTO}  - La entidad de Usuario guardada con el atributo id autogenerado.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la entidad de Usuario.
	 */
	@POST
	public UsuarioDetailDTO createUusario( UsuarioDetailDTO usuario ) throws BusinessLogicException
	{
		return new UsuarioDetailDTO(usuarioLogic.create(usuario.toEntity()));
	}
        
        /**
	 * <h1>GET /api/usuarios : Obtener todas las entidadese de Usuario.</h1>
	 * <pre>Busca y devuelve todas las entidades de Usuario que existen en la aplicacion.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve todas las entidades de Usuario de la aplicacion.</code>
	 * </pre>
	 * @return JSONArray {@link UsuarioDetailDTO} - Las entidades de Usuario encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
	 */
	@GET
	public List<UsuarioDetailDTO> getUsuarios( )
	{
		return listEntity2DTO(usuarioLogic.getAll());
	}
        
        /**
	 * <h1>GET /api/os/{id} : Obtener una entidad de Usuario por id.</h1>
	 * <pre>Busca la entidad de Usuario con el id asociado recibido en la URL y la devuelve.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve la entidad de Usuario correspondiente al id.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found No existe una entidad de Usuario con el id dado.
	 * </code>
	 * </pre>
	 * @param id Identificador de la entidad de Usuario que se esta buscando. Este debe ser una cadena de dígitos.
	 * @return JSON {@link UsuarioDetailDTO} - La entidad de Usuario buscada
	 */
	@GET
	@Path( "{id: \\d+}" )
	public UsuarioDetailDTO getUsuario( @PathParam( "id" ) Long id )
	{
		return null;
	}

	/**
	 * <h1>PUT /api/usuarios/{id} : Actualizar una entidad de Usuario con el id dado.</h1>
	 * <pre>Cuerpo de petición: JSON {@link UsuarioDetailDTO}.
	 *
	 * Actualiza la entidad de Usuario con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Actualiza la entidad de Usuario con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Usuario con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Usuario que se desea actualizar.Este debe ser una cadena de dígitos.
	 * @param detailDTO {@link UsuarioDetailDTO} La entidad de Usuario que se desea guardar.
	 * @return JSON {@link UsuarioDetailDTO} - La entidad de Usuario guardada.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la entidad de Usuario porque ya existe una con ese nombre.
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public UsuarioDetailDTO updateUsuario( @PathParam( "id" ) Long id, UsuarioDetailDTO detailDTO ) throws BusinessLogicException
	{
		return detailDTO;
	}

	/**
	 * <h1>DELETE /api/usuarios/{id} : Borrar una entidad de Usuario por id.</h1>
	 * <pre>Borra la entidad de Usuario con el id asociado recibido en la URL.
	 *
	 * Códigos de respuesta:<br>
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Elimina la entidad de Usuario correspondiente al id dado.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Usuario con el id dado.
	 * </code>
	 * </pre>
	 * @param id Identificador de la entidad de Usuario que se desea borrar. Este debe ser una cadena de dígitos.
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deleteUsuario( @PathParam( "id" ) Long id )
	{
		// Void
	}
}
