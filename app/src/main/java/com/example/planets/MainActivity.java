package com.example.planets;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetArrayList;
    private static  MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //1-AdapterView: a ListView
        listView =findViewById(R.id.list_view);
        //2-Data Source :ArrayList<Planet>
        planetArrayList =new ArrayList<>();
        Planet planet1= new Planet("SUN","9 Planets",R.drawable.sun);
        Planet planet2= new Planet("Mercury","0 Moons",R.drawable.mercury);
        Planet planet3= new Planet("Venus","0 Moons",R.drawable.venus);
        Planet planet4= new Planet("Earth","1 Moon",R.drawable.earth);
        Planet planet5= new Planet("Mars","2 Moons",R.drawable.mars);
        Planet planet6= new Planet("Jupiter","79 Moons",R.drawable.jupiter);
        Planet planet7= new Planet("Saturn","83 Moons",R.drawable.saturn);
        Planet planet8= new Planet("Uranus","27 Moons",R.drawable.uranus);
        Planet planet9= new Planet("Neptune","14 Moons",R.drawable.neptune);
        Planet planet10 = new Planet("Pluto","5 Moons",R.drawable.pluto);
        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);
        planetArrayList.add(planet7);
        planetArrayList.add(planet8);
        planetArrayList.add(planet9);
        planetArrayList.add(planet10);
        //Adapter:
        adapter= new MyCustomAdapter(planetArrayList,getApplicationContext());
        listView.setAdapter(adapter);
        //Handling Click Events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Planet Name:" +adapter.getItem(position).getPlanetName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}