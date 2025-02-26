/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.PacienteDAO.getMD5;
import conexion.IConexion;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase UsuarioDAO proporciona métodos para manejar la persistencia de datos de usuarios
 * en una base de datos. Implementa la interfaz IUsuarioDAO.
 * 
 * @author Abraham Coronel
 */
public class UsuarioDAO implements IUsuarioDAO {

    IConexion conexion;

    /**
     * Constructor de la clase UsuarioDAO.
     * 
     * @param conexion La conexión a la base de datos.
     */
    public UsuarioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Inicia sesión de un usuario validando su nombre y contraseña.
     * 
     * @param usuario El objeto Usuario que contiene el nombre y la contraseña a validar.
     * @return true si el inicio de sesión es exitoso, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error al intentar iniciar sesión.
     */
    @Override
    public boolean iniciarSesion(Usuario usuario) throws PersistenciaException {
        String comandoSQL = "select * from usuarios where nombre = ?;";

        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(comandoSQL)) {

            ps.setString(1, usuario.getNombre());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String contrasenia = rs.getString("contrasenia");
                String contraseniaEncriptada = getMD5(usuario.getContrasenia());

                if (contrasenia.equals(contraseniaEncriptada)) {
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    return true; // inicio de sesión exitoso
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error: No se pudo iniciar sesión.", ex);
        }
        return false;
    }

    /**
     * Obtiene el tipo de usuario asociado a un ID de usuario.
     * 
     * @param id_usuario El ID del usuario cuyo tipo se desea obtener.
     * @return El tipo de usuario como una cadena.
     * @throws PersistenciaException Si ocurre un error al obtener el tipo de usuario.
     */
    @Override
    public String obtenerTipoUsuario(int id_usuario) throws PersistenciaException {
        String tipo_usuario = "";
        String comandoSQL = "call obtener_tipo_usuario(?, ?);";

        try (Connection con = this.conexion.crearConexion(); CallableStatement cs = con.prepareCall(comandoSQL)) {
            cs.setInt(1, id_usuario);
            cs.registerOutParameter(2, Types.VARCHAR);

            cs.execute();

            tipo_usuario = cs.getString(2);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error: No se pudo obtener el tipo de usuario.", ex);
        }
        return tipo_usuario;
    }

    /**
     * Obtiene el nombre de un usuario según su ID.
     * 
     * @param idUsuario El ID del usuario cuyo nombre se desea obtener.
     * @return El nombre del usuario como una cadena.
     * @throws PersistenciaException Si ocurre un error al obtener el nombre del usuario o si no se encuentra el usuario.
     */
    @Override
    public String obtenerNombreUsuario(int idUsuario) throws PersistenciaException {
        String comandoSQL = "SELECT nombre FROM usuarios WHERE id_usuario = ?;";

        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(comandoSQL)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("nombre");
            } else {
                throw new PersistenciaException("Usuario no encontrado con ID: " + idUsuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al obtener el nombre del usuario", ex);
        }
    }
}
