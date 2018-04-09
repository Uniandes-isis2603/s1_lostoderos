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
    public ContratoEntity create(ContratoEntity entity)throws BusinessLogicException{
        
         LOGGER.info("Inicia proceso de creación de hoja de contrato");
        if (entity.getContratista() == null) {
            throw new BusinessLogicException("Debe especificar el contratista del contrato");
        }
        if (entity.getContratista().getId() == null) {
            throw new BusinessLogicException("El contratista que especificó debe tener id para comprobar que existe en la base de datos");
        }
        ContratistaEntity contratista = contratistaPersistence.find(entity.getContratista().getId());
        if (contratista == null) {
            throw new BusinessLogicException("El contratista que especificó no existe");
        }
                persistence.create(entity);
        contratista.setContrato(entity);
        LOGGER.info("Termina proceso de creación de contrato");
        return entity;
    }
        /**
     * consulta el contrato con el id deseado
     * @param id identificador que se desea consultar
     * @return entidad con el id deseado
     */
    public ContratoEntity getContrato(Long contratoId) throws BusinessLogicException{
         LOGGER.info("Inicia proceso de búsqueda de contrato");
        ContratoEntity contrato = persistence.find(contratoId);
        if(contrato==null){
            throw new BusinessLogicException("No existe un contrato con id: "+contratoId);
        }

        LOGGER.info("Termina proceso de búsqueda de contrato");
        return contrato;
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
    public ContratoEntity update(Long contratoId, ContratoEntity entity)throws BusinessLogicException{
        
                LOGGER.log(Level.INFO, "Inicia proceso de actualizar un contrato");
        ContratoEntity newEntity = persistence.find(contratoId);
        if (newEntity == null) {
            throw new BusinessLogicException("No existe un contrato con id: " + contratoId);
        }
        if (entity.getContratista() == null) {
            throw new BusinessLogicException("Debe especificar el contratista del contrato");
        }
        if (entity.getContratista().getId() == null) {
            throw new BusinessLogicException("El contratista que especificó debe tener id para comprobar que existe en la base de datos");
        }
        ContratistaEntity contratista = contratistaPersistence.find(entity.getContratista().getId());
        if (contratista == null) {
            throw new BusinessLogicException("El contratista que especificó no existe");
        }
        entity.setId(contratoId);
        contratista.setContrato(entity);
        contratistaPersistence.update(contratista);
        entity.setContratista(contratista);
        newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar contrato");
        return newEntity;
    }
    
    /**
     * elimina la entidad con el id asignado
     * @param id identificador de la entidad que se desea borrar
     */
    public void delete(Long contratoId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un contrato con id={0}", contratoId);

        if(persistence.find(contratoId)==null){
            throw new BusinessLogicException("No existe un contrato con id: "+contratoId);
        }
        
        persistence.delete(contratoId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar un contrato con id={0}", contratoId);
    } 
    }
    
 
