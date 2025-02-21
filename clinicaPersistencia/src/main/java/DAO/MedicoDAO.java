/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Medico;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abraham Coronel
 */
public class MedicoDAO implements IMedicoDAO {
    
    IConexion conexion;

    public MedicoDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    public Medico obtenerMedico(int id_usuario) throws SQLException, PersistenciaException {
        String comandoSQL = "select * from medicos where id_medico = ?";
        try (Connection con = conexion.crearConexion(); 
                PreparedStatement st = con.prepareStatement(comandoSQL)) {
            st.setInt(1, id_usuario);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medico medico = new Medico();
                medico.setId_medico(rs.getInt("id_medico"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido_paterno(rs.getString("apellido_paterno"));
                medico.setApellido_materno(rs.getString("apellido_materno"));
                medico.setCedula(rs.getString("cedula"));
                medico.setEspecialidad(rs.getString("especialidad"));
                medico.setEstado(rs.getString("estado"));
                return medico;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al obtener médico.", ex);
        }
        return null;
    }
    
    
    
}
