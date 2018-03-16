/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.PersonaNaturalEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author na.morenoe
 */
@Stateless
public class PersonaNaturalPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PersonaNaturalPersistence.class.getName());
    
    @PersistenceContext(unitName = "LosToderosPU")
    protected EntityManager em;
    
    public PersonaNaturalEntity create (PersonaNaturalEntity entity)
    {
        LOGGER.info("Creando una persona natural nueva");
        em.persist(entity);
        LOGGER.info("Persona Natural creada");
        return entity;
    }
    
    public PersonaNaturalEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Consultando persona natural con id={0}", id);
        return em.find(PersonaNaturalEntity.class, id);
    } 
    
     /**
     * Devuelve todas las personas naturales de la base de datos.
     *
     * @return una lista con todas las Personas Naturales que encuentre en la base de
     * datos, "select u from PersonaNaturalEntity u" es como un "select * from
     * PersonaNaturalEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<PersonaNaturalEntity> findAll() {
        LOGGER.info("Consultando todas las Personas Naturales");
        // Se crea un query para buscar todas las hojas de vida en la base de datos.
        TypedQuery query = em.createQuery("select u from PersonaJuridicaEntity u", PersonaNaturalEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de hojas de vida.
        return query.getResultList();
    }       
    
    public PersonaNaturalEntity update(PersonaNaturalEntity entity) 
    {
        LOGGER.log(Level.INFO, "Actualizando persona natural con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) 
    {
        LOGGER.log(Level.INFO, "Borrando persona natural con id={0}", id);
        PersonaNaturalEntity entity = em.find(PersonaNaturalEntity.class, id);
        em.remove(entity);
    }
    
}
