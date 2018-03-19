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
     * @param contratistaId id del contratista
     * @return entidad creada
     * @throws BusinessLogicException si la entidad a crea ya existe
     */
    public ContratoEntity create(ContratoEntity entity, long contratistaId)throws BusinessLogicException{
        
        LOGGER.info("Inicio de creación de la entidad Contrato");
        ContratistaEntity contratista = contratistaPersistence.find(contratistaId);
        entity.setContratista(contratista);
        //TODO: NO hay ninguna regla de negocio?
        persistence.create(entity);
        LOGGER.info("Creacion exitosa");
        return entity;
    }
    
        /**
     * consulta el contrato con el id deseado
     * @param id identificador que se desea consultar
     * @return entidad con el id deseado
     */
    public ContratoEntity getById(Long id){
        
        return persistence.find(id);
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
    public ContratoEntity update(ContratoEntity entity)throws BusinessLogicException{
        

        if(persistence.find(entity.getId()) == null)
            throw new BusinessLogicException("No existe una entidad de Contrato con el id \""+entity.getId()+"\"");
           //TODO: NO hay ninguna regla de negocio?
        return persistence.update(entity);
    }
    
    /**
     * elimina la entidad con el id asignado
     * @param id identificador de la entidad que se desea borrar
     */
    public void delete(Long id){
        
        LOGGER.log(Level.INFO, "Inicia el proceso de borrado en la entidad de Contrato con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Borrado exitoso", id);
    }
    
    
    
}
