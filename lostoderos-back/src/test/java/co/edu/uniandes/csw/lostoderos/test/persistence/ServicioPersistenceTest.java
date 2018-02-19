/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.test.persistence;

import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;
import co.edu.uniandes.csw.lostoderos.persistence.ServicioPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import junit.framework.Assert;
import org.jboss.arquillian.junit.Arquillian;
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
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AuthorEntity.class.getPackage())
                .addPackage(AuthorPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

 
    @Inject
    private ServicioPersistence servicioPersistence;

 
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void createAuthorTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ServicioEntity newEntity = factory.manufacturePojo(ServicioEntity.class);
        ServicioEntity result = ServicioPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ServicioEntity entity = em.find(ServicioEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
}
