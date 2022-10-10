package br.edu.ifsul.teste;

import br.edu.ifsul.clinica.model.Clinica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bernardo Dirceu Tomasi
 */
public class PersistirClinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Clinica-ModelPU");
        
        EntityManager em = emf.createEntityManager();
        
        Clinica e = new Clinica();

        e.setNome("Planalto Médio");
        e.setTelefone("35658041");
        e.setCidade("Passo Fundo");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Planalto Médio - Hospital Central");
        e.setTelefone("33759152");
        e.setCidade("Passo Fundo");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Serra Gaúcha");
        e.setTelefone("21845418");
        e.setCidade("Caxias do Sul");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Lagoa dos Patos");
        e.setTelefone("37778069");
        e.setCidade("POA");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Serras de Sudeste");
        e.setTelefone("32364616");
        e.setCidade("Pelotas");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Centro Ocidental");
        e.setTelefone("32364616");
        e.setCidade("Sata Maria");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Campanha Gaúcha");
        e.setTelefone("38664046");
        e.setCidade("Bagé");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        
        e.setNome("Centro Oriental");
        e.setTelefone("38823546");
        e.setCidade("Lageado");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
