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

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_af);

        final EditText edtNotaA1 = (EditText) findViewById(R.id.edtNotaA1_notas);
        final EditText edtNotaA2 = (EditText) findViewById(R.id.edtNotaA2_notas);
        final EditText edtNotaAF = (EditText) findViewById(R.id.edtNotaAF_notas);
        final TextView txtDisc   = findViewById(R.id.txtDisciplinas);
        final Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        final Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent pacoteNotas = getIntent();
        Bundle parametros = pacoteNotas.getExtras();

        final double notaA1 = parametros.getDouble("notaA1");
        final double notaA2 = parametros.getDouble("notaA2");
        final String disciplina = parametros.getString("disciplina");

        // Preenchendo o valor que chegou no bundle
        txtDisc.setText(disciplina);
        edtNotaA1.setText(Double.toString(notaA1));
        edtNotaA2.setText(Double.toString(notaA2));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Recebendo o valor da AF
                double notaAF = Double.parseDouble(edtNotaAF.getText().toString());

                // Calculo a nota final
                double notaFinal = notaA1 + notaA2;
                double notaA1AF = notaA1 + notaAF;
                double notaA2AF = notaAF + notaA1;

                // Atualizando a tela
                if (notaFinal >= notaA1AF && notaFinal >= notaA2AF) {
                    notaFinal = notaFinal*1; // Só pra condição não ficar vazia
                } else if (notaA1AF >= notaFinal && notaA1AF >= notaA2AF){
                    notaFinal = notaA1AF;
                } else if (notaA2AF >= notaFinal && notaA2AF >= notaA1AF){
                    notaFinal = notaA2AF;
                }

                // Refaz o bundle
                Intent novaActivity = new Intent(v.getContext(), NotasResultado.class);

                // Passando parâmetros
                Bundle bundle = new Bundle();
                bundle.putDouble("notaA1", notaA1);
                bundle.putDouble("notaA2", notaA2);
                bundle.putDouble("notaAF", notaAF);
                bundle.putDouble("notaFinal", notaFinal);
                bundle.putString("disciplina", disciplina);
                bundle.putBoolean("afBool", true);

                // Começa a nova activity
                startActivity(novaActivity.putExtras(bundle));
            }
        });
    }
}