/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;
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
public class ContratoPersistence {
    
        private static final Logger LOGGER = Logger.getLogger(ContratoPersistence.class.getName());
    
    @PersistenceContext(unitName = "LosToderosPU")
    protected EntityManager em;
    
    public ContratoEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando un contrato con id={0}",id);
        return em.find(ContratoEntity.class,id);
    }
    
        /**
     * Devuelve todos los contratos de la base de datos.
     *
     * @return una lista con todos los contratos que encuentre en la base de datos
     */
    public List<ContratoEntity> findAll( )
    {
	LOGGER.info( "Consultando todas las entidades de Contratos" );
	TypedQuery<ContratoEntity> query = em.createQuery( "select u from ContratoEntity u", ContratoEntity.class );
	return query.getResultList( );
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
