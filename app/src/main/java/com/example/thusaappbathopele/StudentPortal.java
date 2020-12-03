package com.example.thusaappbathopele;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentPortal extends AppCompatActivity {
    CardView BrainTrainer, LearningMaterial, MatchingGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_portal);
        BrainTrainer = findViewById(R.id.brainTrainer);
        LearningMaterial = findViewById(R.id.Education);
        MatchingGame = findViewById(R.id.match);

        BrainTrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentPortal.this, BrainTrainer.class));
            }
        });
        LearningMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentPortal.this, LearningMaterialPortal.class));
            }
        });
        MatchingGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentPortal.this, TestYourMemory.class));
            }
        });


    }
}