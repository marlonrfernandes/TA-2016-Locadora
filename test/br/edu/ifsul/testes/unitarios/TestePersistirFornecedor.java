/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Ator;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Fornecedor;
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
public class TestePersistirFornecedor {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirFornecedor() {
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
            Fornecedor f = new Fornecedor();
            f.setNome("Marlon Fernandes");
            f.setTelefone("(54) 9149-9557");
            f.setEmail("marlonrfernandes@gmail.com");
            f.setEndereco("Rua Waldomiro Bortoluzzi");
            f.setCidade("Passo Fundo");
            f.setIe("048782054171");
            f.setCnpj("76.956.752/0001-92");
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
}
