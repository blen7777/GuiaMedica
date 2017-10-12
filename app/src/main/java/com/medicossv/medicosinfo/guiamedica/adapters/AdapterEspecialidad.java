package com.medicossv.medicosinfo.guiamedica.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.IconTextView;
import android.widget.TextView;

import com.medicossv.medicosinfo.guiamedica.R;
import com.medicossv.medicosinfo.guiamedica.entidad.Especialidad;
import com.medicossv.medicosinfo.guiamedica.entidad.Favorito;

import java.util.ArrayList;

/**
 * Created by jose.lopez04 on 4/10/2017.
 */

public class AdapterEspecialidad extends RecyclerView.Adapter<AdapterEspecialidad.ViewHolder>
{
    private final ArrayList<Especialidad> especialidades;
    private final int itemLayout;
    public  View view;

    public AdapterEspecialidad(ArrayList<Especialidad> especialidad, int itemLayoyut) {
        this.especialidades = especialidad;
        this.itemLayout = itemLayoyut;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public  final TextView idEspecialidad;
        public  final TextView especialidad;
        public  final TextView count;


        public ViewHolder(View itemView)
        {
            super(itemView);

            idEspecialidad = itemView.findViewById(R.id.idEspecialidad);
            especialidad = itemView.findViewById(R.id.especialidadName);
            count = itemView.findViewById(R.id.countEspecialidad);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override public void onClick(View v)
                {

                }
            });
        }
    }

    public AdapterEspecialidad.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);

        return new AdapterEspecialidad.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterEspecialidad.ViewHolder viewHolder, int i)
    {
        Especialidad especialidad = especialidades.get(i);
        viewHolder.idEspecialidad.setText(especialidad.getIdEspecialidad());
        viewHolder.especialidad.setText(especialidad.getNombre());
        viewHolder.count.setText(especialidad.getCount());

    }

    @Override
    public int getItemCount() {
        return especialidades.size();
    }
}
