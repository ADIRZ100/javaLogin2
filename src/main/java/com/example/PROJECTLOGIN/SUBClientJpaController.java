/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PROJECTLOGIN;

import com.example.PROJECTLOGIN.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author user
 */
public class SUBClientJpaController implements Serializable {

    public SUBClientJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

 

   
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SUBClient SUBClient) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(SUBClient);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SUBClient SUBClient) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SUBClient = em.merge(SUBClient);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = SUBClient.getUserID();
                if (findSUBClient(id) == null) {
                    throw new NonexistentEntityException("The sUBClient with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SUBClient SUBClient;
            try {
                SUBClient = em.getReference(SUBClient.class, id);
                SUBClient.getUserID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The SUBClient with id " + id + " no longer exists.", enfe);
            }
            em.remove(SUBClient);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SUBClient> findSUBClientEntities() {
        return findSUBClientEntities(true, -1, -1);
    }

    public List<SUBClient> findSUBClientEntities(int maxResults, int firstResult) {
        return findSUBClientEntities(false, maxResults, firstResult);
    }

    private List<SUBClient> findSUBClientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SUBClient.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public SUBClient findSUBClient(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SUBClient.class, id);
        } finally {
            em.close();
        }
    }

    public int getSUBClientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SUBClient> rt = cq.from(SUBClient.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
