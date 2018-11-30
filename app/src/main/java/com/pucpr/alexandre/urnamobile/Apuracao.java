package com.pucpr.alexandre.urnamobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Apuracao extends AppCompatActivity {

    private TextView resultCandidato1Txt, resultCandidato2Txt, resultCandidato3Txt;
    private TextView candidato_1, candidato_2, candidato_3;
    private ImageView img_candidato_1, img_candidato_2, img_candidato_3;
    private Candidato candidato1, candidato2, candidato3;
    private String apuracao1, apuracao2, apuracao3;
    private Integer total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuracao);

        apuracao1 = getIntent().getStringExtra("Apuracao1");
        apuracao2 = getIntent().getStringExtra("Apuracao2");
        apuracao3 = getIntent().getStringExtra("Apuracao3");

        this.total = Integer.parseInt(apuracao1) + Integer.parseInt(apuracao2) + Integer.parseInt(apuracao3);

        this.candidato1 = new Candidato("Candidato1", R.drawable.candidato1);
        this.candidato2 = new Candidato("Candidato2", R.drawable.candidato2);
        this.candidato3 = new Candidato("Candidato3", R.drawable.candidato3);

        resultCandidato1Txt = findViewById(R.id.resultCandidato1Txt);
        resultCandidato2Txt = findViewById(R.id.resultCandidato2Txt);
        resultCandidato3Txt = findViewById(R.id.resultCandidato3Txt);

        img_candidato_1 = findViewById(R.id.img_candidato_1);
        img_candidato_2 = findViewById(R.id.img_candidato_2);
        img_candidato_3 = findViewById(R.id.img_candidato_3);

        candidato_1 = findViewById(R.id.candidato_1);
        candidato_2 = findViewById(R.id.candidato_2);
        candidato_3 = findViewById(R.id.candidato_3);


        /*----------------------------------------------------------*/
        img_candidato_1.setImageResource(candidato1.getImagem());
        img_candidato_2.setImageResource(candidato2.getImagem());
        img_candidato_3.setImageResource(candidato3.getImagem());

        candidato_1.setText(candidato1.getNome());
        candidato_2.setText(candidato2.getNome());
        candidato_3.setText(candidato3.getNome());

        resultCandidato1Txt.setText(apuracao1 + " votos \n" + (Integer.parseInt(apuracao1)*100/total) + "% votos validos");
        resultCandidato2Txt.setText(apuracao2 + " votos \n" + (Integer.parseInt(apuracao2)*100/total) + "% votos validos");
        resultCandidato3Txt.setText(apuracao3 + " votos \n" + (Integer.parseInt(apuracao3)*100/total) + "% votos validos");

    }

    public void btnVotarOnClick(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
