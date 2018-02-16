/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.CalificacionEntity;
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
public class CalificacionPersistence {
    
     private static final Logger LOGGER = Logger.getLogger(CalificacionPersistence.class.getName());
    
    @PersistenceContext(unitName = "LosToderosPU")
    protected EntityManager em;
    
    public CalificacionEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando una calificacion con id={0}",id);
        return em.find(CalificacionEntity.class,id);
    }
    
    public CalificacionEntity create(CalificacionEntity entity){
        LOGGER.info("Creando una calificacion nueva");
        em.persist(entity);
        LOGGER.info("Calificacion creada");
        return entity;
    }
    
    public CalificacionEntity update(CalificacionEntity entity){
        LOGGER.log(Level.INFO,"Actualizando calificacion con id={0}",entity.getId());
        return em.merge(entity);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO,"Borrando calificacion con id={0}",id);
        CalificacionEntity entity = em.find(CalificacionEntity.class,id);
        em.remove(entity);
    }
    
}
