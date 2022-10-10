package br.edu.ifsul.clinica.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * @author Bernardo Dirceu Tomasi
 */
@Entity
@Table(name = "medico")
public class Medico implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_medico", sequenceName = "seq_medico_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_medico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14, min=14, message = "O CPF deve ter 11 dígitos")
    @Column(name = "CPF", nullable = false, length = 14)
    private String CPF;

    @NotBlank(message = "O CRM deve ser informado")
    @Length(max = 6, min=6, message = "O CRM deve ter 6 dígitos")
    @Column(name = "CRM", nullable = false, length = 6)
    private String CRM;

    @NotNull(message = "a especialidade deve ser informado")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    private Especialidade especialidade;

    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome deve ter até 50 caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @NotBlank(message="O telefone deve ser informado")
    @Length(max = 14, min=14, message = "O telefone deve ter 9 dígitos")
    @Column(name="telefone", nullable= false, length=14)
    private String telefone;
    
    @NotNull(message = "A clinica de atentimento deve ser informado")
    @ManyToOne
    @JoinColumn(name = "clinica", referencedColumnName = "id", nullable = false)
    private Clinica clinica;

    public Medico() {

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
     * @return the CRM
     */
    public String getCRM() {
        return CRM;
    }

    /**
     * @param CRM the CRM to set
     */
    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    /**
     * @return the especialidade
     */
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Medico other = (Medico) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * @return the clinica
     */
    public Clinica getClinica() {
        return clinica;
    }

    /**
     * @param clinica the clinica to set
     */
    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
}
