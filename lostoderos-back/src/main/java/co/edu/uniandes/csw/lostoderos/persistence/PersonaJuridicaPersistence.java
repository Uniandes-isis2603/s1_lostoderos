/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.persistence;

import co.edu.uniandes.csw.lostoderos.entities.PersonaJuridicaEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author na.morenoe
 */
public class PersonaJuridicaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PersonaJuridicaPersistence.class.getName());
    
    @PersistenceContext(unitName = "LosToderosPU")
    protected EntityManager em;
    
    public PersonaJuridicaEntity create (PersonaJuridicaEntity entity)
    {
        LOGGER.info("Creando una persona juridica nuevo");
        em.persist(entity);
        LOGGER.info("persona juridica creada");
        return entity;
    }
    
    public PersonaJuridicaEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Consultando persona juridica con id={0}", id);
        return em.find(PersonaJuridicaEntity.class, id);
    }    
    
    public PersonaJuridicaEntity update(PersonaJuridicaEntity entity) 
    {
        LOGGER.log(Level.INFO, "Actualizando persona juridica con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) 
    {
        LOGGER.log(Level.INFO, "Borrando persona juridica con id={0}", id);
        PersonaJuridicaEntity entity = em.find(PersonaJuridicaEntity.class, id);
        em.remove(entity);
    }
    
}
