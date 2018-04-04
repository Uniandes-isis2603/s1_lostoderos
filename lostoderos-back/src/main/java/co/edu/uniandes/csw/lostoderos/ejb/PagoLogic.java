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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author s.rangel
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
    public PagoEntity createPago(PagoEntity entity) throws BusinessLogicException, Exception {
        LOGGER.info("Inicio de creación de la entidad pago");
        //TODO: NO hay ninguna regla de negocio? 
        if (persistence.find(entity.getId())!=null) {
            throw new Exception("Ya existe el pago que se desea crear");

        }
        else{
                    persistence.create(entity);
        LOGGER.info("Creacion exitosa");

        }
        return entity;
    }
/**
     * consulta el pago con el id deseado
     * @param id identificador que se desea consultar
     * @return entidad con el id deseado
     */
    public PagoEntity getById(Long id){
        
        return persistence.find(id);
    }
    //TOD: debería haber getPagoBy algún concepto que permita filtar los pagos
    /**
     *
     * Obtener todos las pagos existentes en la base de datos.
     *
     * @return una lista de pagos.
     */
    public List<PagoEntity> getPagos() throws Exception {
        LOGGER.info("Inicia proceso de consultar todas los pagos");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<PagoEntity> pagos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas los pagos");
        if (pagos ==null) {
            throw new Exception("No hay pagos");
        }
        else
        {
                    return pagos;

        }
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
     * @param entity: pago con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return pago con los cambios actualizados en la base de datos.
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    public PagoEntity updatePago(PagoEntity entity) throws BusinessLogicException {
    
        return persistence.update(entity);
    }

    /**
     * Borrar un Pago
     *
     * @param id: id del pago a borrar
     */
    public void deletePago(Long id) throws Exception   {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar factura con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        //TODO: qué pasa si no hay un pago con ese id?
        if (persistence.find(id)== null) {
            throw new Exception("No existe el pago que se quiere borrar");
        }
        else
        {
                        persistence.delete(id);

        }
        

            LOGGER.log(Level.INFO, "Termina proceso de borrar factura con id=", id);
        }
    
}
