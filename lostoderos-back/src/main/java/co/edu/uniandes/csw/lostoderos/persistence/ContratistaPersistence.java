/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

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

import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author sa.yepes
 */
@Stateless
public class ContratistaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(ContratistaEntity.class.getName());
    
    @PersistenceContext(unitName="LosToderosPU")
    protected EntityManager em;
    
     public ContratistaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando contratista con id={0}", id);
        ContratistaEntity contratista =em.find(ContratistaEntity.class, id); 
        LOGGER.log(Level.INFO, "Termina consulta de contratista con id={0}", id);
        return contratista;
    }
    
    public ContratistaEntity create(ContratistaEntity entity) {
        LOGGER.info("Creando un contratista nuevo");
        em.persist(entity);
        LOGGER.info("Contratista creado");
        return entity;
    }
    
     /**
     * Devuelve todas los contratistas de la base de datos.
     *
     * @return una lista con todas los contratistas que encuentre en la base de
     * datos, "select u from ContratistaEntity u" es como un "select * from
     * ContratistaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<ContratistaEntity> findAll() {
        LOGGER.info("Consultando todas los contratistas");
        // Se crea un query para buscar todos los contratistas en la base de datos.
        TypedQuery query = em.createQuery("select u from ContratistaEntity u", ContratistaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de contratistas.
        return query.getResultList();
    }
    
    public ContratistaEntity update(ContratistaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando tratista con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando contratista con id={0}", id);
        ContratistaEntity entity = em.find(ContratistaEntity.class, id);
        em.remove(entity);
    }
}