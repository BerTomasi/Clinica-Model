package br.edu.ifsul.clinica.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * @author Bernardo Dirceu Tomasi
 */

@Entity
@Table(name = "clinica")
public class Clinica {
    
    @Id
    @SequenceGenerator(name = "seq_polo", sequenceName = "seq_polo_id",
    allocationSize = 1)
    @GeneratedValue(generator="seq_polo", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="O nome do polo deve ser informado")
    @Length(max = 100, message = "O nome do polo não pode ter mais que 100 caracteres")
    @Column(name="nome", nullable= false, length=100)
    private String nome;
    
    @NotBlank(message="O telefone deve ser informado")
    @Length(max = 10, min=8, message = "O telefone não pode ter mais que 9 caracteres")
    @Column(name="telefone", nullable= false, length=10)
    private String telefone;
    
    @NotBlank(message="A cidade deve ser informado")
    @Length(max = 50, message = "A cidade não pode ter mais que 50 caracteres")
    @Column(name="cidade", nullable= false, length=50)
    private String cidade;
    
    public Clinica(){
        
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clinica other = (Clinica) obj;
        return Objects.equals(this.id, other.id);
    }
}
