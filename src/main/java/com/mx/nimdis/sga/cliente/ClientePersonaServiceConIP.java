/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.nimdis.sga.cliente;

import com.mx.nimdis.sga.domain.Persona;
import com.mx.nimdis.sga.servicio.PersonaServiceRemote;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author nestordev
 */
public class ClientePersonaServiceConIP {

    public static void main(String[] args){
        
        System.out.println(" Iniciando llamada al EJB desdeel cliente");
        try {
            Properties props= new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            //aqui se cambia la ip del servidor 
            props.setProperty("org.omg.COBRA.ORBInitialHost", "127.0.0.1");
            // si se necesita combiar el puero.(default: 3700)
            //props.setProperty("org.omg.COBRA.ORBInitialPort", "11025");
            
            Context jndi= new InitialContext(props);
            PersonaServiceRemote  personaService =
            (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!com.mx.nimdis.sga.servicio.PersonaServiceRemote");
             List<Persona> personas = personaService.listarPersonas();
            personas.forEach((persona) -> {
                System.out.println(persona);
            });
            System.out.println("\n Fin de la llamada al EJB desde el cliente");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
}
