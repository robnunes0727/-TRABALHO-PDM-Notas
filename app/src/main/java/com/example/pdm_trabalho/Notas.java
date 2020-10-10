package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Notas extends AppCompatActivity {

    // Calculadora de notas com 2 e envia pro NotasResultado (DA PRA FAZER)
    // Então envia um bundle com nota + disciplina pra NotasResultado (DA PRA FAZER)
    // Pacote de envio: (NotaA1: float=NotaA1),
    //                  (NotaA2: float=NotaA2),
    //                  (NotaFinal: float=NotaA1+A2),
    //                  (AFbool: bool=false),
    //                  (Disciplina: string)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        Toast.makeText(getApplicationContext(), "Executando onCreate!", Toast.LENGTH_LONG).show();

        final EditText edtNotaA1 = (EditText) findViewById(R.id.edtNotaA1);
        final EditText edtNotaA2 = (EditText) findViewById(R.id.edtNotaA2);
        final TextView txtNotaFinal = (TextView) findViewById(R.id.txtNotaFinal);
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {
                // Pegando o valor digitado nos campos EditText
                Float NotaA1 = Float.parseFloat(edtNotaA1.getText().toString());
                Float NotaA2 = Float.parseFloat(edtNotaA2.getText().toString());

                // Calculo a nota final
                Float NotaFinal = NotaA1 + NotaA2;

                // Atualizando a tela
                txtNotaFinal.setText(NotaFinal.toString());

                Bundle bundle = new Bundle();
                bundle.putFloat("NotaA1", NotaA1);
                bundle.putFloat("NotaA2", NotaA2);
                bundle.putFloat("NotaFinal", NotaFinal);
                bundle.putBoolean("AFbool", false);
            }
        });
} }