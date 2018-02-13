/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.SolicitudDetailDTO;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.mappers.BusinessLogicExceptionMapper;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;

import javax.ws.rs.*;

/**
 * <pre>Clase que implementa el recurso "solicitud".
 * URL: /api/solicitudes
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "solicitudes".</i>
 * <p>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que las solicitudes definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (Solicitud).
 * </pre>
 *
 * @author m.saravia
 * @version 1.0
 */

@Path("solicitudes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class SolicitudResource {
    
   /**
	 * <h1>POST /api/solicitudes : Crear una entidad de Solicitud.</h1>
	 * <p>
	 * <pre>Cuerpo de petición: JSON {@link UusarioDetailDTO}.
	 *
	 * Crea una nueva entidad de Solicitud con la informacion que se recibe en el cuerpo
	 * de la petición y se regresa un objeto identico con un id auto-generado
	 * por la base de datos.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Creó la nueva entidad de Solicitud.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 412 Precodition Failed: Ya existe la entidad de Solicitud.
	 * </code>
	 * </pre>
	 *
	 * @param solicitud {@link SolicitudDetailDTO} - La entidad de Solicitud que se desea guardar.
	 * @return JSON {@link SolicitudDetailDTO}  - La entidad de Solicitud guardada con el atributo id autogenerado.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la entidad de Solicitud.
	 */ 
    @POST
    public SolicitudDetailDTO crearSolicitud(SolicitudDetailDTO solicitud) throws BusinessLogicException{
        return solicitud;
    }
    
    /**
	 * <h1>GET /api/solicitud : Obtener todas las entidadese de Solicitud.</h1>
	 * <p>
	 * <pre>Busca y devuelve todas las entidades de Solicitud que existen en la aplicacion.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve todas las entidades de Solicitud de la aplicacion.</code>
	 * </pre>
	 *
	 * @return JSONArray {@link SolicitudDetailDTO} - Las entidades de la solicitud encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
	 */
    @GET
    public List<SolicitudDetailDTO> getSolicitudes(){
        
        return new ArrayList<>();
    }
    
    /**
	 * <h1>GET /api/os/{id} : Obtener una entidad de Solicitud por id.</h1>
	 * <p>
	 * <pre>Busca la entidad de Solicitud con el id asociado recibido en la URL y la devuelve.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve la entidad de Solicitud correspondiente al id.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found No existe una entidad de Solicitud con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Solicitud que se esta buscando. Este debe ser una cadena de dígitos.
	 * @return JSON {@link SolicitudDetailDTO} - La entidad de Solicitud buscada
	 */
    @GET
    @Path( "{id: \\d+}" )
    public SolicitudDetailDTO getSolicitud( @PathParam( "id" ) Integer id ){
        return null;
    }
    
    /**
	 * <h1>PUT /api/solicitudes/{id} : Actualizar una entidad de Solicitud con el id dado.</h1>
	 * <pre>Cuerpo de petición: JSON {@link SolicitudDetailDTO}.
	 *
	 * Actualiza la entidad de Solicitud con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Actualiza la entidad de Solicitud con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Solicitud con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Solicitud que se desea actualizar.Este debe ser una cadena de dígitos.
	 * @param detailDTO {@link SolicitudDetailDTO} La entidad de Solicitud que se desea guardar.
	 * @return JSON {@link SolicitudDetailDTO} - La entidad de Solicitud guardada.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la entidad de Solicitud porque ya existe una con ese nombre.
	 */
    @PUT
    @Path( "{id: \\d+}" )
    public SolicitudDetailDTO updateSolicitud(@PathParam( "id") Integer id, SolicitudDetailDTO solicitud)throws BusinessLogicException{
        
        return solicitud;
    }
    
    /**
	 * <h1>DELETE /api/solicitudes/{id} : Borrar una entidad de Solicitud por id.</h1>
	 * <p>
	 * <pre>Borra la entidad de Solicitud con el id asociado recibido en la URL.
	 *
	 * Códigos de respuesta:<br>
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Elimina la entidad de Solicitud correspondiente al id dado.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Solicitud con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Solicitud que se desea borrar. Este debe ser una cadena de dígitos.
	 */
    @DELETE
    @Path( "{id: \\d+}" )
    public void deleteSolicitud( @PathParam( "id" ) Integer id ){
	
        //cuerpo
    }
    
}