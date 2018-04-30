/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.test.logic;

import co.edu.uniandes.csw.lostoderos.ejb.ContratoLogic;
import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
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

    private final PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ContratoLogic contratoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ContratoEntity> data = new ArrayList<ContratoEntity>();

    private List<ContratistaEntity> contratistaData = new ArrayList<ContratistaEntity>();

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
            ContratistaEntity e = factory.manufacturePojo(ContratistaEntity.class);
            em.persist(e);
            contratistaData.add(e);
        }
        for (int i = 0; i < 3; i++) {
            ContratoEntity entity = factory.manufacturePojo(ContratoEntity.class);
            entity.setContratista(contratistaData.get(i));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un contrato
     *
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void createContratoTest() throws BusinessLogicException {
        ContratoEntity newEntity = factory.manufacturePojo(ContratoEntity.class);
        ContratoEntity result = contratoLogic.create(contratistaData.get(0).getId(), newEntity);
        Assert.assertNotNull(result);
        ContratoEntity entity = em.find(ContratoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Prueba para actualizar un contrato
     *
     *
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void updateContratoTest() throws BusinessLogicException {
        ContratoEntity entity = data.get(0);
        ContratoEntity pojoEntity = factory.manufacturePojo(ContratoEntity.class);
        pojoEntity.setId(entity.getId());
        contratoLogic.update(contratistaData.get(0).getId(), pojoEntity);
        ContratoEntity resp = em.find(ContratoEntity.class, pojoEntity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
    }

    /**
     * Prueba para consultar un contrato
     */
    @Test
    public void getContratoByContratistaTest() throws BusinessLogicException {
        ContratoEntity entity = data.get(0);
        ContratoEntity resultEntity = contratoLogic.getContrato(contratistaData.get(0).getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }

    /**
     * Prueba para eliminar un contrato
     */
    @Test
    public void deleteContratoTest() throws BusinessLogicException {
        ContratoEntity entity = data.get(0);
        contratoLogic.delete(contratistaData.get(0).getId());
        ContratoEntity deleted = em.find(ContratoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
