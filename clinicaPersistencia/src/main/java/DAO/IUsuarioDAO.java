/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Usuario;
import excepciones.PersistenciaException;

/**
 * Interfaz para la gestión de usuarios en el sistema.
 * 
 * Define los métodos necesarios para autenticar, obtener información y gestionar usuarios.
 * 
 * @author alega
 */
public interface IUsuarioDAO {
    
    /**
     * Inicia sesión con las credenciales de un usuario.
     * 
     * @param usuario Objeto Usuario con las credenciales de acceso.
     * @return true si la autenticación es exitosa, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error en la operación de persistencia.
     */
    public boolean iniciarSesion(Usuario usuario) throws PersistenciaException;
    
    /**
     * Obtiene el tipo de usuario en el sistema.
     * 
     * @param id_usuario ID del usuario.
     * @return Tipo de usuario (ej. "Paciente", "Médico", "Administrador").
     * @throws PersistenciaException Si ocurre un error en la operación de persistencia.
     */
    public String obtenerTipoUsuario(int id_usuario) throws PersistenciaException;
    
    /**
     * Obtiene el nombre de usuario asociado a un ID.
     * 
     * @param idUsuario ID del usuario.
     * @return Nombre del usuario.
     * @throws PersistenciaException Si ocurre un error en la operación de persistencia.
     */
    public String obtenerNombreUsuario(int idUsuario) throws PersistenciaException;
    
}
