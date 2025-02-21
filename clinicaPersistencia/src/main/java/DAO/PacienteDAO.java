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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author alega
 */
public class PacienteDAO implements IPacienteDAO {
    
    IConexion conexion;

    public PacienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void registrarPaciente(Paciente paciente) throws PersistenciaException {
        String comandoSQLUsuario = "insert into usuarios(id_usuario, nombre, contrasenia) values (?,?,?);";
        String comandoSQLPaciente = "insert into pacientes(id_paciente, nombre, apellido_paterno, apellido_materno, direccion, fecha_nacimiento, telefono, correo) "
                + "values (?,?,?,?,?,?,?,?);";
        
        try (Connection con = conexion.crearConexion()) { 
            con.setAutoCommit(false);
            
            // encriptar contraseña
            String contraseniaEncriptada = BCrypt.hashpw(paciente.getUsuario().getContrasenia(), BCrypt.gensalt());
            
            try (PreparedStatement stUsuario = con.prepareStatement(comandoSQLUsuario, Statement.RETURN_GENERATED_KEYS)) {
                stUsuario.setInt(1, paciente.getUsuario().getId_usuario());
                stUsuario.setString(2, paciente.getUsuario().getNombre());
                stUsuario.setString(3, contraseniaEncriptada);
                stUsuario.executeUpdate();
                
                try (ResultSet rs = stUsuario.getGeneratedKeys()) {
                    if (!rs.next()) {
                        throw new PersistenciaException("Error: No se pudo obtener el ID del usuario.");
                    }
                    
                    int idUsuario = rs.getInt(1);
                    
                    try (PreparedStatement stPaciente = con.prepareStatement(comandoSQLPaciente)) {
                        stPaciente.setInt(1, idUsuario);
                        stPaciente.setString(2, paciente.getNombre());
                        stPaciente.setString(3, paciente.getApellido_paterno());
                        stPaciente.setString(4, paciente.getApellido_materno());
                        stPaciente.setString(5, paciente.getDireccion());
                        stPaciente.setDate(6, paciente.getFecha_nacimiento());
                        stPaciente.setString(7, paciente.getTelefono());
                        stPaciente.setString(8, paciente.getCorreo());
                        
                        stPaciente.executeUpdate();
                    }
                }
            }
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error: No se pudo registrar el paciente.", ex);
        }
    }
    
    public Paciente obtenerPaciente(int id_usuario) throws SQLException, PersistenciaException {
        String comandoSQL = "select * from pacientes where id_paciente = ?";
        try (Connection con = conexion.crearConexion(); 
                PreparedStatement st = con.prepareStatement(comandoSQL)) {
            st.setInt(1, id_usuario);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId_paciente(rs.getInt("id_paciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido_paterno(rs.getString("apellido_paterno"));
                paciente.setApellido_materno(rs.getString("apellido_materno"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setCorreo(rs.getString("correo"));
                return paciente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al obtener paciente.", ex);
        }
        return null;
    }
    
    
    
}
