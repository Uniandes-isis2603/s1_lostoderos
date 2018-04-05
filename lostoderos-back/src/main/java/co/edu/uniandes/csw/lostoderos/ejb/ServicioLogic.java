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
    
    @Inject
    private ContratistaLogic contratistaLogic;
    
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
            throw new BusinessLogicException("Ya existe un servicio con el nombre: "+entity.getNombre());
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
    public ServicioEntity getById(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar servicio con id={0}", id);
        ServicioEntity servicio = persistence.find(id);
        if (servicio == null)
        {
            LOGGER.log(Level.SEVERE, "El servicio con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar contratista con id={0}", id);
        return servicio;
    }
    
    /**
     * consulta el servicio con el nombre deseado
     * @param nombre identificador que se desea consultar
     * @return entidad con el nombre deseado
     */
    public ServicioEntity getByNombre(String nombre)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar servicio con nombre ={0}", nombre);
        ServicioEntity servicio = persistence.findByNombre(nombre);
        if (servicio == null)
        {
            LOGGER.log(Level.SEVERE, "El servicio con el nombre={0} no existe", nombre);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar servicio con nombre={0}", nombre);
        return servicio;
    }
    
    /**
     * Actualiza la entidad deseada
     * @param entity entidad que se desea actualizar
     * @return entidad actualizada
     * @throws BusinessLogicException si ya existe una entidad con el identificador
     */
    public ServicioEntity update(ServicioEntity entity)throws BusinessLogicException{
        
        if(persistence.find(entity.getId()) == null)
        {
            throw new BusinessLogicException("No existe una entidad de Servicio con el id \""+entity.getId()+"\"");
        }
        return persistence.update(entity);
    }
    
    /**
     * elimina la entidad con el id asignado
     * @param id Identificador de la entidad que se desea borrar
     * @throws BusinessLogicException si la entidad no existe
     */
    public void delete(Long id)throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia el proceso de borrado en la entidad de Servicio con id={0}", id);
        if(persistence.find(id) == null)
        {
            throw new BusinessLogicException("No existe una entidad de servicio con el id \""+id+"\"");
        }
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Borrado exitoso", id);
    }
    
    /**
     * Obtiene una colección de instancias de ContratistaEntity asociadas a una
     * instancia de Servicio
     *
     * @param idServicio identifiacdor de la instancia de Servicio
     * @return Colección de instancias de ContratistaEntity asociadas a la instancia
     * de Servicio
     * 
     */
    public List<ContratistaEntity> listContratistas(Long idServicio) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los contratistas del servicio con id = {0}", idServicio);
        return getById(idServicio).getContratistas();
    }

    /**
     * Obtiene una instancia de ContratistaEntity asociada a una instancia de Servicio
     *
     * @param idServicio Identificador de la instancia de Servicio
     * @param contratistaId Identificador de la instancia de Contratista
     * @return La entidad del Contratista asociada al servicio
     */
    public ContratistaEntity getContratista(Long idServicio, Long contratistaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un contratista del servicio con id = {0}", idServicio);
        List<ContratistaEntity> list = getById(idServicio).getContratistas();
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
     * @param idServicio Identificador de la instancia de Servicio
     * @param contratistaId Identificador de la instancia de Contratista
     * @return Instancia de ContratistaEntity que fue asociada a Servicio
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     * 
     */
    public ContratistaEntity addContratista(Long idServicio, Long contratistaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un contratista al servicio con id = {0}", idServicio);
        ServicioEntity servicioEntity = getById(idServicio);
        ContratistaEntity contratistaEntity = contratistaLogic.getContratista(contratistaId);
        if(contratistaEntity == null)
        {
             throw new BusinessLogicException("No existe un contratista con el id: "+ contratistaId);
        }
        servicioEntity.getContratistas().add(contratistaEntity);
        return getContratista(idServicio, contratistaId);
    }

    /**
     * Remplaza las instancias de Contratista asociadas a una instancia de Servicio
     *
     * @param idServicio Identificador de la instancia de Servicio
     * @param list Colección de instancias de ContratistaEntity a asociar a instancia
     * de Servicio
     * @return Nueva colección de ContratistaEntity asociada a la instancia de Servicio
     * 
     */
    public List<ContratistaEntity> replaceContratistas(Long idServicio, List<ContratistaEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un contratista del servicio con nombre = {0}", idServicio);
        ServicioEntity servicioEntity = getById(idServicio);
        servicioEntity.setContratistas(list);
        return servicioEntity.getContratistas();
    }

    /**
     * Desasocia un Contratista existente de un Servicio existente
     *
     * @param idServicio Identificador de la instancia de Servicio
     * @param contratistaId Identificador de la instancia de Contratista
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     * 
     */
    public void removeContratista(Long idServicio, Long contratistaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un contratista del servicio con id = {0}", idServicio);
        ServicioEntity entity = getById(idServicio);
        ContratistaEntity contratistaEntity = contratistaLogic.getContratista(contratistaId);
        if(contratistaEntity == null)
        {
             throw new BusinessLogicException("No existe un contratista con el id: "+ contratistaId);
        }
        entity.getContratistas().remove(contratistaEntity);
    }
}
