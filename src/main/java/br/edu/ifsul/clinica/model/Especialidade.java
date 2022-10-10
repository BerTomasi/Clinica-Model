package br.edu.ifsul.clinica.model;

import java.io.Serializable;
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
 *
 * @author Bernardo Dirceu Tomasi
 */

@Entity
@Table(name = "especialidade") 
public class Especialidade implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_especialidade", sequenceName = "seq_especialidadeo_id",
    allocationSize = 1)
    @GeneratedValue(generator="seq_especialidade", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="O nome deve ser informado")
    @Length(max = 40, message = "O nome não pode ter mais que 40 caracteres")
    @Column(name="nome", nullable= false, length=40)
    private String nome;
    
    public Especialidade(){
        
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
        final Especialidade other = (Especialidade) obj;
        return Objects.equals(this.id, other.id);
    }
}
