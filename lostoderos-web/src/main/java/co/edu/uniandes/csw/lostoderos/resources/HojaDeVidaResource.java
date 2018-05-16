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
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.HojaDeVidaDTO;
import co.edu.uniandes.csw.lostoderos.mappers.BusinessLogicExceptionMapper;

import co.edu.uniandes.csw.lostoderos.dtos.HojaDeVidaDetailDTO;
import co.edu.uniandes.csw.lostoderos.ejb.HojaDeVidaLogic;
import co.edu.uniandes.csw.lostoderos.entities.HojaDeVidaEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import java.util.logging.Logger;

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

@Path("contratistas/{id_contratista:\\d+}/hojadevida")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class HojaDeVidaResource {

    @Inject
    HojaDeVidaLogic hojaVidaLogic;

    /**
     * <h1>POST /api/hojasdevida : Crear una hoja de vida.</h1>
     *
     * <pre> Cuerpo de petición: JSON {@link HojaDeVidaDetailDTO}.
     *
     * Crea una nueva hoja de vida con la información que se recibe en el cuerpo
     * de la petición y se regresa un objeto idéntico con un id auto-generado
     * por la base de datos.
     *
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva ciudad.
     * </code>
     * </pre>
     *
     * @param id_contratista Identificador del contratista.
     * @param hoja {@link HojaDeVidaDetailDTO} - La entidad de Hoja de Vida que
     * se desea guardar.
     * @return JSON {@link HojaDeVidaDetailDTO} - La entidad de Hoja de Vida que
     * se guarda con el id generado automáticamente.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la entidad de Hoja de
     * Vida.
     */
    @POST
    public HojaDeVidaDetailDTO create(@PathParam("id_contratista") Long id_contratista, HojaDeVidaDTO hoja) throws BusinessLogicException {

        return new HojaDeVidaDetailDTO(hojaVidaLogic.create(id_contratista, hoja.toEntity()));
    }

    /**
     * <h1> GET /api/contratistas/{id_contratista}/hojadevida : Obtener hoja de
     * vida por id. </h1>
     *
     * <pre> Busca la hoja de vida con el id asociado recibido en la URL y la devuelve.
     *
     * Códigos de respuesta:
     * <code style="color:mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la hoja de vida correspondiente al id.
     * </code>
     *  <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una hoja de vida con el nombre dado.
     * </code>
     * </pre>
     *
     * @param id_contratista Identificador del contratista
     * @return JSON {@link HojaDeVidaDetailDTO} - La hoja de vida buscada.
     * @throws BusinessLogicException Lanza excepción si la hoja de vida no
     * existe
     */
    @GET
    public HojaDeVidaDetailDTO getHojaDeVida(@PathParam("id_contratista") Long id_contratista) throws BusinessLogicException {
        HojaDeVidaEntity entity = hojaVidaLogic.findByIdContratista(id_contratista);
        if (entity == null) {
            throw new BusinessLogicException("El contratista con id: " + id_contratista + " no tiene una hoja de vida.");
        }
        return new HojaDeVidaDetailDTO(entity);
    }

    /**
     * <h1>PUT /api/contratistas/{id_contratista}/hojadevida : Actualizar la
     * hoja de vida con el id dado. </h1>
     * <pre>Cuerpo de petición: JSON {@link HojaDeVidaDetailDTO}.
     *
     * Actualiza la hoja de vida con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     *
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la hoja de vida con el id dadocon la información enviadacomo parámetro. Retorna un objeto idéntico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     *  404 Not Found. No existe una hoja de vida con el id dado.
     * </code>
     * </pre>
     *
     * @param id_contratista Identificador del contratista.
     * @param hoja {@link HojaDeVidaDetailDTO} La hoja de vida que se desea
     * guardar.
     * @return JSON {@link HojaDeVidaDetailDTO} - La hoja de vida guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera ya que no existe una hoja de vida con ese
     * id.
     */
    @PUT
    public HojaDeVidaDetailDTO updateHojaDeVida(@PathParam("id_contratista") Long id_contratista, HojaDeVidaDetailDTO hoja) throws BusinessLogicException {
        return new HojaDeVidaDetailDTO(hojaVidaLogic.update(id_contratista, hoja.toEntity()));
    }

    /**
     * <h1>DELETE /api/contratistas/{id_contratista}/hojadevida : Borrar hoja de
     * vida por el id del contratista. </h1>
     *
     * <pre>Borra la hoja de vida con el id asociado recibido en la URL.
     *
     * Códigos de respuesta: <br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la hoja de vida correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una hoja de vida con el id dado.
     * </code>
     * </pre>
     *
     * @param id_contratista Identificador del contratista que será borrado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera ya que no existe una hoja de vida con ese
     * id.
     */
    @DELETE
    public void delete(@PathParam("id_contratista") Long id_contratista) throws BusinessLogicException {
        hojaVidaLogic.delete(id_contratista);
    }
}
