/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.CalificacionEntity;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.ClienteEntity;

import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.CalificacionPersistence;
import co.edu.uniandes.csw.lostoderos.persistence.ClientePersistence;
import co.edu.uniandes.csw.lostoderos.persistence.ContratistaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author s.blancoc
 */
@Stateless
public class CalificacionLogic {
    //TODO: Cambiar el nombre de la clase
    private static final Logger LOGGER = Logger.getLogger(ContratoLogic.class.getName());
    
    @Inject
    /**
     * atributo para acceder a la persistencia de la aplicacion. Es una inyeccion de dependencia
     */
    private CalificacionPersistence persistence;
    
    @Inject
    private ContratistaPersistence contratistaPersistence;
    
    @Inject
    private ClientePersistence clientePersistence;
    
    /**
     * metodo que crea la entidad de calificacion
     * @param entity entidad que se desea crear
     * @param clienteid id del cliente
     * @param contratistaid id del contratista
     * @return entidad creada
     * @throws BusinessLogicException si la entidad a crea ya existe
     */
    public CalificacionEntity create(CalificacionEntity entity, long clienteid, long contratistaid)throws BusinessLogicException{
        
        LOGGER.info("Inicio de creación de la entidad Calificacion");
// TODO: No hay ninguna regla de Negiocio?
        ClienteEntity cliente = clientePersistence.find(clienteid);
        entity.setCliente(cliente);
        
        ContratistaEntity contratista = contratistaPersistence.find(contratistaid);
        entity.setContratista(contratista);
        
        return persistence.create(entity);
    }
    
        /**
     * consulta la calificacion con el id deseado
     * @param id identificador que se desea consultar
     * @return entidad con el id deseado
     */
    public CalificacionEntity getById(Long id){
        
        return persistence.find(id);
    }
    
    /**
     * Actualiza la entidad deseada
     * @param entity entidad que se desea actualizar
     * @return entidad actualizada
     * @throws BusinessLogicException si ya existe una entidad con el identificador
     */
    public CalificacionEntity update(CalificacionEntity entity)throws BusinessLogicException{
        
        if(persistence.find(entity.getId()) == null)
            throw new BusinessLogicException("No existe una entidad de Calificacion con el id \""+entity.getId()+"\"");
        // TODO: Antes de actualizar validar las reglas de negocio
        return persistence.update(entity);
    }
    //TODO: ACtualizar la documentación
    /**
     * elimina la entidad con el id asignado
     * @param id identificador de la entidad que se desea borrar
     * @throws BusinessLogicException si la entidad no existe
     */
    public void delete(Long id){
        
        LOGGER.log(Level.INFO, "Inicia el proceso de borrado en la entidad de Calificacion con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Borrado exitoso", id);
    }

           /**
     * Devuelve todos las calificaciones que hay en la base de datos.
     * @return Lista de entidades de tipo calificacion.
     */
    public List<CalificacionEntity> getCalificaciones() {
        LOGGER.info("Inicia proceso de consultar todos las calificaciones");
        List<CalificacionEntity> calificaciones = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los calificaciones");
        return calificaciones;
    }
    
}

    
    
    
    
    
    

