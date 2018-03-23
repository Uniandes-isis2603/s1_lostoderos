/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.ServicioPersistence;
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
public class ServicioLogic 
{
    private static final Logger LOGGER = Logger.getLogger(ServicioLogic.class.getName());
    
    @Inject
    /**
     * atributo para acceder a la persistencia de la aplicacion. Es una inyeccion de dependencia
     */
    private ServicioPersistence persistence;
    
    /**
     * metodo que crea la entidad de servicio
     * @param entity entidad que se desea crear
     * @return entidad creada
     * @throws BusinessLogicException si la entidad a crea ya existe
     */
    public ServicioEntity create(ServicioEntity entity)throws BusinessLogicException{
        
        LOGGER.info("Inicio de creación de la entidad Servicio");  
        ServicioEntity servicioEntity = persistence.findByNombre(entity.getNombre());
        if(servicioEntity != null)
        {
            throw new BusinessLogicException("Ya existe un servcio con el nombre: "+entity.getUsuario());
        }
        persistence.create(entity);
        LOGGER.info("Creacion exitosa");
        return entity;
    }
    
    /**
     *
     * Obtener todos los servicios existentes en la base de datos.
     *
     * @return una lista de servicios.
     */
    public List<ServicioEntity> getAll( ){
        
	LOGGER.info( "Inicia proceso de consultar todas las entidades de Servicio" );
	List<ServicioEntity> entities = persistence.findAll( );
	LOGGER.info( "Termina proceso de consultar todas las entidades de Servicio" );
	return entities;
    }
    
    /**
     * consulta el servicio con el id deseado
     * @param id identificador que se desea consultar
     * @return entidad con el id deseado
     */
    public ServicioEntity getById(Long id){
        
        return persistence.find(id);
    }
    
    /**
     * consulta el servicio con el nombre deseado
     * @param nombre identificador que se desea consultar
     * @return entidad con el nombre deseado
     */
    public ServicioEntity getByNombre(String nombre){
        
        return persistence.findByNombre(nombre);
    }
    
    /**
     * Actualiza la entidad deseada
     * @param entity entidad que se desea actualizar
     * @return entidad actualizada
     * @throws BusinessLogicException si ya existe una entidad con el identificador
     */
    public ServicioEntity update(ServicioEntity entity)throws BusinessLogicException{
        
        if(persistence.findByNombre(entity.getNombre()) == null)
        {
            throw new BusinessLogicException("No existe una entidad de Servicio con el nombre \""+entity.getNombre()+"\"");
        }
        return persistence.update(entity);
    }
    
    /**
     * elimina la entidad con el id asignado
     * @param nombre Nombre de la entidad que se desea borrar
     * @throws BusinessLogicException si la entidad no existe
     */
    public void delete(String nombre)throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia el proceso de borrado en la entidad de Servicio con nombre={0}", nombre);
        if(persistence.findByNombre(nombre) == null)
        {
            throw new BusinessLogicException("No existe una entidad de Usuario con el username \""+nombre+"\"");
        }
        persistence.delete(nombre);
        LOGGER.log(Level.INFO, "Borrado exitoso", nombre);
    }
    
    /**
     * Obtiene una colección de instancias de ContratistaEntity asociadas a una
     * instancia de Servicio
     *
     * @param nombreServicio nombre de la instancia de Servicio
     * @return Colección de instancias de ContratistaEntity asociadas a la instancia
     * de Servicio
     * 
     */
    public List<ContratistaEntity> listContratistas(String nombreServicio) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los contratistas del servicio con nombre = {0}", nombreServicio);
        return getByNombre(nombreServicio).getContratistas();
    }

    /**
     * Obtiene una instancia de ContratistaEntity asociada a una instancia de Servicio
     *
     * @param nombreServicio nombre de la instancia de Servicio
     * @param contratistaId Identificador de la instancia de Contratista
     * @return La entidad del Contratista asociada al servicio
     */
    public ContratistaEntity getContratista(String nombreServicio, Long contratistaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un contratista del servicio con nombre = {0}", nombreServicio);
        List<ContratistaEntity> list = getByNombre(nombreServicio).getContratistas();
        ContratistaEntity contratistaEntity = new ContratistaEntity();
        contratistaEntity.setId(contratistaId);
        int index = list.indexOf(contratistaEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia un Contratista existente a un Servicio
     *
     * @param nombreServicio nombre de la instancia de Servicio
     * @param contratistaId Identificador de la instancia de Contratista
     * @return Instancia de ContratistaEntity que fue asociada a Servicio
     * 
     */
    public ContratistaEntity addContratista(String nombreServicio, Long contratistaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un contratista al servicio con nombre = {0}", nombreServicio);
        ServicioEntity bookEntity = getByNombre(nombreServicio);
        ContratistaEntity contratistaEntity = new ContratistaEntity();
        contratistaEntity.setId(contratistaId);
        bookEntity.getContratistas().add(contratistaEntity);
        return getContratista(nombreServicio, contratistaId);
    }

    /**
     * Remplaza las instancias de Contratista asociadas a una instancia de Servicio
     *
     * @param nombreServicio nombre de la instancia de Servicio
     * @param list Colección de instancias de ContratistaEntity a asociar a instancia
     * de Servicio
     * @return Nueva colección de ContratistaEntity asociada a la instancia de Servicio
     * 
     */
    public List<ContratistaEntity> replaceContratistas(String nombreServicio, List<ContratistaEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un contratista del servicio con nombre = {0}", nombreServicio);
        ServicioEntity bookEntity = getByNombre(nombreServicio);
        bookEntity.setContratistas(list);
        return bookEntity.getContratistas();
    }

    /**
     * Desasocia un Contratista existente de un Servicio existente
     *
     * @param nombreServicio nombre de la instancia de Servicio
     * @param contratistaId Identificador de la instancia de Contratista
     * 
     */
    public void removeContratista(String nombreServicio, Long contratistaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un contratista del servicio con nombre = {0}", nombreServicio);
        ServicioEntity entity = getByNombre(nombreServicio);
        ContratistaEntity contratistaEntity = new ContratistaEntity();
        contratistaEntity.setId(contratistaId);
        entity.getContratistas().remove(contratistaEntity);
    }
}
