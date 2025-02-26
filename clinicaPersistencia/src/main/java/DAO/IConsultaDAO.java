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
 * Interfaz para la gestión de consultas médicas en el sistema.
 * 
 * Define los métodos necesarios para registrar y consultar consultas médicas.
 * 
 * @author alega
 */
public interface IConsultaDAO {
    
    /**
     * Registra una nueva consulta médica en el sistema.
     * 
     * @param consulta Objeto Consulta con la información a registrar.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    public void realizarConsulta(Consulta consulta) throws PersistenciaException;
    
    /**
     * Obtiene el historial de consultas de un paciente.
     * 
     * @param idPaciente ID del paciente.
     * @param especialidad Especialidad médica de las consultas a filtrar (puede ser nulo o vacío).
     * @param fechaInicio Fecha de inicio para filtrar las consultas (puede ser nulo).
     * @param fechaFin Fecha de fin para filtrar las consultas (puede ser nulo).
     * @return Lista de consultas del paciente.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    public List<Consulta> obtenerHistorialConsultas(int idPaciente, String especialidad, Timestamp fechaInicio, Timestamp fechaFin) throws PersistenciaException;
    
    /**
     * Obtiene el historial de consultas de un paciente con un médico específico.
     * 
     * @param id_medico ID del médico.
     * @param id_paciente ID del paciente.
     * @return Lista de consultas entre el médico y el paciente.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    public List<Consulta> obtenerHistorialConsultasMedicos(int id_medico, int id_paciente) throws PersistenciaException;
    
}
