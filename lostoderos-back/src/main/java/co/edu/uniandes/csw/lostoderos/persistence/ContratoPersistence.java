/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author s.blancoc
 */
@Stateless
public class ContratoPersistence {
    
        private static final Logger LOGGER = Logger.getLogger(ContratoPersistence.class.getName());
    
    @PersistenceContext(unitName = "LosToderosPU")
    protected EntityManager em;
    
    public ContratoEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando un contrato con id={0}",id);
        return em.find(ContratoEntity.class,id);
    }
    
    public ContratoEntity create(ContratoEntity entity){
        LOGGER.info("Creando un contrato nuevo");
        em.persist(entity);
        LOGGER.info("Contrato creado");
        return entity;
    }
    
    public ContratoEntity update(ContratoEntity entity){
        LOGGER.log(Level.INFO,"Actualizando contrato con id={0}",entity.getId());
        return em.merge(entity);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO,"Borrando contrato con id={0}",id);
        ContratoEntity entity = em.find(ContratoEntity.class,id);
        em.remove(entity);
    }
    
}
