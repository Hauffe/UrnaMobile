package com.pucpr.alexandre.urnamobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Urna extends AppCompatActivity {

    private TextView candidateName;
    private ImageView img_candidato;
    private Candidato candidato1, candidato2, candidato3;
    private RadioButton candidato_1,candidato_2, candidato_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urna);

        this.candidato1 = new Candidato("Candidato1", R.drawable.candidato1);
        this.candidato2 = new Candidato("Candidato2", R.drawable.candidato2);
        this.candidato3 = new Candidato("Candidato3", R.drawable.candidato3);


        img_candidato = findViewById(R.id.img_candidato);
        candidateName = findViewById(R.id.nameCandidato);

        candidato_1 = findViewById(R.id.candidato_1);
        candidato_2 = findViewById(R.id.candidato_2);
        candidato_3 = findViewById(R.id.candidato_3);

    }

    public void onRadioButtonClicked(View view) {
        switch(view.getId()) {
            case R.id.candidato_1:
                if (candidato_1.isChecked())
                    img_candidato.setImageResource(candidato1.getImagem());
                    candidateName.setText(candidato1.getNome());
                break;
            case R.id.candidato_2:
                if (candidato_2.isChecked())
                    img_candidato.setImageResource(candidato2.getImagem());
                    candidateName.setText(candidato2.getNome());
                break;
            case R.id.candidato_3:
                if (candidato_3.isChecked())
                    img_candidato.setImageResource(candidato3.getImagem());
                    candidateName.setText(candidato3.getNome());
                break;
        }
    }

    public void btnVoteOnClick(View view) {
        try {
            if (candidato_1.isChecked()) {
                Toast.makeText(this, "Candidato 1 Selecionado", Toast.LENGTH_LONG).show();
                candidato1.receberVoto();
            }
            if (candidato_2.isChecked()) {
                Toast.makeText(this, "Candidato 2 Selecionado", Toast.LENGTH_LONG).show();
                candidato2.receberVoto();
            }
            if (candidato_3.isChecked()) {
                Toast.makeText(this, "Candidato 3 Selecionado", Toast.LENGTH_LONG).show();
                candidato3.receberVoto();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Selecione um candidato", Toast.LENGTH_LONG).show();
        }
    }

    public void btnNullOnClick(View view){

    }

    public void btnCandidatesOnClick(View view){
        Intent intent = new Intent(this, Apuracao.class);
        intent.putExtra("Apuracao1", ""+candidato1.getVotos());
        intent.putExtra("Apuracao2", ""+candidato2.getVotos());
        intent.putExtra("Apuracao3", ""+candidato3.getVotos());
        startActivity(intent);
    }

}
