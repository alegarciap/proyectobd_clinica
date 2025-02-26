/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 * La clase PacienteDTO representa un objeto de transferencia de datos 
 * utilizado para almacenar información sobre un paciente. Incluye 
 * detalles como el nombre, apellidos, dirección, fecha de nacimiento, 
 * teléfono, correo y el usuario asociado al paciente.
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
    private UsuarioDTO usuario;

    /**
     * Constructor vacío de PacienteDTO.
     */
    public PacienteDTO() {
    }

    /**
     * Constructor de PacienteDTO con todos los parámetros.
     * 
     * @param id_paciente El ID del paciente.
     * @param nombre El nombre del paciente.
     * @param apellido_paterno El apellido paterno del paciente.
     * @param apellido_materno El apellido materno del paciente.
     * @param direccion La dirección del paciente.
     * @param fecha_nacimiento La fecha de nacimiento del paciente.
     * @param telefono El número de teléfono del paciente.
     * @param correo El correo electrónico del paciente.
     * @param usuario El usuario asociado al paciente.
     */
    public PacienteDTO(int id_paciente, String nombre, String apellido_paterno, String apellido_materno, String direccion, Date fecha_nacimiento, String telefono, String correo, UsuarioDTO usuario) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
    }

    /**
     * Constructor de PacienteDTO sin ID de paciente.
     * 
     * @param nombre El nombre del paciente.
     * @param apellido_paterno El apellido paterno del paciente.
     * @param apellido_materno El apellido materno del paciente.
     * @param direccion La dirección del paciente.
     * @param fecha_nacimiento La fecha de nacimiento del paciente.
     * @param telefono El número de teléfono del paciente.
     * @param correo El correo electrónico del paciente.
     * @param usuario El usuario asociado al paciente.
     */
    public PacienteDTO(String nombre, String apellido_paterno, String apellido_materno, String direccion, Date fecha_nacimiento, String telefono, String correo, UsuarioDTO usuario) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
    }

    /**
     * Obtiene el ID del paciente.
     * 
     * @return El ID del paciente.
     */
    public int getId_paciente() {
        return id_paciente;
    }

    /**
     * Establece el ID del paciente.
     * 
     * @param id_paciente El nuevo ID del paciente.
     */
    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    /**
     * Obtiene el nombre del paciente.
     * 
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del paciente.
     * 
     * @param nombre El nuevo nombre del paciente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del paciente.
     * 
     * @return El apellido paterno del paciente.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno del paciente.
     * 
     * @param apellido_paterno El nuevo apellido paterno del paciente.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno del paciente.
     * 
     * @return El apellido materno del paciente.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno del paciente.
     * 
     * @param apellido_materno El nuevo apellido materno del paciente.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtiene la dirección del paciente.
     * 
     * @return La dirección del paciente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del paciente.
     * 
     * @param direccion La nueva dirección del paciente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la fecha de nacimiento del paciente.
     * 
     * @return La fecha de nacimiento del paciente.
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento del paciente.
     * 
     * @param fecha_nacimiento La nueva fecha de nacimiento del paciente.
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Obtiene el número de teléfono del paciente.
     * 
     * @return El número de teléfono del paciente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del paciente.
     * 
     * @param telefono El nuevo número de teléfono del paciente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del paciente.
     * 
     * @return El correo electrónico del paciente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del paciente.
     * 
     * @param correo El nuevo correo electrónico del paciente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el usuario asociado al paciente.
     * 
     * @return El usuario asociado.
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado al paciente.
     * 
     * @param usuario El nuevo usuario asociado.
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto PacienteDTO.
     * 
     * @return Una cadena que representa el objeto PacienteDTO.
     */
    @Override
    public String toString() {
        return "PacienteDTO{" + "id_paciente=" + id_paciente + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", direccion=" + direccion + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", correo=" + correo + ", usuario=" + usuario + '}';
    }
}
