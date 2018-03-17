/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.UsuarioEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.UsuarioPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author s.naranjop1
 */
@Stateless
public class UsuarioLogic 
{
    private static final Logger LOGGER = Logger.getLogger(UsuarioLogic.class.getName());
    
    @Inject
    /**
     * atributo para acceder a la persistencia de la aplicacion. Es una inyeccion de dependencia
     */
    private UsuarioPersistence persistence;
    
    /**
     * metodo que crea la entidad de cotizacion
     * @param entity entidad que se desea crear
     * @return entidad creada
     * @throws BusinessLogicException si la entidad a crea ya existe
     */
    public UsuarioEntity create(UsuarioEntity entity)throws BusinessLogicException{
        
        LOGGER.info("Inicio de creación de la entidad Cotización");
        //TODO: NO hay ninguna regla de negocio? 
        persistence.create(entity);
        LOGGER.info("Creacion exitosa");
        return entity;
    }
    
    /**
     *
     * Obtener todos los usuarios existentes en la base de datos.
     *
     * @return una lista de usuarios.
     */
    public List<UsuarioEntity> getAll( ){
        
	LOGGER.info( "Inicia proceso de consultar todas las entidades de Todero" );
	List<UsuarioEntity> entities = persistence.findAll( );
	LOGGER.info( "Termina proceso de consultar todas las entidades de Todero" );
	return entities;
    }
    
    /**
     * consulta el usuario con el id deseado
     * @param id identificador que se desea consultar
     * @return entidad con el id deseado
     */
    public UsuarioEntity getById(Long id){
        
        return persistence.find(id);
    }
    
    /**
     * Actualiza la entidad deseada
     * @param entity entidad que se desea actualizar
     * @return entidad actualizada
     * @throws BusinessLogicException si ya existe una entidad con el identificador
     */
    public UsuarioEntity update(UsuarioEntity entity)throws BusinessLogicException{
        
        if(persistence.find(entity.getId()) == null)
            throw new BusinessLogicException("No existe una entidad de Usuario con el id \""+entity.getId()+"\"");
        //TODO: NO hay ninguna regla de negocio? 
        return persistence.update(entity);
    }
    
    /**
     * elimina la entidad con el id asignado
     * @param id identificador de la entidad que se desea borrar
     * @throws BusinessLogicException si la entidad no existe
     */
    public void delete(Long id)throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia el proceso de borrado en la entidad de Usuario con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Borrado exitoso", id);
    }    
}
