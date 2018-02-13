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


import co.edu.uniandes.csw.lostoderos.dtos.HojaDeVidaDetailDTO;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
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

@Path("hojasdevida")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class HojaDeVidaResource {
    
    /**
     * <h1>POST /api/hojasdevida : Crear una hoja de vida.<h1>
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
     * @param hoja {@link HojaDeVidaDetailDTO} - La entidad de Hoja de Vida que se desea guardar.
     * @return JSON {@link HojaDeVidaDetailDTO} - La entidad de Hoja de Vida que se guarda con el id generado automáticamente.
     * @throws BusinessLogicException {@link HojaDeVidaDetailDTO} - Error de lógica que se genera cuando ya existe la entidad de Hoja de Vida.
     */
    @POST
    public HojaDeVidaDetailDTO createHojaDeVida(HojaDeVidaDetailDTO hoja) throws BusinessLogicException{
        return hoja;
    } 
    
    /**
     * <h1>GET /api/hojasdevida: Obtener todas las hojas de vida. </h1>
     * 
     * <pre> Busca y devuelve todas las ciudades que existen en la aplicación.
     * 
     * Códigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las ciudades de la aplicación. </code>
     * </pre>
     * @return JSONArray {@link HojaDeVidaDetailDTO} - Las hojas de vida encontradas en la aplicación. 
     */
    @GET
    public List<HojaDeVidaDetailDTO> getHojasDeVida(){
        return new ArrayList<>();
    }
    
    /**
     * <h1> GET /api/hojasdevida/{id} : Obtener hoja de vida por id de contratista. </h1>
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
     * @param id Id de la hoja de vida que se está buscando. Este debe ser una cadena de números.
     * @return JSON {@link HojaDeVidaDetailDTO} - La hoja de vida buscada.
     */
    @GET
    @Path("{id: \\d+}")
    public HojaDeVidaDetailDTO getHojaDeVida(@PathParam("id") Long id){
        return null;
    }
    
    /**
     * <h1>PUT /api/hojasdevida/{id} : Actualizar la hoja de vida con el id dado. <h1>
     * <pre>Cuerpo de petición: JSON {@link HojaDeVidaDetailDTO}.
     * 
     * Actualiza la hoja de vida con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     * 
     * Códigos de respuesta: 
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la hoja de vida con el id dadocon la información enviadacomo parámetro. Retorna un objeto idéntico.</code>
     *  404 Not Found. No existe una hoja de vida con el id dado.
     * </code> 
     * </pre>
     * @param id Id de la hoja de vida que se desea actualizar. Este debe ser una cadena de números.
     * @param hoja {@link HojaDeVidaDetailDTO} La hoja de vida que se desea guardar.
     * @return  JSON {@link HojaDeVidaDetailDTO} - La hoja de vida guardada.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera ya que no existe una hoja de vida con ese nombre. 
     */
    @PUT
    @Path("(id: \\d+)")
    public HojaDeVidaDetailDTO updateHojaDeVida(@PathParam("id") Long id,HojaDeVidaDetailDTO hoja)throws BusinessLogicException{
        return hoja;
    }
   
    /**
     * <h1>DELETE /api/cities/{id} : Borrar hoja de vida por el id. </h1>
     * 
     * <pre>Borra la hoja de vida con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta: <br>
     * 200 OK Elimina la hoja de vida correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una hoja de vida con el id dado.
     * </code>
     * </pre>
     * @param id Id de la hoja de vida que se desea borrar. Este debe ser una cadena de números.
     */
    @DELETE
    @Path("(id:\\d+)")
    public void deleteHojaDeVida(@PathParam("nombre") Long id){
        //Void
    }
}
