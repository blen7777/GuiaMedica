package com.medicossv.medicosinfo.guiamedica.entidad;

import com.orm.SugarRecord;

/**
 * Created by jose.lopez04 on 2/10/2017.
 */

public class Favorito extends SugarRecord
{
    String id_medico,nombreCompleto, especialidad, foto;

    public Favorito() {
    }

    public Favorito(String id_medico, String nombreCompleto, String especialidad, String foto) {
        this.id_medico = id_medico;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.foto = foto;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
