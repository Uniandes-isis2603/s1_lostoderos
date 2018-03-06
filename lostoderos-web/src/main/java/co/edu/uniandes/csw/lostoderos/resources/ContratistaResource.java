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

import co.edu.uniandes.csw.lostoderos.dtos.ContratistaDetailDTO;
import co.edu.uniandes.csw.lostoderos.ejb.ContratistaLogic;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
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
 *<pre>Clase que implementa el recurso "contratistas".
 * URL: /api/contratistas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "contratistas".</i>
 * 
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author sa.yepes
 */
@Path("contratistas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ContratistaResource {
    
    @Inject
    ContratistaLogic contratistaLogic;
    
    /**
     * <h1>POST /api/contratistas: Crear un contratista. </h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ContratistaDetailDTO}.
     * 
     * Crea un nuevo contratista con la información que se recibe en el cuerpo
     * de la petición y se regresa un objeto idéntico con un id auto-generado
     * por la base de datos.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo contratista .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el contratista.
     * </code>
     * </pre>
     * 
     * @param contratista {@link ContratistaDetailDTO} - El contratista que se desea guardar.
     * @return JSON {@link ContratistaDetailDTO} - El contratista guardado con el atributo id cuando ya existe el contratista.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica cuando se intenta crear un contratista que ya existe.
     */
    @POST
    public ContratistaDetailDTO createContratista(ContratistaDetailDTO contratista) throws BusinessLogicException{
        return new ContratistaDetailDTO(contratistaLogic.createContratista(contratista.toEntity()));
    }
    
     /**
     * <h1>GET /api/contratistas : Obtener todas los contratistas.</h1>
     * 
     * <pre>Busca y devuelve todas los contratistas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas los contratistas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ContratistaDetailDTO} - Los contratistas encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ContratistaDetailDTO> getContratistas() {
        return listEntity2DetailDTO(contratistaLogic.getContratistas());
    }
    
    
     /**
     * <h1>GET /api/contratistas/{id} : Obtener contratista por id.</h1>
     * 
     * <pre>Busca el contratista con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el contratista correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un contratista con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del contratista que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ContratistaDetailDTO} - El contratista buscada
     */
    @GET
    @Path("{id: \\d+}")
    public ContratistaDetailDTO getContratista(@PathParam("id") Long id){
        return new ContratistaDetailDTO(contratistaLogic.getContratista(id));
    }
    
     /**
     * <h1>PUT /api/contratistas/{id} : Actualizar contratista con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ContratistaDetailDTO}.
     * 
     * Actualiza el contratista con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el contratista con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un contratista con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del contratista que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param contratista {@link ContratistaDetailDTO} El contratista que se desea guardar.
     * @return JSON {@link ContratistaDetailDTO} - El contratista guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica al intentar actualizar un contratista que no existe.
     */
    @PUT
    @Path("{id: \\d+}")
    public ContratistaDetailDTO updateContratista(@PathParam("id") Long id, ContratistaDetailDTO contratista)throws BusinessLogicException{
        return new ContratistaDetailDTO(contratistaLogic.updateContratista(id, contratista.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/contratistas/{id} : Borrar contratista por id.</h1>
     * 
     * <pre>Borra el contratista con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el contratista correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un contratista con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del contratista que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteContratista(@PathParam("id") Long id){
        //Void
        contratistaLogic.deleteContratista(id);
    }
    
    private List<ContratistaDetailDTO> listEntity2DetailDTO(List<ContratistaEntity> entityList) {
        List<ContratistaDetailDTO> list = new ArrayList<>();
        for (ContratistaEntity entity : entityList) {
            list.add(new ContratistaDetailDTO(entity));
        }
        return list;
    }
}
