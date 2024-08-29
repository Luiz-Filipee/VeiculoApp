package br.luizfilipe.veiculoapp.model;

import java.io.Serializable;

public class Veiculo implements Serializable {
    private static Integer nextId = 1;
    private Integer id;
    private String nome;
    private String marca;
    private String ano;

    public Veiculo(){
        this.id = nextId++;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Nome='" + nome + '\'' +
                "marca='" + marca + '\'' +
                "ano=" + ano;
    }
}
