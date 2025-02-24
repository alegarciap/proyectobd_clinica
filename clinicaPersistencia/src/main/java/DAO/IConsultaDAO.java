/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Consulta;
import excepciones.PersistenciaException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author alega
 */
public interface IConsultaDAO {
    
    public void realizarConsulta(Consulta consulta) throws PersistenciaException;
    
    public List<Consulta> obtenerHistorialConsultas(int idPaciente, String especialidad, Timestamp fechaInicio, Timestamp fechaFin) throws PersistenciaException;
    
    public List<Consulta> obtenerHistorialConsultasMedicos(int id_medico, int id_paciente) throws PersistenciaException;
    
        
}
