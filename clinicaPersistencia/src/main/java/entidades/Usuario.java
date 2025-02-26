/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 * Clase que representa a un usuario en el sistema.
 * Contiene la información básica de autenticación del usuario.
 * 
 */
public class Usuario {
    
    private int id_usuario;
    private String nombre;
    private String contrasenia;

    /**
     * Constructor vacío de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param id_usuario Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param contrasenia Contraseña del usuario.
     */
    public Usuario(int id_usuario, String nombre, String contrasenia) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor sin el identificador del usuario.
     * 
     * @param nombre Nombre del usuario.
     * @param contrasenia Contraseña del usuario.
     */
    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el ID del usuario.
     * @return ID del usuario.
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Establece el ID del usuario.
     * @param id_usuario Nuevo ID del usuario.
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre Nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return Contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contrasenia Nueva contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Devuelve una representación en cadena del objeto Usuario.
     * @return Cadena con los atributos del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", contrasenia=" + contrasenia + '}';
    }
}
