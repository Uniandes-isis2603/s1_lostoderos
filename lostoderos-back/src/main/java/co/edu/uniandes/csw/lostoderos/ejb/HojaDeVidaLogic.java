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
    private ContratistaPersistence contratistaPersistence;

    /**
     * Devuelve todas las hojas de vida que hay en la base de datos.
     *
     * @return Lista de entidades de tipo hoja de vida.
     */
    public List<HojaDeVidaEntity> getHojasDeVida() {
        LOGGER.info("Inicia proceso de consultar todas las hojas  de vida");
        List<HojaDeVidaEntity> hojasDeVida = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos las hojas de vida");
        return hojasDeVida;
    }

    /**
     * Se encarga de crear una hoja de vida en la base de datos
     *
     * @param contratistaId Identificador del Contratista que será padre de la
     * HojaDeVida.
     * @param entity Objeto de HojaDeVidaEntity con los datos nuevos.
     * @return
     * @throws BusinessLogicException
     */
    public HojaDeVidaEntity createHojaDeVida(Long contratistaId, HojaDeVidaEntity entity) throws BusinessLogicException {

        LOGGER.info("Inicia proceso de creación de hoja de vida");
        ContratistaEntity contratista = contratistaPersistence.find(contratistaId);
        if (contratista == null) {
            throw new BusinessLogicException("El contratista no existe");
        }
        //TODO: NO hay ninguna regla de negocio? 
        HojaDeVidaEntity resp = persistence.create(entity);
        LOGGER.info("Termina proceso de creación de hoja de vida");
        contratista.setHojaVida(entity);
        return resp;

    }

    /**
     * Obtiene la instancia de HojaDeVida de un contratista específico.
     *
     * @param contratistaId Identificador del COntratista.
     * @return Instancia de HojaDeVida del Contratista.
     * @throws BusinessLogicException Si el contratista no tiene hoja de vida.
     */
    public HojaDeVidaEntity getHojaDeVidaContratista(Long contratistaId) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de búsqueda de hoja de vida");
        ContratistaEntity contratista = contratistaPersistence.find(contratistaId);
        //TODO: QUé pasa si el contratista no existe? nullpointerexception
        HojaDeVidaEntity entity = contratista.getHojaVida();
        if (entity == null) {
            throw new BusinessLogicException("El contratista consultado no tiene hoja de vida.");
        }
        LOGGER.info("Termina proceso de búsqueda de hoja de vida");
        return entity;
    }

    /**
     *
     * Obtener una hojas de vida por medio de su id.
     *
     * @param id: id de la hoja de vida para ser buscada.
     * @return la hoja de vida asociada al contratista.
     */
    public HojaDeVidaEntity getHojaDeVida(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar hoja de vida con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        HojaDeVidaEntity hojaDeVida = persistence.find(id);
        if (hojaDeVida == null) {
            LOGGER.log(Level.INFO, "La hoja de vida con el id no existe");
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar hoja de vida con id={0}", id);
        return hojaDeVida;
    }

    /**
     *
     * Actualizar una hoja de vida.
     *
     * @param entity: hoja de vida con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return la hoja de vida con los cambios actualizados en la base de datos.
     */
    public HojaDeVidaEntity updateHojaDeVida(HojaDeVidaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una hoja de vida");
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        //TODO: NO hay ninguna regla de negocio? 
        HojaDeVidaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar hoja de vida");
        return newEntity;
    }

    /**
     * Borrar una hoja de vida.
     *
     * @param id: id de la hoja de vida a borrar
     *
     */
    public void deleteHojaDeVida(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una hoja de vida con id={0}", id);
        //TODO: qué pasa si no existe una hoja de vida con ese id?
        persistence.delete(id);
    }

}
