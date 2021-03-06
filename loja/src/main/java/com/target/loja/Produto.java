package com.target.loja;



import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


@Entity
public class Produto {

    @ApiModelProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(nullable = false,name="nome")
    private String nome;
    private double valor;

    public Produto(){}

    public Produto(long id, String nome, double valor) {
        this.id = id;

        this.nome = nome;
        this.valor = valor;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
