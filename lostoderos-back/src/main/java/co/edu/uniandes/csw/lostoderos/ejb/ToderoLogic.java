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
package co.edu.uniandes.csw.lostoderos.ejb;

import co.edu.uniandes.csw.lostoderos.entities.ToderoEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.ToderoPersistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author ISIS2603
 */
@Stateless
public class ToderoLogic
{

	private static final Logger LOGGER = Logger.getLogger( ToderoLogic.class.getName( ) );

	@Inject
	private ToderoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

	public ToderoEntity create( ToderoEntity entity ) throws BusinessLogicException
	{
		LOGGER.info( "Inicia proceso de creación de una entidad de Todero" );
		// Verifica la regla de negocio que dice que no puede haber dos entidades de Toderos con el mismo nombre
		if( persistence.findByName( entity.getName( ) ) != null )
		{
			throw new BusinessLogicException( "Ya existe una entidad de Todero con el nombre \"" + entity.getName( ) + "\"" );
		}
		// Invoca la persistencia para crear la entidad de Todero
		persistence.create( entity );
		LOGGER.info( "Termina proceso de creación de entidad de Todero" );
		return entity;
	}

	public List<ToderoEntity> getAll( )
	{
		LOGGER.info( "Inicia proceso de consultar todas las entidades de Todero" );
		// Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
		List<ToderoEntity> entities = persistence.findAll( );
		LOGGER.info( "Termina proceso de consultar todas las entidades de Todero" );
		return entities;
	}

	public ToderoEntity getById( Long id )
	{
		return persistence.find( id );
	}

	public ToderoEntity update( ToderoEntity entity ) throws BusinessLogicException
	{
		if( persistence.findByName( entity.getName( ) ) != null )
		{
			throw new BusinessLogicException( "Ya existe una entidad de Todero con el nombre \"" + entity.getName( ) + "\"" );
		}
                //TODO: NO hay ninguna regla de negocio? 
		return persistence.update( entity );
	}

	public void delete( ToderoEntity entity ) throws BusinessLogicException
	{//Este método debe recibir un id y hayq ue verificar que exista el todero correspondiente
		LOGGER.log( Level.INFO, "Inicia proceso de borrar la entidad de Todero con id={0}", entity.getId( ) );
                
		persistence.delete( entity );
		LOGGER.log( Level.INFO, "Termina proceso de borrar la entidad de Todero con id={0}", entity.getId( ) );
	}
}
