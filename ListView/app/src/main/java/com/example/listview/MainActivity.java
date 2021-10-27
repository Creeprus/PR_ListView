package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    String[] devices = {"Ноутбук", "Компьютер", "Планшет", "Телефон"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, devices);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //Обработка нажатия на item
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String finale="" ;
                SparseBooleanArray clickedItemPositions = lst.getCheckedItemPositions();


                  for (int oof=0;oof<clickedItemPositions.size();oof++) {
                        if(clickedItemPositions.valueAt(oof))
                        finale=finale+devices[clickedItemPositions.keyAt(oof)]+" ";
                    }
                    Toast.makeText(getApplicationContext(),finale, Toast.LENGTH_LONG).show();



                }
            }
        );
    }
}
