/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.AluguelID;
import br.edu.ifsul.modelo.AluguelItem;
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
public class TestePersistirAluguel {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirAluguel() {
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
            Aluguel a = new Aluguel();
            AluguelID id = new AluguelID();
            id.setNumeroNota(22222);
            id.setPessoa(em.find(Cliente.class, 9));
            a.setId(id);
            a.setData(Calendar.getInstance());
            //a.setValorTotal(10.00);
            AluguelItem item = new AluguelItem();
            item.setFilme(em.find(Filme.class, 20));
            item.setQuantidade(3.00);
            item.setValorUnitario(item.getFilme().getPreco());
            item.setValorTotal(item.getQuantidade()*item.getValorUnitario());
//            a.adicionarAluguel(item);
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
}
