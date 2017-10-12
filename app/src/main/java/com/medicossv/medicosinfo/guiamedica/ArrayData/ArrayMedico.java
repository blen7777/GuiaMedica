package com.medicossv.medicosinfo.guiamedica.ArrayData;

import android.util.Log;

import com.medicossv.medicosinfo.guiamedica.entidad.Medico;
import com.medicossv.medicosinfo.guiamedica.entidad.MedicoRow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jose.lopez04 on 8/10/2017.
 */

public class ArrayMedico
{
    public ArrayList<Medico> parser(JSONArray response)
    {
        ArrayList<Medico> parqueosAux = new ArrayList<Medico>();
        for (int i=0; i<response.length();i++)
        {
            Medico p = new Medico();
            try
            {
                JSONObject jsonObject = (JSONObject) response.get(i);
                p.setIdMedico(jsonObject.getString("usu_id"));
                p.setFullName(jsonObject.getString("fullName"));
                p.setFoto(jsonObject.getString("gal_hash"));
                p.setEspecialidad(jsonObject.getString("esp_especialidad"));
                p.setTelefono(jsonObject.getString("cli_usu_telefono"));
                p.setEducacion(jsonObject.getString("cli_usu_telefono"));
                p.setDireccion(jsonObject.getString("fullName"));
                p.setEspecialidadDesc(jsonObject.getString("esp_especialidad"));
                p.setEmail(jsonObject.getString("mun_nombre"));
                p.setServicios(jsonObject.getString("cli_usu_telefono"));
                p.setLatitude(jsonObject.getString("esp_especialidad"));
                //p.setEducacion(jsonObject.getString("cli_usu_info_perfil"));
                p.setLongitude(jsonObject.getString("mun_nombre"));
                parqueosAux.add(p);

            }
            catch (JSONException e)
            {
                e.printStackTrace();
                Log.e("Medico", e.toString());
            }
        }

        return parqueosAux;
    }
}
