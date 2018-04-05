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
     * @param entity Objeto de HojaDeVidaEntity con los datos nuevos.
     * @return
     * @throws BusinessLogicException
     */
    public HojaDeVidaEntity createHojaDeVida( HojaDeVidaEntity entity) throws BusinessLogicException {

        LOGGER.info("Inicia proceso de creación de hoja de vida");
        if(entity.getContratista()==null) throw new BusinessLogicException("Debe especificar el contratista de la hoja de vida");
        if(entity.getContratista().getId()== null) throw new BusinessLogicException("El contratista que especificó debe tener id para comprobar que existe en la base de datos");
        ContratistaEntity contratista = contratistaPersistence.find(entity.getContratista().getId());
        if(contratista==null) throw new BusinessLogicException("El contratista que especificó no existe");
        persistence.create(entity);
        //entity.setContratista(contratista);
        LOGGER.info("Termina proceso de creación de hoja de vida");
        return entity;

    }

    /**
     * Obtiene la instancia de HojaDeVida de un contratista específico.
     *
     * @param id Identificador de la hoja de vida
     * @return Instancia de HojaDeVida del Contratista.
     * @throws BusinessLogicException Si la hoja de vida no existe.
     */
    public HojaDeVidaEntity getHojaDeVida(Long id) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de búsqueda de hoja de vida");
        HojaDeVidaEntity entity = persistence.find(id);
        System.out.println("PRUEBA SYSOUT: "+entity);
        LOGGER.info("Termina proceso de búsqueda de hoja de vida");
        return entity;
    }


    /**
     *
     * Actualizar una hoja de vida.
     *
     * @param id Identifcador de la hoja de vida.
     * @param entity: hoja de vida con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @throws BusinessLogicException Lanza excepción si no existe esa hoja de vida
     * @return la hoja de vida con los cambios actualizados en la base de datos.
     */
    public HojaDeVidaEntity updateHojaDeVida(Long id,HojaDeVidaEntity entity)throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una hoja de vida");
        //No existe ninguna regla de negocio para actualizar la hoja de vida.
        HojaDeVidaEntity newEntity = persistence.find(id);
        if(newEntity==null)throw new BusinessLogicException("No existe una hoja de vida con id: "+id);
        if(entity.getContratista()==null) throw new BusinessLogicException("Debe especificar el contratista de la hoja de vida");
        if(entity.getContratista().getId()== null) throw new BusinessLogicException("El contratista que especificó debe tener id para comprobar que existe en la base de datos");
        ContratistaEntity contratista = contratistaPersistence.find(entity.getContratista().getId());
        if(contratista==null) throw new BusinessLogicException("El contratista que especificó no existe");
        entity.setId(id);
        contratista.setHojaVida(entity);
        contratistaPersistence.update(contratista);
        entity.setContratista(contratista);
        newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar hoja de vida");
        return newEntity;
    }

    /**
     * Borrar una hoja de vida.
     * @param id Identificador de la hoja de vida.
     * @throws BusinessLogicException Lanza excepción si no existe una hoja de vida para ese contratista
     *
     */
    public void deleteHojaDeVida(Long id)throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una hoja de vida con id={0}", id);
        HojaDeVidaEntity entity = persistence.find(id);
        if(entity==null)throw new BusinessLogicException("No existe una hoja de vida con id: "+id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar una hoja de vida con id={0}", id);
    }

}
