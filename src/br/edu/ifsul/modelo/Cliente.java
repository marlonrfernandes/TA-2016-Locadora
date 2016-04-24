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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Marlon Rodrigues
 */
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable{
    @CPF(message = "Informe um CPF válido!")
    @NotBlank(message = "O CPF deve ser informado!")
    @Length(max = 14, message = "O CPF não deve ter mais que {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false)    
    private String cpf;
    @NotBlank(message = "O RG deve ser informado!")
    @Length(min= 10,max = 10, message =
            "O RG  deve ter {max} caracteres")
    @Column(name = "rg", length = 10, nullable = false)   
    private String rg;
    @NotNull(message = "A Dada de Nascimento deve ser informada!")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = false)
    private Calendar data_nascimento;
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;
    
    
    

    public Cliente() {
    }
    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

   
    

    
    
    
}
