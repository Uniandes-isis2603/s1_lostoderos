/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

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
package co.edu.uniandes.csw.lostoderos.test.persistence;

import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;
import co.edu.uniandes.csw.lostoderos.persistence.ServicioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author s.naranjop1
 */
@RunWith(Arquillian.class)
public class ServicioPersistenceTest 
{
   /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Editorial, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ServicioEntity.class.getPackage())
                .addPackage(ServicioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase ContratistaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private ServicioPersistence servicioPersistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from ServicioEntity").executeUpdate();
    }

    /**
     * lista que tiene los datos de prueba
     */
    private List<ServicioEntity> data = new ArrayList<ServicioEntity>();
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            
            ServicioEntity entity = factory.manufacturePojo(ServicioEntity.class);

            em.persist(entity);
            
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Contratista.
     *
     *
     */
    @Test
    public void createServicioTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ServicioEntity newEntity = factory.manufacturePojo(ServicioEntity.class);
        ServicioEntity result = servicioPersistence.create(newEntity);
        Assert.assertNotNull(result);
        ServicioEntity entity = em.find(ServicioEntity.class, result.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    } 
    
    /**
     * Prueba para eliminar un Servicio
     *
     * 
     */
    @Test
    public void deleteServicioTest() {
        ServicioEntity entity = data.get(0);
        servicioPersistence.delete(entity.getNombre());
        ServicioEntity deleted = em.find(ServicioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un Servicio.
     *
     * 
     */
    @Test
    public void updateServicioTest() {
        ServicioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ServicioEntity newEntity = factory.manufacturePojo(ServicioEntity.class);

        newEntity.setId(entity.getId());

        servicioPersistence.update(newEntity);

        ServicioEntity resp = em.find(ServicioEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
    
    /**
     * Prueba para consultar un Servicio.
     *
     * 
     */
    @Test
    public void getServicioTest() {
        ServicioEntity entity = data.get(0);
        ServicioEntity newEntity = servicioPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    /**
     * Prueba para consultar la lista de servicios.
     *
     * 
     */
    @Test
    public void getServiciosTest() {
        List<ServicioEntity> list = servicioPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ServicioEntity ent : list) {
            boolean found = false;
            for (ServicioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar un Servcio por nombre.
     *
     * 
     */
    @Test
    public void getServcioByNombre() {
        ServicioEntity entity = data.get(0);
        ServicioEntity newEntity = servicioPersistence.findByNombre(entity.getNombre());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }
}
