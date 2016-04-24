/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marlon Rodrigues
 */
@Embeddable
public class AluguelID implements Serializable{
    @NotNull(message = "O numero da nota deve ser informada!")
    @Column(name = "numero_nota", nullable = false)
    private Integer numeroNota;
    @NotNull(message = "A pessoa deve ser informada!")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.numeroNota);
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
        final AluguelID other = (AluguelID) obj;
        if (!Objects.equals(this.numeroNota, other.numeroNota)) {
            return false;
        }
        return true;
    }
    
    

    public Integer getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
}
