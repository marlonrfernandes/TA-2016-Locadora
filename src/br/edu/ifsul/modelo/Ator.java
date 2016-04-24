/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marlon Rodrigues
 */
@Entity
@Table(name = "ator")
public class Ator implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_ator", sequenceName = "seq_ator_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ator", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O nome deve possuir até {max} caracteres")
    @NotBlank(message = "O nome deve ser informado!")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento")
    private Calendar nascimento;
    @ManyToMany
    @JoinTable(name = "atuacao",
            joinColumns = 
            @JoinColumn(name = "ator", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "filme", referencedColumnName = "id", 
                    nullable = false))    
    private List<Filme> atuam = new ArrayList<>();

    public Ator() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Ator other = (Ator) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ator{" + "nome=" + nome + '}';
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public List<Filme> getAtuam() {
        return atuam;
    }

    public void setAtuam(List<Filme> atuam) {
        this.atuam = atuam;
    }
    
    
}
