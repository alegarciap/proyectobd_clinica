/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Medico;
import entidades.Paciente;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author alega
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    IConexion conexion;
    private MedicoDAO medico;
    private PacienteDAO paciente;

    public UsuarioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Usuario autenticarUsuario(String nombre_usuario, String contrasenia) throws PersistenciaException {
        String consultaSQL = "select id_usuario, contrasenia from usuarios where nombre = ?;";

        try (Connection con = conexion.crearConexion(); 
                PreparedStatement st = con.prepareStatement(consultaSQL)) {
            st.setString(1, nombre_usuario);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String contraseniaGuardada = rs.getString("contrasenia");
                
                // verificar la constraseña encriptada
                if (BCrypt.checkpw(contrasenia, contraseniaGuardada)) {
                    // revisar en que tabla está el usuario
                    if (existeEnTabla("pacientes", id_usuario, con)) {
                        return paciente.obtenerPaciente(id_usuario).getUsuario(); // duda aquí
                    } else if (existeEnTabla("medicos", id_usuario, con)) {
                        return medico.obtenerMedico(id_usuario).getUsuario(); 
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al iniciar sesión.", ex);
        }
        return null;
    }

    // método auxiliar
    private boolean existeEnTabla(String tabla, int id_usuario, Connection conexion) throws SQLException {
        String comandoSQL = "select 1 from " + tabla + " where id_" + tabla.substring(0, tabla.length() - 1) + " = ?"; // 

        try (PreparedStatement stmt = conexion.prepareStatement(comandoSQL)) {
            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // devuelve true si encuentra un registro
        }
    }
    
    

   
}
