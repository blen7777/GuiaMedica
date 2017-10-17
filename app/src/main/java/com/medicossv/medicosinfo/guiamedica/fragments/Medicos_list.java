package com.medicossv.medicosinfo.guiamedica.fragments;

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.IconTextView;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.medicossv.medicosinfo.guiamedica.ArrayData.ArrayMedicos;
import com.medicossv.medicosinfo.guiamedica.R;
import com.medicossv.medicosinfo.guiamedica.adapters.AdapterRowMedicos;
import com.medicossv.medicosinfo.guiamedica.entidad.Medico;
import com.medicossv.medicosinfo.guiamedica.entidad.MedicoRow;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Medicos_list extends Fragment
{
    ArrayList<MedicoRow> dataset;
    AdapterRowMedicos adapterRowMedicos;
    private MenuItem mSearchItem;
    private Toolbar mToolbar;

    public Medicos_list()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.recycler_medicos, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final RecyclerView recyclerView = getView().findViewById(R.id.my_recycler_medicos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        dataset = new ArrayList<MedicoRow>();

        final ArrayMedicos arrayMedicos = new ArrayMedicos();

        String URL = "http://10.0.2.2/medic/rowMedicos.php";
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "Please Wait", "We are taking your request");

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



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        android.widget.SearchView searchView = (android.widget.SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                final ArrayList<MedicoRow> filteredModelList = filter(dataset, newText);

                adapterRowMedicos.setFilter(filteredModelList);
                return true;

            }

        });
        super.onCreateOptionsMenu(menu, inflater);

    }

    private ArrayList<MedicoRow> filter(ArrayList<MedicoRow> models, String query) {
        query = query.toLowerCase();
        final ArrayList<MedicoRow> filteredModelList = new ArrayList<>();
        for (MedicoRow medico : models) {
            final String text = medico.getNombreCompleto().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(medico);
            }
        }
        return filteredModelList;
    }



}
