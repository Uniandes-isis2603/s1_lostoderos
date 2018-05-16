/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.ClienteEntity;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.CotizacionEntity;
import co.edu.uniandes.csw.lostoderos.entities.FacturaEntity;
import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;
import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.ClientePersistence;
import co.edu.uniandes.csw.lostoderos.persistence.ContratistaPersistence;
import co.edu.uniandes.csw.lostoderos.persistence.CotizacionPersistence;
import co.edu.uniandes.csw.lostoderos.persistence.FacturaPersistence;
import co.edu.uniandes.csw.lostoderos.persistence.ServicioPersistence;
import co.edu.uniandes.csw.lostoderos.persistence.SolicitudPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.*;
import java.util.logging.Level;


/**
 *
 * @author m.saravia
 */

@Stateless
public class SolicitudLogic {
    
    	private static final Logger LOGGER = Logger.getLogger( SolicitudLogic.class.getName( ) );
        
        @Inject
        /**
         * variable que accede a la persistencia de la aplecacicion
         */
        private SolicitudPersistence persistence;
        
        /**
         * servicio que se persiste para la relación en al BD
         */
        @Inject
        private ServicioPersistence servicioPersistence;
        
        /**
         * cotización que se persiste para la relación en al BD
         */
        @Inject
        private CotizacionPersistence cotizacionPersistence;
        
        /**
         * factura que se persiste para la relación en al BD
         */
        @Inject
        private FacturaPersistence facturaPersistence;
        
        /**
         * contratista que se persiste para la relación en al BD
         */
        @Inject
        private ContratistaPersistence contratistaPersistence;
        
        /**
         * cliente que se persiste para la relación en al BD
         */
        @Inject
        private ClientePersistence clientePersistence;
        
        
        
        /**
         * 
         * @param entity entidad que se quiere persistir en la base de datos
         * @return entidad que fue persistida
         * @throws BusinessLogicException si no hay un cliente, servicio o contratista que le correspondan
         */
        public SolicitudEntity crearSolicitud(SolicitudEntity entity)throws BusinessLogicException{
            
            LOGGER.info("Inicia el proceso de creación de una entidad de Solicitud");
            
            ServicioEntity servicio= entity.getServicio();
            if(servicio == null){
                throw new BusinessLogicException("Servicio no encontrado");
            }
            if(servicio.getId()== null){
                throw new BusinessLogicException("id del servicio invalido");
            }
            ServicioEntity servicioP = servicioPersistence.find(servicio.getId());
            if(servicioP == null){
                throw new BusinessLogicException("el servicio no existe");
            }
            
            ClienteEntity cliente= entity.getCliente();
            if(cliente == null){
                throw new BusinessLogicException("cliente no encontrado");
            }
            if(cliente.getId()== null){
                throw new BusinessLogicException("id del cliente invalido");
            }
            ClienteEntity clienteP = clientePersistence.find(cliente.getId());
            if(clienteP == null){
                throw new BusinessLogicException("cliente no existe");
            }
            if(entity.getContratista() == null){
                if(servicioP.getContratistas().isEmpty()){
                    throw new BusinessLogicException("No existe un contratista disponible para la solicitud");
                }
                ContratistaEntity contratista = servicioP.getContratistas().get(0);
                entity.setContratista(contratista);
                contratista.setDisponibilidad(false);
            }
   
            return persistence.create(entity);
            }
 
        
        /**
         * encuentra todas las entidades de Solicitud
         * @return entidades de solicitud
         */
        public List<SolicitudEntity> getAll(){
            
            LOGGER.info("Inicia proceso de consultar todas las entidades de Solicitud");
            
            List<SolicitudEntity> entities= persistence.findAll();
            LOGGER.info("Solicitud exitosa");
            return entities;
        }
        
        /**
         * Metodo que muestra la entidad con el id correspondido
         * @param id id que se desea consultar
         * @return Solicitud con el id correspondido
         */
        public SolicitudEntity getById(Long id){
            
            return persistence.find(id);
        }
        
        /**
         * actualiza la enidad deseada
         * @param entity entidad que se desea actualizar
         * @return la entidad actualizada
         * @throws BusinessLogicException sa hay otra entidad con ese id
         */
        public SolicitudEntity update(SolicitudEntity entity) throws BusinessLogicException{
            
            if(persistence.find(entity.getId()) == null)
                throw new BusinessLogicException("No existe una Solicitud con el id \""+entity.getId()+"\"");
            //TODO: NO hay ninguna regla de negocio? 
            return persistence.update(entity);
        }
                
        /**
         * elimina la entidad deseada
         * @param id id de  entidad que se desea eliminar
         * @throws BusinessLogicException si no existe la entidad
         */
        public void delete(Long id) throws BusinessLogicException{
            
            LOGGER.log(Level.INFO, "inicia proceso de borrado de la entidad Solicitud con id={0}", id);
            //TODO: qué pasa si no existe una solicitud con ese id? done
            if(getById(id) == null) 
                throw new BusinessLogicException("No existe la solicitud que se desea borrar");
            persistence.delete(id);
            LOGGER.log(Level.INFO, "Termina el proceso de borrado de la entidad Solicitud con id={0}", id);
        }
        
        /**
         * 
         * @param cotizacion
         * @param solicitudId
         * @return
         * @throws BusinessLogicException 
         */
        public CotizacionEntity addCotizacion(Long cotizacionId, Long solicitudId) throws BusinessLogicException{
            
            LOGGER.log(Level.INFO, "Inicia el proceso de agregar una cotizacion a la entidad solicitud id = {0}", solicitudId);
            SolicitudEntity entity =getById(solicitudId);
            CotizacionEntity cotizacion= cotizacionPersistence.find(cotizacionId);
            if(entity == null)
                throw new BusinessLogicException("No existe esa solicitud");
            cotizacionPersistence.create(cotizacion);
            entity.setCotizacion(cotizacion);
            update(entity);
            return cotizacion;
        }
        
        /**
         * 
         * @param factura
         * @param solicitudId
         * @return
         * @throws BusinessLogicException 
         */
        public FacturaEntity addFactura(FacturaEntity factura, Long solicitudId)throws BusinessLogicException{
            
            LOGGER.log(Level.INFO, "Inicia el proceso de agregar una factura a la entidad solicitud id = {0}", solicitudId);
            SolicitudEntity entity= getById(solicitudId);
            if(entity == null)
                throw new BusinessLogicException("No existe esa solicitud");
            
            CotizacionEntity cotizacion= entity.getCotizacion();
            
            if(cotizacion== null)
                throw new BusinessLogicException("Para agregar una factura se necesita que haya una cotizacion");

            if(cotizacion.getValor() != factura.getSubtotal())
                factura.setSubtotal(cotizacion.getValor());
            
            facturaPersistence.create(factura);
            entity.setFactura(factura);
            update(entity);
            return factura;
        }
        
        

    
}
