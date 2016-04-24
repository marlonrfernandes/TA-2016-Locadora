/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Ator;
import br.edu.ifsul.modelo.Filme;
import br.edu.ifsul.modelo.Genero;
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
public class TestePersistirFilme {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirFilme() {
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
            Filme f = new Filme();
            f.setTitulo("Titanic");
            f.setDiretor("James Cameron");
            f.setQuantidade(10.00);
            f.setPreco(5.00);
            f.setAno(1997);
            String v = ",";
            f.setSinopse("Titanic é um filme norte-americano de 1997 escrito" + v + " dirigido" +v+ " co-produzido"
                    + "e co-editado por James Cameron. É uma história de ficção do naufrágio real do"
                    + "RMS Titanic" +v+ " estrelando Leonardo DiCaprio como Jack Dawson"+v+" e Kate Winslet como"
                    + "Rose DeWitt Bukater"+v+" membros de diferentes classes sociais que se apaixonam"
                    + "durante a fatídica viagem inaugural no navio. Apesar dos personagens principais"
                    + "serem fictícios"+v+" alguns personagens são figuras históricas.");
            f.setLancamento("Não");
            f.setFormato("1080p");
            f.setDuracao("180 minutos");
            f.setTipo("Blu-ray");
            //f.setAtor(em.find(Ator.class, 1));
            f.setGenero(em.find(Genero.class, 4));
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
