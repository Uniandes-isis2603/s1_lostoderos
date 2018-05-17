/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.test.logic;

import co.edu.uniandes.csw.lostoderos.ejb.PagoLogic;
import co.edu.uniandes.csw.lostoderos.entities.FacturaEntity;
import co.edu.uniandes.csw.lostoderos.entities.PagoEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.PagoPersistence;
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
 * @author nicol_000
 */
@RunWith(Arquillian.class)
public class PagoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private PagoLogic pagoLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private  List<PagoEntity> data = new ArrayList<>();
    
    private  List<FacturaEntity> facturas = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PagoEntity.class.getPackage())
                .addPackage(PagoLogic.class.getPackage())
                .addPackage(PagoPersistence.class.getPackage())
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
        em.createQuery("delete from HojaDeVidaEntity").executeUpdate();
        em.createQuery("delete from ContratistaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        
        for (int i = 0; i < 3; i++) {
            FacturaEntity entity = factory.manufacturePojo(FacturaEntity.class);
            em.persist(entity);
            facturas.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            PagoEntity entity = factory.manufacturePojo(PagoEntity.class);
            entity.setFactura(facturas.get(i));
            em.persist(entity);
            data.add(entity);
        }        
    }
    
    @Test
    public void createTest()throws BusinessLogicException{
        PagoEntity newEntity= factory.manufacturePojo(PagoEntity.class);
        PagoEntity result = pagoLogic.create(newEntity,facturas.get(0).getId());
        Assert.assertNotNull(result);
        PagoEntity entity = em.find(PagoEntity.class,result.getId());
        Assert.assertEquals(newEntity.getId(),entity.getId());
    }
    
    @Test
    public void getPagoFacturaTest() throws BusinessLogicException{
        
        PagoEntity entity = data.get(0);
        PagoEntity resultEntity = pagoLogic.getPagoFactura(facturas.get(0).getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
    }    
    
    @Test
    public void deletePagoTest()throws BusinessLogicException{
        PagoEntity entity = data.get(0);
        pagoLogic.deletePago(facturas.get(0).getId());
        PagoEntity deleted = em.find(PagoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updatePagoTest()throws BusinessLogicException {
        PagoEntity entity = data.get(0);
        PagoEntity pojoEntity = factory.manufacturePojo(PagoEntity.class);
        pojoEntity.setId(entity.getId());
        pagoLogic.update(entity.getFactura().getId(), pojoEntity);
        PagoEntity resp = em.find(PagoEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}