package com.medicossv.medicosinfo.guiamedica.entidad;

import com.orm.SugarRecord;

/**
 * Created by jose.lopez04 on 29/9/2017.
 */

public class Especialidad extends SugarRecord
{

    String nombre, count;

    public Especialidad()
    {
    }

    public Especialidad(String nombre, String count) {
        this.nombre = nombre;
        this.count = count;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
