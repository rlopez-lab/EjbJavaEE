
package mx.com.gm.sga.cliente.ciclovidajpa;


import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;



public class ActualizarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. inicia la transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //2. ejecutar SQL de tipo select 
        //El id proporcionada debe existir en la base de datos
        Persona persona1 = em.find(Persona.class, 1);
        
        //3 termina la transaccion 1
        tx.commit();
        //Objeto en estado detached
        log.debug("Objeto recuperado: " + persona1);
        
        //Paso 4 setValue (nuevoValor)
        persona1.setApellido("Juarez");
        
        //Paso 5 inicia la transaccion 2
        EntityTransaction tx2 = em.getTransaction();        
        tx2.begin();
        //Paso 6 Modificamos el objeto
        em.merge(persona1);
        
        
        //Paso 7 termina la transaccion 2
        tx2.commit();
        
        //Objeto en estado detached ya  modificado
        log.debug("Objeto recuperado: " + persona1);
        //Cerramos el entity manager
        em.close();
        
    }
    
}
