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

import co.edu.uniandes.csw.lostoderos.entities.HojaDeVidaEntity;
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
public class HojaDeVidaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(HojaDeVidaPersistence.class.getName());
    
    @PersistenceContext(unitName = "LosToderosPU")
    protected EntityManager em;
    
    public HojaDeVidaEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando una hoja de vida con id={0}",id);
        return em.find(HojaDeVidaEntity.class,id);
    }
    
    public HojaDeVidaEntity create(HojaDeVidaEntity entity){
        LOGGER.info("Creando una hoja de vida nueva");
        em.persist(entity);
        LOGGER.info("Hoja de vida creado");
        return entity;
    }
    
     /**
     * Devuelve todas las hojas de vida de la base de datos.
     *
     * @return una lista con todas las hojas de vida que encuentre en la base de
     * datos, "select u from HojaDeVidaEntity u" es como un "select * from
     * HojaDeVidaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<HojaDeVidaEntity> findAll() {
        LOGGER.info("Consultando todas las hojas de vida");
        // Se crea un query para buscar todas las hojas de vida en la base de datos.
        TypedQuery query = em.createQuery("select u from HojaDeVidaEntity u", HojaDeVidaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de hojas de vida.
        return query.getResultList();
    }
    
    public HojaDeVidaEntity update(HojaDeVidaEntity entity){
        LOGGER.log(Level.INFO,"Actualizando hoja de vida con id={0}",entity.getId());
        return em.merge(entity);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO,"Borrando hoja de vida con id={0}",id);
        HojaDeVidaEntity entity = em.find(HojaDeVidaEntity.class,id);
        em.remove(entity);
    }
    
}
