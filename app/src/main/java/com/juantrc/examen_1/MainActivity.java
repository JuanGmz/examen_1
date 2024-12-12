package com.juantrc.examen_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.juantrc.examen_1.modelos.DetallePersona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juantrc.examen_1.adaptadores.PersonaAdaptador;
import com.juantrc.examen_1.modelos.Persona;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvPersonas = findViewById(R.id.recyclerView);

        List<Persona> listaPersonas = new ArrayList<>();

        Intent accion = new Intent(Intent.ACTION_DIAL);

        String numero1 = "871 392 3040";

        String numero2 = "871 322 1240";

        String numero3 = "871 122 1000";

        String des1 = "es una buena persona";
        String des2 = "es una mala persona";
        String des3 = "es una muy mala persona";

        listaPersonas.add(new Persona("Juan", accion, numero1, des1));

        listaPersonas.add(new Persona("Juan", accion, numero2, des2));

        listaPersonas.add(new Persona("Juan", accion, numero3, des3));

        PersonaAdaptador adaptador = new PersonaAdaptador(listaPersonas, getApplicationContext());

        rvPersonas.setAdapter(adaptador);

        rvPersonas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        rvPersonas.setHasFixedSize(true);
    }
}