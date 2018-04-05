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
     * @param clienteId id del cliente
     * @param contratistaId id del contratista
     * @return entidad creada
     * @throws BusinessLogicException si la entidad a crea ya existe
     */
    public CalificacionEntity create(CalificacionEntity entity)throws BusinessLogicException{
        
        LOGGER.info("Inicio de creación de la entidad Calificacion");
        if(entity.getCliente()== null){
            throw new BusinessLogicException("No existe un cliente asociado a la calificacion");
        }
        if(entity.getCliente().getId()== null){
            throw new BusinessLogicException("id del cliente invalido");
        }
        ClienteEntity cliente =clientePersistence.find(entity.getCliente().getId());
        if(cliente== null){
        throw new BusinessLogicException("El cliente no existe");
    }
// TODO: No hay ninguna regla de Negiocio?
        

        if(entity.getContratista()==null){
            throw new BusinessLogicException("No existe un contratista asociado a la calificacion");
        }
        if(entity.getContratista().getId()== null){
            throw new BusinessLogicException("id del contratista invalido");
        }
        ContratistaEntity contratista = contratistaPersistence.find(entity.getContratista().getId());
        if(contratista==null){
            throw new BusinessLogicException("El contratista no existe");
        }
        //cliente.getCalificaciones().add(entity);
        //clientePersistence.update(cliente);
        //contratista.getCalificaciones().add(entity);
        //contratistaPersistence.update(contratista);
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
    public CalificacionEntity update(CalificacionEntity entity, Long calificacionId)throws BusinessLogicException{
        
        if(persistence.find(calificacionId) == null)
            throw new BusinessLogicException("No existe una entidad de Calificacion con el id \""+entity.getId()+"\"");
        entity.setId(calificacionId);
        if(entity.getCliente()== null){
            throw new BusinessLogicException("No existe un cliente asociado a la calificacion");
        }
        if(entity.getCliente().getId()== null){
            throw new BusinessLogicException("id del cliente invalido");
        }
        if(clientePersistence.find(entity.getCliente().getId())== null){
        throw new BusinessLogicException("El cliente no existe");
    }
// TODO: No hay ninguna regla de Negiocio?

        if(entity.getContratista()==null){
            throw new BusinessLogicException("No existe un contratista asociado a la calificacion");
        }
        if(entity.getContratista().getId()== null){
            throw new BusinessLogicException("id del contratista invalido");
        }
        if(contratistaPersistence.find(entity.getContratista().getId())==null){
            throw new BusinessLogicException("El contratista no existe");
        }
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

    
    
    
    
    
    

