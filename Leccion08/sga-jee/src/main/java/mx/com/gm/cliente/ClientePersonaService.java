
package mx.com.gm.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;


public class ClientePersonaService {
    public static void main(String[] args)  {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService  = (PersonaServiceRemote) 
                    jndi.lookup( "java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = personaService.listarPersonas();
            
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
