/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author alega
 */
public class MedicoDTO {
    
    private int id_medico;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String cedula;
    private String especialidad;
    private String estado;
    private UsuarioDTO usuario;

    public MedicoDTO() {
    }

    public MedicoDTO(int id_medico, String nombre, String apellido_paterno, String apellido_materno, String cedula, String especialidad, String estado, UsuarioDTO usuario) {
        this.id_medico = id_medico;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.estado = estado;
        this.usuario = usuario;
    }

    public MedicoDTO(String nombre, String apellido_paterno, String apellido_materno, String cedula, String especialidad, String estado, UsuarioDTO usuario) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "MedicoDTO{" + "id_medico=" + id_medico + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", cedula=" + cedula + ", especialidad=" + especialidad + ", estado=" + estado + ", usuario=" + usuario + '}';
    }
    
}
