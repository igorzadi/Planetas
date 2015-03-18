package br.edu.fatecriopreto.planetas;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PlanetasActivity extends ActionBarActivity {

    int[] idPlanetas = {R.drawable.mercurio,
            R.drawable.venus, R.drawable.terra, R.drawable.marte,
            R.drawable.jupiter, R.drawable.saturno, R.drawable.urano,
            R.drawable.netuno, R.drawable.plutao};

    List<String> planetas = new ArrayList<>(
            Arrays.asList("Mercurio", "Venus", "Terra",
                    "Marte", "Jupiter", "Saturno","Urano",
                    "Netuno", "Plutao"));

    Spinner spnPlanetas;
    ImageView imgPlaneta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planetas);

        spnPlanetas = (Spinner) findViewById(R.id.spnPlanetas);
        imgPlaneta = (ImageView) findViewById(R.id.imgPlaneta);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, planetas);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spnPlanetas.setAdapter(arrayAdapter);

        spnPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imgPlaneta.setImageResource(idPlanetas[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_planetas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
