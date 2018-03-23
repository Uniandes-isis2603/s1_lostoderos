/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.ContratistaDetailDTO;
import co.edu.uniandes.csw.lostoderos.ejb.ServicioLogic;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author s.naranjop1
 */
@Path("servicios/{nombre}/contratistas")
public class ServicioContratistaResource 
{
    @Inject
    private ServicioLogic servicioLogic;

    /**
     * Convierte una lista de ContratistaEntity a una lista de ContratistaDetailDTO.
     *
     * @param entityList Lista de ContratistaEntity a convertir.
     * @return Lista de ContratistaDetailDTO convertida.
     * 
     */
    private List<ContratistaDetailDTO> contratistasListEntity2DTO(List<ContratistaEntity> entityList) {
        List<ContratistaDetailDTO> list = new ArrayList<>();
        for (ContratistaEntity entity : entityList) {
            list.add(new ContratistaDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de ContratistaDetailDTO a una lista de ContratistaEntity.
     *
     * @param dtos Lista de ContratistaDetailDTO a convertir.
     * @return Lista de ContratistaEntity convertida.
     * 
     */
    private List<ContratistaEntity> contratistasListDTO2Entity(List<ContratistaDetailDTO> dtos) {
        List<ContratistaEntity> list = new ArrayList<>();
        for (ContratistaDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * <h1>GET /api/servicios/{nombre}/contratistas : Obtener todos los contratistas de un servicio.</h1>
     *
     * <pre>Busca y devuelve todos los contratistas que existen en un servicio.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los contratistas del servicio.</code> 
     * </pre>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un servicio con el nombre dado.
     * </code>
     * @param nombreServicio El nombre del servicio del cual se buscan los contratistas
     * @return JSONArray {@link ContratistaDetailDTO} - Los contratistaes encontrados en el servicio. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ContratistaDetailDTO> listContratistas(@PathParam("nombre") String nombreServicio) {
        return contratistasListEntity2DTO(servicioLogic.listContratistas(nombreServicio));
    }

    /**
     * <h1>GET /api/servicios/{nombre}/contratistas/{contratistaId} : Obtener un contratista de un servicio.</h1>
     *
     * <pre>Busca y devuelve el contratista con el ID recibido en la URL, relativo a un
     * servicio.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el contratista del servicio.</code> 
     * </pre>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un servicio con el id dado.
     * </code>
     * @param contratistaId El ID del contratista que se busca
     * @param nombreServicio El nombre del servicio del cual se busca el contratista
     * @return {@link ContratistaDetailDTO} - El contratista encontrado en el servicio.
     */
    @GET
    @Path("{contratistaId: \\d+}")
    public ContratistaDetailDTO getContratistas(@PathParam("nombre") String nombreServicio, @PathParam("contratistaId") Long contratistaId) {
        return new ContratistaDetailDTO(servicioLogic.getContratista(nombreServicio, contratistaId));
    }

    /**
     * <h1>POST /api/servicios/{nombre}/contratistas/{contratistaId} : Asociar un contratista a un servicio.</h1>
     *
     * <pre> Asocia un contratista existente con un servicio existente
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Asoció el contratista .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found: No existe el servicio o el contratista
     * </code>
     * </pre>
     * @param contratistaId El ID del contratista que se va a asociar
     * @param nombreServicio El nombre del servicio al cual se le va a asociar el contratista
     * @return JSON {@link ContratistaDetailDTO}  - El contratista asociado.
     */
    @POST
    @Path("{contratistaId: \\d+}")
    public ContratistaDetailDTO addContratistas(@PathParam("nombre") String nombreServicio, @PathParam("contratistaId") Long contratistaId) {
        return new ContratistaDetailDTO(servicioLogic.addContratista(nombreServicio, contratistaId));
    }

    /**
     * <h1>PUT api/servicios/{nombre}/contratistas/ : Actualizar los contratistaes de un servicio..</h1>
     *
     * <pre>Cuerpo de petición: JSONArray {@link ContratistaDetailDTO}.
     * 
     * Actualiza la lista de contratistaes de un servicio con la lista que se recibe en el
     * cuerpo
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Se actualizó la lista de contratistaes
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: No se pudo actualizar la lista
     * </code>
     * </pre>
     * @param nombreServicio El nombre del servicio al cual se le va a asociar la lista de contratistaes
     * @param contratistas JSONArray {@link ContratistaDetailDTO} - La lista de contratistaes que se desea guardar.
     * @return JSONArray {@link ContratistaDetailDTO}  - La lista actualizada.
     */
    @PUT
    public List<ContratistaDetailDTO> replaceContratistas(@PathParam("nombre") String nombreServicio, List<ContratistaDetailDTO> contratistas) {
        return contratistasListEntity2DTO(servicioLogic.replaceContratistas(nombreServicio, contratistasListDTO2Entity(contratistas)));
    }

    /**
     * <h1>DELETE api/servicios/{nombre}/contratistas/{contratistaId} : Desasociar contratista por id.</h1>
     *
     * <pre>Elimina la conexión entre el contratista y el servicio recibidos en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la referencia al contratista.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un contratista con el id dado en el servicio.
     * </code>
     * </pre>
     * @param nombreServicio El nombre del servicio al cual se le va a desasociar el contratista
     * @param contratistaId El ID del contratista que se desasocia
     */
    @DELETE
    @Path("{contratistaId: \\d+}")
    public void removeContratista(@PathParam("nombre") String nombreServicio, @PathParam("contratistaId") Long contratistaId) {
        servicioLogic.removeContratista(nombreServicio, contratistaId);
    }    
}
