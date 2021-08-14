package com.senac.autonomiatotalmvc.model;

public class Carro {
    private String nome;
    private Double km;
    private Double qtdCombustivel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public void setKm(String km) {
        try {
            this.km = Double.parseDouble(km);
        } catch(Exception e){
            this.km = null;
        }
    }

    public Double getQtdCombustivel() {
        return qtdCombustivel;
    }

    public void setQtdCombustivel(Double qtdCombustivel) {
        this.qtdCombustivel = qtdCombustivel;
    }

    public void setQtdCombustivel(String qtdCombustivel) {
        try {
            this.qtdCombustivel = Double.parseDouble(qtdCombustivel);
        } catch(Exception e){
            this.qtdCombustivel = null;
        }
    }

    public Carro() {
    }

    public Carro(String nome, Double km, Double qtdCombustivel) {
        this.nome = nome;
        this.km = km;
        this.qtdCombustivel = qtdCombustivel;
    }
}
