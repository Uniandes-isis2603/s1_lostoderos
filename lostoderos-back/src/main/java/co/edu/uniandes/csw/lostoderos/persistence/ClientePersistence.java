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

import co.edu.uniandes.csw.lostoderos.entities.ClienteEntity;
import java.util.Date;
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
public class ClientePersistence 
{
    private static final Logger LOGGER = Logger.getLogger(ClientePersistence.class.getName());
    
    @PersistenceContext(unitName = "LosToderosPU")
    protected EntityManager em;
    
    /**
     * Crea un cliente en la base de datos
     * @param entity objeto cliente que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ClienteEntity create (ClienteEntity entity)
    {
        LOGGER.info("Creando un cliente nuevo");
        em.persist(entity);
        LOGGER.info("Cliente creado");
        return entity;
    }
    
    /**
     * Devuelve todos los clientes de la base de datos.
     *
     * @return una lista con todos los clientes que encuentre en la base de datos
     */
    public List<ClienteEntity> findAll( )
    {
	LOGGER.info( "Consultando todas las entidades de Clientes" );
	TypedQuery<ClienteEntity> query = em.createQuery( "select u from ClienteEntity u", ClienteEntity.class );
	return query.getResultList( );
    }
    
    /**
     * Busca si hay algun cliente con el id que se envía de argumento
     *
     * @param id: id correspondiente al cliente buscado.
     * @return un cliente.
     */
    public ClienteEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Consultando cliente con id={0}", id);
        return em.find(ClienteEntity.class, id);
    }    
    
    /**
     * Actualiza un cliente.
     *
     * @param entity: el cliente que viene con los nuevos cambios.
     * @return un cliente con los cambios aplicados.
     */
    public ClienteEntity update(ClienteEntity entity) 
    {
        LOGGER.log(Level.INFO, "Actualizando cliente con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * Borra un cliente de la base de datos recibiendo como argumento el id
     * de la author
     *
     * @param id: id correspondiente al cliente a borrar.
     */
    public void delete(Long id) 
    {
        LOGGER.log(Level.INFO, "Borrando cliente con id={0}", id);
        ClienteEntity entity = em.find(ClienteEntity.class, id);
        em.remove(entity);
    }
    
     /**
     * Busca si hay alguna entidad de usuario con el usuario que se envía de argumento
     *
     * @param username: usuario de la entidad de usuario que se está buscando
     * @return null si no existe ninguna entidad usuario con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public ClienteEntity findByUsername( String username )
    {
	LOGGER.log( Level.INFO, "Consultando entidades de Usuarios por username ", username );

	TypedQuery<ClienteEntity> query = em.createQuery( "Select e From ClienteEntity e where e.usuario = :username", ClienteEntity.class );
	query = query.setParameter( "username", username );
	List<ClienteEntity> sameUserName = query.getResultList( );
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
