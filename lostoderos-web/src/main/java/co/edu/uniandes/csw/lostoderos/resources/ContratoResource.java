/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.ContratoDetailDTO;
import co.edu.uniandes.csw.lostoderos.ejb.ContratoLogic;
import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;
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
import javax.ws.rs.WebApplicationException;

/**
 * <pre>Clase que implementa el recurso "contrato".
 * URL: /api/contratos
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "contrato".</i>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 *
 * @author s.blancoc
 */

@Path("contratos")
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class ContratoResource {
    
    @Inject
    private ContratoLogic contratoLogic;
    
    /**
	 * <h1>POST /api/toderos : Crear una entidad de contrato.</h1>
	 * <pre>Cuerpo de petición: JSON {@link ContratoDetailDTO}.
	 *
	 * Crea una nueva entidad de contrato con la informacion que se recibe en el cuerpo
	 * de la petición y se regresa un objeto identico con un id auto-generado
	 * por la base de datos.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Creó la nueva entidad de contrato.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 412 Precodition Failed: Ya existe la entidad de contrato.
	 * </code>
	 * </pre>
	 *
         * @param contratistaId id del contratista
         * @param contratoId
	 * @param dto {@link ContratoDetailDTO} - La entidad de contrato que se desea guardar.
	 * @return JSON {@link ContratoDetailDTO}  - La entidad de contrato guardada con el atributo id autogenerado.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la entidad.
	 */
	@POST
	public ContratoDetailDTO createContrato(ContratoDetailDTO dto ) throws BusinessLogicException
	{
		return new ContratoDetailDTO(contratoLogic.create(dto.toEntity()));
	}
        

        
        /**
     * <h1>GET /api/contratos/{id} : Obtener contrato por id.</h1>
     * 
     * <pre>Busca el contrato con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el contrato correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un contrato con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del contrato que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ContratoDetailDTO} - El contrato buscado
     */
    @GET
    @Path("{contratoId: \\d+}")
    public ContratoDetailDTO getContrato(@PathParam("contratoId") Long contratoId) throws BusinessLogicException {
                ContratoEntity entity = contratoLogic.getContrato(contratoId);
        return new ContratoDetailDTO(entity);
    }
    
    /**
     * <h1>PUT /api/contratos/{id} : Actualizar contrato con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ContratoDetailDTO}.
     * 
     * Actualiza el contrato con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el contrato con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un contrato con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del contrato que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param contrato {@link ContratoDetailDTO} el contrato que se desea guardar.
     * @return JSON {@link ContratoDetailDTO} - El contrato guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el contrato porque ya existe uno.
     */
    @PUT
    @Path("{contratoId: \\d+}")
    public ContratoDetailDTO updateContrato(@PathParam("contratoId") Long contratoId, ContratoDetailDTO contrato) throws BusinessLogicException {
        return new ContratoDetailDTO(contratoLogic.update(contratoId, contrato.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/contratos/{id} : Borrar contrato por id.</h1>
     * 
     * <pre>Borra elcontrato con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el contrato correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un contrato con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del contrato que se desea borrar. Este debe ser una cadena de dígitos.
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @DELETE
    @Path("{contratoId: \\d+}")
     public void deleteContrato(@PathParam("contratoId") Long contratoId)throws BusinessLogicException {
        contratoLogic.delete(contratoId);
    }

    
}
