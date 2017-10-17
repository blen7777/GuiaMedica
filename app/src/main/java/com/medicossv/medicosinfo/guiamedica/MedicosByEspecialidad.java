package com.medicossv.medicosinfo.guiamedica;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.medicossv.medicosinfo.guiamedica.ArrayData.ArrayMedicos;
import com.medicossv.medicosinfo.guiamedica.adapters.AdapterRowMedicos;
import com.medicossv.medicosinfo.guiamedica.entidad.MedicoRow;

import org.json.JSONArray;

import java.util.ArrayList;

public class MedicosByEspecialidad extends AppCompatActivity
{
    ArrayList<MedicoRow> dataset;
    AdapterRowMedicos adapterRowMedicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_medicos_especialidad);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_medico_especialidad);
        setSupportActionBar(toolbar);

        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.mipmap.leftrow);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_medicos_especialidad);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        dataset = new ArrayList<MedicoRow>();

        final ArrayMedicos arrayMedicos = new ArrayMedicos();

        String URL = "http://10.0.2.2/medic/rowMedicosEspecialidad.php?token=123456&espeID=4";
        RequestQueue queue = Volley.newRequestQueue(this);
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Please Wait", "We are taking your request");

        JsonArrayRequest request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        dataset = arrayMedicos.parser(response);
                        adapterRowMedicos =  new AdapterRowMedicos(dataset, R.layout.row_medico);
                        recyclerView.setAdapter(adapterRowMedicos);
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
