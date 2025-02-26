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
 * La clase UsuarioBO es responsable de la lógica de negocio relacionada con los usuarios.
 * Proporciona métodos para iniciar sesión y obtener información del usuario.
 * 
 * Utiliza la interfaz IUsuarioDAO para interactuar con la capa de persistencia.
 * 
 * @autor Abraham Coronel
 */
public class UsuarioBO {

    private static final Logger logger = Logger.getLogger(UsuarioBO.class.getName());
    private final IUsuarioDAO usuarioDAO;

    /**
     * Constructor de la clase UsuarioBO.
     * 
     * @param conexion La conexión a la base de datos.
     */
    public UsuarioBO(IConexion conexion) {
        this.usuarioDAO = new UsuarioDAO(conexion);
    }

    /**
     * Inicia sesión para un usuario dado.
     * 
     * @param usuarioDTO El objeto UsuarioDTO que contiene la información del usuario que intenta iniciar sesión.
     * @return true si el inicio de sesión es exitoso, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al intentar iniciar sesión.
     * @throws NegocioException Si ocurre un error de negocio durante el inicio de sesión, como datos inválidos.
     */
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

    /**
     * Obtiene el tipo de usuario según su ID.
     * 
     * @param id_usuario El ID del usuario cuyo tipo se desea obtener.
     * @return El tipo de usuario (por ejemplo, "paciente", "médico").
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al intentar obtener el tipo de usuario.
     * @throws NegocioException Si ocurre un error de negocio durante la obtención del tipo de usuario.
     */
    public String obtenerTipoUsuario(int id_usuario) throws PersistenciaException, NegocioException {
        // validaciones necesarias

        try {
            return usuarioDAO.obtenerTipoUsuario(id_usuario);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al obtener el tipo de usuario.", ex);
            throw new NegocioException("Ocurrió un error al obtener el tipo de usuario.", ex);
        }
    }

    /**
     * Obtiene el nombre del usuario según su ID.
     * 
     * @param idUsuario El ID del usuario cuyo nombre se desea obtener.
     * @return El nombre del usuario.
     * @throws NegocioException Si ocurre un error de negocio debido a un ID de usuario inválido.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al intentar obtener el nombre del usuario.
     */
    public String obtenerNombreUsuario(int idUsuario) throws NegocioException, PersistenciaException {
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
