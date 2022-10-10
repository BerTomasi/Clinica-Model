package br.edu.ifsul.clinica.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * @author Bernardo Dirceu Tomasi
 */

@Entity
@Table(name = "paciente") 
public class Paciente implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id",
    allocationSize = 1)
    @GeneratedValue(generator="seq_pessoa", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="O CPF deve ser informado")
    @Length(max = 14, min=14, message = "O CPF deve ter 11 dígitos")
    @Column(name="CPF", nullable= false, length=14)
    private String CPF;
    
    @NotBlank(message="O nome deve ser informado")
    @Length(max = 50, message = "O nome deve ter até 50 caracteres")
    @Column(name="nome", nullable= false, length=50)
    private String nome;
    
    @NotNull(message="A data de nascimento deve ser informado")
    @Column(name="nascimento", nullable= false)
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    
    @NotBlank(message="O telefone deve ser informado")
    @Length(max = 14, min=14, message = "O telefone deve ter 9 dígitos mais o DDD")
    @Column(name="telefone", nullable= false, length=14)
    private String telefone;
    
    public Paciente (){
        
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
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
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
     * @return the nascimento
     */
    public Calendar getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
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
        final Paciente other = (Paciente) obj;
        return Objects.equals(this.id, other.id);
    }
}
