package com.example.thusaappbathopele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChooseAnswer extends AppCompatActivity {

    ImageView imgOne,imgTwo,imgThree,imgFour,imgFive,imgSix,imgSeven,imgEight,imgNine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_answer);

        imgOne = findViewById(R.id.image_one);
        imgOne.setTag(R.drawable.apple);
        imgOne.setOnClickListener(this::onClick);

        imgTwo= findViewById(R.id.image_two);
        imgTwo.setTag(R.drawable.apricot);
        imgTwo.setOnClickListener(this::onClick);

        imgThree = findViewById(R.id.image_three);
        imgThree.setTag(R.drawable.avocado);
        imgThree.setOnClickListener(this::onClick);

        imgFour = findViewById(R.id.image_four);
        imgFour.setTag(R.drawable.banana);
        imgFour.setOnClickListener(this::onClick);

        imgFive = findViewById(R.id.image_five);
        imgFive.setTag(R.drawable.kwiwi);
        imgFive.setOnClickListener(this::onClick);

        imgSix = findViewById(R.id.image_six);
        imgSix.setTag(R.drawable.mango);
        imgSix.setOnClickListener(this::onClick);

        imgSeven = findViewById(R.id.image_seven);
        imgSeven.setTag(R.drawable.orange);
        imgSeven.setOnClickListener(this::onClick);

        imgEight = findViewById(R.id.image_eight);
        imgEight.setTag(R.drawable.peach);
        imgEight.setOnClickListener(this::onClick);

        imgOne = findViewById(R.id.image_nine);
        imgOne.setTag(R.drawable.pear);
        imgOne.setOnClickListener(this::onClick);

    }
    public void onClick(View view){
        Intent intent = new Intent();
        ImageView img = (ImageView) view;

        int img_resource_id = Integer.parseInt(img.getTag().toString());
        intent.putExtra("Answer", img_resource_id);
        setResult(1999, intent);
        finish();

    }
}