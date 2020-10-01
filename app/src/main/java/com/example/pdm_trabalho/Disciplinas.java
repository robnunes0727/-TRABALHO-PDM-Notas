package com.example.pdm_trabalho;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Disciplinas extends ListActivity {
    // Componentes como propriedades da classe
    private ArrayList<String> disciplinas = new ArrayList<String>();
    private EditText edtDisciplina;
    private Set<String> discSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);

        // Coloca o componente na variavel
        edtDisciplina = findViewById(R.id.edtDisciplina);

        // Abre as SharedPrefs
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.pdm_trabalho.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);

        // Coloca SharedPrefs na lista
        discSet = sharedPref.getStringSet("lista_de_disciplinas", null);
        if(discSet != null &&!discSet.isEmpty())
            disciplinas.addAll(discSet);

        atualizarLista();
        edtDisciplina.setText("");
    }

    protected void atualizarLista(){
        // Coloca o array num adapter e manda pra lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, disciplinas);
        setListAdapter(adapter);
    }

    public void btnInserir(View view){
        String disc = edtDisciplina.getText().toString();

        // Se não vazio, adiciona o texto pra lista, else mostra erro
        if (!disc.trim().isEmpty()){
            disciplinas.add(disc);
            edtDisciplina.setText("");
            atualizarLista();
        } else {
            edtDisciplina.setText("");
            Toast.makeText(view.getContext(), "Campo vazio!", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnVoltar(View v){
        // Fecha a activity
        finish();
    }

    public void btnAvancar(View v){
        // Salva lista
        salvarLista();

        // Abre nova activity
        Intent novaActivity = new Intent(v.getContext(), Notas.class);
        startActivity(novaActivity);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // Remove o item quando clica nele
        disciplinas.remove(position);
        salvarLista();
        atualizarLista();
    }

    protected void salvarLista(){
        // Converte Array para Set, pq SharedPrefs só aceitam sets
        discSet = new HashSet<String>();
        discSet.addAll(disciplinas);

        // Salva
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.pdm_trabalho.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet("lista_de_disciplinas", discSet);
        editor.apply();
    }
}