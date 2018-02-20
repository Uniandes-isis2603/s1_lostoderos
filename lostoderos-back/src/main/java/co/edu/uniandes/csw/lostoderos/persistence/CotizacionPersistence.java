/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.CotizacionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ejb.Stateless;
import javax.persistence.Query;


/**
 *
 * @author m.saravia
 */
@Stateless
public class CotizacionPersistence {
    
    private static final Logger LOGGER = Logger.getLogger( CotizacionPersistence.class.getName( ) );

	@PersistenceContext( unitName = "LosToderosPU" )
	protected EntityManager em;

	/**
	 * @param entity objeto Solicitud que se creará en la base de datos
	 * @return devuelve la entidad creada con un id dado por la base de datos.
	 */
	public CotizacionEntity create( CotizacionEntity entity )
	{
		LOGGER.info( "Creando una nueva entidad de losToderos" );
		em.persist( entity );
		LOGGER.info( "Creando una entidad de losToderos" );
		return entity;
	}

	public List<CotizacionEntity> findAll( )
	{
		LOGGER.info( "Consultando todas las cotizaciones de losToderos" );
		Query  query = em.createQuery( "select u from CotizacionEntity u" );
		return query.getResultList( );
	}

	public CotizacionEntity find( Long id )
	{
                LOGGER.log(Level.INFO, "Consultando una cotizacion con id={0}",id);
		return em.find( CotizacionEntity.class, id );
	}

	public CotizacionEntity update( CotizacionEntity entity )
	{
                LOGGER.log(Level.INFO, "Consultando una cotizacion con id={0}",entity.getId());
		return em.merge( entity );
	}

	public void delete( Long id )
	{
                LOGGER.log(Level.INFO, "Consultando una cotizacion con id={0}",id);
                CotizacionEntity entity= em.find(CotizacionEntity.class, id);
		em.remove( entity );
	}
    
}
