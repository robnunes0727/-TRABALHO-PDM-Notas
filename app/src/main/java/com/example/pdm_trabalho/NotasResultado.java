package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NotasResultado extends AppCompatActivity {

    // Recebe o bundle da pagina Notas ou NotasAF (nota + disciplina + afbool) e mostra Aprovado / Reprovado / Precisa AF
    // Caso o aluno tenha sido reprovado sem fazer AF, o botão voltar envia o pacote para NotasAF.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_aprovado);
    }
}