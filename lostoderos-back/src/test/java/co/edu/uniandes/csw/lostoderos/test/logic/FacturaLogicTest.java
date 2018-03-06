/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.test.logic;


import co.edu.uniandes.csw.lostoderos.ejb.FacturaLogic;
import co.edu.uniandes.csw.lostoderos.entities.FacturaEntity;
import co.edu.uniandes.csw.lostoderos.entities.PagoEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.FacturaPersistence;
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
 * @author s.rangel
 */
@RunWith(Arquillian.class)
public class FacturaLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private FacturaLogic facturaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<FacturaEntity> data = new ArrayList<FacturaEntity>();
    private List<PagoEntity> pagoData = new ArrayList();

    @Deployment
    public static JavaArchive createDeployment() {
           return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FacturaEntity.class.getPackage())
                .addPackage(FacturaLogic.class.getPackage())
                .addPackage(FacturaPersistence.class.getPackage())
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
        em.createQuery("delete from FacturaEntity").executeUpdate();
        em.createQuery("delete from PagoEntity").executeUpdate();

    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
         for (int i = 0; i < 3; i++) {
            PagoEntity pago = factory.manufacturePojo(PagoEntity.class);
            em.persist(pago);
            pagoData.add(pago);
        }
          for (int i = 0; i < 3; i++) {
            
            FacturaEntity entity = factory.manufacturePojo(FacturaEntity.class);
            entity.setPago(pagoData.get(i));
            em.persist(entity);
            
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una factura
     *
     * @throws co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException
     */
    @Test
    public void createFacturaTest() throws BusinessLogicException {
        FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
        FacturaEntity result = facturaLogic.createFactura(newEntity);
        Assert.assertNotNull(result);
        FacturaEntity entity = em.find(FacturaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Prueba para consultar una Factura
     *
     * 
     */
    @Test
    public void getFacturaTest() {
        FacturaEntity entity = data.get(0);
        FacturaEntity resultEntity = facturaLogic.getById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }
        /**
     * Prueba para consultar la lista de Facturas
     *
     *
     */
    @Test
    public void getFacturasTest() {
        List<FacturaEntity> list = facturaLogic.getFacturas();
        Assert.assertEquals(data.size(), list.size());
        for (FacturaEntity entity : list) {
            boolean found = false;
            for (FacturaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        
    }

    /**
     * Prueba para eliminar una factura
     *
     * 
     */
    @Test
    public void deleteFacturaTest()   {
        FacturaEntity entity = data.get(0);
        facturaLogic.deleteFactura(entity.getId());
        FacturaEntity deleted = em.find(FacturaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Factura
     *
     * 
     */
    @Test
    public void updateFacturaTest() throws BusinessLogicException {
         FacturaEntity entity = data.get(0);
        FacturaEntity pojoEntity = factory.manufacturePojo(FacturaEntity.class);

        pojoEntity.setId(entity.getId());

        facturaLogic.updateFactura(pojoEntity);

        FacturaEntity resp = em.find(FacturaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
    }
}
