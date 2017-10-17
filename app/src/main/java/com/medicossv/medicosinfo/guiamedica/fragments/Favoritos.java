package com.medicossv.medicosinfo.guiamedica.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.medicossv.medicosinfo.guiamedica.ArrayData.ArrayEspecialidades;
import com.medicossv.medicosinfo.guiamedica.R;
import com.medicossv.medicosinfo.guiamedica.adapters.AdapterEspecialidad;
import com.medicossv.medicosinfo.guiamedica.adapters.AdapterFavorito;
import com.medicossv.medicosinfo.guiamedica.entidad.Especialidad;
import com.medicossv.medicosinfo.guiamedica.entidad.Favorito;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose.lopez04 on 3/10/2017.
 */

public class Favoritos extends Fragment
{
    ArrayList<Favorito> faArrayList = null;
    AdapterFavorito adapterFavorito;
    Favorito favorito;
    private RelativeLayout mCLayout;

    public Favoritos()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_favorito, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_favoritos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        mCLayout = (RelativeLayout) getActivity().findViewById(R.id.mLayout);

       //--------------------Codigo para leer datos DB Local------
        faArrayList = new ArrayList<>();
        favorito = new Favorito();
        List<Favorito> faList = Favorito.listAll(Favorito.class);
        Log.d("data", faList.toString());
        for(int i=0; i<faList.size(); i++)
        {
            favorito = faList.get(i);
            faArrayList.add(favorito);
        }
        if (faArrayList == null  || faArrayList.isEmpty())
        {
            Snackbar.make(mCLayout, "No hay datos para mostrar", Snackbar.LENGTH_LONG)
                    .show();
        }
        else{
            adapterFavorito =  new AdapterFavorito(faArrayList, R.layout.row_favoritos);
            recyclerView.setAdapter(adapterFavorito);
        }
        //----------------END-------------------------------

    }

}
