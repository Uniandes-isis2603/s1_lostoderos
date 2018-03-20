/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;


import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.ContratistaPersistence;
import co.edu.uniandes.csw.lostoderos.persistence.ContratoPersistence;
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
public class ContratoLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ContratoLogic.class.getName());
    
    @Inject
    /**
     * atributo para acceder a la persistencia de la aplicacion. Es una inyeccion de dependencia
     */
    private ContratoPersistence persistence;
    
    @Inject
    private ContratistaPersistence contratistaPersistence;
    
    /**
     * metodo que crea la entidad de contrato
     * @param entity entidad que se desea crear
     * @param idContratista id del contratista
     * @return entidad creada
     * @throws BusinessLogicException si la entidad a crea ya existe
     */
    public ContratoEntity create(ContratoEntity entity, long idContratista)throws BusinessLogicException{
        
        LOGGER.info("Inicio de creación de la entidad Contrato");
        ContratistaEntity contratista = contratistaPersistence.find(idContratista);
            if(contratista==null){
            throw new BusinessLogicException("No existe un contratista con el id_ "+idContratista);
        }
        entity.setContratista(contratista);
        entity.setId(idContratista);
        ContratoEntity resp;
        if(persistence.find(idContratista)!=null){
            resp = persistence.update(entity);
        }
        else{
            resp = persistence.create(entity);
        }
        LOGGER.info("Termina proceso de asociación entre el contratista y la hoja de vida");
        LOGGER.info("Termina proceso de creación de hoja de vida");
        return resp;
    }
        /**
     * consulta el contrato con el id deseado
     * @param id identificador que se desea consultar
     * @return entidad con el id deseado
     */
    public ContratoEntity getByIdContratista(Long id) throws BusinessLogicException{
         LOGGER.info("Inicia proceso de búsqueda de contrato");
        ContratistaEntity contratista = contratistaPersistence.find(id);
        if(contratista==null){
            throw new BusinessLogicException("No existe un contratista con id: "+id);
        }
        ContratoEntity entity = persistence.find(id);
        
        if (entity == null) {
            throw new BusinessLogicException("El contratista con id: "+id+" no tiene contrato.");
        }
        LOGGER.info("Termina proceso de búsqueda de contrato");
        return entity;
    }
    
    
        /**
     * Devuelve todos los contratos que hay en la base de datos.
     * @return Lista de entidades de tipo contrato.
     */
    public List<ContratoEntity> getContratos() {
        LOGGER.info("Inicia proceso de consultar todos los contratos");
        List<ContratoEntity> contratos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los contratos");
        return contratos;
    }
    
    //TODO: Debería haber un getContratosByContratista
    /**
     * Actualiza la entidad deseada
     * @param entity entidad que se desea actualizar
     * @return entidad actualizada
     * @throws BusinessLogicException si ya existe una entidad con el identificador
     */
    public ContratoEntity update(Long idContratista, ContratoEntity entity)throws BusinessLogicException{
                LOGGER.log(Level.INFO, "Inicia proceso de actualizar un contrato");
        //No existe ninguna regla de negocio para actualizar la hoja de vida.
        if(persistence.find(idContratista)==null){
            throw new BusinessLogicException("No existe un contrato asociado a ese contratista con id: "+idContratista);
        }
        entity.setId(idContratista);
        entity.setContratista(contratistaPersistence.find(idContratista));
        ContratoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar contrato");
        return newEntity;
    }
    
    /**
     * elimina la entidad con el id asignado
     * @param id identificador de la entidad que se desea borrar
     */
    public void delete(Long idContratista) throws BusinessLogicException{
                LOGGER.log(Level.INFO, "Inicia proceso de borrar un contrato con id={0}", idContratista);
        if(persistence.find(idContratista)==null){
            throw new BusinessLogicException("No existe un contrato asociado a ese contratista con id: "+idContratista);
        }
        persistence.delete(idContratista);
        LOGGER.log(Level.INFO, "Termina proceso de borrar un contrato con id={0}", idContratista);
    } 
    }
    
 
