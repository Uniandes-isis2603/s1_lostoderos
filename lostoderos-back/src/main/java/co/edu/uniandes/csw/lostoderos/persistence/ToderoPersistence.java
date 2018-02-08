/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.ToderoEntity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author ISIS2603
 */
@Stateless
public class ToderoPersistence
{
	private static final Logger LOGGER = Logger.getLogger( ToderoPersistence.class.getName( ) );

	@PersistenceContext( unitName = "LosToderosPU" )
	protected EntityManager em;

	/**
	 * @param entity objeto Todero que se creará en la base de datos
	 * @return devuelve la entidad creada con un id dado por la base de datos.
	 */
	public ToderoEntity create( ToderoEntity entity )
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
	public ToderoEntity findByName( String name )
	{
		LOGGER.log( Level.INFO, "Consultando entidades de Toderos por nombre ", name );

		// Se crea un query para buscar entidades de Todero con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
		TypedQuery<ToderoEntity> query = em.createQuery( "Select e From ToderoEntity e where e.name = :name", ToderoEntity.class );
		// Se remplaza el placeholder ":name" con el valor del argumento
		query = query.setParameter( "name", name );
		// Se invoca el query se obtiene la lista resultado
		List<ToderoEntity> sameName = query.getResultList( );
		if( sameName.isEmpty( ) )
		{
			return null;
		}
		else
		{
			return sameName.get( 0 );
		}
	}

	public List<ToderoEntity> findAll( )
	{
		LOGGER.info( "Consultando todas las entidades de losToderos" );
		TypedQuery<ToderoEntity> query = em.createQuery( "select u from ToderoEntity u", ToderoEntity.class );
		return query.getResultList( );
	}

	public ToderoEntity find( Long id )
	{
		return em.find( ToderoEntity.class, id );
	}

	public ToderoEntity update( ToderoEntity entity )
	{
		return em.merge( entity );
	}

	public void delete( ToderoEntity entity )
	{
		em.remove( entity );
	}
}
