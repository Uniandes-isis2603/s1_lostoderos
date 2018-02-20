/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.CotizacionDetailDTO;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.mappers.BusinessLogicExceptionMapper;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;

import javax.ws.rs.*;

/**
 * <pre>Clase que implementa el recurso "cotizacion".
 * URL: /api/cotizaciones
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "cotizaciones".</i>
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que las cotizaciones definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (cotizacion).
 * </pre>
 *
 * @author m.saravia
 * @version 1.0
 */
@Path("cotizaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CotizacionResource {
    
    /**
	 * <h1>POST /api/cotizaciones : Crear una entidad de Cotizacion.</h1>
	 * 
	 * <pre>Cuerpo de petición: JSON {@link UusarioDetailDTO}.
	 *
	 * Crea una nueva entidad de Cotizacion con la informacion que se recibe en el cuerpo
	 * de la petición y se regresa un objeto identico con un id auto-generado
	 * por la base de datos.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Creó la nueva entidad de Cotizacion.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 412 Precodition Failed: Ya existe la entidad de Cotizacion.
	 * </code>
	 * </pre>
	 *
	 * @param cotizacion {@link CotizacionDetailDTO} - La entidad de Cotizacion que se desea guardar.
	 * @return JSON {@link CotizacionDetailDTO}  - La entidad de Cotizacion guardada con el atributo id autogenerado.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la entidad de Cotizacion.
	 */
    @POST
    public CotizacionDetailDTO crearCotizacion(CotizacionDetailDTO cotizacion) throws BusinessLogicException{
        return cotizacion;
    }
    
    /**
	 * <h1>GET /api/cotizacion : Obtener todas las entidadese de Cotizacion.</h1>
	 * 
	 * <pre>Busca y devuelve todas las entidades de Cotizacion que existen en la aplicacion.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve todas las entidades de Cotizacion de la aplicacion.</code>
	 * </pre>
	 *
	 * @return JSONArray {@link CotizacionDetailDTO} - Las entidades de la Cotizacion encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
	 */
    @GET
    public List<CotizacionDetailDTO> getCotizaciones(){
        
        return new ArrayList<>();
    }
    
    /**
	 * <h1>GET /api/os/{id} : Obtener una entidad de Cotizacion por id.</h1>
	 * 
	 * <pre>Busca la entidad de Cotizacion con el id asociado recibido en la URL y la devuelve.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve la entidad de Cotizacion correspondiente al id.
	 * </code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found No existe una entidad de Cotizacion con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Cotizacion que se esta buscando. Este debe ser una cadena de dígitos.
	 * @return JSON {@link CotizacionDetailDTO} - La entidad de Cotizacion buscada
	 */
    @GET
    @Path( "{id: \\d+}" )
    public CotizacionDetailDTO getCotizacion( @PathParam( "id" ) Long id ){
        return null;
    }
    
     /**
	 * <h1>PUT /api/Cotizaciones/{id} : Actualizar una entidad de Cotizacion con el id dado.</h1>
	 * <pre>Cuerpo de petición: JSON {@link CotizacionDetailDTO}.
	 *
	 * Actualiza la entidad de Cotizacion con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Actualiza la entidad de Cotizacion con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Cotizacion con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Cotizacion que se desea actualizar.Este debe ser una cadena de dígitos.
	 * @param detailDTO {@link CotizacionDetailDTO} La entidad de Cotizacion que se desea guardar.
	 * @return JSON {@link CotizacionDetailDTO} - La entidad de Cotizacion guardada.
	 * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la entidad de Cotizacion porque ya existe una con ese nombre.
	 */
    @PUT
    @Path( "{id: \\d+}" )
    public CotizacionDetailDTO updateCOtizacion(@PathParam( "id") Long id, CotizacionDetailDTO cotizacion)throws BusinessLogicException{
        
        return cotizacion;
    }
    
    /**
	 * <h1>DELETE /api/cotizaciones/{id} : Borrar una entidad de Cotizacion por id.</h1>
	
	 * <pre>Borra la entidad de Cotizacion con el id asociado recibido en la URL.
	 *
	 * Códigos de respuesta:<br>
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Elimina la entidad de Cotizacion correspondiente al id dado.</code>
	 * <code style="color: #c7254e; background-color: #f9f2f4;">
	 * 404 Not Found. No existe una entidad de Cotizacion con el id dado.
	 * </code>
	 * </pre>
	 *
	 * @param id Identificador de la entidad de Cotizacion que se desea borrar. Este debe ser una cadena de dígitos.
	 */
    @DELETE
    @Path( "{id: \\d+}" )
    public void deleteCotizacion( @PathParam( "id" ) Long id ){
	
        //cuerpo
    }
    
}