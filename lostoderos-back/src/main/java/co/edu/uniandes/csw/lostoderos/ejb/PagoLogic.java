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

import co.edu.uniandes.csw.lostoderos.entities.PagoEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.PagoPersistence;
import java.util.logging.Logger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Santiago
 */
@Stateless

public class PagoLogic {
    private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());

    @Inject
    private PagoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

      /**
     * Crea un pago en la persistencia.
     * @param entity La entidad que representa el pago a persistir.
     * @return La entiddad del pago luego de persistirla.
     * @throws BusinessLogicException Si el pago a persistir ya existe.
     */
    public PagoEntity createPago(PagoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de pago");
        // Verifica la regla de negocio que dice que no puede haber dos facturas con el mismo nombre
        if (persistence.findByName(entity.getName()) != null) {
            throw new BusinessLogicException("Ya existe un pago con el nombre \"" + entity.getName() + "\"");
        }
        // Invoca la persistencia para crear la factura

        LOGGER.info("Termina proceso de creación de pago");
        return persistence.create(entity);
    }

    /**
     *
     * Obtener todos las pagos existentes en la base de datos.
     *
     * @return una lista de pagos.
     */
    public List<PagoEntity> getPagos() {
        LOGGER.info("Inicia proceso de consultar todas los pagos");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<PagoEntity> pagos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas los pagos");
        return pagos;
    }

    /**
     *
     * Obtener un pago por medio de su id.
     *
     * @param id: id del pago para ser buscada.
     * @return pago solicitado por medio de su id.
     */
    public PagoEntity getPago(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar pago con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        PagoEntity pago = persistence.find(id);
        if (pago == null) {
            LOGGER.log(Level.SEVERE, "El pago con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar pago con id={0}", id);
        return pago;
    }

    /**
     *
     * Actualizar un pago.
     *
     * @param id: id del pago para buscarla en la base de datos.
     * @param entity: pago con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return pago con los cambios actualizados en la base de datos.
     */
    public PagoEntity updatePago(Long id, PagoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar pago con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
         PagoEntity pago = persistence.find(id);
         if (pago == null) {    
            LOGGER.log(Level.SEVERE, "El pago con el id {0} no existe", id);
        }
        PagoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar pago con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un Pago
     *
     * @param id: id del pago a borrar
     */
    public void deletePago(Long id)   {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar factura con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
            persistence.delete(id);

            LOGGER.log(Level.INFO, "Termina proceso de borrar factura con id={0}", id);
        }
    
}
