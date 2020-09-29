package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NotasAF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_reprovado);

        final EditText edtNotaA1 = (EditText) findViewById(R.id.edtNotaA1_notas);
        final EditText edtNotaA2 = (EditText) findViewById(R.id.edtNotaA2_notas);
        final EditText edtNotaAF = (EditText) findViewById(R.id.edtNotaAF_notas);
        final TextView txtNotaFinal = (TextView) findViewById(R.id.txtNotaFinal);
        final TextView txtSituacao = (TextView) findViewById(R.id.txtSituacao);
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {
                // Pegando o valor digitado nos campos EditText
                Double notaA1 = Double.parseDouble(edtNotaA1.getText().toString());
                Double notaA2 = Double.parseDouble(edtNotaA2.getText().toString());

                // Calculo a nota final
                Double notaFinal = notaA1 + notaA2; // notaFinal = (vem do bundle)
                Double notaA1AF = notaA1 + notaAF;
                Double notaA2AF = notaAF + notaA1;

                // Atualizando a tela
                txtNotaFinal.setText(notaFinal.toString());
                if (notaFinal >= ((notaA1AF) && (notaA2AF))) {
                    txtSituacao.setText("Aprovado");
                    txtSituacao.setTextColor(getColor(R.color.colorAprovado));
                } else if (notaA1AF >= ((notaFinal) && (notaA2AF))){
                    txtSituacao.setText("Reprovado");
                    txtSituacao.setTextColor(getColor(R.color.colorReprovado));
                } else (notaA2AF >= ((notaFinal)&& (notaA1AF))){
                    txtSituacao.setText("Reprovado");
                    txtSituacao.setTextColor(getColor(R.color.colorReprovado));
                }
            }
        });


        Intent pacoteNotas = getIntent();
        Bundle parametros = pacoteNotas.getExtras();

        double notaA1 = parametros.getDouble("notaA1");
        double notaA2 = parametros.getDouble("notaA2");
        double notaAF = parametros.getDouble("notaAF");
        double notaFinal = parametros.getDouble("notaFinal");
        String disciplina = parametros.getString("disciplina");
        boolean afBool = parametros.getBoolean("afBoll");


    }
}