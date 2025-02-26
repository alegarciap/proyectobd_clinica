/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.ConsultaDAO;
import DAO.IConsultaDAO;
import DTO.ConsultaDTO;
import conexion.IConexion;
import entidades.Consulta;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.Mapper;

/**
 * La clase ConsultaBO es responsable de la lógica de negocio relacionada con las consultas médicas.
 * Proporciona métodos para realizar consultas y obtener historiales de consultas para pacientes y médicos.
 * 
 * Utiliza la interfaz IConsultaDAO para interactuar con la capa de persistencia.
 * 
 * @autor alega
 */
public class ConsultaBO {
    
    private static final Logger logger = Logger.getLogger(MedicoBO.class.getName());
    private final IConsultaDAO consultaDAO;

    /**
     * Constructor de la clase ConsultaBO.
     * 
     * @param conexion La conexión a la base de datos.
     */
    public ConsultaBO(IConexion conexion) {
        this.consultaDAO = new ConsultaDAO(conexion);
    }
    
    /**
     * Realiza una consulta médica.
     * 
     * @param consultaDTO El objeto ConsultaDTO que contiene los datos de la consulta a realizar.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al intentar registrar la consulta.
     * @throws NegocioException Si ocurre un error de negocio al intentar realizar la consulta.
     */
    public void realizarConsulta(ConsultaDTO consultaDTO) throws PersistenciaException, NegocioException {
        // validaciones necesarias
        
        try {
            consultaDAO.realizarConsulta(Mapper.toEntity(consultaDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al registrar consulta.", ex);
            throw new NegocioException("Ocurrió un error al registrar la consulta.", ex);
        }
    }
    
    /**
     * Obtiene el historial de consultas de un paciente en un rango de fechas y especialidad.
     * 
     * @param id_paciente El ID del paciente cuyas consultas se desean obtener.
     * @param especialidad La especialidad de las consultas que se desean filtrar.
     * @param fecha_inicio La fecha de inicio del rango de fechas.
     * @param fecha_fin La fecha de fin del rango de fechas.
     * @return Una lista de objetos ConsultaDTO que representan las consultas del paciente.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al obtener el historial de consultas.
     * @throws NegocioException Si el ID del paciente es inválido.
     */
    public List<ConsultaDTO> obtenerHistorialConsultas(int id_paciente, String especialidad, Timestamp fecha_inicio, Timestamp fecha_fin) throws PersistenciaException, NegocioException {
        if (id_paciente <= 0) {
            throw new NegocioException("ID de paciente inválido.");
        }
        
        // validaciones necesarias
        
        try {
            List<Consulta> historial_consultas = consultaDAO.obtenerHistorialConsultas(id_paciente, especialidad, fecha_inicio, fecha_fin);
            List<ConsultaDTO> consultasDTO = new ArrayList<>();
            for (Consulta consulta : historial_consultas) {
                consultasDTO.add(Mapper.toDTO(consulta));
            }
            return consultasDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al obtener las consultas.", ex);
            throw new NegocioException("Hubo un error al obtener las consultas.", ex);
        }
    }

    /**
     * Obtiene el historial de consultas realizadas por un médico a un paciente específico.
     * 
     * @param id_medico El ID del médico cuyas consultas se desean obtener.
     * @param id_paciente El ID del paciente cuyas consultas se desean obtener.
     * @return Una lista de objetos ConsultaDTO que representan las consultas del paciente realizadas por el médico.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al obtener el historial de consultas.
     * @throws NegocioException Si el ID del médico o el ID del paciente son inválidos.
     */
    public List<ConsultaDTO> obtenerHistorialConsultasMedicos(int id_medico, int id_paciente) throws PersistenciaException, NegocioException {
        if (id_medico <= 0) {
            throw new NegocioException("ID médico inválido.");
        }

        if (id_paciente <= 0) {
            throw new NegocioException("ID paciente inválido.");
        }

        // validaciones necesarias
        
        try {
            List<Consulta> historial_consultas = consultaDAO.obtenerHistorialConsultasMedicos(id_medico, id_paciente);
            List<ConsultaDTO> consultasDTO = new ArrayList<>();
            for (Consulta consulta : historial_consultas) {
                consultasDTO.add(Mapper.toDTO(consulta));
            }
            return consultasDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al obtener las consultas.", ex);
            throw new NegocioException("Hubo un error al obtener las consultas.", ex);
        }
    }
    
}
