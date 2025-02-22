/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.PacienteDAO.getMD5;
import conexion.IConexion;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alega
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    IConexion conexion;

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
                if (getMD5(contrasenia).equals(contraseniaGuardada)) { 
                    // revisar en que tabla está el usuario
                    if (existeEnTabla("pacientes", id_usuario, con)) {
                        PacienteDAO paciente = new PacienteDAO(conexion);
                        return paciente.obtenerPaciente(id_usuario).getUsuario(); 
                    } else if (existeEnTabla("medicos", id_usuario, con)) {
                        MedicoDAO medico = new MedicoDAO(conexion);
                        return medico.obtenerMedico(id_usuario).getUsuario(); 
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al iniciar sesión. Credenciales incorrectas.", ex);
        }
        return null;
    }

    // método auxiliar
    private boolean existeEnTabla(String tabla, int id_usuario, Connection conexion) throws SQLException {
        String campoId = "id_" + tabla.substring(0, tabla.length() - 1);  
        String comandoSQL = "select 1 from " + tabla + " where " + campoId + " = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(comandoSQL)) {
            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
            }
        }
        return false; // devuelve true si encuentra un registro
    }
    
}
