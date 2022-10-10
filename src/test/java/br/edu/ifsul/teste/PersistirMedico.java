package br.edu.ifsul.teste;

import br.edu.ifsul.clinica.model.Especialidade;
import br.edu.ifsul.clinica.model.Medico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20202PF.CC0002
 */
public class PersistirMedico {

    public static void main(String[] args) {

        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Clinica-ModelPU");

        EntityManager em = emf.createEntityManager();

        Medico e = new Medico();
        Especialidade es = em.find(Especialidade.class, 1);

        e.setNome("Bernardo Tomasi");
        e.setCPF("12345678912");
        e.setCRM("123456");
        e.setTelefone("123456789");
        e.setEspecialidade(es);
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
