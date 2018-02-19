/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.PersonaJuridicaDetailDTO;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.mappers.BusinessLogicExceptionMapper;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * <pre>Clase que implementa el recurso "PersonaJuridica".
 * URL: /api/PersonaJuridica
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "toderos".</i>
 * <p>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author na.morenoe
 * @version 1.0
 */
@Path( "PersonasJuridicas" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class PersonaJuridicaResource {
    /**
	 * <h1>POST /api/PersonaJuridica : Crear una entidad de PersonaJuridica.</h1>
	 * <p>
	 * <pre>Cuerpo de petición: JSON {@link PersonaJuridicaDetailDTO}.
	 *
	 * Crea una nueva entidad de PersonaJuridica con la informacion que se recibe en el cuerpo
	 * de la petición y se regresa un objeto identico con un id auto-generado
	 * por la base de datos.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Creó la nueva entidad de Persona Juridica.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 412 Precodition Failed: Ya existe la entidad de Persona Juridica.
	 * </code>
	 * </pre>
	 *
	 * @param dto {@link PersonaJuridicaDetailDTO} - La entidad de Persona Juridica que se desea guardar.
	 * @return JSON {@link PersonaJuridicaDetailDTO}  - La entidad de Persona Juridica guardada con el atributo id autogenerado.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la entidad de Persona Juridica.
	 */
	@POST
	public PersonaJuridicaDetailDTO createPersonaJuridica( PersonaJuridicaDetailDTO dto ) throws BusinessLogicException
	{
		return dto;
	}

	/**
	 * <h1>GET /api/PersonaJuridica : Obtener todas las entidades de PersonaJuridica.</h1>
	 * <p>
	 * <pre>Busca y devuelve todas las entidades de PersonaJuridica que existen en la aplicacion.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve todas las entidades de PersonaJuridica de la aplicacion.</code>
	 * </pre>
	 *
	 * @return JSONArray {@link PersonaJuridicaDetailDTO} - Las entidades de PersonaJuridica encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
	 */
	@GET
	public List<PersonaJuridicaDetailDTO> getPersonaJuridica( )
	{
		return new ArrayList<>( );
	}

	/**
	 * <h1>GET /api/PersonasJuridicas/{id} : Obtener una entidad de PersonaJuridica por id.</h1>
	 * <p>
	 * <pre>Busca la entidad de PersonaJuridica con el id asociado recibido en la URL y la devuelve.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve la entidad de PersonaJuridica correspondiente al id.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found No existe una entidad de PersonaJuridica con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de PersonaJuridica que se esta buscando. Este debe ser una cadena de dígitos.
	 * @return JSON {@link PersonaJuridicaDetailDTO} - La entidad de PersonaJuridica buscada
	 */
	@GET
	@Path( "{id: \\d+}" )
	public PersonaJuridicaDetailDTO getPersonJuridica( @PathParam( "id" ) Long id )
	{
		return null;
	}

	/**
	 * <h1>PUT /api/PersonasJuridicas/{id} : Actualizar una entidad de PersonaJuridica con el id dado.</h1>
	 * <pre>Cuerpo de petición: JSON {@link PersonaJuridicaDetailDTO}.
	 *
	 * Actualiza la entidad de PersonaJuridica con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Actualiza la entidad de PersonaJuridica con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de PersonaJuridica con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id        Identificador de la entidad de PersonaJuridica que se desea actualizar.Este debe ser una cadena de dígitos.
	 * @param detailDTO {@link PersonaJuridicaDetailDTO} La entidad de PersonaJuridica que se desea guardar.
	 * @return JSON {@link PersonaJuridicaDetailDTO} - La entidad de PersonaJuridica guardada.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la entidad de PersonaJuridica porque ya existe una con ese nombre.
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public PersonaJuridicaDetailDTO updatePersonaJuridica( @PathParam( "id" ) Long id, PersonaJuridicaDetailDTO detailDTO ) throws BusinessLogicException
	{
		return detailDTO;
	}

	/**
	 * <h1>DELETE /api/PersonasJuridicas/{id} : Borrar una entidad de PersonaJuridica por id.</h1>
	 * <p>
	 * <pre>Borra la entidad de PersonaJuridica con el id asociado recibido en la URL.
	 *
	 * Códigos de respuesta:<br>
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Elimina la entidad de PersonaJuridica correspondiente al id dado.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de PersonaJuridica con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de PersonaJuridica que se desea borrar. Este debe ser una cadena de dígitos.
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deletePersonaJuridica( @PathParam( "id" ) Long id )
	{
		// Void
	}
}
