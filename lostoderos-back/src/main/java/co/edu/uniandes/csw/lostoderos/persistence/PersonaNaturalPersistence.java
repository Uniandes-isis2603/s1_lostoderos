/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.PersonaNaturalEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author na.morenoe
 */
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
