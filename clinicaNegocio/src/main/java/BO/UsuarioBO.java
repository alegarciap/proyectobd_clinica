/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IUsuarioDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import conexion.IConexion;
import entidades.Usuario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.Mapper;

/**
 *
 * @author alega
 */
public class UsuarioBO {
    
    private static final Logger logger = Logger.getLogger(CitaBO.class.getName());
    private final IUsuarioDAO usuarioDAO;
    
    public UsuarioBO(IConexion conexion) {
        this.usuarioDAO = new UsuarioDAO(conexion);
    }
    
    public UsuarioDTO autenticarUsuario(String nombre_usuario, String contrasenia) throws PersistenciaException, NegocioException {
        if (nombre_usuario.isEmpty()) {
            throw new NegocioException("El nombe de usuario no puede estar vacío");
        }
        
        if (contrasenia == null || contrasenia.trim().isEmpty() || contrasenia.length() < 8) {
            throw new NegocioException("La contraseña debe tener mínimo 8 caracteres");
        }
        
        try {
            Usuario usuario = usuarioDAO.autenticarUsuario(nombre_usuario, contrasenia);
            if (usuario == null) {
                throw new NegocioException("No se encontró el usuario " + nombre_usuario);
            }
            return Mapper.toDTO(usuario);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al iniciar sesión. ", ex);
            throw new NegocioException("Error al iniciar sesión. ", ex);
        }
    }
    
}
