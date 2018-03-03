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
        private ServicioLogic servicioLogic;
        
        @Inject
        private CotizacionLogic cotizacionLogic;
        
        @Inject
        private FacturaLogic facturaLogic;
        
        @Inject
        private ContratistaLogic contratistaLogic;
        
        @Inject
        private ClienteLogic clienteLogic;
        
        @Inject
        private CalificacionLogic calificacionLogic;
        
        
        public SolicitudEntity create(SolicitudEntity entity, Long servicioId, Long cotizacionId, Long facturaId,
        Long contratistaId)throws BusinessLogicException{
            
            LOGGER.info("Inicia el proceso de creación de una enidad de Solicitud");
            
            if(persistence.find(entity.getId()) != null)
                throw new BusinessLogicException("Ya existe una entidad de Solicitud con el id \"" + entity.getId( ) + "\"");
            
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
            
            if(persistence.find(entity.getId()) != null)
                throw new BusinessLogicException("Ya existe una entidad de Solicitud con el id \""+entity.getId()+"\"");
            
            return persistence.update(entity);
        }
                
        /**
         * elimina la entidad deseada
         * @param entity entidad que se desea eliminar
         * @throws BusinessLogicException si no existe la entidad
         */
        public void delete(Long id) throws BusinessLogicException{
            
            LOGGER.log(Level.INFO, "inicia proceso de borrado de la entidad Solicitud con id={0}", id);
            persistence.delete(id);
            LOGGER.log(Level.INFO, "Termina el proceso de borrado de la entidad Solicitud con id={0}", id);
        }
        
        
        public ServicioEntity addServicio(Long solicitudId, Long servicioId ){
            
            //LOGGER.log(Level.INFO, "Inicia proceso de agregar un servicio a la solicitud con id = {0}", solicitudId);
            SolicitudEntity entity= getById(solicitudId);
            ServicioEntity servicio= servicioLogic.getById(servicioId);
            entity.setServicio(servicio);
            return servicio;
        }
        
        public void removeServicio(Long solicitudId){
            
            SolicitudEntity entity= getById(solicitudId);
            entity.setServicio(null);
        }
        
        public ServicioEntity getServicio(Long solicitudId){
            
            LOGGER.log(Level.INFO, "Inicia proceso de consultar todos el servicio con id = {0}", solicitudId);
            return getById(solicitudId).getServicio();

        }
        
        public ServicioEntity replaceServicio(Long solicitudId, ServicioEntity servicio){
            
            SolicitudEntity solicitud= getById(solicitudId);
            solicitud.setServicio(servicio);
            return servicio;
        }
        
        public CotizacionEntity addCotizacion(Long solicitudId, Long cotizacionId){
            
            SolicitudEntity entity= getById(solicitudId);
            CotizacionEntity cotizacion= cotizacionLogic.getById(cotizacionId);
            entity.setCotizacion(cotizacion);
            return cotizacion;
        }
        
        public CotizacionEntity getCotizacion(Long solicitudId){
            
            LOGGER.log(Level.INFO, "Inicia proceso de consultar la cotizacion con id = {0}", solicitudId);
            return getById(solicitudId).getCotizacion();
        }
        
//        public CotizacionEntity replaceCotizacion(Long solicitudId, CotizacionEntity cotizacion){
//            
//            SolicitudEntity solicitud= getById(solicitudId);
//            solicitud.setCotizacion(cotizacion);
//            return cotizacion;
//        }
//        
//        public void removeCotizacion(Long solicitudId){
//            
//            SolicitudEntity entity= getById(solicitudId);
//            entity.setCotizacion(null);
//        }
        
        public FacturaEntity addFactura(Long solicitudId, Long facturaId){
            
            SolicitudEntity entity= getById(solicitudId);
            FacturaEntity factura= facturaLogic.getFactura(facturaId);
            entity.setFactura(factura);
            return factura;
        }
        
        public FacturaEntity getFactura(Long solicitudId){
            
            LOGGER.log(Level.INFO, "Inicia proceso de consultar la factura con id = {0}", solicitudId);
            return getById(solicitudId).getFactura();
        }
        
        public ContratistaEntity addContratista(Long solicitudId, Long contratistaId){
            
            SolicitudEntity entity= getById(solicitudId);
            ContratistaEntity contratista= contratistaLogic.getContratista(contratistaId);
            entity.setContratista(contratista);
            return contratista;
        }
        
        public ContratistaEntity getContratista(Long solicitudId){
            
            LOGGER.log(Level.INFO, "Inicia proceso de consultar el contratista con id = {0}", solicitudId);
            return getById(solicitudId).getContratista();

        }
        
        public ClienteEntity addCliente(Long solicitudId, Long clienteId){
            
            SolicitudEntity entity= getById(solicitudId);
            ClienteEntity cliente= clienteLogic.getById(clienteId);
            entity.setCliente(cliente);
            return cliente;
        }
        
        public ClienteEntity getCliente(Long solicitudId){
            
            LOGGER.log(Level.INFO, "Inicia proceso de consultar el cliente con id = {0}", solicitudId);
            return getById(solicitudId).getCliente();
        }
        
        public CalificacionEntity addCalificacion(Long solicitudId, Long calificacionId){
            
            SolicitudEntity entity= getById(solicitudId);
            CalificacionEntity calificacion= calificacionLogic.getById(calificacionId);
            entity.setCalificacion(calificacion);
            return calificacion;
        }
        
        public CalificacionEntity getCalificacion(Long solicitudId){
            
            LOGGER.log(Level.INFO, "Inicia proceso de consultar la calificacion con id = {0}", solicitudId);
            return getById(solicitudId).getCalificacion();
        }
    
}
