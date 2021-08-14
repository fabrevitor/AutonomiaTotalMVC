package com.senac.autonomiatotalmvc.model;

public class CarroBO {
    public static boolean validarNome(String nome){
        return nome!=null && !nome.equals("");
    }

    public static boolean validarKm(Double km){
        return km!=null && km>=0;
    }

    public static boolean validarQtdCombustivel(Double qtdCombustivel){
        return qtdCombustivel!=null && qtdCombustivel>=0;
    }

    public static Double calcularMedia(Carro carro){
        return(carro.getKm()/carro.getQtdCombustivel());
    }
}
