/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Medico;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz IMedicoDAO para la gestión de médicos en el sistema.
 * 
 * Proporciona métodos para obtener información de médicos, así como activarlos y desactivarlos.
 * 
 * @author Abraham Coronel
 */
public class MedicoDAO implements IMedicoDAO {
    
    IConexion conexion;

    /**
     * Constructor que recibe una conexión a la base de datos.
     * 
     * @param conexion Objeto de conexión a la base de datos.
     */
    public MedicoDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Obtiene la información de un médico a partir de su ID de usuario.
     * 
     * @param id_usuario ID del usuario asociado al médico.
     * @return Objeto Medico con la información obtenida.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     * @throws PersistenciaException Si ocurre un error en la persistencia de datos.
     */
    @Override
    public Medico obtenerMedico(int id_usuario) throws SQLException, PersistenciaException {
        String comandoSQL = "select * from medicos m "
                + "join usuarios u on m.id_medico = u.id_usuario "
                + "where m.id_medico = ?"; 
        
        try (Connection con = conexion.crearConexion(); 
                PreparedStatement st = con.prepareStatement(comandoSQL)) {
            st.setInt(1, id_usuario);
            
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Medico medico = new Medico();
                    medico.setId_medico(rs.getInt("id_medico"));
                    medico.setNombre(rs.getString("nombre"));
                    medico.setApellido_paterno(rs.getString("apellido_paterno"));
                    medico.setApellido_materno(rs.getString("apellido_materno"));
                    medico.setCedula(rs.getString("cedula"));
                    medico.setEspecialidad(rs.getString("especialidad"));
                    medico.setEstado(rs.getString("estado"));
                    
                    Usuario usuario = new Usuario();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setContrasenia(rs.getString("contrasenia"));  
                    
                    medico.setUsuario(usuario);
                    
                    return medico;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al obtener médico.", ex);
        }
        return null;
    }

    /**
     * Desactiva el registro de un médico en el sistema.
     * 
     * @param medico Objeto Medico que se desea desactivar.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     * @throws PersistenciaException Si ocurre un error en la persistencia de datos.
     */
    @Override
    public void desactivarMedico(Medico medico) throws SQLException, PersistenciaException {
        String comandoSQL = "call desactivar_medico(?);";
        
        try (Connection con = this.conexion.crearConexion();
                CallableStatement cb = con.prepareCall(comandoSQL)) {
            cb.setInt(1, medico.getId_medico());
            
            cb.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al dar de baja el médico.", ex);
        }
    }

    /**
     * Activa el registro de un médico en el sistema.
     * 
     * @param medico Objeto Medico que se desea activar.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     * @throws PersistenciaException Si ocurre un error en la persistencia de datos.
     */
    @Override
    public void activarMedico(Medico medico) throws SQLException, PersistenciaException {
        String comandoSQL = "call activar_medico(?);";
        
        try (Connection con = this.conexion.crearConexion();
                CallableStatement cb = con.prepareCall(comandoSQL)) {
            cb.setInt(1, medico.getId_medico());
            
            cb.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al activar el médico.", ex);
        }
    }
    
}
