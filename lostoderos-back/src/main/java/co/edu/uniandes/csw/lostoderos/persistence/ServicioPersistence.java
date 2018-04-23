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

import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author s.naranjop1
 */
@Stateless
public class ServicioPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(ServicioPersistence.class.getName());
    
    @PersistenceContext(unitName = "LosToderosPU")
    protected EntityManager em;
    
    /**
     * Crea un servicio en la base de datos
     * @param entity objeto servicio que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ServicioEntity create (ServicioEntity entity)
    {
        LOGGER.info("Creando un servicio nuevo");
        em.persist(entity);
        LOGGER.info("Servicio creado");
        return entity;
    }
    
    /**
     * Devuelve todos los servicios de la base de datos.
     *
     * @return una lista con todos los servicios que encuentre en la base de datos
     */
    public List<ServicioEntity> findAll( )
    {
	LOGGER.info( "Consultando todas las entidades de Servicios" );
        LOGGER.info( "Consultando todas las entidades de Servicios" );
	TypedQuery<ServicioEntity> query = em.createQuery( "select u from ServicioEntity u", ServicioEntity.class );
	return query.getResultList( );
    }
    
    /**
     * Busca si hay algun servicio con el id que se envía de argumento
     *
     * @param id: id correspondiente al servicio buscado.
     * @return un servicio.
     */
    public ServicioEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Consultando servicio con id={0}", id);
        return em.find(ServicioEntity.class, id);
    }    
    
    /**
     * Actualiza un servicio.
     *
     * @param entity: el servicio que viene con los nuevos cambios.
     * @return un servicio con los cambios aplicados.
     */
    public ServicioEntity update(ServicioEntity entity) 
    {
        LOGGER.log(Level.INFO, "Actualizando servicio con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * Borra un servicio de la base de datos recibiendo como argumento el id
     * de la author
     *
     * @param id: id correspondiente al servicio a borrar.
     */
        public void delete(Long id) 
    {
        LOGGER.log(Level.INFO, "Eliminando servicio con id={0}", id);
        ServicioEntity entity = em.find(ServicioEntity.class, id);
        em.remove(entity);
        LOGGER.log(Level.INFO, "Termina eliminación de id con id={0}", id);
    }
    
    /**
     * Busca si hay alguna entidad de servicio con el nombre que se envía de argumento
     *
     * @param nombre: usuario de la entidad de usuario que se está buscando
     * @return null si no existe ninguna entidad usuario con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public ServicioEntity findByNombre( String nombre )
    {
	LOGGER.log( Level.INFO, "Consultando entidades de Usuarios por username ", nombre );

	TypedQuery<ServicioEntity> query = em.createQuery( "Select e From ServicioEntity e where e.nombre = :name", ServicioEntity.class );
	query = query.setParameter( "name", nombre );
	List<ServicioEntity> sameUserName = query.getResultList( );
	if( sameUserName.isEmpty( ) )
	{
		return null;
	}
	else
	{
		return sameUserName.get( 0 );
	}
    }
    
}
