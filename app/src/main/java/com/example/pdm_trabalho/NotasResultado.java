package com.example.pdm_trabalho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NotasResultado extends AppCompatActivity {

    private Button btnVoltar;
    private Bundle parametros;

    // Recebe o bundle da pagina Notas ou NotasAF (nota + disciplina + afbool) e mostra Aprovado / Reprovado / Precisa AF
    // Caso o aluno tenha sido reprovado sem fazer AF, o botão voltar envia o pacote para NotasAF.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_resultado);

        EditText edtDisciplina = findViewById(R.id.edtDisciplina_res);
        EditText edtNotaFinal = findViewById(R.id.edtNotaFinal_res);
        TextView txtResultado = findViewById(R.id.txtResultado_res);
        btnVoltar    = findViewById(R.id.btnVoltar);

        Intent pacoteNotas = getIntent();
        parametros = pacoteNotas.getExtras();

        double notaA1 = parametros.getDouble("notaA1");
        double notaA2 = parametros.getDouble("notaA2");
        double notaFinal = parametros.getDouble("notaFinal");
        String disciplina = parametros.getString("disciplina");
        boolean afBool = parametros.getBoolean("afBool");

        edtDisciplina.setText(disciplina);
        edtNotaFinal.setText(String.valueOf(notaFinal));

        if(notaFinal >= 6) {
            txtResultado.setText(getString(R.string.txtAprovado));
            txtResultado.setTextColor(Color.GREEN);
        } else if (!afBool) {
            txtResultado.setText(getString(R.string.txtAf));
            txtResultado.setTextColor(Color.RED);

            // Método que muda o layout
            mudancasAF();
        } else {
            txtResultado.setText(getString(R.string.txtReprovado));
            txtResultado.setTextColor(Color.RED);
        }
    }

    public void btnVoltar(View v){
        // Retorna como se tivesse apertado back
        super.onBackPressed();
    }

    protected void mudancasAF(){
        // Criando botão de calcular AF
        Button btnAF = new Button(this);
        btnAF.setText(R.string.btnAF);
        btnAF.setId(View.generateViewId());

        // Chamando o layout e colocando parametros
        RelativeLayout layout = findViewById(R.id.layout);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, R.id.txtResultado_res);
        layout.addView(btnAF, params);

        // Mudando a posição do botão Voltar
        params = (RelativeLayout.LayoutParams) btnVoltar.getLayoutParams();
        params.addRule(RelativeLayout.BELOW, btnAF.getId());
        btnVoltar.setLayoutParams(params);

        // Listener do botão AF
        btnAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent novaActivity = new Intent(view.getContext(), NotasAF.class);
                startActivity(novaActivity.putExtras(parametros));
            }
        });
    }
}