/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.test.logic;

import co.edu.uniandes.csw.lostoderos.ejb.HojaDeVidaLogic;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.HojaDeVidaEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.HojaDeVidaPersistence;
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
public class HojaDeVidaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private HojaDeVidaLogic hojaVidaLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private  List<HojaDeVidaEntity> data = new ArrayList<>();
    
    private  List<ContratistaEntity> contratistas = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HojaDeVidaEntity.class.getPackage())
                .addPackage(HojaDeVidaLogic.class.getPackage())
                .addPackage(HojaDeVidaPersistence.class.getPackage())
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
            ContratistaEntity entity = factory.manufacturePojo(ContratistaEntity.class);
            em.persist(entity);
            contratistas.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            HojaDeVidaEntity entity = factory.manufacturePojo(HojaDeVidaEntity.class);
            entity.setContratista(contratistas.get(i));
            em.persist(entity);
            data.add(entity);
        }        
    }
    
    /* Se omite este Test porque si se coloca hace que las demás preubas no funcionan. Según
    parece, es porque en el mismo método se crea la relación entre contratista y hoja de vida.
     * Para probar que el método create de HojaDeVidaTest está bien, debe descomentar el test.
    */
    /*
    
    */
    @Test
    public void createTest()throws BusinessLogicException{
        HojaDeVidaEntity newEntity= factory.manufacturePojo(HojaDeVidaEntity.class);
        HojaDeVidaEntity result = hojaVidaLogic.create(contratistas.get(0).getId(),newEntity);
        Assert.assertNotNull(result);
        HojaDeVidaEntity entity = em.find(HojaDeVidaEntity.class,result.getId());
        Assert.assertEquals(newEntity.getId(),entity.getId());
    }
    
    @Test
    public void findByIdContratistaTest() throws BusinessLogicException{
        
        HojaDeVidaEntity entity = data.get(0);
        HojaDeVidaEntity resultEntity = hojaVidaLogic.findByIdContratista(contratistas.get(0).getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
    }
    
    @Test
    public void deleteTest()throws BusinessLogicException{
        HojaDeVidaEntity entity = data.get(0);
        hojaVidaLogic.delete(contratistas.get(0).getId());
        HojaDeVidaEntity deleted = em.find(HojaDeVidaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateTest()throws BusinessLogicException {
        HojaDeVidaEntity entity = data.get(0);
        HojaDeVidaEntity pojoEntity = factory.manufacturePojo(HojaDeVidaEntity.class);
        pojoEntity.setId(entity.getId());
        hojaVidaLogic.update(entity.getContratista().getId(), pojoEntity);
        HojaDeVidaEntity resp = em.find(HojaDeVidaEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }
}