/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 * Clase que representa a un paciente en el sistema.
 * Contiene información personal del paciente y su usuario asociado.
 * 
 */
public class Paciente {
    
    private int id_paciente;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String direccion;
    private Date fecha_nacimiento;
    private String telefono;
    private String correo;
    private Usuario usuario;

    /**
     * Constructor vacío de la clase Paciente.
     */
    public Paciente() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param id_paciente Identificador único del paciente.
     * @param nombre Nombre del paciente.
     * @param apellido_paterno Apellido paterno del paciente.
     * @param apellido_materno Apellido materno del paciente.
     * @param direccion Dirección del paciente.
     * @param fecha_nacimiento Fecha de nacimiento del paciente.
     * @param telefono Número de teléfono del paciente.
     * @param correo Correo electrónico del paciente.
     * @param usuario Usuario asociado al paciente.
     */
    public Paciente(int id_paciente, String nombre, String apellido_paterno, String apellido_materno, 
                    String direccion, Date fecha_nacimiento, String telefono, String correo, Usuario usuario) {
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
     * Constructor sin el identificador del paciente.
     * 
     * @param nombre Nombre del paciente.
     * @param apellido_paterno Apellido paterno del paciente.
     * @param apellido_materno Apellido materno del paciente.
     * @param direccion Dirección del paciente.
     * @param fecha_nacimiento Fecha de nacimiento del paciente.
     * @param telefono Número de teléfono del paciente.
     * @param correo Correo electrónico del paciente.
     * @param usuario Usuario asociado al paciente.
     */
    public Paciente(String nombre, String apellido_paterno, String apellido_materno, 
                    String direccion, Date fecha_nacimiento, String telefono, String correo, Usuario usuario) {
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
     * @return ID del paciente.
     */
    public int getId_paciente() {
        return id_paciente;
    }

    /**
     * Establece el ID del paciente.
     * @param id_paciente Nuevo ID del paciente.
     */
    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    /**
     * Obtiene el nombre del paciente.
     * @return Nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del paciente.
     * @param nombre Nuevo nombre del paciente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del paciente.
     * @return Apellido paterno del paciente.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno del paciente.
     * @param apellido_paterno Nuevo apellido paterno del paciente.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno del paciente.
     * @return Apellido materno del paciente.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno del paciente.
     * @param apellido_materno Nuevo apellido materno del paciente.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtiene la dirección del paciente.
     * @return Dirección del paciente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del paciente.
     * @param direccion Nueva dirección del paciente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la fecha de nacimiento del paciente.
     * @return Fecha de nacimiento del paciente.
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento del paciente.
     * @param fecha_nacimiento Nueva fecha de nacimiento del paciente.
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Obtiene el número de teléfono del paciente.
     * @return Número de teléfono del paciente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del paciente.
     * @param telefono Nuevo número de teléfono del paciente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del paciente.
     * @return Correo electrónico del paciente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del paciente.
     * @param correo Nuevo correo electrónico del paciente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el usuario asociado al paciente.
     * @return Usuario asociado al paciente.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado al paciente.
     * @param usuario Nuevo usuario asociado al paciente.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve una representación en cadena del objeto Paciente.
     * @return Cadena con los atributos del paciente.
     */
    @Override
    public String toString() {
        return "Paciente{" + 
               "id_paciente=" + id_paciente + 
               ", nombre=" + nombre + 
               ", apellido_paterno=" + apellido_paterno + 
               ", apellido_materno=" + apellido_materno + 
               ", direccion=" + direccion + 
               ", fecha_nacimiento=" + fecha_nacimiento + 
               ", telefono=" + telefono + 
               ", correo=" + correo + 
               '}';
    }
}
