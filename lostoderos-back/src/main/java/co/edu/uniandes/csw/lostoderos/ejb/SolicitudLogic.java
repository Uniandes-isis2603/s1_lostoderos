/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.SolicitudPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.*;
import java.util.logging.Level;


/**
 *
 * @author m.saravia
 */

@Stateless
public class SolicitudLogic {
    
    	private static final Logger LOGGER = Logger.getLogger( SolicitudLogic.class.getName( ) );
        
        @Inject
        /**
         * variable que accede a la persistencia de la aplecacicion
         */
        private SolicitudPersistence persistence;
        
        /**
         * metodo que crea la entidad
         * @param entity entidad que se desea crear
         * @return la entidad creada
         * @throws BusinessLogicException excepcion si ya existe esa entidad
         */
        public SolicitudEntity create(SolicitudEntity entity)throws BusinessLogicException{
            
            LOGGER.info("Inicia el proceso de creación de una enidad de Solicitud");
            
            if(persistence.find(entity.getId()) != null)
                throw new BusinessLogicException("Ya existe una entidad de Solicitud con el id \"" + entity.getId( ) + "\"");
            
            persistence.create(entity);
            LOGGER.info("Creación exitosa");
            return entity;
        }
        
        /**
         * encuentra todas las entidades de Solicitud
         * @return entidades de solicitud
         */
        public List<SolicitudEntity> getAll(){
            
            LOGGER.info("Inicia proceso de consultar todas las entidades de Solicitud");
            
            List<SolicitudEntity> entities= persistence.findAll();
            LOGGER.info("Solicitud exitosa");
            return entities;
        }
        
        /**
         * Metodo que muestra la entidad con el id correspondido
         * @param id id que se desea consultar
         * @return Solicitud con el id correspondido
         */
        public SolicitudEntity getById(Long id){
            
            return persistence.find(id);
        }
        
        /**
         * actualiza la enidad deseada
         * @param entity entidad que se desea actualizar
         * @return la entidad actualizada
         * @throws BusinessLogicException sa hay otra entidad con ese id
         */
        public SolicitudEntity update(SolicitudEntity entity) throws BusinessLogicException{
            
            if(persistence.find(entity.getId()) != null)
                throw new BusinessLogicException("Ya existe una entidad de Solicitud con el id \""+entity.getId()+"\"");
            
            return persistence.update(entity);
        }
        
        /**
         * elimina la entidad deseada
         * @param entity entidad que se desea eliminar
         * @throws BusinessLogicException si no existe la entidad
         */
        public void delete(Long id) throws BusinessLogicException{
            
            LOGGER.log(Level.INFO, "inicia proceso de borrado de la entidad Solicitud con id={0}", id);
            persistence.delete(id);
            LOGGER.log(Level.INFO, "Termina el proceso de borrado de la entidad Solicitud con id={0}", id);
        }

    
}
