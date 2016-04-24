/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author Marlon Rodrigues
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa implements Serializable {

    @NotBlank(message = "Incrição estadual não pode ser nula!")
    @Column(name = "ie", length = 15, nullable = false)
    private String ie;
    @CNPJ(message = "CNPJ inválido!")
    @NotBlank(message = "CNPJ não pode ser nulo!")
    @Column(name = "cnpj", length = 18, nullable = false)
    private String cnpj;
    @ManyToMany
    @JoinTable(name = "fornece",
            joinColumns
            = @JoinColumn(name = "fornecedor", referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "filme", referencedColumnName = "id",
                    nullable = false))
    private List<Filme> fornece = new ArrayList<>();

    public Fornecedor() {
    }
    
    


    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Filme> getFornece() {
        return fornece;
    }

    public void setFornece(List<Filme> fornece) {
        this.fornece = fornece;
    }

}
