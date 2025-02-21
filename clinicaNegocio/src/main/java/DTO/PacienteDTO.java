/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author alega
 */
public class PacienteDTO {
    
    private int id_paciente;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String direccion;
    private Date fecha_nacimiento;
    private String telefono;
    private String correo;
    private int id_usuario;
    private String nombre_usuario;
    private String contrasenia_usuario;

    public PacienteDTO() {
    }

    public PacienteDTO(int id_paciente, String nombre, String apellido_paterno, String apellido_materno, String direccion, Date fecha_nacimiento, String telefono, String correo, int id_usuario, String nombre_usuario, String contrasenia_usuario) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia_usuario = contrasenia_usuario;
    }

    public PacienteDTO(String nombre, String apellido_paterno, String apellido_materno, String direccion, Date fecha_nacimiento, String telefono, String correo, int id_usuario, String nombre_usuario, String contrasenia_usuario) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia_usuario = contrasenia_usuario;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia_usuario() {
        return contrasenia_usuario;
    }

    public void setContrasenia_usuario(String contrasenia_usuario) {
        this.contrasenia_usuario = contrasenia_usuario;
    }

    @Override
    public String toString() {
        return "PacienteDTO{" + "id_paciente=" + id_paciente + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", direccion=" + direccion + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", correo=" + correo + ", id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", contrasenia_usuario=" + contrasenia_usuario + '}';
    }
    
}
