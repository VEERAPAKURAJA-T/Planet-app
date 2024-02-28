package com.example.planet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listview;
ArrayList<planet> planetArrayList;
private static custom_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1-adapter view:ListView
        listview=findViewById(R.id.listview);
        //2-Data source:ArrayList<planet>
        planetArrayList=new ArrayList<>();
        planet planet1=new planet("jupiter","63",R.drawable.jupiter);
        planet planet2=new planet("mercury","6",R.drawable.mercury);
        planet planet3=new planet("pluto","8",R.drawable.pluto);
        planet planet4=new planet("venus","9",R.drawable.venus);
        planet planet5=new planet("saturn","4",R.drawable.saturn);
        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);

       adapter=new custom_adapter(planetArrayList,getApplicationContext());
       listview.setAdapter(adapter);
       //handling click event
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                onItemClick method is a call back method that is commonly used with list view,
                grid view and other adapter
                 */
                Toast.makeText(
                        MainActivity.this,"Planet Name "+adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_LONG).show();
            }
        });



    }
}