/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.lostoderos.test.logic;

import co.edu.uniandes.csw.lostoderos.ejb.UsuarioLogic;
import co.edu.uniandes.csw.lostoderos.entities.UsuarioEntity;
import co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.lostoderos.persistence.UsuarioPersistence;
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
 * @author s.naranjop1
 */
@RunWith(Arquillian.class)
public class UsuarioLogicTest 
{
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private UsuarioLogic usuarioLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<UsuarioEntity> data = new ArrayList<UsuarioEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioLogic.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
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
        em.createQuery("delete from UsuarioEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            
            UsuarioEntity entity = factory.manufacturePojo(UsuarioEntity.class);
            
            em.persist(entity);
            
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Usuario
     *
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void createUsuarioTest() throws BusinessLogicException {
        UsuarioEntity newEntity = factory.manufacturePojo(UsuarioEntity.class);
        UsuarioEntity result = usuarioLogic.create(newEntity);
        Assert.assertNotNull(result);
        UsuarioEntity entity = em.find(UsuarioEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar un Usuario
     *
     * 
     */
    @Test
    public void getUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity resultEntity =usuarioLogic.getById(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }

    /**
     * Prueba para consultar la lista de Usuarios
     *
     *
     */
    @Test
    public void getAllTest(){
        List<UsuarioEntity> list = usuarioLogic.getAll();
        Assert.assertEquals(data.size(), list.size());
        for(UsuarioEntity entity:list){
            boolean found = false;
            for(UsuarioEntity storedEntity:data){
                if(entity.getId().equals(storedEntity.getId())) found =true;
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para eliminar un Usuario
     *
     * 
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void deleteUsuarioTest() throws BusinessLogicException {
        UsuarioEntity entity = data.get(0);
        usuarioLogic.delete(entity.getId());
        UsuarioEntity deleted = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Usuario
     *
     * 
     * @throws co.edu.uniandes.csw.lostoderos.exceptions.BusinessLogicException
     */
    @Test
    public void updateUsuarioTest() throws BusinessLogicException {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity pojoEntity = factory.manufacturePojo(UsuarioEntity.class);

        pojoEntity.setId(entity.getId());

        usuarioLogic.update(pojoEntity);

        UsuarioEntity resp = em.find(UsuarioEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }   
}
