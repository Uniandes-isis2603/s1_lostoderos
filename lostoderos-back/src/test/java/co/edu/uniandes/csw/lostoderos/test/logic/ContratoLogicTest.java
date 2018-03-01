/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.test.logic;


import co.edu.uniandes.csw.lostoderos.ejb.ContratoLogic;
import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.ContratoPersistence;
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
public class ContratoLogicTest {
    
     private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ContratoLogic contratoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ContratoEntity> data = new ArrayList<ContratoEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ContratoEntity.class.getPackage())
                .addPackage(ContratoLogic.class.getPackage())
                .addPackage(ContratoPersistence.class.getPackage())
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
        em.createQuery("delete from ContratoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            
            ContratoEntity entity = factory.manufacturePojo(ContratoEntity.class);
            
            em.persist(entity);
            
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Contrato
     *
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void createContratoTest() throws BusinessLogicException {
        ContratoEntity newEntity = factory.manufacturePojo(ContratoEntity.class);
        ContratoEntity result = contratoLogic.create(newEntity);
        Assert.assertNotNull(result);
        ContratoEntity entity = em.find(ContratoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar un Contrato
     *
     * 
     */
    @Test
    public void getContratoTest() {
        ContratoEntity entity = data.get(0);
        ContratoEntity resultEntity = contratoLogic.getById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }

    /**
     * Prueba para eliminar una Contrato
     *
     * 
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void deleteContratoTest() throws BusinessLogicException {
        ContratoEntity entity = data.get(0);
        contratoLogic.delete(entity.getId());
        ContratoEntity deleted = em.find(ContratoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Contrato
     *
     * 
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void updateClienteTest() throws BusinessLogicException {
        ContratoEntity entity = data.get(0);
        ContratoEntity pojoEntity = factory.manufacturePojo(ContratoEntity.class);

        pojoEntity.setId(entity.getId());

        contratoLogic.update(pojoEntity);

        ContratoEntity resp = em.find(ContratoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }
    
}
