package com.medicossv.medicosinfo.guiamedica.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.IconTextView;
import android.widget.TextView;

import com.medicossv.medicosinfo.guiamedica.R;
import com.medicossv.medicosinfo.guiamedica.entidad.Medico;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by jose.lopez04 on 8/10/2017.
 */

public class AdapterMedico  extends RecyclerView.Adapter<AdapterMedico.ViewHolder>
{

    private final ArrayList<Medico> medicos;
    private final int itemLayout;
    public View view;

    public AdapterMedico(ArrayList<Medico> medicos, int itemLayoyut) {
        this.medicos = medicos;
        this.itemLayout = itemLayoyut;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public  final TextView idMedico;
        public  final TextView fullaName;
        public  final TextView especialidad;
        public  final IconTextView telefono;
       // public  final CircleImageView foto;
        public  final TextView latitude;
        public  final TextView longitude;
        public  final IconTextView perfil;
        public  final IconTextView direccion;
        public  final IconTextView email;
        public  final IconTextView infoEspecialidad;


        public ViewHolder(View itemView)
        {
            super(itemView);

            idMedico = itemView.findViewById(R.id.idMedico);
            fullaName = itemView.findViewById(R.id.MedicName);
            especialidad = itemView.findViewById(R.id.MedicEspecialidad);
            telefono = itemView.findViewById(R.id.MedicTelefonos);
            //foto = itemView.findViewById(R.id.MedicFoto);
            latitude = itemView.findViewById(R.id.MedicLatitude);
            longitude = itemView.findViewById(R.id.MedicLongitude);
            perfil = itemView.findViewById(R.id.MedicPerfil);
            direccion = itemView.findViewById(R.id.MedicDireccion);
            email = itemView.findViewById(R.id.MedicEmail);
            infoEspecialidad = itemView.findViewById(R.id.MedicEspe);

        }
    }

    public AdapterMedico.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);

        return new AdapterMedico.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterMedico.ViewHolder viewHolder, int i)
    {
        Medico  medico = medicos.get(i);
        viewHolder.idMedico.setText(medico.getIdMedico());
        viewHolder.fullaName.setText(medico.getFullName());
        viewHolder.especialidad.setText(medico.getEspecialidad());
        viewHolder.telefono.setText(medico.getTelefono());
        //viewHolder.foto.setText(medico.getTitle());
        viewHolder.latitude.setText(medico.getLatitude());
        viewHolder.longitude.setText(medico.getLongitude());
        viewHolder.perfil.setText(medico.getServicios());
        viewHolder.direccion.setText(medico.getDireccion());
        viewHolder.email.setText(medico.getEmail());
        viewHolder.infoEspecialidad.setText(medico.getEspecialidadDesc());

    }

    @Override
    public int getItemCount() {
        return medicos.size();
    }
}
