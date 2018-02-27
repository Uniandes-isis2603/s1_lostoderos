/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
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
     *
     * Obtener todas las hojas de vida existentes en la base de datos.
     *
     * @return una lista de hojas de vida.
     */
    public List<ContratistaEntity> getHojasDeVida() {
        LOGGER.info("Inicia proceso de consultar todas las hojas de vida");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ContratistaEntity> contratistas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las hojas de vida");
        return contratistas;
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
    public void deletContratista(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una hoja de vida con id={0}", id);
        persistence.delete(id);    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
