
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;

import org.apache.logging.log4j.*;


public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //inicia la transaccion
        
        //Paso 1. crea nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Pedro", "Luna", "pluna@mail.com", "13135566");
        
        //paso 3 inicia transaccion
        tx.begin();
        em.persist(persona1);
        
        //paso4 . commit
        tx.commit();
        
        log.debug("objeto persistido en estado de detached: " + persona1);
        //cerramos el entity manager
        em.close();
        
    }
    
}
