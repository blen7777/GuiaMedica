package com.medicossv.medicosinfo.guiamedica.ArrayData;

import android.util.Log;

import com.medicossv.medicosinfo.guiamedica.entidad.MedicoRow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jose.lopez04 on 5/10/2017.
 */

public class ArrayMedicos
{
    public ArrayList<MedicoRow> parser(JSONArray response)
    {
        ArrayList<MedicoRow> parqueosAux = new ArrayList<MedicoRow>();
        for (int i=0; i<response.length();i++)
        {
            MedicoRow p = new MedicoRow();
            try
            {
                JSONObject jsonObject = (JSONObject) response.get(i);
                p.setIdMedico(jsonObject.getString("usu_id"));
                p.setNombreCompleto(jsonObject.getString("fullName"));
                p.setEspecialidad(jsonObject.getString("esp_especialidad"));
                p.setCiudad(jsonObject.getString("mun_nombre"));
                p.setTelefono(jsonObject.getString("cli_usu_telefono"));
                parqueosAux.add(p);

            }
            catch (JSONException e)
            {
                e.printStackTrace();
                Log.e("MedicosRow", e.toString());
            }
        }

        return parqueosAux;
    }
}
