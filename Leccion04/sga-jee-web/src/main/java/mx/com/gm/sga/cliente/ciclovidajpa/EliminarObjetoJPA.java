
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EliminarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Persona persona1 = em.find(Persona.class, 13);                           
        tx.commit();
        log.debug("Objeto encontrado: " + persona1);
        
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        em.remove(em.merge(persona1));
        tx2.commit();
        log.debug("Objeto eliminado: " + persona1);
        em.close();
                
        
    }
    
}
