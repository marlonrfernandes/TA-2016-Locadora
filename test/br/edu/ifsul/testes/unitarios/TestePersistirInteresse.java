/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Ator;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Filme;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marlon Rodrigues
 */
public class TestePersistirInteresse {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirInteresse() {
    }
    
        
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2016-LocadoraPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste(){
        boolean exception = false;
        try {
            Cliente c = em.find(Cliente.class, 1);
            Filme f = em.find(Filme.class, 19);
            c.getInteresses().add(f);            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
}
