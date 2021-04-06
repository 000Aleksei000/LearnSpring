import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.simpleJpa.model.Category;
import org.simpleJpa.model.Topic;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppTest {
    private EntityManager em;

    @Before
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaRush");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void close() {
        if(em.getTransaction().isActive()){
            em.getTransaction().commit();
        }
        em.getEntityManagerFactory().close();
        em.close();
    }
    @Test
    public void shouldPersistCategory() {
        Category cat = new Category();
        cat.setTitle("new category");
        // JUnit обеспечит тест свежим EntityManager'ом
        em.persist(cat);
    }

    @Test
    public void shouldFindCategory(){
        Category cat = new Category();
        cat.setTitle("test");
        em.persist(cat);
        Category result = em.find(Category.class, 1L);
        Assert.assertNotNull(result);
    }
    @Test
    public void shouldPersistCategoryAndTopics() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }
}