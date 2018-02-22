/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author m.saravia
 */
@Stateless
public class SolicitudPersistence {
    
    
    private static final Logger LOGGER = Logger.getLogger( SolicitudPersistence.class.getName( ) );

	@PersistenceContext( unitName = "LosToderosPU" )
	protected EntityManager em;

	/**
	 * @param entity objeto Solicitud que se creará en la base de datos
	 * @return devuelve la entidad creada con un id dado por la base de datos.
	 */
	public SolicitudEntity create( SolicitudEntity entity )
	{
		LOGGER.info( "Creando una nueva solicitud de losToderos" );
		em.persist( entity );
		LOGGER.info( "Creando una solicitud de losToderos" );
		return entity;
	}

	/**
	 * Busca si hay alguna entidad de losToderos con el nombre que se envía de argumento
	 *
	 * @param name: Nombre de la entidad de losToderos que se está buscando
	 * @return null si no existe ninguna entidad losToderos con el nombre del argumento. Si
	 * existe alguna devuelve la primera.
	 */
	/*public SolicitudEntity findByName( String name )
	{
		LOGGER.log( Level.INFO, "Consultando entidades de Solucitudes por nombre ", name );

		// Se crea un query para buscar entidades de Solicitud con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
		TypedQuery<SolicitudEntity> query = em.createQuery( "Select e From SolicitudEntity e where e.name = :name", SolicitudEntity.class );
		// Se remplaza el placeholder ":name" con el valor del argumento
		query = query.setParameter( "name", name );
		// Se invoca el query se obtiene la lista resultado
		List<SolicitudEntity> sameName = query.getResultList( );
		if( sameName.isEmpty( ) )
		{
			return null;
		}
		else
		{
			return sameName.get( 0 );
		}
	}*/
        
        /**
         * se traen todas la entidades de Solicitud
         * @return lista de solicitudes
         */
	public List<SolicitudEntity> findAll( )
	{
		LOGGER.info( "Consultando todas las entidades de losToderos" );
		TypedQuery<SolicitudEntity> query = em.createQuery( "select u from SolicitudEntity u", SolicitudEntity.class );
		return query.getResultList( );
	}

	public SolicitudEntity find( Long id )
	{
                LOGGER.log(Level.INFO, "Consultando una solicitud con id={0}",id);
		return em.find( SolicitudEntity.class, id );
	}

	public SolicitudEntity update( SolicitudEntity entity )
	{
                LOGGER.log(Level.INFO, "Consultando una solicitud con id={0}",entity.getId());
		return em.merge( entity );
	}

	public void delete( Long id )
	{
                LOGGER.log(Level.INFO, "Consultando una solicitud con id={0}",id);
                SolicitudEntity entity= em.find(SolicitudEntity.class, id);
		em.remove( entity );
	}
    
}
