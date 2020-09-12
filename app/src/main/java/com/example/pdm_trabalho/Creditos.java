package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Creditos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Activity com os nomes do grupo e link para o código
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
    }

    public void btnGithub(View v){
        // Abre o navegador no github do trabalho
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/robnunes0727/-TRABALHO-PDM-Notas")));
    }

    public void btnVoltar(View v){
        // Volta para a activity anterior
        finish();
    }

}