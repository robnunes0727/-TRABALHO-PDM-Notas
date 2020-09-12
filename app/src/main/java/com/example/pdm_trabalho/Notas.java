package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
    }
}