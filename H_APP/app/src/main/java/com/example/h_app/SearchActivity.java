package com.example.h_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ListView mylistview;
    ArrayList<String> array;

    ArrayList<String> link;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        array = new ArrayList<String>();
        array.add("구글");
        array.add("네이버");
        array.add("다음");


        link = new ArrayList<String>();
        link.add("https://www.google.com");
        link.add("https://www.naver.com");
        link.add("https://www.daum.net");

        mylistview = findViewById(R.id.list);

        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,array);

        mylistview.setAdapter(adapter);


        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),link.get(position),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link.get(position)));
                startActivity(intent);
            }
        });



    }
}