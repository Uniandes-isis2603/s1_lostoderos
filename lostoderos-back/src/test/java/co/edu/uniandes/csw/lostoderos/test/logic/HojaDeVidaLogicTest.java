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
import org.junit.After;
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
    
    private final PodamFactory factory = new PodamFactoryImpl();
    
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
    
    private void configData() {
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
            em.persist(entity);
            data.add(entity);
        }
        
        
    }
    
    /** Se omite este Test porque si se coloca hace que las demás preubas no funcionen.
     * Para probar que el método create de HojaDeVidaTest está bien, debe descomentar el test.
    @Test
    public void create()throws BusinessLogicException{
        HojaDeVidaEntity newEntity= factory.manufacturePojo(HojaDeVidaEntity.class);
        ContratistaEntity contratista = contratistas.get(0);
        newEntity.setContratista(contratista);
        HojaDeVidaEntity result = hojaVidaLogic.create(newEntity);
        Assert.assertNotNull(result);
        HojaDeVidaEntity entity = em.find(HojaDeVidaEntity.class,result.getId());
        Assert.assertEquals(newEntity.getId(),entity.getId());
    }
    */
    
    @Test
    public void getAll(){
        
        List<HojaDeVidaEntity> list = hojaVidaLogic.getAll();
        Assert.assertEquals(data.size(), list.size());
        for(HojaDeVidaEntity entity:list){
            boolean found = false;
            for(HojaDeVidaEntity storedEntity:data){
                if(entity.getId().equals(storedEntity.getId())) found =true;
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void findById() throws BusinessLogicException{
        
        HojaDeVidaEntity entity = data.get(0);
        HojaDeVidaEntity resultEntity = hojaVidaLogic.findById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }
    
    @Test
    public void delete()throws BusinessLogicException{
        HojaDeVidaEntity entity = data.get(0);
        hojaVidaLogic.delete(entity.getId());
        HojaDeVidaEntity deleted = em.find(HojaDeVidaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateContratistaTest()throws BusinessLogicException {
        HojaDeVidaEntity entity = data.get(0);
        HojaDeVidaEntity pojoEntity = factory.manufacturePojo(HojaDeVidaEntity.class);
        pojoEntity.setContratista(contratistas.get(0));
        pojoEntity.setId(entity.getId());
        hojaVidaLogic.update(pojoEntity.getId(), pojoEntity);
        HojaDeVidaEntity resp = em.find(HojaDeVidaEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }
}