package com.example.pickrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Contents extends AppCompatActivity {
    private TextView tvTitle, tvdescription;
    private ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);

        tvTitle  = (TextView) findViewById(R.id.cTitle);
        tvdescription = (TextView) findViewById(R.id.cDescription);
        img = (ImageView) findViewById(R.id.kFoodTopImg);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        int image = intent.getExtras().getInt("ListThumbnail");

        tvTitle.setText(Title);
        img.setImageResource(image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            case R.id.action1:
                Intent intent1 = new Intent(this, TfoodList.class);
                startActivity(intent1);
            case R.id.action2:
                Intent intent2 = new Intent(this, KfoodList.class);
                startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }


    public void taiwanFood(View view) {
        Intent intent1 = new Intent(this, TfoodList.class);
        startActivity(intent1);
    }

    public void koreanFood(View view) {
        Intent intent2 = new Intent(this, KfoodList.class);
        startActivity(intent2);
    }
}
