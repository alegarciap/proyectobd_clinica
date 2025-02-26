/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * La clase UsuarioDTO representa un objeto de transferencia de datos 
 * utilizado para almacenar información sobre un usuario. Incluye 
 * detalles como el ID del usuario, el nombre y la contraseña.
 * 
 * @author alega
 */
public class UsuarioDTO {
    
    private int id_usuario;
    private String nombre;
    private String contrasenia;

    /**
     * Constructor vacío de UsuarioDTO.
     */
    public UsuarioDTO() {
    }

    /**
     * Constructor de UsuarioDTO con todos los parámetros.
     * 
     * @param id_usuario El ID del usuario.
     * @param nombre El nombre del usuario.
     * @param contrasenia La contraseña del usuario.
     */
    public UsuarioDTO(int id_usuario, String nombre, String contrasenia) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor de UsuarioDTO sin ID de usuario.
     * 
     * @param nombre El nombre del usuario.
     * @param contrasenia La contraseña del usuario.
     */
    public UsuarioDTO(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el ID del usuario.
     * 
     * @return El ID del usuario.
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Establece el ID del usuario.
     * 
     * @param id_usuario El nuevo ID del usuario.
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return La contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param contrasenia La nueva contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto UsuarioDTO.
     * 
     * @return Una cadena que representa el objeto UsuarioDTO.
     */
    @Override
    public String toString() {
        return "UsuarioDTO{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", contrasenia=" + contrasenia + '}';
    }
}
