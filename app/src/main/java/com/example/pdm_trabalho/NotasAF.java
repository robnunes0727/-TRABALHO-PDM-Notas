package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NotasAF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Calculadora de notas com 3 (DA PRA FAZER VISUAL)
        // Menor nota é substituida pela nota da AF (DA PRA FAZER COM JAVA)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_reprovado);

        /* Conta para nota:
        notaFinal = (vem do bundle)
        notaA1AF = notaA1 + notaAF
        notaA2AF = notaAF + notaA1

        depois testar com ifs:
        notaFinal é maior igual que A1AF e A2AF?
        else notaA1AF é maior igual que notaFinal e A2AF?
        else notaA2AF é maior igual que notaFinal e A1AF?

        então, refazer o pacote com as novas notas (e afBool true) e mandar para NotasResultado
         */

    }
}