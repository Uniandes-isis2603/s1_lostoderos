/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.PersonaNaturalDetailDTO;
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
 * <pre>Clase que implementa el recurso "PersonaNatural".
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
@Path( "PersonasNaturales" )
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class PersonaNaturalResource {
    /**
	 * <h1>POST /api/PersonaJuridica : Crear una entidad de PersonaNatural.</h1>
	 * <p>
	 * <pre>Cuerpo de petición: JSON {@link PersonaNaturalDetailDTO}.
	 *
	 * Crea una nueva entidad de Todero con la informacion que se recibe en el cuerpo
	 * de la petición y se regresa un objeto identico con un id auto-generado
	 * por la base de datos.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Creó la nueva entidad de PersonaNatural.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 412 Precodition Failed: Ya existe la entidad de PersonaNatural.
	 * </code>
	 * </pre>
	 *
	 * @param dto {@link PersonaNaturalDetailDTO} - La entidad de PersonaNatural que se desea guardar.
	 * @return JSON {@link PersonaNaturalDetailDTO}  - La entidad de PersonaNatural guardada con el atributo id autogenerado.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la entidad de PersonaNatural.
	 */
	@POST
	public PersonaNaturalDetailDTO createPersonaJuridica( PersonaNaturalDetailDTO dto ) throws BusinessLogicException
	{
		return dto;
	}

	/**
	 * <h1>GET /api/PersonaNatural : Obtener todas las entidades de PersonaNatural.</h1>
	 * <p>
	 * <pre>Busca y devuelve todas las entidades de PersonaNatural que existen en la aplicacion.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve todas las entidades de PersonaNatural de la aplicacion.</code>
	 * </pre>
	 *
	 * @return JSONArray {@link PersonaNaturalDetailDTO} - Las entidades de PersonaNatural encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
	 */
	@GET
	public List<PersonaNaturalDetailDTO> getPersonaNatural( )
	{
		return new ArrayList<>( );
	}

	/**
	 * <h1>GET /api/PersonasNaturales/{id} : Obtener una entidad de PersonaNatural por id.</h1>
	 * <p>
	 * <pre>Busca la entidad de PersonaNatural con el id asociado recibido en la URL y la devuelve.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve la entidad de PersonaNatural correspondiente al id.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found No existe una entidad de PersonaNatural con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de PersonaNatural que se esta buscando. Este debe ser una cadena de dígitos.
	 * @return JSON {@link PersonaNaturalDetailDTO} - La entidad de PersonaNatural buscada
	 */
	@GET
	@Path( "{id: \\d+}" )
	public PersonaNaturalDetailDTO getPersonaNatural( @PathParam( "id" ) Long id )
	{
		return null;
	}

	/**
	 * <h1>PUT /api/PersonasNaturales/{id} : Actualizar una entidad de PersonaNatural con el id dado.</h1>
	 * <pre>Cuerpo de petición: JSON {@link PersonaNaturalDetailDTO}.
	 *
	 * Actualiza la entidad de PersonaNatural con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Actualiza la entidad de PersonaNatural con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de PersonaNatural con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id        Identificador de la entidad de PersonaNatural que se desea actualizar.Este debe ser una cadena de dígitos.
	 * @param detailDTO {@link PersonaNaturalDetailDTO} La entidad de PersonaNatural que se desea guardar.
	 * @return JSON {@link PersonaNaturalDetailDTO} - La entidad de PersonaJuridica guardada.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la entidad de PersonaNatural porque ya existe una con ese nombre.
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public PersonaNaturalDetailDTO updatePersonaNatural( @PathParam( "id" ) Long id, PersonaNaturalDetailDTO detailDTO ) throws BusinessLogicException
	{
		return detailDTO;
	}

	/**
	 * <h1>DELETE /api/PersonasNaturales/{id} : Borrar una entidad de PersonaNatural por id.</h1>
	 * <p>
	 * <pre>Borra la entidad de PersonaNatural con el id asociado recibido en la URL.
	 *
	 * Códigos de respuesta:<br>
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Elimina la entidad de PersonaNatural correspondiente al id dado.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de PersonaNatural con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de PersonaNatural que se desea borrar. Este debe ser una cadena de dígitos.
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deletePersonaNatural( @PathParam( "id" ) Long id )
	{
		// Void
	}
}
