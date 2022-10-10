package br.edu.ifsul.clinica.model;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * @author Bernardo Dirceu Tomasi
 */

@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_atendimento", sequenceName = "seq_atendimento_id",
    allocationSize = 1)
    @GeneratedValue(generator="seq_atendimento", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message="O valor deve ser informado")
    @Column(name="valor", nullable= false, columnDefinition = "numeric(10,2)")
    private Double valor;
    
    @NotNull(message = "o medico deve ser informado")
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false)
    private Medico medico;
    
    @NotNull(message = "o paciente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
    
    @NotBlank(message="a descricao deve ser informado")
    @Length(max = 40, message = "a descricao não pode ter mais que 300 caracteres")
    @Column(name="descricao", nullable= false, length=300)
    private String Descricao;
    
    @NotNull(message="a data da consulta deve ser informado")
    @Column(name="data", nullable= false)
    @Temporal(TemporalType.DATE)
    private Calendar data;
    
    public Atendimento(){
        
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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
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
        final Atendimento other = (Atendimento) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
