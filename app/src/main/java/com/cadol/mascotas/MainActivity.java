package com.cadol.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    public AppCompatImageButton imgEstrella;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascota();
        inicializaAdaptador();

        imgEstrella = (AppCompatImageButton) findViewById(R.id.imgestrella);

        imgEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                Log.d("Entro", "onClick: ");
                Intent intent = new Intent(MainActivity.this, activity_mas_like.class);
                startActivity(intent);
            }
        });
    }

    public void inicializaAdaptador() {
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarListaMascota() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add( new Mascota( R.drawable.bianca,"Bianca", "5"));
        mascotas.add( new Mascota( R.drawable.chocolate,"Chocolate","6"));
        mascotas.add( new Mascota( R.drawable.lola,"Lola", "4"));
        mascotas.add( new Mascota( R.drawable.rayo, "Rayo", "9"));
        mascotas.add( new Mascota( R.drawable.tobby,"Tobby", "1"));
        mascotas.add( new Mascota( R.drawable.carmelia,"Carmelia", "2"));
        mascotas.add( new Mascota( R.drawable.danger,"Danger", "1"));
        mascotas.add( new Mascota( R.drawable.renata,"Renata", "3"));
        mascotas.add( new Mascota( R.drawable.sultan,"Sultan", "10"));
    }
}