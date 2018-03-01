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
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.ContratistaPersistence;
import java.util.ArrayList;
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
    private HojaDeVidaLogic hojaVidaLogic;
    
    @Inject
    private SolicitudLogic solicitudLogic;
    
    @Inject
    private ServicioLogic servicioLogic;
    
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
    
    
    public ServicioEntity addServicio(Long servicioId,Long contratistaId){
        LOGGER.info("Inicia proceso de agregar un servicio al contratista");
        ContratistaEntity contratista = getContratista(contratistaId);
        ServicioEntity servicio = new ServicioEntity();
        servicio.setId(servicioId);
        contratista.getServicios().add(servicio);
        
        return getServicio(contratistaId, servicioId);
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
     *
     * @param id: id del contratista a borrar
 
     */
    public void deleteContratista(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una hoja de vida con id={0}", id);
        persistence.delete(id);    
    }
      
}
