package com.pizzaria.java.pizza;

import jakarta.persistence.*;

@Entity
@Table(name="Pizza")

public class PizzaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private PizzaSabor pizzaSabor;
    private Double preco;
    @Enumerated(EnumType.STRING)
    private PizzaTamanho pizzaTamanho;
    private Boolean disponivel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PizzaSabor getPizzaSabor() {
        return pizzaSabor;
    }

    public void setPizzaSabor(PizzaSabor pizzaSabor) {
        this.pizzaSabor = pizzaSabor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public PizzaTamanho getPizzaTamanho() {
        return pizzaTamanho;
    }

    public void setPizzaTamanho(PizzaTamanho pizzaTamanho) {
        this.pizzaTamanho = pizzaTamanho;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
