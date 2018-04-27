/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.HojaDeVidaEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.ContratistaPersistence;
import co.edu.uniandes.csw.lostoderos.persistence.HojaDeVidaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de Hoja
 * de vida.
 *
 * @author sa.yepes
 */
@Stateless
public class HojaDeVidaLogic {

    private static final Logger LOGGER = Logger.getLogger(HojaDeVidaLogic.class.getName());

    @Inject
    private HojaDeVidaPersistence persistence;

    @Inject
    private ContratistaLogic contratistaLogic;

    /**
     * Se encarga de crear una hoja de vida en la base de datos
     *
     * @param entity Objeto de HojaDeVidaEntity con los datos nuevos.
     * @param id_contratista Identificación del contratista.
     * @return
     * @throws BusinessLogicException
     */
    public HojaDeVidaEntity create(Long id_contratista, HojaDeVidaEntity entity) throws BusinessLogicException {

        LOGGER.info("Inicia proceso de creación de hoja de vida");

        ContratistaEntity contratista = contratistaLogic.getContratista(id_contratista);
        if (contratista == null) {
            throw new BusinessLogicException("El contratista que especificó no existe");
        }
        entity.setContratista(contratista);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de hoja de vida");
        return entity;

    }

    /**
     * Obtiene la instancia de HojaDeVida de un contratista específico.
     *
     * @param id_contratista Identificador del contratista.
     * @return Instancia de HojaDeVida del contratista.
     * @throws BusinessLogicException Si la hoja de vida no existe.
     */
    public HojaDeVidaEntity findByIdContratista(Long id_contratista) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de búsqueda de hoja de vida");
        HojaDeVidaEntity entity = contratistaLogic.getContratista(id_contratista).getHojaVida();
        LOGGER.info("Termina proceso de búsqueda de hoja de vida");
        return entity;
    }

    /**
     *
     * Actualizar una hoja de vida.
     *
     * @param id_contratista Identifcador del contratista.
     * @param entity: hoja de vida con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @throws BusinessLogicException Lanza excepción si no existe esa hoja de
     * vida
     * @return la hoja de vida con los cambios actualizados en la base de datos.
     */
    public HojaDeVidaEntity update(Long id_contratista, HojaDeVidaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una hoja de vida");
        //No existe ninguna regla de negocio para actualizar la hoja de vida.
        ContratistaEntity contratista = contratistaLogic.getContratista(id_contratista);
        if (contratista == null) {
            throw new BusinessLogicException("El contratista que especificó no existe");
        }
        if (contratista.getHojaVida() == null) {
            throw new BusinessLogicException("El contratista no cuenta con una hoja de vida. Cree primero la oja de vida para pdoer actualizarla.");
        }
        entity.setId(contratista.getHojaVida().getId());
        entity.setContratista(contratista);
        HojaDeVidaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar hoja de vida");
        return newEntity;
    }

    /**
     * Borrar una hoja de vida.
     *
     * @param id_contratista Identificador del contratista
     * @throws BusinessLogicException Lanza excepción si no existe una hoja de
     * vida para ese contratista
     */
    public void delete(Long id_contratista) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la hoja de vida de un contratista con id={0}", id_contratista);
        ContratistaEntity contratista = contratistaLogic.getContratista(id_contratista);
        if (contratista == null) {
            throw new BusinessLogicException("No existe un contratista con id: " + id_contratista);
        }
        HojaDeVidaEntity entity = contratista.getHojaVida();
        if (entity == null) {
            throw new BusinessLogicException("El contratista con id: " + id_contratista + " no tiene una hoja de vida");
        }
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar la hoja de vida de un contratista con id={0}", id_contratista);
    }

}
