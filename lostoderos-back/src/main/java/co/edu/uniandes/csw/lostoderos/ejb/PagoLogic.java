/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.BaseEntity;
import co.edu.uniandes.csw.lostoderos.entities.FacturaEntity;
import co.edu.uniandes.csw.lostoderos.entities.PagoEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.PagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author s.rangel
 */
@Stateless
public class PagoLogic {

    private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());

    /**
     * atributo que modela el pago en la BD
     */
    @Inject
    private PagoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject
    private FacturaLogic facturaLogic;

    /**
     * Crea un pago en la persistencia.
     *
     * @param entity La entidad que representa el pago a persistir.
     * @return La entiddad del pago luego de persistirla.
     */
    public PagoEntity create(PagoEntity entity, Long idFactura) throws BusinessLogicException {
        LOGGER.info("Inicio de creación de la entidad pago");
        FacturaEntity factura = facturaLogic.getFactura(idFactura);
        if (factura == null) {
            throw new BusinessLogicException("El factura que especificó no existe");

        }
        entity.setFactura(factura);
        persistence.create(entity);
        LOGGER.info("Creacion exitosa");
        return entity;
    }

    /**
     *
     * Obtener un pago por medio de su id.
     *
     * @param id: id del pago para ser buscada.
     * @return pago solicitado por medio de su id.
     */
    public PagoEntity getPagoFactura(Long id_factura) {
        LOGGER.info("Inicia proceso de búsqueda del pago");
        PagoEntity entity = facturaLogic.getFactura(id_factura).getPago();
        LOGGER.info("Termina proceso de búsqueda del pago");
        return entity;
    }

    /**
     *
     * Actualizar un pago.
     *
     * @param entity: pago con los cambios para ser actualizada, por ejemplo el
     * nombre.
     * @return pago con los cambios actualizados en la base de datos.
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    public PagoEntity update(Long id_factura, PagoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una hoja de vida");
        //No existe ninguna regla de negocio para actualizar la hoja de vida.
        FacturaEntity factura = facturaLogic.getFactura(id_factura);
        if (factura == null) {
            throw new BusinessLogicException("El contratista que especificó no existe");
        }
        if (factura.getPago() == null) {
            throw new BusinessLogicException("El contratista no cuenta con una hoja de vida. Cree primero la hoja de vida para pdoer actualizarla.");
        }
        entity.setId(factura.getPago().getId());
        entity.setFactura(factura);
        PagoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar hoja de vida");
        return newEntity;
    }

    /**
     * Borrar un Pago
     *
     * @param id: id del pago a borrar
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     * si no existe una entidad con ese id
     */
    public void deletePago(Long id_factura) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la hoja de vida de un contratista con id={0}", id_factura);
        FacturaEntity factura = facturaLogic.getFactura(id_factura);
        if (factura == null) {
            throw new BusinessLogicException("No existe un contratista con id: " + id_factura);
        }
        PagoEntity entity = factura.getPago();
        if (entity == null) {
            throw new BusinessLogicException("El contratista con id: " + id_factura + " no tiene una hoja de vida");
        }
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar la hoja de vida de un contratista con id={0}", id_factura);

    }

}
