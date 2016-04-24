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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marlon Rodrigues
 */
@Entity
@Table(name = "aluguel")
public class Aluguel implements Serializable{
    @EmbeddedId
    private AluguelID id;
    @NotNull(message = "A data da compra deve ser informada!")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "O valor total deve ser informado!")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorTotal;
    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL, 
            orphanRemoval = true,fetch = FetchType.LAZY)
    private List<AluguelItem> itens = new ArrayList<>();

    public Aluguel() {
        this.valorTotal = 0.0;
    }
    
    public void adicionarItem(AluguelItem obj){
        obj.setAluguel(this);
        this.valorTotal += obj.getValorTotal();
        this.itens.add(obj);
    }
    
    public void removerItem(int index){
        AluguelItem obj = this.itens.get(index);
        this.valorTotal -= obj.getValorTotal();
        this.itens.remove(obj);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

    public AluguelID getId() {
        return id;
    }

    public void setId(AluguelID id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<AluguelItem> getItens() {
        return itens;
    }

    public void setItens(List<AluguelItem> itens) {
        this.itens = itens;
    }
    
    
}
