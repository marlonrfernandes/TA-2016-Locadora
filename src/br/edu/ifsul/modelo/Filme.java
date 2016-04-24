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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "filme")
public class Filme implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_filme", sequenceName = "seq_filme_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_filme", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O Título deve possuir até {max} caracteres")
    @NotBlank(message = "O Título deve ser informado!")
    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;
    @Column(name = "diretor", length = 50)
    private String diretor;
    @NotNull(message = "A quantidade deve ser informada!")
    @Column(name = "quantidade", nullable = false, columnDefinition = "numeric(12,2)")
    private Double quantidade;
    @NotNull(message = "O preço deve ser informado!")
    @Column(name = "preco", nullable = false, columnDefinition = "numeric(12,2)")
    private Double preco;
    @NotNull(message = "O ano deve ser informado!")
    @Column(name = "ano", nullable = false)
    private Integer ano;
    @Length(max = 800, message = "A Sínopse deve possuir até {max} caracteres")
    @NotBlank(message = "A Sínopse deve ser informada!")
    @Column(name = "sinopse", length = 800, nullable = false)
    private String sinopse;
    @Length(max = 5, message = "O Lançamento deve possuir até {max} caracteres")
    @NotBlank(message = "O Lançamento deve ser informado!")
    @Column(name = "lancamento", length = 5, nullable = false)
    private String lancamento;
    @Length(max = 15, message = "O formato deve possuir até {max} caracteres")
    @NotBlank(message = "O Formato deve ser informado!")
    @Column(name = "formato", length = 15, nullable = false)
    private String formato;
    @Column(name = "duracao", length = 20)
    private String duracao;
    @Length(max = 10, message = "O Tipo deve possuir até {max} caracteres")
    @NotBlank(message = "O Tipo deve ser informado!")
    @Column(name = "tipo", length = 10, nullable = false)
    private String tipo;
    
    @NotNull(message = "O Gênero deve ser informado!")
    @ManyToOne
    @JoinColumn(name = "genero", referencedColumnName = "id", nullable = false)
    private Genero genero;
    @ManyToMany
    @JoinTable(name = "interesses",
            joinColumns = 
            @JoinColumn(name = "filme", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "pessoa", referencedColumnName = "id", 
                    nullable = false))
    private List<Pessoa> interessam = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "fornece",
            joinColumns = 
            @JoinColumn(name = "filme", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "fornecedor", referencedColumnName = "id", 
                    nullable = false))
    private List<Fornecedor> fornecedores = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "atuacao",
            joinColumns = 
            @JoinColumn(name = "filme", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "ator", referencedColumnName = "id", 
                    nullable = false))
    private List<Ator> atuacao = new ArrayList<>();
    
    
    
    
    
    public Filme() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Filme other = (Filme) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filme{" + "titulo=" + titulo + '}';
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Pessoa> getInteressam() {
        return interessam;
    }

    public void setInteressam(List<Pessoa> interessam) {
        this.interessam = interessam;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<Ator> getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(List<Ator> atuacao) {
        this.atuacao = atuacao;
    }

    
    
    
    
}
