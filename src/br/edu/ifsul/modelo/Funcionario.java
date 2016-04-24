/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marlon Rodrigues
 */
@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable{
    @NotBlank(message = "O Login deve ser informado!")
    @Length(max = 20, message = "O Login não deve ter mais que {max} caracteres")
    @Column(name = "login", length = 20, nullable = false)    
    private String login;
    @NotBlank(message = "A senha deve ser informada!")
    @Length(max = 15, message = "A senha não deve ter mais que {max} caracteres")
    @Column(name = "senha", length = 15, nullable = false)    
    private String senha;
    
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, 
            orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Cliente> atende = new ArrayList<>();
    
    

    public Funcionario() {
    }
    
    public void adicionarCliente(Cliente obj){
        obj.setFuncionario(this);
        this.atende.add(obj);
    }
    
    public void removerCliente(int index){
        Cliente obj = this.atende.get(index);
        this.atende.remove(obj);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Cliente> getAtende() {
        return atende;
    }

    public void setAtende(List<Cliente> atende) {
        this.atende = atende;
    }




    
    
}
