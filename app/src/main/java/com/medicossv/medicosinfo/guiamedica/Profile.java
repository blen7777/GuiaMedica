package com.medicossv.medicosinfo.guiamedica;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.medicossv.medicosinfo.guiamedica.entidad.Favorito;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {
    public TextView txt_idMedico;
    public TextView txt_fullaName;
    public TextView txt_especialidad;
    public TextView txt_telefono;
    // public  final CircleImageView txt_foto;
    public TextView txt_latitude;
    public TextView txt_longitude;
    public WebView txt_perfil;
    public TextView txt_direccion;
    public TextView txt_email;
    public TextView txt_infoEspecialidad;
    public TextView txt_municipio;
    public TextView call;
    private CoordinatorLayout mCLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_medico);

        //----------Lectura de variables.
        txt_idMedico = (TextView) findViewById(R.id.idMedico);
        txt_fullaName = (TextView) findViewById(R.id.MedicName);
        txt_especialidad = (TextView) findViewById(R.id.MedicEspecialidad);
        txt_telefono = (TextView) findViewById(R.id.MedicTelefonos);
        // txt_foto = (TextView) findViewById(R.id.texlink);
        txt_latitude = (TextView) findViewById(R.id.MedicLatitude);
        txt_longitude = (TextView) findViewById(R.id.MedicLongitude);
        txt_perfil = (WebView) findViewById(R.id.MedicPerfil);
        txt_direccion = (TextView) findViewById(R.id.MedicDireccion);
        txt_email = (TextView) findViewById(R.id.MedicEmail);
        txt_infoEspecialidad = (TextView) findViewById(R.id.MedicEspe);
        txt_municipio = (TextView) findViewById(R.id.MedicMunicipio);
        mCLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        call = (TextView) findViewById(R.id.callNum);

        Bundle extras = getIntent().getExtras();
        final Integer medicID = Integer.valueOf(extras.getString("medicID"));

        String URL = "http://10.0.2.2/medic/medico.php?token=123456&medicID=" + medicID;
        RequestQueue queue = Volley.newRequestQueue(this);


        JsonArrayRequest request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Process the JSON
                        try {
                            // Loop through the array elements
                            for (int i = 0; i < response.length(); i++) {
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
                                String minucipio = medico.getString("mun_nombre");
                                //String infoEspecialidad = medico.getString("age");


                                WebView webview = (WebView) findViewById(R.id.MedicPerfil);
                                webview.getSettings().setJavaScriptEnabled(true);
                                webview.loadDataWithBaseURL("", perfil, "text/html", "UTF-8", "");

                                // Display the formatted json data in text view
                                txt_idMedico.setText(idMedico);
                                txt_fullaName.setText(titulo + " " + fullaName);
                                txt_especialidad.setText(especialidad);
                                txt_municipio.setText(minucipio);
                                txt_telefono.setText(telefono);
                                call.setText(telefono);
                                //txt_perfil.setText(perfil);
                                txt_latitude.setText(latitude);
                                txt_longitude.setText(longitude);
                                txt_direccion.setText(direccion);
                                txt_email.setText(email);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                // Do something when error occurred
                Snackbar.make(mCLayout, "Algo salió mal :(  Datos incorrectos", Snackbar.LENGTH_LONG)
                        .show();

            }
        });


        queue.add(request);
    }

    public void DoCall(View view) {

        if (txt_telefono.getText().toString() != "") {

            try {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + quitarGion(txt_telefono.getText().toString())));
                Log.d("numeroSin", quitarGion(txt_telefono.getText().toString()));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }catch(Exception e)
            {
                Snackbar.make(mCLayout, "Su llamada fallo", Snackbar.LENGTH_LONG)
                        .show();

                e.printStackTrace();
                Log.e("errorCall", e.toString());
            }


        }
        else
        {
            Snackbar.make(mCLayout, "El numero de teléfono es incorrecto", Snackbar.LENGTH_LONG)
                    .show();
        }

    }

    public String quitarGion(String texto)
    {
        return texto.replaceAll("-","");
    }

    public void GoMaps(View view)
    {
        Intent intent = new Intent(this, Mapa.class);
        startActivity(intent);
    }

    public void AddFavorite(View view)
    {
        try {
            Favorito register = new Favorito(txt_idMedico.getText().toString(),txt_fullaName.getText().toString(),txt_especialidad.getText().toString(),"null",txt_municipio.getText().toString());
            register.save();
            Toast.makeText(this, "Favorito agregado correctamente", Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {
            Snackbar.make(mCLayout, "Algo salio mal, al intentar guardar el dato", Snackbar.LENGTH_LONG)
                    .show();

            e.printStackTrace();
            Log.e("errorSAve", e.toString());
        }


    }
}
