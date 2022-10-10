package br.edu.ifsul.teste;

import br.edu.ifsul.clinica.model.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bernardo Dirceu Tomasi
 */
public class PersistirEspecialidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Clinica-ModelPU");
        
        EntityManager em = emf.createEntityManager();
        
        Especialidade e = new Especialidade();

        e.setNome("Neurologia");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Psiquiatria");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Cardiologia");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Clínica Médica");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Gastrologia");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Dermatologia");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Imunologia");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
