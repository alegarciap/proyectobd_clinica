/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Consulta;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            throw new PersistenciaException("Ocurrió un error al realizar la consulta", ex);
        }
    }
    
}
