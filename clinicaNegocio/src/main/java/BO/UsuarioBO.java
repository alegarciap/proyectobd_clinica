/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IUsuarioDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import conexion.IConexion;
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
    
    private static final Logger logger = Logger.getLogger(UsuarioBO.class.getName());
    private final IUsuarioDAO usuarioDAO;
    
    public UsuarioBO(IConexion conexion) {
        this.usuarioDAO = new UsuarioDAO(conexion);
    }
    
    public boolean iniciarSesion(UsuarioDTO usuarioDTO) throws PersistenciaException, NegocioException {
        if (usuarioDTO.getNombre() == null || usuarioDTO.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombe de usuario no puede estar vacío");
        }
        
        if (usuarioDTO.getContrasenia() == null || usuarioDTO.getContrasenia().trim().isEmpty() || usuarioDTO.getContrasenia().length() < 8) {
            throw new NegocioException("La contraseña debe tener mínimo 8 caracteres");
        }
        
        try {
            return usuarioDAO.iniciarSesion(Mapper.toEntity(usuarioDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al iniciar sesión.", ex);
            throw new NegocioException("Ocurrió un error al iniciar sesión.", ex); 
        }
    }
    
    public String obtenerTipoUsuario(String id_usuario) throws PersistenciaException, NegocioException {
        // validaciones necesarias
        
        try {
            return usuarioDAO.obtenerTipoUsuario(id_usuario);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al iniciar sesión.", ex);
            throw new NegocioException("Ocurrió un error al obtener el tipo usuario.", ex); 
        }
    }
    
}
