package com.medicossv.medicosinfo.guiamedica.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.IconTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.medicossv.medicosinfo.guiamedica.Profile;
import com.medicossv.medicosinfo.guiamedica.R;
import com.medicossv.medicosinfo.guiamedica.entidad.MedicoRow;

import java.util.ArrayList;

/**
 * Created by jose.lopez04 on 4/10/2017.
 */

public class AdapterRowMedicos extends RecyclerView.Adapter<AdapterRowMedicos.ViewHolder>
{
    private final ArrayList<MedicoRow> medicoRows;
    private final int itemLayout;
    public  View view;

    public AdapterRowMedicos(ArrayList<MedicoRow> medicoRows, int itemLayoyut) {
        this.medicoRows = medicoRows;
        this.itemLayout = itemLayoyut;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public  final TextView idRow;
        public  final TextView fullaName;
        //public  final IconTextView foto;
        public  final TextView especialidad;
        public  final IconTextView ciudad;
        public  final IconTextView telefono;

        public ViewHolder(View itemView)
        {
            super(itemView);

            idRow = itemView.findViewById(R.id.idRow);
            fullaName = itemView.findViewById(R.id.fullNameRow);
           // foto = itemView.findViewById(R.id.imgRow);
            especialidad = itemView.findViewById(R.id.especialidadRow);
            ciudad = itemView.findViewById(R.id.ciudadRow);
            telefono = itemView.findViewById(R.id.telefonoRow);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v)
                {

                    Intent link = new Intent(v.getContext(), Profile.class);
                    link.putExtra("medicID", 17);
                    v.getContext().startActivity(link);
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i)
    {
        MedicoRow medico = medicoRows.get(i);
        viewHolder.idRow.setText(medico.getIdMedico());
        viewHolder.fullaName.setText(medico.getNombreCompleto());
        //viewHolder.foto.setText(medico.getPhoto());
        viewHolder.especialidad.setText(medico.getEspecialidad());
        viewHolder.ciudad.setText(medico.getCiudad());
        viewHolder.telefono.setText(medico.getTelefono());

    }

    @Override
    public int getItemCount() {
        return medicoRows.size();
    }


}
