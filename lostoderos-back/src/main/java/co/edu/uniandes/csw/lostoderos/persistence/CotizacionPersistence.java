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

	/**
	 * Busca si hay alguna entidad de losToderos con el nombre que se envía de argumento
	 *
	 * @param name: Nombre de la entidad de losToderos que se está buscando
	 * @return null si no existe ninguna entidad losToderos con el nombre del argumento. Si
	 * existe alguna devuelve la primera.
	 */
	public CotizacionEntity findByName( String name )
	{
		LOGGER.log( Level.INFO, "Consultando entidades de Cotizaciones por nombre ", name );

		// Se crea un query para buscar entidades de Solicitud con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
		TypedQuery<CotizacionEntity> query = em.createQuery( "Select e From CotizacionEntity e where e.name = :name", CotizacionEntity.class );
		// Se remplaza el placeholder ":name" con el valor del argumento
		query = query.setParameter( "name", name );
		// Se invoca el query se obtiene la lista resultado
		List<CotizacionEntity> sameName = query.getResultList( );
		if( sameName.isEmpty( ) )
		{
			return null;
		}
		else
		{
			return sameName.get( 0 );
		}
	}

	public List<CotizacionEntity> findAll( )
	{
		LOGGER.info( "Consultando todas las entidades de losToderos" );
		TypedQuery<CotizacionEntity> query = em.createQuery( "select u from SolicitudEntity u", CotizacionEntity.class );
		return query.getResultList( );
	}

	public CotizacionEntity find( Long id )
	{
		return em.find( CotizacionEntity.class, id );
	}

	public CotizacionEntity update( CotizacionEntity entity )
	{
		return em.merge( entity );
	}

	public void delete( CotizacionEntity entity )
	{
		em.remove( entity );
	}
    
}
