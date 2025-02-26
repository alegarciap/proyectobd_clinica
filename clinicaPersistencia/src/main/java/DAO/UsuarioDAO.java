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
 *
 * @author Abraham Coronel
 */
public class UsuarioDAO implements IUsuarioDAO {

    IConexion conexion;

    public UsuarioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

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
