package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NotasAF extends AppCompatActivity {

    Spinner activity_notas_reprovados_spinner_Diciplinas;
    // Calculadora de notas com 3 (DA PRA FAZER VISUAL)
    // Menor nota é substituida pela nota da AF (DA PRA FAZER)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_reprovado);

        activity_notas_reprovados_spinner_Diciplinas = findViewById(R.id.spinnerDiciplinas);


        final EditText edtNotaA1_notas = (EditText) findViewById(R.id.edtNotaA1_notas);
        final EditText edtNotaA2_notas = (EditText) findViewById(R.id.edtNotaA2_notas);
        final EditText edtNotaAF_notas = (EditText) findViewById(R.id.edtNotaAF_notas);
        Button btnCalcular = (Button) findViewById(R.id.btnCancelar);

        btnCalcular.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String disciplina =
                Float notaA1 = Float.parseFloat(edtNotaA1_notas.getText().toString());
                Float notaA2 = Float.parseFloat(edtNotaA2_notas.getText().toString());
                Float notaAF = Float.parseFloat(edtNotaAF_notas.getText().toString());

                // Calcular as notas = notaA1+notaA2 || notaA1+notaAF || notaA2+notaAF;
                Float notaFinal= notaA1+notaA2;
                //Float notaFinal = if (notaA1<notaA2){
                // notaA2+notaAF} else{
                // notaA1+notaAF};

                //Retorno na tela
               // txtNotaFinal.setText(notaFinal.toString());

            }
        }));

        @Override
        protected void onStart() {
            super.onStart();
            Toast.makeText(this,"Executando onStart!",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onResume() {
            super.onResume();
            Toast.makeText(this,"Executando onResume!",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPause() {
            super.onPause();
            Toast.makeText(this,"Executando onPause!",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onStop() {
            super.onStop();
            Toast.makeText(this,"Socorro!",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Toast.makeText(this,"Fui...",Toast.LENGTH_LONG).show();
        }

        public void spinnerDiciplinasOnClick(View v) {
            Intent novoTexto = new Intent(this, Disciplina.class);

            // Passando parâmetros
            Bundle bundle = new Bundle();
            bundle.putString("nome", "João");
            bundle.putInt("idade", 42);
            startActivity(disciplinaActivity.putExtras(bundle));
        }
    }
}