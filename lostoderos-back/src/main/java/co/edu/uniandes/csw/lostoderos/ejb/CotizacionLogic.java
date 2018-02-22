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
     * metodo que crea la entidad de cotizacion
     * @param entity entidad que se desea crear
     * @return entidad creada
     * @throws BusinessLogicException si la entidad a crea ya existe
     */
    public CotizacionEntity create(CotizacionEntity entity)throws BusinessLogicException{
        
        LOGGER.info("Inicio de creación de la entidad Cotización");
        if(persistence.find(entity.getId()) != null)
            throw new BusinessLogicException("Ya existe una entidad de Cotizacion con el id \""+entity.getId()+"\"");
        
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
    
    /**
     * Actualiza la entidad deseada
     * @param entity entidad que se desea actualizar
     * @return entidad actualizada
     * @throws BusinessLogicException si ya existe una entidad con el identificador
     */
    public CotizacionEntity update(CotizacionEntity entity)throws BusinessLogicException{
        
        if(persistence.find(entity.getId()) != null)
            throw new BusinessLogicException("Ya existe una entidad de Cotizacion con el id \""+entity.getId()+"\"");
        
        return persistence.update(entity);
    }
    
    /**
     * elimina la entidad con el id asignado
     * @param id identificador de la entidad que se desea borrar
     * @throws BusinessLogicException si la entidad no existe
     */
    public void delete(Long id)throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia el proceso de borrado en la entidad de Cotizacion con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Borrado exitoso", id);
    }
}
