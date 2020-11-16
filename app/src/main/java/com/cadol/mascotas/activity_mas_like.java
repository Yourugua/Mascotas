package com.cadol.mascotas;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Objects;

public class activity_mas_like extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

     @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_like);

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvLikes);

        LinearLayoutManager llm = new LinearLayoutManager(activity_mas_like.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascota();
        inicializaAdaptador();
    }

    public void inicializaAdaptador() {
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascota() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add( new Mascota( R.drawable.sultan,"Sultan", "10"));
        mascotas.add( new Mascota( R.drawable.rayo, "Rayo", "9"));
        mascotas.add( new Mascota( R.drawable.chocolate,"Chocolate","6"));
        mascotas.add( new Mascota( R.drawable.bianca,"Bianca", "5"));
        mascotas.add( new Mascota( R.drawable.lola,"Lola", "4"));
    }
}
