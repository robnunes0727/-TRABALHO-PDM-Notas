package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NotasResultado extends AppCompatActivity {

    private EditText edtDisciplina;
    private EditText edtNotaFinal;
    private TextView txtDisciplina;
    private TextView txtNotaFinal;
    private TextView txtResultado;

    // Recebe o bundle da pagina Notas ou NotasAF (nota + disciplina + afbool) e mostra Aprovado / Reprovado / Precisa AF
    // Caso o aluno tenha sido reprovado sem fazer AF, o botão voltar envia o pacote para NotasAF.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_resultado);


        edtDisciplina = findViewById(R.id.edtDisciplina);
        edtNotaFinal = findViewById(R.id.edtNotaFinal_res);
        txtDisciplina = findViewById(R.id.txtDisciplina_res);
        txtNotaFinal = findViewById(R.id.txtNotaFinal_res);
        txtResultado = findViewById(R.id.txtResultado_res);

        Intent pacoteNotas = getIntent();
        Bundle parametros = pacoteNotas.getExtras();

        double notaA1 = parametros.getDouble("notaA1");
        double notaA2 = parametros.getDouble("notaA2");
        double notaFinal = parametros.getDouble("notaFinal");
        String disciplina = parametros.getString("disciplina");
        Boolean afBool = parametros.getBoolean("afBool");

        if(notaFinal / 2 >=6) {
            txtResultado.setText(getString(R.string.txtAprovado));
            txtResultado.setTextColor(Color.GREEN);
            }
            else if (afBool == false) {
            txtResultado.setText(getString(R.string.txtAf));
            txtResultado.setTextColor(Color.RED);
            }

            else {
                txtResultado.setText(getString(R.string.txtReprovado));
                txtResultado.setTextColor(Color.RED);
            }

    }
    public void btnVoltar(View v){
        // Retorna como se tivesse apertado back
        super.onBackPressed();
    }

}