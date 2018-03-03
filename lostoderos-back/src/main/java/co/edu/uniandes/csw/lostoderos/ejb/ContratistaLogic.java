/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.CalificacionEntity;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.HojaDeVidaEntity;
import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;
import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.ContratistaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de Contratista.
 * @author sa.yepes
 */
@Stateless
public class ContratistaLogic {
    private static final Logger LOGGER = Logger.getLogger(HojaDeVidaLogic.class.getName());
 
    @Inject
    private ContratistaPersistence persistence;
    
    @Inject
    private SolicitudLogic solicitudLogic;
    
    @Inject
    private CalificacionLogic calificacionLogic;
    
    @Inject
    private ContratoLogic contratoLogic;
    
    /**
     * Crea un contratista en la persistencia.
     * @param entity la entidad que representa el contratista.
     * @return La entidad del contratista luego de persistirla.
     * @throws BusinessLogicException Si el contratista a persistir ya existe.
     */
    public ContratistaEntity createContratista(ContratistaEntity entity)throws BusinessLogicException{
         LOGGER.info("Inicia proceso de creación de hoja de vida");
        // Invoca la persistencia para crear la hoja de vida
        
        LOGGER.info("Termina proceso de creación de hoja de vida");
        return persistence.create(entity);
    }
    
     /**
     * Obtener todos los contratistas en la base de datos.
     *
     * @return una lista de contratistas.
     */
    public List<ContratistaEntity> getContratistas() {
        LOGGER.info("Inicia proceso de consultar todos los contratistas");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ContratistaEntity> contratistas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los contratistas");
        return contratistas;
    }
    
    /**
     * Obtiene una colección de instancias de ServicioEntity asociadas a una
     * instancia de Contratista.
     * @param id Identificador de la instancia de Contratista
     * @return Colección de instancias de ServicioEntity asociadas a las
     * instancias de Contratista
     */
    public List<ServicioEntity> listServicios(Long id){
        
        LOGGER.info("Inicia proceso de consultar todos los servicios del contratista");
        List<ServicioEntity> list = getContratista(id).getServicios();
        LOGGER.info("Termina proceso de consultar todos los servicios del contratista");
        return list;
    }
   
    /**
     * Obtiene una instanciación de ServicioEntity asociada a una instancia de
     * Contratista.
     * @param contratistaId Identificador del contratista.
     * @param servicioId Identificador de la instancia de Servicio.
     * @return  La entidad del servicio asociada al contratista.
     */
    public ServicioEntity getServicio(Long contratistaId, Long servicioId){
        LOGGER.info("Inicia proceso de consultar un servicio del contratista");
        List<ServicioEntity> list = getContratista(contratistaId).getServicios();
        ServicioEntity servicioEntity = new ServicioEntity();
        servicioEntity.setId(servicioId);
        int index = list.indexOf(servicioEntity);
        if(index>0){
            LOGGER.info("Termina proceso de consultar un servicio del contratista");
            return list.get(index);
        }
        return null;
    }
    
    
    /**
     * Asocia un Servicio exisente a un Contratista
     * @param servicioId Identificador de la instancia Servicio.
     * @param contratistaId Identificador de la instancia Contratista.
     * @return Instancia de Servicio que fue asociada a Contratista.
     */
    public ServicioEntity addServicio(Long servicioId,Long contratistaId){
        LOGGER.info("Inicia proceso de agregar un servicio al contratista");
        ContratistaEntity contratista = getContratista(contratistaId);
        ServicioEntity servicio = new ServicioEntity();
        servicio.setId(servicioId);
        contratista.getServicios().add(servicio);
        LOGGER.info("Termina proceso de agregar un servicio al contratista");

        return getServicio(contratistaId, servicioId);
    }
    
    /**
     * Desasocia un Servicio existente de un Contratista existente.
     * @param servicioId Identificador de la instancia Servicio.
     * @param contratistaId  Identificador de la instancia Contratista.
     */
    public void removeServicio(Long servicioId,Long contratistaId){
        LOGGER.info("Inicia proceso de remover un servicio al contratista");
        ContratistaEntity entity = getContratista(contratistaId);
        ServicioEntity servicio = new ServicioEntity();
        servicio.setId(servicioId);
        entity.getServicios().remove(servicio);
        LOGGER.info("Termina proceso de agregar un servicio al contratista");
    }
    
    
    
