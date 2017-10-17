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
import com.medicossv.medicosinfo.guiamedica.entidad.MedicoRow;

import java.util.ArrayList;

/**
 * Created by jose.lopez04 on 4/10/2017.
 */

public class AdapterFavorito extends RecyclerView.Adapter<AdapterFavorito.ViewHolder>
{
    private final ArrayList<Favorito> favoritos;
    private final int itemLayout;
    public View view;

    public AdapterFavorito(ArrayList<Favorito> favoritos, int itemLayoyut) {
        this.favoritos = favoritos;
        this.itemLayout = itemLayoyut;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public  final TextView idFavorito;
        public  final TextView fullaName;
        //public  final IconTextView foto;
        public  final TextView especialidad;

        public ViewHolder(View itemView)
        {
            super(itemView);

            idFavorito = itemView.findViewById(R.id.idFavorito);
            fullaName = itemView.findViewById(R.id.NameFavorito);
            //foto = itemView.findViewById(R.id.imgfavorito);
            especialidad = itemView.findViewById(R.id.especialidadFavorito);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override public void onClick(View v)
                {

                }
            });
        }
    }

    public AdapterFavorito.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);

        return new AdapterFavorito.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterFavorito.ViewHolder viewHolder, int i)
    {
        Favorito favorito = favoritos.get(i);
        viewHolder.idFavorito.setText(favorito.getId_medico());
        viewHolder.fullaName.setText(favorito.getNombreCompleto());
        //viewHolder.foto.setText(favorito.getFoto());
        viewHolder.especialidad.setText(favorito.getEspecialidad());

    }

    @Override
    public int getItemCount() {
        return favoritos.size();
    }
}
