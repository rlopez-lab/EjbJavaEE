
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;


public class EncontrarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        
        //Inicia la transaccion 
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        //paso 2 ejecutar sql tipo select
        Persona persona1 = em.find(Persona.class, 1);
        
        //Paso 3 termina la transaccion
        tx.commit();
        log.debug("Objeto recuperado: " + persona1);
        
        //cerramos el entitymanager
        em.close();
    }
    
}
