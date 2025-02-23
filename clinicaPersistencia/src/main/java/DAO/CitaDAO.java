/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Cita;
import entidades.Paciente;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alega
 */
public class CitaDAO implements ICitaDAO {
    
    IConexion conexion;

    public CitaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agendarCita(Cita cita) throws PersistenciaException {      
        String comandoSQL = "call agendar_cita(?,?,?);";
        
        try (Connection con = this.conexion.crearConexion();
                CallableStatement cb = con.prepareCall(comandoSQL)) {
            cb.setTimestamp(1, cita.getFecha_hora());
            cb.setInt(2, cita.getPaciente().getId_paciente());
            cb.setInt(3, cita.getMedico().getId_medico());
            
            cb.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error: No se pudo agendar la cita.", ex);
        }
    }

    @Override
    public void agendarCitaEmergencia(Cita cita) throws PersistenciaException {
        String comandoSQL = "call agendar_cita_emergencia(?);";
        
        try (Connection con = this.conexion.crearConexion();
                CallableStatement cb = con.prepareCall(comandoSQL)) {
            cb.setInt(1, cita.getPaciente().getId_paciente());
            
            cb.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error: No se pudo agendar la cita de emergencia.", ex);
        }
    }

    @Override
    public void cancelarCita(Cita cita) throws PersistenciaException {
        String comandoSQL = "call cancelar_cita(?,?);";
        
        try (Connection con = this.conexion.crearConexion();
                CallableStatement cb = con.prepareCall(comandoSQL)) {
            cb.setInt(1, cita.getId_cita());
            cb.setInt(2, cita.getPaciente().getId_paciente());
            
            cb.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error: No se pudo cancelar la cita.", ex);
        }
    }

    @Override
    public List<Cita> obtenerCitasMedico(int id_medico) throws PersistenciaException {
        List<Cita> citas = new ArrayList<>();
        String consultaSQL = "select c.id_cita, c.fecha_hora, p.id_paciente, p.nombre, p.apellido_paterno, p.apellido_materno "
                + "from citas c "
                + "inner join pacientes p on c.id_paciente = p.id_paciente "
                + "where c.id_medico = ? and c.estado = 'programada' "
                + "order by c.fecha_hora asc;";
        
        try (Connection con = conexion.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(consultaSQL)) {
            ps.setInt(1, id_medico);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId_paciente(rs.getInt("id_paciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido_paterno(rs.getString("apellido_paterno"));
                paciente.setApellido_materno(rs.getString("apellido_materno"));
                
                Cita cita = new Cita();
                cita.setId_cita(rs.getInt("id_cita"));
                cita.setFecha_hora(rs.getTimestamp("fecha_hora"));
                cita.setPaciente(paciente);

                citas.add(cita);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al obtener las citas del médico.", ex);
        }
        return citas;
    }
    
}
