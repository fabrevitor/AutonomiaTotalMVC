package com.senac.autonomiatotalmvc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.senac.autonomiatotalmvc.R;
import com.senac.autonomiatotalmvc.control.MainControl;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editKm;
    private EditText editQtdCombustivel;
    private ListView lvResultado;
    private Button btnCalcular;
    private Button btnLimparDados;

    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        control = new MainControl(this);
    }

    private void initialize(){
        editNome = findViewById(R.id.editNome);
        editKm = findViewById(R.id.editKm);
        editQtdCombustivel = findViewById(R.id.editQtdCombustivel);
        lvResultado = findViewById(R.id.lvResultado);

        //onClick
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                control.calcularAction();
            }
        });

        //onClick
        btnLimparDados = findViewById(R.id.btnLimparDados);
        btnLimparDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.limparDadosAction();
            }
        });
    }

    public EditText getEditNome() {
        return editNome;
    }

    public EditText getEditKm() {
        return editKm;
    }

    public EditText getEditQtdCombustivel() {
        return editQtdCombustivel;
    }

    public ListView getLvResultado() {
        return lvResultado;
    }

    public Button getBtnCalcular() {
        return btnCalcular;
    }

    public Button getBtnLimparDados() {
        return btnLimparDados;
    }
}
