/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marlon Rodrigues
 */
@Entity
@Table(name = "aluguel_item")
public class AluguelItem implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_aluguel_item", sequenceName = "seq_aluguel_item_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel_item", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A quantidade deve ser informada!")
    @Column(name = "quantidade", nullable = false, columnDefinition = "numeric(10,2)")
    private Double quantidade;
    @NotNull(message = "O valor unitario deve ser informado!")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valorUnitario;
    @NotNull(message = "O valor total deve ser informado!")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(10,2)")
    private Double valorTotal;
    @NotNull(message = "O Filme deve ser informado!")
    @ManyToOne
    @JoinColumn(name = "filme", referencedColumnName = "id", nullable = false)
    private Filme filme;
    @NotNull(message = "A compra deve ser informada")
    @ManyToOne
    private Aluguel aluguel;
    

    public AluguelItem() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
    
    
}
