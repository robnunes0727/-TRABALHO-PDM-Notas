package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

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

        final EditText edtNotaA1 = (EditText) findViewById(R.id.edtNotaA1);
        final EditText edtNotaA2 = (EditText) findViewById(R.id.edtNotaA2);
        final Spinner spnDisciplina = findViewById(R.id.spnDisciplina);
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);

        // Puxando sharedprefs para preencher spinner
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.pdm_trabalho.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);

        // Coloca SharedPrefs em um Set
        Set<String> discSet = sharedPref.getStringSet("lista_de_disciplinas", null);

        // Testa o conteúdo do Set
        if(discSet != null && !discSet.isEmpty()){
            // Transforma Set em lista e então lista em adapter
            ArrayList<String> discList = new ArrayList<>(discSet);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, discList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Insere adapter no spinner
            spnDisciplina.setAdapter(adapter);
        } else {
            // Se não vier nada, fechar o programa
            Toast.makeText(this, R.string.toastErroDisciplinaCadastrada, Toast.LENGTH_LONG).show();
            finish();
        }

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {
                String n1 = edtNotaA1.getText().toString().trim();
                String n2 = edtNotaA2.getText().toString().trim();

                // Checa se vazio
                if (n1.isEmpty() || n2.isEmpty()) {
                    Toast.makeText(v.getContext(), R.string.toastErroCampos, Toast.LENGTH_SHORT).show();
                    return;
                }

                // Pegando o valor digitado nos campos EditText
                double NotaA1 = Double.parseDouble(n1);
                double NotaA2 = Double.parseDouble(n2);

                // Checa se os valores são válidos
                if (NotaA1 < 0 ||NotaA1 > 5 || NotaA2 < 0 || NotaA2 > 5) {
                    Toast.makeText(v.getContext(), R.string.toastErroNotas, Toast.LENGTH_SHORT).show();
                    return;
                }

                // Calculo a nota final
                double NotaFinal = NotaA1 + NotaA2;

                // Abrindo novo intent de activity
                Intent novaActivity = new Intent(v.getContext(), NotasResultado.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("notaA1", NotaA1);
                bundle.putDouble("notaA2", NotaA2);
                bundle.putDouble("notaFinal", NotaFinal);
                bundle.putString("disciplina", spnDisciplina.getSelectedItem().toString());
                bundle.putBoolean("afBool", false);

                startActivity(novaActivity.putExtras(bundle));
            }
        });
    }

    public void btnVoltarDisciplinas(View v){
        // Volta a activity
        super.onBackPressed();
    }

    public void btnCreditos(View v){
        Intent intent = new Intent(v.getContext(), Creditos.class);
        startActivity(intent);
    }
}