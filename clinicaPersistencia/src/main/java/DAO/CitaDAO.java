/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Cita;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
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
    
}
