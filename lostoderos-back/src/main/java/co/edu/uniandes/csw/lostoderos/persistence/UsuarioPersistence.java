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

import co.edu.uniandes.csw.lostoderos.entities.UsuarioEntity;
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
public class UsuarioPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(UsuarioPersistence.class.getName());
    
    @PersistenceContext(unitName = "LosToderosPU")
    protected EntityManager em;
    
    /**
     * Crea un usuario en la base de datos
     * @param entity objeto usuario que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public UsuarioEntity create (UsuarioEntity entity)
    {
        LOGGER.info("Creando un usuario nuevo");
        em.persist(entity);
        LOGGER.info("Usuario creado");
        return entity;
    }
    
    /**
     * Devuelve todos los usuarios de la base de datos.
     *
     * @return una lista con todos los usuarios que encuentre en la base de datos
     */
    public List<UsuarioEntity> findAll( )
    {
	LOGGER.info( "Consultando todas las entidades de Usuarios" );
	TypedQuery<UsuarioEntity> query = em.createQuery( "select u from UsuarioEntity u", UsuarioEntity.class );
	return query.getResultList( );
    }
    
    /**
     * Busca si hay algun usuario con el id que se envía de argumento
     *
     * @param id: id correspondiente al usuario buscado.
     * @return un usuario.
     */
    public UsuarioEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Consultando usuario con id={0}", id);
        return em.find(UsuarioEntity.class, id);
    }    
    
    /**
     * Actualiza un usuario.
     *
     * @param entity: el usuario que viene con los nuevos cambios.
     * @return un usuario con los cambios aplicados.
     */
    public UsuarioEntity update(UsuarioEntity entity) 
    {
        LOGGER.log(Level.INFO, "Actualizando usuario con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * Borra un usuario de la base de datos recibiendo como argumento el id
     * de la author
     *
     * @param id: id correspondiente al usuario a borrar.
     */
    public void delete(Long id) 
    {
        LOGGER.log(Level.INFO, "Borrando usuario con id={0}", id);
        UsuarioEntity entity = em.find(UsuarioEntity.class, id);
        em.remove(entity);
    }
}
