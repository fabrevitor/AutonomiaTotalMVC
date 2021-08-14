package com.senac.autonomiatotalmvc.control;


import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.senac.autonomiatotalmvc.R;
import com.senac.autonomiatotalmvc.model.Carro;
import com.senac.autonomiatotalmvc.model.CarroBO;
import com.senac.autonomiatotalmvc.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainControl {
    private MainActivity activity;

    //Para o ListView
    private ArrayAdapter<String> adapterResultados;
    private List<String> listResultados;

    public MainControl(MainActivity activity){
        this.activity = activity;
        configListViewResultados();
    }

    public void calcularAction(){
        Carro carro = new Carro();
        carro.setNome(activity.getEditNome().getText().toString());
        carro.setKm(activity.getEditKm().getText().toString());
        carro.setQtdCombustivel(activity.getEditQtdCombustivel().getText().toString());

        if(validarDadosForm(carro)){
            Double media = CarroBO.calcularMedia(carro);

            String txtResultadoFinal = "";

            //Resultado
            txtResultadoFinal += activity.getString(R.string.carro) + ": " + carro.getNome() + " - ";
            txtResultadoFinal += media + "km/L \n";

            adapterResultados.add(txtResultadoFinal);

            //Limpa o formulario digitado
            limparForm();
        } else{
            Toast.makeText(activity, "Form incompleto", Toast.LENGTH_SHORT).show();
        }
    }



    private boolean validarDadosForm(Carro a){
        if(!CarroBO.validarNome(a.getNome())){
            activity.getEditNome().setError(activity.getString(R.string.erro_nome));
            activity.getEditNome().requestFocus();
            return false;
        }

        if(!CarroBO.validarKm(a.getKm())){
            activity.getEditKm().setError(activity.getString(R.string.erro_km));
            activity.getEditKm().requestFocus();
            return false;
        }
        if(!CarroBO.validarQtdCombustivel(a.getQtdCombustivel())){
            activity.getEditQtdCombustivel().setError(activity.getString(R.string.erro_qtdCombustivel));
            activity.getEditQtdCombustivel().requestFocus();
            return false;
        }
        return true;
    }

    public void limparDadosAction(){
        limparForm();
        //activity.getLvResultado().removeAllViewsInLayout();
        //adapterResultados.areAllItemsEnabled();
        configListViewResultados();
    }

    private void limparForm(){
        activity.getEditNome().setText("");
        activity.getEditKm().setText("");
        activity.getEditQtdCombustivel().setText("");
        activity.getEditNome().requestFocus();
    }

    private void configListViewResultados(){
        //Elementos da lista
        listResultados = new ArrayList<>();

        adapterResultados = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                listResultados
        );
        activity.getLvResultado().setAdapter(adapterResultados);

        //Adicionando dados ao listView
        // adapterResultados.add(new String("Teste 1" ));
    }
}
