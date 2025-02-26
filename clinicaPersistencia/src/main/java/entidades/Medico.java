/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 * Representa a un médico dentro del sistema, incluyendo su información personal, 
 * especialidad, estado y la relación con un usuario del sistema.
 * 
 * @author alega
 */
public class Medico {
    
    /**
     * Identificador único del médico.
     */
    private int id_medico;
    
    /**
     * Nombre del médico.
     */
    private String nombre;
    
    /**
     * Apellido paterno del médico.
     */
    private String apellido_paterno;
    
    /**
     * Apellido materno del médico.
     */
    private String apellido_materno;
    
    /**
     * Cédula profesional del médico.
     */
    private String cedula;
    
    /**
     * Especialidad médica del médico.
     */
    private String especialidad;
    
    /**
     * Estado actual del médico (activo, inactivo, suspendido, etc.).
     */
    private String estado;
    
    /**
     * Usuario asociado al médico dentro del sistema.
     */
    private Usuario usuario;

    /**
     * Constructor por defecto.
     */
    public Medico() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param id_medico Identificador único del médico.
     * @param nombre Nombre del médico.
     * @param apellido_paterno Apellido paterno del médico.
     * @param apellido_materno Apellido materno del médico.
     * @param cedula Cédula profesional del médico.
     * @param especialidad Especialidad médica del médico.
     * @param estado Estado actual del médico.
     * @param usuario Usuario asociado al médico.
     */
    public Medico(int id_medico, String nombre, String apellido_paterno, String apellido_materno, String cedula, String especialidad, String estado, Usuario usuario) {
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
     * Constructor sin identificador (para registros nuevos).
     * 
     * @param nombre Nombre del médico.
     * @param apellido_paterno Apellido paterno del médico.
     * @param apellido_materno Apellido materno del médico.
     * @param cedula Cédula profesional del médico.
     * @param especialidad Especialidad médica del médico.
     * @param estado Estado actual del médico.
     * @param usuario Usuario asociado al médico.
     */
    public Medico(String nombre, String apellido_paterno, String apellido_materno, String cedula, String especialidad, String estado, Usuario usuario) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.estado = estado;
        this.usuario = usuario;
    }

    /**
     * Obtiene el identificador único del médico.
     * 
     * @return Identificador del médico.
     */
    public int getId_medico() {
        return id_medico;
    }

    /**
     * Establece el identificador único del médico.
     * 
     * @param id_medico Nuevo identificador del médico.
     */
    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    /**
     * Obtiene el nombre del médico.
     * 
     * @return Nombre del médico.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del médico.
     * 
     * @param nombre Nuevo nombre del médico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del médico.
     * 
     * @return Apellido paterno del médico.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno del médico.
     * 
     * @param apellido_paterno Nuevo apellido paterno del médico.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno del médico.
     * 
     * @return Apellido materno del médico.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno del médico.
     * 
     * @param apellido_materno Nuevo apellido materno del médico.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtiene la cédula profesional del médico.
     * 
     * @return Cédula profesional.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula profesional del médico.
     * 
     * @param cedula Nueva cédula profesional.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene la especialidad médica del médico.
     * 
     * @return Especialidad médica.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad médica del médico.
     * 
     * @param especialidad Nueva especialidad médica.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene el estado actual del médico.
     * 
     * @return Estado del médico.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del médico.
     * 
     * @param estado Nuevo estado del médico.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el usuario asociado al médico dentro del sistema.
     * 
     * @return Usuario asociado al médico.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado al médico dentro del sistema.
     * 
     * @param usuario Nuevo usuario asociado.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Representación en cadena del médico.
     * 
     * @return Una cadena con los valores de los atributos del médico.
     */
    @Override
    public String toString() {
        return "Medico{" + 
                "id_medico=" + id_medico + 
                ", nombre=" + nombre + 
                ", apellido_paterno=" + apellido_paterno + 
                ", apellido_materno=" + apellido_materno + 
                ", cedula=" + cedula + 
                ", especialidad=" + especialidad + 
                ", estado=" + estado + 
                ", usuario=" + usuario + 
                '}';
    }
}