    /**
     * contratista por medio de su id.
     *
     * @param id: id del contratista para ser buscado.
     * @return el contratista solicitado por medio de su id.
     */
    public ContratistaEntity getContratista(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar contratista con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        ContratistaEntity contratista = persistence.find(id);
        if (contratista == null) {
            LOGGER.log(Level.SEVERE, "El contratista con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar contratista con id={0}", id);
        return contratista;
    } 
    /**
     *
     * Actualizar un contratista.
     *
     * @param id: id del contratista para buscarlo en la base de datos.
     * @param entity: contratista con los cambios para ser actualizado, por
     * ejemplo el nombre.
     * @return el contratista con los cambios actualizados en la base de datos.
     */
    public ContratistaEntity updateContratista(Long id, ContratistaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un contratista con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        ContratistaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar contratista con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Borrar un contratista.
     * @param id: id del contratista a borrar
 
     */
    public void deleteContratista(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una hoja de vida con id={0}", id);
        persistence.delete(id);    
    }
    
    
    /**
     * Agrega una Solicitud a un Contratista.
     * @param solicitudId Identificador de la Solicitud.
     * @param contratistaId Identificador del Contratista.
     * @return La Solicitud que fue asociada al Contratista.
     */
    public SolicitudEntity addSolicitud(Long solicitudId,Long contratistaId){
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una solicitud a un contratista");
        ContratistaEntity contratista = getContratista(contratistaId);
        SolicitudEntity solicitud = solicitudLogic.getById(solicitudId);
        solicitud.setContratista(contratista);
        LOGGER.log(Level.INFO, "Termina proceso de asociar una solicitud a un contratista");
       return solicitud;
    }
    
    /**
     * Desasocia una Solicitud a un Contratista.
     * @param solicitudId Identificador de la Solicitud
     * @param contratistaId Identificador del Contratista.
     */
    public void removeSolicitud(Long solicitudId, Long contratistaId){
        LOGGER.log(Level.INFO, "Inicia proceso de desasociar una solicitud a un contratista");
        ContratistaEntity contratista = getContratista(contratistaId);
        SolicitudEntity solicitud = solicitudLogic.getById(solicitudId);
        solicitud.setContratista(contratista);
        contratista.getSolicitudes().remove(solicitud);
        LOGGER.log(Level.INFO, "Termina proceso de desasociar una solicitud a un contratista");
    }
   
    /**
     * Reemplazar las solicitudes de un Contratista.
     * @param contratistaId Identificador del Contratista.
     * @param solicitudes Lista de solicitudes que se queire actualizar.
     * @return La lista de solicitudes actualizada
     */
    public List<SolicitudEntity> replaceSolicitudes(Long contratistaId,List<SolicitudEntity> solicitudes){
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar las solicitudes de un contratista por otras");
        ContratistaEntity contratista = getContratista(contratistaId);
        List<SolicitudEntity> list = solicitudLogic.getAll();
        for(SolicitudEntity solicitud:list){
            if(solicitudes.contains(solicitud)) solicitud.setContratista(contratista);
            else if(solicitud.getContratista()!= null && solicitud.getContratista().equals(contratista))
                solicitud.setContratista(null);
        }
        LOGGER.log(Level.INFO, "Termina proceso de reemplazar las solicitudes de un contratista por otras");
        return solicitudes;
    }
    
    /**
     * Retorna todas las solicitudes de un Contratista.
     * @param contratistaId Identificador del Contratista.
     * @return Lista de las solicitudes asociadas a un Contratista.
     */
    public List<SolicitudEntity> getSolicitudes(Long contratistaId){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar las solicitudes de un contratistas");
        List<SolicitudEntity> resp = getContratista(contratistaId).getSolicitudes();
        LOGGER.log(Level.INFO, "Termina proceso de consultar las solicitudes de un contratistas");
        return resp;
    }
    
    /**
     * Retorna un Servicio asociada a un Contratista.
     * @param solicitudId Identificador del Servicio.
     * @param contratistaId Identificador del Contratista.
     * @return La solicitud asociada a un Contratista.
     * @throws BusinessLogicException Si la solicitud no se encuentra en el Contratista.
     */
    public SolicitudEntity getSolicitud(Long solicitudId,Long contratistaId)throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una solicitud de un contratistas");
        List<SolicitudEntity> solicitudes = getSolicitudes(contratistaId);
        SolicitudEntity solicitud = solicitudLogic.getById(solicitudId);
        int index = solicitudes.indexOf(solicitud);
        LOGGER.log(Level.INFO, "Termina proceso de consultar una solicitud de un contratistas");        
        if(index>=0){
            return solicitudes.get(index);
        }
        throw new BusinessLogicException("La solicitud no está asociada al contratista");
    }
      
}
