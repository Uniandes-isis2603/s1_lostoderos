/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.test.logic;

import co.edu.uniandes.csw.lostoderos.ejb.CotizacionLogic;
import co.edu.uniandes.csw.lostoderos.entities.CotizacionEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.CotizacionPersistence;
import java.util.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author m.saravia
 */
@RunWith(Arquillian.class)
public class CotizacionLogicTest {
    
    /**
     * 
     */
    private PodamFactoryImpl factory= new PodamFactoryImpl();
        
    /**
     * 
     */
    @Inject
    private CotizacionLogic cotizacionLogic;
    
    /**
     * 
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * 
     */
    @Inject
    private UserTransaction utx;
    
    /**
     * 
     */
    private List<CotizacionEntity> data= new ArrayList<CotizacionEntity>();
    
    /**
     * 
     * @return 
     */
    @Deployment
    public static JavaArchive createDeployment(){
        
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CotizacionEntity.class.getPackage())
                .addPackage(CotizacionLogic.class.getPackage())
                .addPackage(CotizacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * 
     */
    @Before
    public void confifTest(){
        
        try{
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        }catch(Exception e){
            e.printStackTrace();
            try{
                utx.rollback();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        
    }
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     */
    private void clearData() {
        em.createQuery("delete from CotizacionEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            
            CotizacionEntity entity = factory.manufacturePojo(CotizacionEntity.class);
            
            em.persist(entity);
            
            data.add(entity);
        }
    }
    
    /**
     * 
     * @throws BusinessLogicException 
     */
   @Test
   public void createCotizacionTest()throws BusinessLogicException{
       
       CotizacionEntity newEntity= factory.manufacturePojo(CotizacionEntity.class);
       CotizacionEntity result= cotizacionLogic.create(newEntity);
       Assert.assertNotNull(result);
       CotizacionEntity entity= em.find(CotizacionEntity.class, result.getId());
       Assert.assertEquals(newEntity.getId(), entity.getId());
       Assert.assertEquals(newEntity.getName(), entity.getName());
   }
   
   /**
    * 
    * @throws BusinessLogicException 
    */
   @Test
   public void getCotizacionTest()throws BusinessLogicException{
       
       CotizacionEntity entity= data.get(0);
       CotizacionEntity resultEntity= cotizacionLogic.getById(entity.getId());
       Assert.assertNotNull(resultEntity);
       Assert.assertEquals(entity.getId(), resultEntity.getId());
       Assert.assertEquals(entity.getName(), resultEntity.getName());
   }
   
   /**
    * 
    * @throws BusinessLogicException 
    */
   @Test
   public void updateCotizacionTest() throws BusinessLogicException{
       
       CotizacionEntity entity= data.get(0);
       CotizacionEntity pojoEntity= factory.manufacturePojo(CotizacionEntity.class);
       
       pojoEntity.setId(entity.getId());
       
       cotizacionLogic.update(pojoEntity);
       
       CotizacionEntity result= em.find(CotizacionEntity.class, entity.getId());
       
       Assert.assertEquals(pojoEntity.getId(), result.getId());
   }
   
   /**
    * 
    * @throws BusinessLogicException
    */
   @Test
    public void deleteCotizacionTest() throws BusinessLogicException {
        
        CotizacionEntity entity = data.get(0);
        cotizacionLogic.delete(entity.getId());
        CotizacionEntity deleted = em.find(CotizacionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    
}
