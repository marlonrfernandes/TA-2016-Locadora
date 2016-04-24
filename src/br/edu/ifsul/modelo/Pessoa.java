/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marlon Rodrigues
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE) 
    private Integer id;
    @NotBlank(message = "O nome deve ser informado!")
    @Length(max = 50, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)    
    private String nome;
    @NotBlank(message = "O telefone deve ser informado!")
    @Length(max = 14, message = "O telefone não deve ter mais que {max} caracteres")
    @Column(name = "telefone", length = 14, nullable = false)    
    private String telefone;
    @Email(message = "Informe um email válido!")
    @NotBlank(message = "O email deve ser informado!")
    @Length(max = 50, message = "O email não deve ter mais que {max} caracteres")
    @Column(name = "email", length = 50, nullable = false, unique = true)    
    private String email;
    @NotBlank(message = "O endereco deve ser informado!")
    @Length(max = 60, message = "O endereco não deve ter mais que {max} caracteres")
    @Column(name = "endereco", length = 60, nullable = false)    
    private String endereco;
    @NotBlank(message = "A cidade deve ser informada!")
    @Length(max = 50, message = "A cidade não deve ter mais que {max} caracteres")
    @Column(name = "cidade", length = 50, nullable = false)    
    private String cidade;
    @ManyToMany
    @JoinTable(name = "interesses",
            joinColumns = 
            @JoinColumn(name = "pessoa", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "filme", referencedColumnName = "id", 
                    nullable = false))
    private List<Filme> interesses = new ArrayList<>();

    public Pessoa() {
    }
    


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Filme> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<Filme> interesses) {
        this.interesses = interesses;
    }
    
    
}
