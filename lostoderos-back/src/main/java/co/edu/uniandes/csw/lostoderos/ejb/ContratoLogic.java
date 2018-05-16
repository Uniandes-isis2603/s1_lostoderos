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
     * atributo para acceder a la persistencia de la aplicacion. Es una
     * inyeccion de dependencia
     */
    private ContratoPersistence persistence;

    /**
     * atributo que modela el contratista en la BD
     */
    @Inject
    private ContratistaPersistence contratistaLogic;

    /**
     * metodo que crea la entidad de contrato
     *
     * @param entity entidad que se desea crear
     * @param id_contratista id del contratista
     * @return entidad creada
     * @throws BusinessLogicException si la entidad a crea ya existe
     */
    public ContratoEntity create(Long id_contratista, ContratoEntity entity) throws BusinessLogicException {

        LOGGER.info("Inicia proceso de creación de hoja de contrato");
        ContratistaEntity contratista = contratistaLogic.find(id_contratista);
        if (contratista == null) {
            throw new BusinessLogicException("El contratista que especificó no existe");
        }
        
        entity.setContratista(contratista);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de contrato");
        return entity;
    }

    /**
     * consulta el contrato con el id deseado
     *
     * @param id_contratista identificador que se desea consultar
     * @return entidad con el id deseado
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     * Lanza excepción si no existe el contratista
     */
    public ContratoEntity getContrato(Long id_contratista) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de búsqueda de contrato");
        ContratistaEntity contratista = contratistaLogic.find(id_contratista);
        if (contratista == null) {
            throw new BusinessLogicException("No existe un contratista con id: " + id_contratista);
        }
        LOGGER.info("Termina proceso de búsqueda de contrato");
        return contratista.getContrato();
    }

    //TODO: Debería haber un getContratosByContratista
    /**
     * Actualiza la entidad deseada
     *
     * @param id_contratista Identificador del contratista.
     * @param entity entidad que se desea actualizar
     * @return entidad actualizada
     * @throws BusinessLogicException si ya existe una entidad con el
     * identificador
     */
    public ContratoEntity update(Long id_contratista, ContratoEntity entity) throws BusinessLogicException {

        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un contrato");
        ContratistaEntity contratista = contratistaLogic.find(id_contratista);
        if (contratista == null) {
            throw new BusinessLogicException("No existe un contratista con id: " + id_contratista);
        }
        if (contratista.getContrato() == null) {
            throw new BusinessLogicException("El contratista con id: " + id_contratista + " no tiene un contrato asociado. Intente crear el contrato primero.");
        }
        entity.setId(contratista.getContrato().getId());
        entity.setContratista(contratista);
        ContratoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar contrato");
        return newEntity;
    }

    /**
     * elimina la entidad con el id asignado
     *
     * @param id_contratista identificador del contratista.
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     * Lanza excepción si no existe el contratista.
     */
    public void delete(Long id_contratista) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un contrato");
        ContratistaEntity contratista = contratistaLogic.find(id_contratista);
        if (contratista == null) {
            throw new BusinessLogicException("No existe un contratista con id: " + id_contratista);
        }
        ContratoEntity contrato = contratista.getContrato();
        if (contrato == null) {
            throw new BusinessLogicException("el contratista con id: " + id_contratista + " no tiene un contrato.");
        }
        persistence.delete(contrato.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar un contrato");
    }
}
