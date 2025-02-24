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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alega
 */
public class ConsultaDAO implements IConsultaDAO{
    
    IConexion conexion;

    public ConsultaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void realizarConsulta(Consulta consulta) throws PersistenciaException {
        String comandoSQL = "insert into consultas (fecha_hora, diagnostico, tratamiento, observaciones, id_cita) "
                + "values (?, ?, ?, ?, ?);";
        
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

    @Override
    public List<Consulta> obtenerHistorialConsultas(int id_paciente, String especialidad, Timestamp fecha_inicio, Timestamp fecha_fin) throws PersistenciaException {
        List<Consulta> historialConsultas = new ArrayList<>();
        String comandoSQL = "select id_consulta, fecha_hora, diagnostico, tratamiento, observaciones, nombre, apellido_paterno, especialidad "
                + "from vista_historial_consultas_p "
                + "where id_paciente = ? "
                + (especialidad != null && !especialidad.isEmpty() ? "and especialidad = ? " : "")
                + (fecha_inicio != null ? "and fecha_hora >= ? " : "")
                + (fecha_fin != null ? "and fecha_hora <= ? " : "")
                + "order by fecha_hora desc;";
        
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
    
    @Override
    public List<Consulta> obtenerHistorialConsultasMedicos(int id_medico, int id_paciente) throws PersistenciaException {
        List<Consulta> historialConsultas = new ArrayList<>();
        String comandoSQL = "select id_consulta, fecha_hora, diagnostico, tratamiento, observaciones "
                + "from vista_historial_consultas_m where id_medico = ? and id_paciente = ? "
                + "order by fecha_hora desc";
        
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
