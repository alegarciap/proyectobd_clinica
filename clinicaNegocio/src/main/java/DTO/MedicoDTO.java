/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * La clase MedicoDTO representa un objeto de transferencia de datos 
 * utilizado para almacenar información sobre un médico. Incluye detalles
 * como el nombre, apellidos, cédula, especialidad, estado y el usuario 
 * asociado al médico.
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

    /**
     * Constructor vacío de MedicoDTO.
     */
    public MedicoDTO() {
    }

    /**
     * Constructor de MedicoDTO con todos los parámetros.
     * 
     * @param id_medico El ID del médico.
     * @param nombre El nombre del médico.
     * @param apellido_paterno El apellido paterno del médico.
     * @param apellido_materno El apellido materno del médico.
     * @param cedula La cédula del médico.
     * @param especialidad La especialidad del médico.
     * @param estado El estado del médico (por ejemplo, activo, inactivo).
     * @param usuario El usuario asociado al médico.
     */
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

    /**
     * Constructor de MedicoDTO sin ID de médico.
     * 
     * @param nombre El nombre del médico.
     * @param apellido_paterno El apellido paterno del médico.
     * @param apellido_materno El apellido materno del médico.
     * @param cedula La cédula del médico.
     * @param especialidad La especialidad del médico.
     * @param estado El estado del médico (por ejemplo, activo, inactivo).
     * @param usuario El usuario asociado al médico.
     */
    public MedicoDTO(String nombre, String apellido_paterno, String apellido_materno, String cedula, String especialidad, String estado, UsuarioDTO usuario) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.estado = estado;
        this.usuario = usuario;
    }

    /**
     * Obtiene el ID del médico.
     * 
     * @return El ID del médico.
     */
    public int getId_medico() {
        return id_medico;
    }

    /**
     * Establece el ID del médico.
     * 
     * @param id_medico El nuevo ID del médico.
     */
    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    /**
     * Obtiene el nombre del médico.
     * 
     * @return El nombre del médico.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del médico.
     * 
     * @param nombre El nuevo nombre del médico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del médico.
     * 
     * @return El apellido paterno del médico.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno del médico.
     * 
     * @param apellido_paterno El nuevo apellido paterno del médico.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno del médico.
     * 
     * @return El apellido materno del médico.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno del médico.
     * 
     * @param apellido_materno El nuevo apellido materno del médico.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtiene la cédula del médico.
     * 
     * @return La cédula del médico.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del médico.
     * 
     * @param cedula La nueva cédula del médico.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene la especialidad del médico.
     * 
     * @return La especialidad del médico.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad del médico.
     * 
     * @param especialidad La nueva especialidad del médico.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene el estado del médico.
     * 
     * @return El estado del médico.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del médico.
     * 
     * @param estado El nuevo estado del médico.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el usuario asociado al médico.
     * 
     * @return El usuario asociado.
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado al médico.
     * 
     * @param usuario El nuevo usuario asociado.
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto MedicoDTO.
     * 
     * @return Una cadena que representa el objeto MedicoDTO.
     */
    @Override
    public String toString() {
        return "MedicoDTO{" + "id_medico=" + id_medico + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", cedula=" + cedula + ", especialidad=" + especialidad + ", estado=" + estado + ", usuario=" + usuario + '}';
    }
}
