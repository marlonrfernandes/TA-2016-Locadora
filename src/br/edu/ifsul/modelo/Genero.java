/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marlon Rodrigues
 */
@Entity
@Table(name = "genero")
public class Genero implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_genero", sequenceName = "seq_genero_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_genero", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 30, message = "O nome deve possuir até {max} caracteres")
    @NotBlank(message = "O nome deve ser informado!")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "A classificação deve ser informada!")
    @Column(name = "classificacao", nullable = false)
    private Integer classificacao;

    public Genero() {
    }

    @Override
    public String toString() {
        return "Genero{" + "nome=" + nome + '}';
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Genero other = (Genero) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
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

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }
    
    
}
