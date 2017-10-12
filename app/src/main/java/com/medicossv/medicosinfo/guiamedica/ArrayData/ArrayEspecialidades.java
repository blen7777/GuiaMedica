package com.medicossv.medicosinfo.guiamedica.ArrayData;

import android.util.Log;

import com.medicossv.medicosinfo.guiamedica.entidad.Especialidad;
import com.medicossv.medicosinfo.guiamedica.entidad.MedicoRow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jose.lopez04 on 5/10/2017.
 */

public class ArrayEspecialidades
{
    public ArrayList<Especialidad> parser(JSONArray response)
    {
        ArrayList<Especialidad> parqueosAux = new ArrayList<Especialidad>();
        for (int i=0; i<response.length();i++)
        {
            Especialidad p = new Especialidad();
            try
            {
                JSONObject jsonObject = (JSONObject) response.get(i);
                p.setIdEspecialidad(jsonObject.getString("esp_id"));
                p.setNombre(jsonObject.getString("esp_especialidad"));
                p.setCount(jsonObject.getString("total"));
                parqueosAux.add(p);

            }
            catch (JSONException e)
            {
                e.printStackTrace();
                Log.e("EspecialidadRow", e.toString());
            }
        }

        return parqueosAux;
    }
}
