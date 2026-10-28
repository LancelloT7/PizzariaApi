package com.pizzaria.java.pizza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PizzaDTO {
    @NotBlank
    private String nome;
    private PizzaSabor pizzaSabor;
    @Positive
    @NotNull
    private Double preco;
    private PizzaTamanho pizzaTamanho;
    @NotNull
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
}
