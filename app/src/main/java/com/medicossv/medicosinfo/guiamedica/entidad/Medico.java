package com.medicossv.medicosinfo.guiamedica.entidad;

import com.orm.SugarRecord;

/**
 * Created by jose.lopez04 on 29/9/2017.
 */

public class Medico extends SugarRecord
{
    String idMedico, titulo, fullName, especialidad, latitude, longitude, foto, educacion, direccion, especialidadDesc, telefono, email, servicios;

    public Medico()
    {
    }

    public Medico(String idMedico, String titulo, String fullName, String especialidad, String latitude, String longitude, String foto, String educacion, String direccion, String especialidadDesc, String telefono, String email, String servicios) {
        this.idMedico = idMedico;
        this.titulo = titulo;
        this.fullName = fullName;
        this.especialidad = especialidad;
        this.latitude = latitude;
        this.longitude = longitude;
        this.foto = foto;
        this.educacion = educacion;
        this.direccion = direccion;
        this.especialidadDesc = especialidadDesc;
        this.telefono = telefono;
        this.email = email;
        this.servicios = servicios;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEspecialidadDesc() {
        return especialidadDesc;
    }

    public void setEspecialidadDesc(String especialidadDesc) {
        this.especialidadDesc = especialidadDesc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }
}
