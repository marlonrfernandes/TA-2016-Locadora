/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Ator;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Funcionario;
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
public class TestePersistirCliente {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCliente() {
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
            
            Cliente c = new Cliente();
            c.setNome("José");
            c.setTelefone("(55) 9999-9999");
            c.setEmail("josedossantos@hotmail.com");
            c.setEndereco("Rua 1");
            c.setCidade("Passo Fundo");
            c.setCpf("022.232.780-43");
            c.setRg("9097834882");
            c.setFuncionario(em.find(Funcionario.class, 1));
            c.setData_nascimento(new GregorianCalendar(1990, Calendar.SEPTEMBER,27));
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
