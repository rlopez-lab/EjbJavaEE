
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ActualizarObjetoSesionLarga {
   static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx= em.getTransaction();        
        tx.begin();
        
        Persona persona1 = em.find(Persona.class, 1);
        log.debug("Objeto encontrado: " + persona1);
        
        //paso 3 setValue (nuevoValor)
        persona1.setEmail("jjuarez@mail.com");
        persona1.setEmail("j.juarez@mail.com");
        
        //Paso 4 termina la transaccion
        tx.commit();
        
        //Objeto en estad detached
        log.debug("Objeto modificado: " + persona1);
        
        
        em.close();
        
    }
    
}
