package com.example.pickrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class TfoodList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        List<CardList> dataList =  new ArrayList<>();
        dataList.add(new CardList("[Rice]", "Bibimbap", R.drawable.kfood_thumb1));
        dataList.add(new CardList("[Soup]", "Korean Kimchi", R.drawable.kfood_thumb2));
        dataList.add(new CardList("[Soup]", "Korean Kimchi", R.drawable.kfood_thumb3));
        dataList.add(new CardList("[Soup]", "Korean Kimchi", R.drawable.kfood_thumb1));
        dataList.add(new CardList("[Soup]", "Korean Kimchi", R.drawable.kfood_thumb2));
        dataList.add(new CardList("[Soup]", "Korean Kimchi", R.drawable.kfood_thumb3));
        dataList.add(new CardList("[Soup]", "Korean Kimchi", R.drawable.kfood_thumb1));


        RecyclerViewListAdapter adapter = new RecyclerViewListAdapter(dataList, this);
        recyclerView.setAdapter(adapter);
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
}
