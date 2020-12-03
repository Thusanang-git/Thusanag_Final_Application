package com.example.thusaappbathopele;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class TestYourMemory extends AppCompatActivity {
    ImageView img_question, img_answer;
    Button btnAnswer;

    int array_images[] = new int[]{

            R.drawable.apple,
            R.drawable.apricot,
            R.drawable.avocado,
            R.drawable.banana,
            R.drawable.kwiwi,
            R.drawable.mango,
            R.drawable.orange,
            R.drawable.peach,
            R.drawable.pear,
    };
    int correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_your_memory);

       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       toolbar.setTitle("Test Your Memory");
       setSupportActionBar(toolbar);

        img_question = findViewById(R.id.img_question);
        btnAnswer = findViewById(R.id.Answer);
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestYourMemory.this, ChooseAnswer.class);
                startActivityForResult(intent, 1999);
            }
        });
        randomImage();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1999){
            int answer_resource_id = data.getIntExtra("Answer", 0);
            img_answer = (ImageView) findViewById(R.id.img_Answer);
            img_answer.setImageResource(answer_resource_id);
            if(answer_resource_id == correctAnswer){
                Toast.makeText(this, "Good ! You Have Good Memory", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Oppsie ! Your Forgot the Image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_renew:
                randomImage();
                break;
        }
        return true;
    }
    private void randomImage(){
        int img_resource = array_images[new Random().nextInt(9)];
        img_question.setImageResource(img_resource);

        correctAnswer = img_resource;

    }
}