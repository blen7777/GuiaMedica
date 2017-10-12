package com.medicossv.medicosinfo.guiamedica.entidad;

import com.orm.SugarRecord;

/**
 * Created by jose.lopez04 on 4/10/2017.
 */

public class MedicoRow extends SugarRecord
{
    String idMedico, nombreCompleto, especialidad, ciudad, telefono, photo;

    public MedicoRow() {
    }

    public MedicoRow(String idMedico, String nombreCompleto, String especialidad, String ciudad, String telefono, String photo) {
        this.idMedico = idMedico;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.photo = photo;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
