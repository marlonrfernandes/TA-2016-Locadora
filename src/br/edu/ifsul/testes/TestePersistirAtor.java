/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Ator;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marlon Rodrigues
 */
public class TestePersistirAtor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("TA-2016-LocadoraPU");
        EntityManager em = emf.createEntityManager();
        Ator a = new Ator();
        a.setNome("Leonardo DiCaprio");
        a.setNascimento(new GregorianCalendar(1974, Calendar.NOVEMBER,11));
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        emf.close();        
    }
    
}
