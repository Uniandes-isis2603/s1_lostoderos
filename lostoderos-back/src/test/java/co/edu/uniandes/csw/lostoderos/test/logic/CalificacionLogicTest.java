/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.test.logic;

import co.edu.uniandes.csw.lostoderos.ejb.CalificacionLogic;
import co.edu.uniandes.csw.lostoderos.entities.CalificacionEntity;
import co.edu.uniandes.csw.lostoderos.entities.ClienteEntity;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.CalificacionPersistence;
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
 * @author s.blancoc
 */
@RunWith(Arquillian.class)
public class CalificacionLogicTest {
    
     private final PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private CalificacionLogic calificacionLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<CalificacionEntity> data = new ArrayList<CalificacionEntity>();
    
    private List<ClienteEntity> clienteData = new ArrayList<ClienteEntity>();
    
    private List<ContratistaEntity> contratistaData = new ArrayList<ContratistaEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
       return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionLogic.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     */
     @Before
    public void configTest() {
        try {
            utx.begin();
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
     */
    private void clearData() {
        em.createQuery("delete from CalificacionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        
                for (int i = 0; i < 3; i++) {
            ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
            em.persist(cliente);
            clienteData.add(cliente);
        }
            for (int i = 0; i < 3; i++) {
            ContratistaEntity e = factory.manufacturePojo(ContratistaEntity.class);
            em.persist(e);
            contratistaData.add(e);
        }
                
        for (int i = 0; i < 3; i++) {
            
            CalificacionEntity entity = factory.manufacturePojo(CalificacionEntity.class);
            entity.setCliente(clienteData.get(1));
            entity.setContratista(contratistaData.get(1));
            em.persist(entity);
            
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una calificacion
     *
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void createCalificacionTest() throws BusinessLogicException   {
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        CalificacionEntity result = calificacionLogic.create(newEntity, data.get(0).getCliente().getId(), data.get(0).getContratista().getId());
        Assert.assertNotNull(result);
        CalificacionEntity entity = em.find(CalificacionEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    
    /**
     * Prueba para consultar una calificacion
     *
     *
     */
    @Test
    public void getCalificacionTest() {
        CalificacionEntity entity = data.get(0);
        CalificacionEntity resultEntity = calificacionLogic.getById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
}
     /**
     * Prueba para consultar la lista de calificaciones
     *
     *
     */
    @Test
    public void getCalificacionesTest() {
        List<CalificacionEntity> list = calificacionLogic.getCalificaciones();
        Assert.assertEquals(data.size(), list.size());
        for (CalificacionEntity entity : list) {
            boolean found = false;
            for (CalificacionEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        
    }
    
     /**
     * Prueba para eliminar una calificacion
     *
     *
     */
    @Test
    public void deleteCalificacionTest() {
        CalificacionEntity entity = data.get(0);
        calificacionLogic.delete(entity.getId());
        CalificacionEntity deleted = em.find(CalificacionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
        * Prueba para actualizar una calificacion
     *
     *
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void updateCalificacionTest() throws BusinessLogicException {
        CalificacionEntity entity = data.get(0);
        CalificacionEntity pojoEntity = factory.manufacturePojo(CalificacionEntity.class);

        pojoEntity.setId(entity.getId());

        calificacionLogic.update(entity);

        CalificacionEntity resp = em.find(CalificacionEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
     
    }
    
}
      