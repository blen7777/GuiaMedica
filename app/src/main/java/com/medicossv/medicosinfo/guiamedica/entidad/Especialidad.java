package com.medicossv.medicosinfo.guiamedica.entidad;

import com.orm.SugarRecord;

/**
 * Created by jose.lopez04 on 29/9/2017.
 */

public class Especialidad extends SugarRecord
{

    String nombre, count, idEspecialidad;

    public Especialidad()
    {
    }

    public Especialidad(String nombre, String count, String idEspecialidad) {
        this.nombre = nombre;
        this.count = count;
        this.idEspecialidad = idEspecialidad;
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

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
}
