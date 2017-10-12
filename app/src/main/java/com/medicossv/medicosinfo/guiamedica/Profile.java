package com.medicossv.medicosinfo.guiamedica;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.IconTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity
{
    public  TextView txt_idMedico;
    public  TextView txt_fullaName;
    public  TextView txt_especialidad;
    public  TextView txt_telefono;
    // public  final CircleImageView txt_foto;
    public  TextView txt_latitude;
    public  TextView txt_longitude;
    public  TextView txt_perfil;
    public  TextView txt_direccion;
    public  TextView txt_email;
    public  TextView txt_infoEspecialidad;
    public  TextView call;
    private CoordinatorLayout mCLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_medico);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_medico);
        setSupportActionBar(toolbar);

        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.mipmap.leftrow);

        //----------Lectura de variables.
        txt_idMedico = (TextView) findViewById(R.id.idMedico);
        txt_fullaName = (TextView) findViewById(R.id.MedicName);
        txt_especialidad = (TextView) findViewById(R.id.MedicEspecialidad);
        txt_telefono = (TextView) findViewById(R.id.MedicTelefonos);
       // txt_foto = (TextView) findViewById(R.id.texlink);
        txt_latitude = (TextView) findViewById(R.id.MedicLatitude);
        txt_longitude = (TextView) findViewById(R.id.MedicLongitude);
        txt_perfil = (TextView) findViewById(R.id.MedicPerfil);
        txt_direccion = (TextView) findViewById(R.id.MedicDireccion);
        txt_email = (TextView) findViewById(R.id.MedicEmail);
        txt_infoEspecialidad = (TextView) findViewById(R.id.MedicEspe);
        mCLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        call = (TextView) findViewById(R.id.callNum);


        String URL = "http://10.0.2.2/medic/medico.php?";
        RequestQueue queue = Volley.newRequestQueue(this);


        JsonArrayRequest request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        // Process the JSON
                        try{
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++)
                            {
                                // Get current json object
                                JSONObject medico = response.getJSONObject(i);

                                // Get the current student (json object) data
                                String idMedico = medico.getString("usu_id");
                                String fullaName = medico.getString("fullName");
                                String titulo = medico.getString("cli_usu_titulo");
                                String especialidad = medico.getString("esp_especialidad");
                                String telefono = medico.getString("cli_usu_telefono");
                                String latitude = medico.getString("cli_ubicacion_lat");
                                String longitude = medico.getString("cli_ubicacion_lon");
                                String perfil = medico.getString("cli_usu_info_perfil");
                                String direccion = medico.getString("cli_usu_direccion");
                                String email = medico.getString("cli_usu_correo");
                                //String infoEspecialidad = medico.getString("age");

                                // Display the formatted json data in text view
                                txt_idMedico.setText(idMedico);
                                txt_fullaName.setText(titulo+" "+fullaName);
                                txt_especialidad.setText(especialidad);
                                txt_telefono.setText(telefono);
                                call.setText(telefono);
                                txt_perfil.setText(perfil);
                                txt_latitude.setText(latitude);
                                txt_longitude.setText(longitude);
                                txt_direccion.setText(direccion);
                                txt_email.setText(email);
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError)
            {
                // Do something when error occurred
                Log.d("arrayMedico", volleyError.toString());
                Snackbar.make(mCLayout, "Algo salio mal :(  Datos incorrectos", Snackbar.LENGTH_LONG)
                        .show();

            }
        });


        queue.add(request);
    }
}
