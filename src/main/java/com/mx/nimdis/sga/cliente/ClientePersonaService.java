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
public class ClientePersonaService {
    
    public static void main(String[] args){
        
        System.out.println("Iniciar llamada al EJB desde cliente");
            
        try {
            Context jndi = new InitialContext();
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
