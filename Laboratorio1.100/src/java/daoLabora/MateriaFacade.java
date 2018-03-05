/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoLabora;

import LaborModel.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Santiago
 */
@Stateless
public class MateriaFacade extends AbstractFacade<Materia> implements MateriaFacadeLocal {

    @PersistenceContext(unitName = "Laboratorio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaFacade() {
        super(Materia.class);
    }

    @Override
    public List<Materia> listMaterias(int code) {
         Query q =em.createQuery("select a from Materia a where a.code=:code");
        q.setParameter("code", code);      
        return q.getResultList();
    }
    
//     public List<Materia> listMaterias2(int code,String name,int credits,String horary) {
//         Query q =em.createQuery("select a from Materia a where a.code=:code and a.name=:name and a.credits=:credits and a.horary=:horary");
//         q.setParameter("code", code);
//         q.setParameter("name", name);
//         q.setParameter("credits", credits);
//         q.setParameter("horary", horary);
//        return q.getResultList();
//    }
    
    
    
    
}
