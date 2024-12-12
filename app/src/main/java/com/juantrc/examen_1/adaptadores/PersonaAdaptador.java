package com.juantrc.examen_1.adaptadores;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juantrc.examen_1.R;
import com.juantrc.examen_1.modelos.DetallePersona;
import com.juantrc.examen_1.modelos.Persona;

import java.util.List;

public class PersonaAdaptador extends RecyclerView.Adapter<PersonaAdaptador.PersonaViewHolder> {
    private List<Persona> ListaPersonas;
    private Context context;

    public PersonaAdaptador(List<Persona> listaPersonas, Context context) {
        ListaPersonas = listaPersonas;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonaAdaptador.PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.detalle_persona, parent, false);
        return new PersonaViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return ListaPersonas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaAdaptador.PersonaViewHolder holder, int position) {
        holder.setData(ListaPersonas.get(position));
    }

    public class PersonaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombre, informacion, telefono;
        private Persona persona;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            informacion = itemView.findViewById(R.id.tvInformacion);
            telefono = itemView.findViewById(R.id.tvTelefono);
            informacion.setOnClickListener(this);
            nombre.setOnClickListener(this);
            telefono.setOnClickListener(this);
        }

        public void setData(Persona persona) {
            this.persona = persona;
            nombre.setText(persona.getNombre());
            telefono.setText(persona.getNumero());
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tvNombre) {
                Intent descripcion = new Intent(context, DetallePersona.class);
                descripcion.putExtra("persona", persona);
                v.getContext().startActivity(descripcion);
            } else if (v.getId() == R.id.tvTelefono) {
                Intent intentTelefono = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + persona.getNumero()));
                v.getContext().startActivity(intentTelefono);
            } else if (v.getId() == R.id.tvInformacion) {
                Intent intentInformacion = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.422219,-122.08364?z=14"));
                v.getContext().startActivity(intentInformacion);
            }
        }
    }
}