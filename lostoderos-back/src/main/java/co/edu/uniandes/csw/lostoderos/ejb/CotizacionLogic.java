/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.CotizacionEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.CotizacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;
import co.edu.uniandes.csw.lostoderos.persistence.ContratistaPersistence;
import java.util.ArrayList;

/**
 *
 * @author m.saravia
 */
@Stateless
public class CotizacionLogic {
    
    private static final Logger LOGGER = Logger.getLogger(CotizacionLogic.class.getName());
    
    @Inject
    /**
     * atributo para acceder a la persistencia de la aplicacion. Es una inyeccion de dependencia
     */
    private CotizacionPersistence persistence;
    
    /**
     * atributo que modela la cotización en la base de datos
     */
    @Inject
    private ContratistaPersistence contratista;
    
    /**
     * metodo que crea la entidad de cotizacion
     * @param entity entidad que se desea crear
     * @return entidad creada
     * @throws BusinessLogicException si la entidad a crea ya existe
     */
    public CotizacionEntity create(CotizacionEntity entity)throws BusinessLogicException{
        
        LOGGER.info("Inicio de creación de la entidad Cotización");
        //TODO: NO hay ninguna regla de negocio?
        persistence.create(entity);
        LOGGER.info("Creacion exitosa");
        return entity;
    }
    
    /**
     * Consulta las entidades de cotizacion
     * @return las entidades de cotizacion
     */
    public List<CotizacionEntity> getAll(){
        
         LOGGER.info("Inicio de consulta de todas las entidades de Cotizacion");
         
         List<CotizacionEntity> entities= persistence.findAll();
         LOGGER.info("Consula exitosa");
         return entities;
    }
    
    /**
     * consulta la cotizacion con el id deseado
     * @param id identificador que se desea consultar
     * @return entidad con el id deseado
     */
    public CotizacionEntity getById(Long id){
        
        return persistence.find(id);
    }
    //TODO: Debería haber un getCotizacionByContratista
    
    /**
     * Obtiene las cotizaciones a partir del contratista deseado
     * @param idContratista id requerido para tener las cotizaciones
     * @return
     * @throws BusinessLogicException 
     */
   public List<CotizacionEntity> getCotizacionesByContratista(Long idContratista)throws BusinessLogicException{
       
        LOGGER.info("Inicia proceso de consultar todas las entidades de Cotizacion, a partir de un contratista");
       
       ContratistaEntity entity_1= contratista.find(idContratista);
       if( entity_1== null)
           throw new BusinessLogicException("No hay un contratista con ese id");
       
       List<SolicitudEntity> solicitudes= entity_1.getSolicitudes();

            List<CotizacionEntity> cotizaciones= new ArrayList<>();
            for(SolicitudEntity entity_2: solicitudes){
                CotizacionEntity cotizacion= entity_2.getCotizacion();
                cotizaciones.add(cotizacion);
       }
       return cotizaciones;

   }
    /**
     * Actualiza la entidad deseada
     * @param entity entidad que se desea actualizar
     * @return entidad actualizada
     * @throws BusinessLogicException si ya existe una entidad con el identificador
     */
    public CotizacionEntity update(CotizacionEntity entity)throws BusinessLogicException{
           //TODO: NO hay ninguna regla de negocio? 
           // TODO: que pasa si la contización que se quiere actualizar no existe
        CotizacionEntity entity_1= getById(entity.getId());
        if(entity_1 == null)
            throw new BusinessLogicException("No existe la cotizacion que se desea actualizar");
           
        return persistence.update(entity);
    }
    
    /**
     * elimina la entidad con el id asignado
     * @param id identificador de la entidad que se desea borrar
     * @throws BusinessLogicException si la entidad no existe
     */
    public void delete(Long id)throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia el proceso de borrado en la entidad de Cotizacion con id={0}", id);
           // TODO: que pasa si la contización que se quiere actualizar no existe
        
        CotizacionEntity entity= getById(id);
        if(entity == null)
            throw new BusinessLogicException("No hay una entidad de solicitud con ese ID");
           
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Borrado exitoso", id);
    }
}
