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
 *
 * @author alega
 */
public class ConsultaBO {
    
    private static final Logger logger = Logger.getLogger(MedicoBO.class.getName());
    private final IConsultaDAO consultaDAO;

    public ConsultaBO(IConexion conexion) {
        this.consultaDAO = new ConsultaDAO(conexion);
    }
    
    public void realizarConsulta(ConsultaDTO consultaDTO) throws PersistenciaException, NegocioException {
        // validaciones necesarias
        
        try {
            consultaDAO.realizarConsulta(Mapper.toEntity(consultaDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al registrar consulta.", ex);
            throw new NegocioException("Ocurrió un error al registrar la consulta.", ex);
        }
        
    }
    
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
