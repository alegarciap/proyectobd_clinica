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
 * @author Abraham Coronel
 */
public class UsuarioBO {

    private static final Logger logger = Logger.getLogger(UsuarioBO.class.getName());
    private final IUsuarioDAO usuarioDAO;

    public UsuarioBO(IConexion conexion) {
        this.usuarioDAO = new UsuarioDAO(conexion);
    }

    public boolean iniciarSesion(UsuarioDTO usuarioDTO) throws PersistenciaException, NegocioException {
        if (usuarioDTO.getNombre() == null || usuarioDTO.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre de usuario no puede estar vacío");
        }

        if (usuarioDTO.getContrasenia() == null || usuarioDTO.getContrasenia().trim().isEmpty() || usuarioDTO.getContrasenia().length() < 8) {
            throw new NegocioException("La contraseña debe tener mínimo 8 caracteres");
        }

        try {
            Usuario usuarioEntity = Mapper.toEntity(usuarioDTO);
            boolean loginOk = usuarioDAO.iniciarSesion(usuarioEntity);
            if (loginOk) {
                usuarioDTO.setId_usuario(usuarioEntity.getId_usuario());
            }
            return loginOk;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al iniciar sesión.", ex);
            throw new NegocioException("Ocurrió un error al iniciar sesión.", ex);
        }
    }

    public String obtenerTipoUsuario(int id_usuario) throws PersistenciaException, NegocioException {
        // validaciones necesarias

        try {
            return usuarioDAO.obtenerTipoUsuario(id_usuario);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al iniciar sesión.", ex);
            throw new NegocioException("Ocurrió un error al obtener el tipo usuario.", ex);
        }
    }

    public String obtenerNombreUsuario(int idUsuario) throws NegocioException {
        try {
            if (idUsuario <= 0) {
                throw new NegocioException("ID de usuario inválido");
            }

            return usuarioDAO.obtenerNombreUsuario(idUsuario);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al obtener el nombre del usuario", ex);
            throw new NegocioException("No se pudo obtener el nombre del usuario", ex);
        }
    }

}
