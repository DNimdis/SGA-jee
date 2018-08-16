/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mx.nimdis.sga.domain.Persona;
import com.mx.nimdis.sga.servicio.PersonaServiceLocal;
import java.util.List;
import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author nestordev
 */
public class PersonaServiceTestLocal {
 
   private PersonaServiceLocal personaService;

    @Before
    public void setUp() throws Exception {
        Properties props= new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            //aqui se cambia la ip del servidor 
            props.setProperty("org.omg.COBRA.ORBInitialHost", "127.0.0.1");
            // si se necesita combiar el puero.(default: 3700)
            props.setProperty("org.omg.COBRA.ORBInitialPort", "11025");
        EJBContainer contenedor = EJBContainer.createEJBContainer(props);
        personaService = (PersonaServiceLocal) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!com.mx.nimdis.sga.servicio.PersonaServiceLocal");
    }

    @Test
    public void testEJBPersonaService() {
        System.out.println("Iniciando test EJB PersonaService");
        assertTrue(personaService != null);

        assertEquals(2, personaService.listarPersonas().size());

        System.out.println("El no. de personas es igual a:" + personaService.listarPersonas().size());

        this.desplegarPersonas(personaService.listarPersonas());
        System.out.println("Fin test EJB PersonaService");
    }

    private void desplegarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
    
}
