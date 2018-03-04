/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.CalificacionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    
        /**
     * Devuelve todos las calificaciones de la base de datos.
     *
     * @return una lista con todos las calificaciones que encuentre en la base de datos
     */
    public List<CalificacionEntity> findAll( )
    {
	LOGGER.info( "Consultando todas las entidades de Calificaciones" );
	TypedQuery<CalificacionEntity> query = em.createQuery( "select u from CalificacionEntity u", CalificacionEntity.class );
	return query.getResultList( );
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
