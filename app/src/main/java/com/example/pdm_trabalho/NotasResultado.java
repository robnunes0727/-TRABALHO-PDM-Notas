package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NotasResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Recebe o bundle da pagina Notas ou NotasAF (nota + disciplina) e mostra Aprovado / Reprovado
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_aprovado);
    }
}