/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.PagoDetailDTO;
import co.edu.uniandes.csw.lostoderos.ejb.PagoLogic;
import co.edu.uniandes.csw.lostoderos.entities.PagoEntity;
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
import co.edu.uniandes.csw.lostoderos.mappers.BusinessLogicExceptionMapper;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.PagoPersistence;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;


/**
 * <pre>Clase que implementa el recurso "pagos".
 * URL: /api/pagos
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "pagos".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author s.rangel  
 * @version 1.0
 */
//@Path( "facturas/{id: \\d+}/pagos" )
@Path( "pagos" )

@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class PagoResource {
/**
     * <h1>POST /api/pagos : Crear un pago.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link PagoDetailDTO}.
     * 
     * Crea una nueva ciudad con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva ciudad .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la ciudad.
     * </code>
     * </pre>
     * @param dto {@link PagoDetailDTO} - El pago que se desea guardar.
     * @return JSON {@link PagoDetailDTO}  - El pago guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya esta el pago.

     */
    
    @Inject
    PagoLogic pagoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(PagoPersistence.class.getName());

    @POST
	public PagoDetailDTO createPago( PagoDetailDTO dto ) throws BusinessLogicException, Exception 
	{
	        return new PagoDetailDTO(pagoLogic.createPago(dto.toEntity()));

	}
         /**
     * <h1>GET /api/pagos : Obtener todas los pagos.</h1>
     * 
     * <pre>Busca y devuelve todas los pagos que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los pagos de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link PagoDetailDTO} - Los pagos encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<PagoDetailDTO> getPagos() throws Exception {
        return listEntity2DetailDTO(pagoLogic.getPagos());
    }
        /**
     * <h1>GET /api/pagos/{id} : Obtener pago por id.</h1>
     * 
     * <pre>Busca el pago con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe el pago con el id dado.
     * </code> 
     * </pre>
     * @param id  Este debe ser una cadena de dígitos.
     * @return JSON {@link PagoDetailDTO} - La ciudad buscada
     */
    @GET
    @Path( "{id: \\d+}" )
    public PagoDetailDTO getPago(@PathParam("id") Long id )
	{
        PagoEntity entity = pagoLogic.getPago(id);
        if (entity == null) {
            throw new WebApplicationException("El pago no existe", 404);
        }
        return new PagoDetailDTO(entity);
	}

         /**
     * <h1>PUT /api/pagos/{id} : Actualizar pago con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link PagoDetailDTO}.
     * 
     * Actualiza el pago con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la ciudad con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una ciudad con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del pago que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param pago {@link PagoDetailDTO} del pago  que se desea guardar.
     * @return JSON {@link PagoDetailDTO} - del pago  guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar del pago  porque ya existe uno con ese nombre.

     */
     
    @PUT
    @Path( "{id: \\d+}" )
    public PagoDetailDTO updatePago( @PathParam( "id" ) Long id, PagoDetailDTO pago ) throws BusinessLogicException 
	{
		PagoEntity entity = pago.toEntity();
        entity.setId(id);
        PagoEntity oldEntity = pagoLogic.getById(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El pago no existe", 404);
        }
        return new PagoDetailDTO(pagoLogic.updatePago(entity));
	}
           
    private List<PagoDetailDTO> listEntity2DetailDTO(List<PagoEntity> entityList) {
        List<PagoDetailDTO> list = new ArrayList<>();
        entityList.forEach((entity) -> {
            list.add(new PagoDetailDTO(entity));
        });
        return list;
    }

          /**
     * <h1>DELETE /api/pagos/{id} : Borrar pago por id.</h1>
     * 
     * <pre>Borra el pago con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la ciudad correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una ciudad con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del pago que se desea borrar. Este debe ser una cadena de dígitos.
     */
@DELETE
@Path( "{id: \\d+}" )
public PagoDetailDTO deletePago( @PathParam( "id" ) Long id ) throws Exception
	{
		  PagoEntity entity = pagoLogic.getById(id);
        if (entity == null) {
            throw new WebApplicationException("El pago no existe", 404);
        }
        else
        {
            pagoLogic.deletePago(id);
                    
        }
        return new PagoDetailDTO(entity);
	}
         
    
}
