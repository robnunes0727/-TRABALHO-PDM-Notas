package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtRA;
    private EditText edtNome;
    private EditText edtTurma;
    private Spinner cmbCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancia os atributos
        edtRA       = findViewById(R.id.edtRA);
        edtNome     = findViewById(R.id.edtNome);
        edtTurma    = findViewById(R.id.edtTurma);
        cmbCurso    = findViewById(R.id.cmbCurso);

        // Abre as SharedPrefs
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.pdm_trabalho.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);

        // Preenche Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cursos_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbCurso.setAdapter(adapter);

        // Procura dados na sharedprefs
        String nome = sharedPref.getString("nome_aluno", null);
        if(nome != null && !nome.isEmpty()) {
            // Se a lista estiver preenchida, preencher os campos e pular activity
            edtRA.setText(sharedPref.getString("ra_aluno", null));
            edtNome.setText(nome);
            edtTurma.setText(sharedPref.getString("turma_aluno", null));
            cmbCurso.setSelection(adapter.getPosition(sharedPref.getString("curso_aluno", null)));

            Intent novaActivity = new Intent(this, Disciplinas.class);
            startActivity(novaActivity);
        }
    }

    public void btnDesistir(View v){
        // Retorna como se tivesse apertado back
        super.onBackPressed();
    }

    public void btnAvancar(View v){
        // Abre preferencias
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.pdm_trabalho.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // Puxa texto, grava senão estiver vazio
        String numRA = edtRA.getText().toString().trim();
        if(!numRA.isEmpty())
            editor.putString("ra_aluno", numRA);
        else {
            Toast.makeText(v.getContext(), R.string.toastErroRA, Toast.LENGTH_SHORT).show();
            return;
        }

        // Puxa texto, grava senão estiver vazio
        String nome = edtNome.getText().toString().trim();
        if (!nome.isEmpty())
            editor.putString("nome_aluno", nome);
        else {
            Toast.makeText(v.getContext(), R.string.toastErroNome, Toast.LENGTH_SHORT).show();
            return;
        }

        // Puxa texto, grava senão estiver vazio
        String turma = edtTurma.getText().toString().trim();
        if (!turma.isEmpty())
            editor.putString("turma_aluno", turma);
        else {
            Toast.makeText(v.getContext(), R.string.toastErroTurma, Toast.LENGTH_SHORT).show();
            return;
        }

        // Puxa texto, grava senão estiver vazio
        String curso = cmbCurso.getSelectedItem().toString().trim();
        String[] arr = getResources().getStringArray(R.array.cursos_array);
        if (!curso.equals(arr[0]) && !curso.isEmpty())
            editor.putString("curso_aluno", curso);
        else {
            Toast.makeText(v.getContext(), R.string.toastErroCurso, Toast.LENGTH_SHORT).show();
            return;
        }
        editor.apply();

        Intent novaActivity = new Intent(v.getContext(), Disciplinas.class);
        startActivity(novaActivity);
    }
}