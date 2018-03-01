/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.test.logic;

import co.edu.uniandes.csw.lostoderos.ejb.PagoLogic;
import co.edu.uniandes.csw.lostoderos.ejb.PersonaJuridicaLogic;
import co.edu.uniandes.csw.lostoderos.ejb.PersonaNaturalLogic;
import co.edu.uniandes.csw.lostoderos.entities.PagoEntity;
import co.edu.uniandes.csw.lostoderos.entities.PersonaJuridicaEntity;
import co.edu.uniandes.csw.lostoderos.entities.PersonaNaturalEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
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
 * @author na.morenoe
 */
@RunWith(Arquillian.class)
public class PersonaNaturalLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private PersonaNaturalLogic personanaturalLogic;

    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;

    private List<PersonaNaturalEntity> data = new ArrayList<PersonaNaturalEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PagoEntity.class.getPackage())
                .addPackage(PagoLogic.class.getPackage())
                .addPackage(PagoEntity.class.getPackage())
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
        em.createQuery("delete from PersonaNaturalEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            
            PersonaNaturalEntity entity = factory.manufacturePojo(PersonaNaturalEntity.class);
            
            em.persist(entity);
            
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un pago
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test
    public void createPersonaNaturalTest() throws BusinessLogicException {
        PersonaNaturalEntity newEntity = factory.manufacturePojo(PersonaNaturalEntity.class);
        PersonaNaturalEntity result = personanaturalLogic.create(newEntity);
        Assert.assertNotNull(result);
        PersonaNaturalEntity entity = em.find(PersonaNaturalEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar un pago
     *
     * 
     */
    @Test
    public void getPersonaNaturalTest() {
        PersonaNaturalEntity entity = data.get(0);
        PersonaNaturalEntity resultEntity = personanaturalLogic.getById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }

    /**
     * Prueba para eliminar un pago
     *
     * 
     */
    @Test
    public void deletePersonaNaturalTest() throws BusinessLogicException {
        PersonaNaturalEntity entity = data.get(0);
        personanaturalLogic.delete(entity.getId());
        PersonaNaturalEntity deleted = em.find(PersonaNaturalEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Servicio
     *
     * 
     */
    @Test
    public void updatePersonaNaturalTest() throws BusinessLogicException {
        PersonaNaturalEntity entity = data.get(0);
        PersonaNaturalEntity pojoEntity = factory.manufacturePojo(PersonaNaturalEntity.class);

        pojoEntity.setId(entity.getId());

        personanaturalLogic.update(pojoEntity);

        PersonaNaturalEntity resp = em.find(PersonaNaturalEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }
    
}
