/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoLabora;

import LaborModel.Estudiante;
import java.awt.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Santiago
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {

    @PersistenceContext(unitName = "Laboratorio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }

    @Override
    public boolean checkLogin(Integer i, String p) {       
        Query q =em.createQuery("select a from Estudiante a"
            + " where a.id=:i and a.password=:p");
        q.setParameter("i", i);
        q.setParameter("p", p);       
       return q.getResultList().size()>0;
    }
    


    

    
    
}
