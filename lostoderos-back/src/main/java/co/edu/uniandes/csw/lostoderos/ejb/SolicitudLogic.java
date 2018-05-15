/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.CalificacionEntity;
import co.edu.uniandes.csw.lostoderos.entities.ClienteEntity;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.CotizacionEntity;
import co.edu.uniandes.csw.lostoderos.entities.FacturaEntity;
import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;
import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.CalificacionPersistence;
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
        
        @Inject
        private ServicioPersistence servicioPersistence;
        
        @Inject
        private CotizacionPersistence cotizacionPersistence;
        
        @Inject
        private FacturaPersistence facturaPersistence;
        
        @Inject
        private ContratistaPersistence contratistaPersistence;
        
        @Inject
        private ClientePersistence clientePersistence;
        
        @Inject
        private CalificacionPersistence calificacionPersistence;
        
        /**
         * 
         * @param entity
         * @param servicioId
         * @param clienteId
         * @param cotizacionId
         * @param facturaId
         * @param calificacionId
         * @param contratistaId
         * @return
         * @throws BusinessLogicException 
         */
        /*public SolicitudEntity create(SolicitudEntity entity, Long servicioId, Long clienteId, Long cotizacionId,
        Long facturaId, Long calificacionId, Long contratistaId)throws BusinessLogicException{
            
            LOGGER.info("Inicia el proceso de creación de una enidad de Solicitud");
            
            ServicioEntity servicio=servicioPersistence.find(servicioId);
            if(servicio == null )
                throw new BusinessLogicException("No existe el servicio que se requiere");
            else
                entity.setServicio(servicio);
            
            ClienteEntity cliente = clientePersistence.find(clienteId);
            if(cliente== null)
                throw new BusinessLogicException("No existe un cliente con el id dado");
            else
                entity.setCliente(cliente);
            
            ContratistaEntity contratista= contratistaPersistence.find(contratistaId);
            if(contratista==null)
                throw new BusinessLogicException("No existe un contratista con e id especificado");
            else
                entity.setContratista(contratista);
            
            CotizacionEntity cotizacion= cotizacionPersistence.find(cotizacionId);
            if(cotizacion== null)
                throw new BusinessLogicException("No existe una cotizacion con ese id");
            else
                entity.setCotizacion(cotizacion);
            
            FacturaEntity factura= facturaPersistence.find(facturaId);
            if(factura==null)
                throw new BusinessLogicException("No existe una factura con el i dado");
            else
                entity.setFactura(factura);
            
            CalificacionEntity calificacion= calificacionPersistence.find(calificacionId);
            if(calificacion==null)
                throw new BusinessLogicException("No existe una calificacion con el id dado");
            else
                entity.setCalificacion(calificacion);
            
            
            persistence.create(entity);
            LOGGER.info("Creación exitosa");
            return entity;
        }*/
        
        /**
         * 
         * @param entity
         * @return
         * @throws BusinessLogicException 
         */
        public SolicitudEntity crearSolicitud(SolicitudEntity entity)throws BusinessLogicException{
            
            LOGGER.info("Inicia el proceso de creación de una entidad de Solicitud");
            
            ServicioEntity servicio= entity.getServicio();
            ContratistaEntity contratista= entity.getContratista();
            ClienteEntity cliente= entity.getCliente();
            
//            if(servicio  == null && entity.getTipo_servicio()== null)
//                throw new BusinessLogicException("Debe especificar un servicio en la entidad");
            if(servicio == null){
                Long id= entity.getTipo_servicio().longValue();
                ServicioEntity nuevo= servicioPersistence.find(id);
                entity.setServicio(nuevo);
                crearSolicitud(entity);
            }
            if(servicioPersistence.find(servicio.getId())== null){
                servicioPersistence.create(servicio);
            }
            
            
            
            
            
            /*if(factura == null)
                throw new BusinessLogicException("Debe especificar la entidad");
            facturaPersistence.create(factura);
            
            if(cotizacion == null)
                throw new BusinessLogicException("Debe especificar la entidad");
            cotizacionPersistence.create(cotizacion);*/
            
            if(contratista == null)
                throw new BusinessLogicException("Debe especificar un contrtista");
            if(contratistaPersistence.find(contratista.getId()) == null)
                throw new BusinessLogicException("Debe existir una entidad de contratista en la base de datos");
            
            if(cliente == null)
                throw  new BusinessLogicException("Debe especifica el cliente");
            if(clientePersistence.find(cliente.getId()) == null)
                throw new BusinessLogicException("debe existir el cliente en la base de datos");
            
            persistence.create(entity);
            LOGGER.info("Creación exitosa");
            return entity;
            
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
         * @param entity entidad que se desea eliminar
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
        public CotizacionEntity addCotizacion(CotizacionEntity cotizacion, Long solicitudId) throws BusinessLogicException{
            
            LOGGER.log(Level.INFO, "Inicia el proceso de agregar una cotizacion a la entidad solicitud id = {0}", solicitudId);
            SolicitudEntity entity =getById(solicitudId);
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
        
        
//        /**
//         * 
//         * @param solicitudId
//         * @param servicioId
//         * @return 
//         */
//        public ServicioEntity addServicio(Long solicitudId, Long servicioId ){
//            
//            //LOGGER.log(Level.INFO, "Inicia proceso de agregar un servicio a la solicitud con id = {0}", solicitudId);
//            SolicitudEntity entity= getById(solicitudId);
//            ServicioEntity servicio= servicioLogic.getById(servicioId);
//            entity.setServicio(servicio);
//            return servicio;
//        }
//        
//        /**
//         * 
//         * @param solicitudId 
//         */
//        public void removeServicio(Long solicitudId){
//            
//            SolicitudEntity entity= getById(solicitudId);
//            entity.setServicio(null);
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @return 
//         */
//        public ServicioEntity getServicio(Long solicitudId){
//            
//            LOGGER.log(Level.INFO, "Inicia proceso de consultar todos el servicio con id = {0}", solicitudId);
//            return getById(solicitudId).getServicio();
//
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @param servicio
//         * @return 
//         */
//        public ServicioEntity replaceServicio(Long solicitudId, ServicioEntity servicio){
//            
//            SolicitudEntity solicitud= getById(solicitudId);
//            solicitud.setServicio(servicio);
//            return servicio;
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @param cotizacionId
//         * @return 
//         */
//        public CotizacionEntity addCotizacion(Long solicitudId, Long cotizacionId){
//            
//            SolicitudEntity entity= getById(solicitudId);
//            CotizacionEntity cotizacion= cotizacionLogic.getById(cotizacionId);
//            entity.setCotizacion(cotizacion);
//            return cotizacion;
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @return 
//         */
//        public CotizacionEntity getCotizacion(Long solicitudId){
//            
//            LOGGER.log(Level.INFO, "Inicia proceso de consultar la cotizacion con id = {0}", solicitudId);
//            return getById(solicitudId).getCotizacion();
//        }
//        
////        public CotizacionEntity replaceCotizacion(Long solicitudId, CotizacionEntity cotizacion){
////            
////            SolicitudEntity solicitud= getById(solicitudId);
////            solicitud.setCotizacion(cotizacion);
////            return cotizacion;
////        }
////        
////        public void removeCotizacion(Long solicitudId){
////            
////            SolicitudEntity entity= getById(solicitudId);
////            entity.setCotizacion(null);
////        }
//        /**
//         * 
//         * @param solicitudId
//         * @param facturaId
//         * @return 
//         */
//        public FacturaEntity addFactura(Long solicitudId, Long facturaId){
//            
//            SolicitudEntity entity= getById(solicitudId);
//            FacturaEntity factura= facturaLogic.getFactura(facturaId);
//            entity.setFactura(factura);
//            return factura;
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @return 
//         */
//        public FacturaEntity getFactura(Long solicitudId){
//            
//            LOGGER.log(Level.INFO, "Inicia proceso de consultar la factura con id = {0}", solicitudId);
//            return getById(solicitudId).getFactura();
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @param contratistaId
//         * @return 
//         */
//        public ContratistaEntity addContratista(Long solicitudId, Long contratistaId){
//            
//            SolicitudEntity entity= getById(solicitudId);
//            ContratistaEntity contratista= contratistaLogic.getContratista(contratistaId);
//            entity.setContratista(contratista);
//            return contratista;
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @return 
//         */
//        public ContratistaEntity getContratista(Long solicitudId){
//            
//            LOGGER.log(Level.INFO, "Inicia proceso de consultar el contratista con id = {0}", solicitudId);
//            return getById(solicitudId).getContratista();
//
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @param clienteId
//         * @return 
//         */
//        public ClienteEntity addCliente(Long solicitudId, Long clienteId){
//            
//            SolicitudEntity entity= getById(solicitudId);
//            ClienteEntity cliente= clienteLogic.getById(clienteId);
//            entity.setCliente(cliente);
//            return cliente;
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @return 
//         */
//        public ClienteEntity getCliente(Long solicitudId){
//            
//            LOGGER.log(Level.INFO, "Inicia proceso de consultar el cliente con id = {0}", solicitudId);
//            return getById(solicitudId).getCliente();
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @param calificacionId
//         * @return 
//         */
//        public CalificacionEntity addCalificacion(Long solicitudId, Long calificacionId){
//            
//            SolicitudEntity entity= getById(solicitudId);
//            CalificacionEntity calificacion= calificacionLogic.getById(calificacionId);
//            entity.setCalificacion(calificacion);
//            return calificacion;
//        }
//        
//        /**
//         * 
//         * @param solicitudId
//         * @return 
//         */
//        public CalificacionEntity getCalificacion(Long solicitudId){
//            
//            LOGGER.log(Level.INFO, "Inicia proceso de consultar la calificacion con id = {0}", solicitudId);
//            return getById(solicitudId).getCalificacion();
//        }
    
}
