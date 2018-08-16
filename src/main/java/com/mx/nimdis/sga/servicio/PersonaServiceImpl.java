/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.nimdis.sga.servicio;

import com.mx.nimdis.sga.domain.Persona;
import com.mx.nimdis.sga.eis.PersonaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author nestordev
 */
@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaServiceLocal{
    
    
    @EJB
    private PersonaDAO personaDAO;
    
    @Override
    public List<Persona> listarPersonas() {
       
        return personaDAO.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
       return personaDAO.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return  personaDAO.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDAO.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        personaDAO.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDAO.deletePersona(persona);
    }
    
}
