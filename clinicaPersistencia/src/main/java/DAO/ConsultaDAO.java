/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Cita;
import entidades.Consulta;
import entidades.Medico;
import excepciones.PersistenciaException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz IConsultaDAO para gestionar consultas médicas
 * en la base de datos.
 */
public class ConsultaDAO implements IConsultaDAO {
    
    /**
     * Objeto de conexión a la base de datos.
     */
    private final IConexion conexion;

    /**
     * Constructor de la clase ConsultaDAO.
     * 
     * @param conexion Objeto de conexión a la base de datos.
     */
    public ConsultaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta una nueva consulta médica en la base de datos.
     * 
     * @param consulta Objeto Consulta con la información a registrar.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    @Override
    public void realizarConsulta(Consulta consulta) throws PersistenciaException {
        String comandoSQL = "INSERT INTO consultas (fecha_hora, diagnostico, tratamiento, observaciones, id_cita) "
                + "VALUES (?, ?, ?, ?, ?);";
        
        try (Connection con = conexion.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(comandoSQL)) {
            ps.setTimestamp(1, consulta.getFecha_hora());
            ps.setString(2, consulta.getDiagnostico());
            ps.setString(3, consulta.getTratamiento());
            ps.setString(4, consulta.getObservaciones());
            ps.setInt(5, consulta.getCita().getId_cita());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Ocurrió un error al realizar la consulta.", ex);
        }
    }

    /**
     * Obtiene el historial de consultas de un paciente en un rango de fechas y
     * opcionalmente filtrado por especialidad.
     * 
     * @param id_paciente ID del paciente.
     * @param especialidad Especialidad médica (puede ser nulo o vacío).
     * @param fecha_inicio Fecha de inicio del historial (puede ser nula).
     * @param fecha_fin Fecha de fin del historial (puede ser nula).
     * @return Lista de consultas del paciente.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    @Override
    public List<Consulta> obtenerHistorialConsultas(int id_paciente, String especialidad, Timestamp fecha_inicio, Timestamp fecha_fin) throws PersistenciaException {
        List<Consulta> historialConsultas = new ArrayList<>();
        String comandoSQL = "SELECT id_consulta, fecha_hora, diagnostico, tratamiento, observaciones, nombre, apellido_paterno, especialidad "
                + "FROM vista_historial_consultas_p "
                + "WHERE id_paciente = ? "
                + (especialidad != null && !especialidad.isEmpty() ? "AND especialidad = ? " : "")
                + (fecha_inicio != null ? "AND fecha_hora >= ? " : "")
                + (fecha_fin != null ? "AND fecha_hora <= ? " : "")
                + "ORDER BY fecha_hora DESC;";
        
        try (Connection con = conexion.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(comandoSQL)) {
            int index = 1;
            ps.setInt(index++, id_paciente);
            if (especialidad != null && !especialidad.isEmpty()) {
                ps.setString(index++, especialidad);
            }
            if (fecha_inicio != null) {
                ps.setTimestamp(index++, fecha_inicio);
            }
            if (fecha_fin != null) {
                ps.setTimestamp(index++, fecha_fin);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId_consulta(rs.getInt("id_consulta"));
                consulta.setFecha_hora(rs.getTimestamp("fecha_hora"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setTratamiento(rs.getString("tratamiento"));
                consulta.setObservaciones(rs.getString("observaciones"));

                Medico medico = new Medico();
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido_paterno(rs.getString("apellido_paterno"));
                medico.setEspecialidad(rs.getString("especialidad"));

                Cita cita = new Cita();
                cita.setMedico(medico);
                consulta.setCita(cita);

                historialConsultas.add(consulta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Ocurrió un error al obtener el historial de consultas.", ex);
        }
        return historialConsultas;
    }
    
    /**
     * Obtiene el historial de consultas realizadas por un médico a un paciente.
     * 
     * @param id_medico ID del médico.
     * @param id_paciente ID del paciente.
     * @return Lista de consultas realizadas por el médico al paciente.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    @Override
    public List<Consulta> obtenerHistorialConsultasMedicos(int id_medico, int id_paciente) throws PersistenciaException {
        List<Consulta> historialConsultas = new ArrayList<>();
        String comandoSQL = "SELECT id_consulta, fecha_hora, diagnostico, tratamiento, observaciones "
                + "FROM vista_historial_consultas_m WHERE id_medico = ? AND id_paciente = ? "
                + "ORDER BY fecha_hora DESC";
        
        try (Connection con = conexion.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(comandoSQL)) {
            ps.setInt(1, id_medico);
            ps.setInt(2, id_paciente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId_consulta(rs.getInt("id_consulta"));
                consulta.setFecha_hora(rs.getTimestamp("fecha_hora"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setTratamiento(rs.getString("tratamiento"));
                consulta.setObservaciones(rs.getString("observaciones"));

                historialConsultas.add(consulta);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Ocurrió un error al obtener el historial de consultas.", ex);
        }
        return historialConsultas;
    }
}
