package com.juantrc.examen_1.modelos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.juantrc.examen_1.R;

public class DetallePersona extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion_persona);

        TextView nombre = findViewById(R.id.tvNombre);
        TextView descripcion = findViewById(R.id.tvInformacion);
        TextView telefono = findViewById(R.id.tvTelefono);

        Intent intent = getIntent();

        Persona persona = (Persona) intent.getSerializableExtra("persona");

        if (persona != null) {
            nombre.setText(persona.getNombre());
            descripcion.setText(persona.getDescripcion());
            telefono.setText(persona.getNumero());
        }
    }
}