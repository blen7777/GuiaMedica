package com.medicossv.medicosinfo.guiamedica.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.medicossv.medicosinfo.guiamedica.ArrayData.ArrayEspecialidades;
import com.medicossv.medicosinfo.guiamedica.ArrayData.ArrayMedicos;
import com.medicossv.medicosinfo.guiamedica.R;
import com.medicossv.medicosinfo.guiamedica.adapters.AdapterEspecialidad;
import com.medicossv.medicosinfo.guiamedica.adapters.AdapterRowMedicos;
import com.medicossv.medicosinfo.guiamedica.entidad.Especialidad;
import com.medicossv.medicosinfo.guiamedica.entidad.MedicoRow;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by jose.lopez04 on 30/9/2017.
 */

public class Especialidad_list extends Fragment
{
    ArrayList<Especialidad> dataset;
    AdapterEspecialidad adapterEspecialidad;

    public Especialidad_list()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_especialidades, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final RecyclerView recyclerView = getView().findViewById(R.id.recycler_especialidades);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        dataset = new ArrayList<Especialidad>();

        final ArrayEspecialidades arrayEspecialidades = new ArrayEspecialidades();

        String URL = "http://10.0.2.2/medic/especialidades.php";
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "Please Wait", "We are taking your request");

        JsonArrayRequest request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        dataset = arrayEspecialidades.parser(response);
                        adapterEspecialidad =  new AdapterEspecialidad(dataset, R.layout.row_especialidades);
                        recyclerView.setAdapter(adapterEspecialidad);
                        progressDialog.cancel();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError)
            {

                progressDialog.cancel();

            }
        });


        queue.add(request);
    }
}
