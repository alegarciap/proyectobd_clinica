/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.CitaDAO;
import DAO.ICitaDAO;
import DTO.CitaDTO;
import conexion.IConexion;
import entidades.Cita;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.Mapper;

/**
 * La clase CitaBO es responsable de la lógica de negocio relacionada con las citas médicas.
 * Proporciona métodos para agendar, cancelar y obtener citas para médicos y pacientes.
 * 
 * Utiliza la interfaz ICitaDAO para interactuar con la capa de persistencia.
 * 
 * @author alega
 */
public class CitaBO {
    
    private static final Logger logger = Logger.getLogger(CitaBO.class.getName());
    private final ICitaDAO citaDAO;
    
    /**
     * Constructor de la clase CitaBO.
     * 
     * @param conexion La conexión a la base de datos.
     */
    public CitaBO(IConexion conexion) {
        this.citaDAO = new CitaDAO(conexion);
    }
    
    /**
     * Agenda una nueva cita médica.
     * 
     * @param citaDTO El objeto CitaDTO que contiene los datos de la cita a agendar.
     * @throws NegocioException Si la cita es nula o si ocurre un error de negocio.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al intentar agendar la cita.
     */
    public void agendarCita(CitaDTO citaDTO) throws NegocioException, PersistenciaException {
        if (citaDTO == null) {
            throw new NegocioException("La cita no debe ser nula.");
        }
        
        // validaciones necesarias
        
        // ahora si intentar agendar la cita
        try {
            citaDAO.agendarCita(Mapper.toEntity(citaDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al agendar la cita.", ex);
            throw new NegocioException("Hubo un error al agendar la cita.", ex);
        }
    }
    
    /**
     * Agenda una cita médica de emergencia.
     * 
     * @param citaDTO El objeto CitaDTO que contiene los datos de la cita a agendar.
     * @throws NegocioException Si la cita es nula o si ocurre un error de negocio.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al intentar agendar la cita de emergencia.
     */
    public void agendarCitaEmergencia(CitaDTO citaDTO) throws NegocioException, PersistenciaException {
        if (citaDTO == null) {
            throw new NegocioException("La cita no debe ser nula.");
        }
        
        // validaciones necesarias
        
        // ahora si intentar agendar la cita
        try {
            citaDAO.agendarCitaEmergencia(Mapper.toEntity(citaDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al agendar la cita de emergencia.", ex);
            throw new NegocioException("Hubo un error al agendar la cita de emergencia.", ex);
        }
    }
    
    /**
     * Cancela una cita médica.
     * 
     * @param citaDTO El objeto CitaDTO que contiene los datos de la cita a cancelar.
     * @throws NegocioException Si la cita es nula o si ocurre un error de negocio.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al intentar cancelar la cita.
     */
    public void cancelarCita(CitaDTO citaDTO) throws PersistenciaException, NegocioException {
        if (citaDTO == null) {
            throw new NegocioException("La cita a cancelar no puede ser nula.");
        }
        
        // validaciones necesarias
        
        try {
            citaDAO.cancelarCita(Mapper.toEntity(citaDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al cancelar la cita.", ex);
            throw new NegocioException("Hubo un error al cancelar la cita.", ex);
        }
    }
    
    /**
     * Obtiene una lista de citas asociadas a un médico.
     * 
     * @param id_medico El ID del médico cuyas citas se desean obtener.
     * @return Una lista de objetos CitaDTO que representan las citas del médico.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al obtener las citas.
     * @throws NegocioException Si el ID del médico es inválido.
     */
    public List<CitaDTO> obtenerCitasMedico(int id_medico) throws PersistenciaException, NegocioException {
        if (id_medico <= 0) {
            throw new NegocioException("ID de médico inválido.");
        }
        
        try {
            List<Cita> citas = citaDAO.obtenerCitasMedico(id_medico);
            List<CitaDTO> citasDTO = new ArrayList<>();
            for (Cita cita : citas) {
                citasDTO.add(Mapper.toDTO(cita));
            }
            return citasDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al obtener las citas.", ex);
            throw new NegocioException("Hubo un error al obtener las citas.", ex);
        }
    }
    
    /**
     * Obtiene una lista de citas asociadas a un paciente.
     * 
     * @param id_paciente El ID del paciente cuyas citas se desean obtener.
     * @return Una lista de objetos CitaDTO que representan las citas del paciente.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al obtener las citas.
     * @throws NegocioException Si el ID del paciente es inválido.
     */
    public List<CitaDTO> obtenerCitasPaciente(int id_paciente) throws PersistenciaException, NegocioException {
        if (id_paciente <= 0) {
            throw new NegocioException("ID de paciente inválido.");
        }
        
        try {
            List<Cita> citas = citaDAO.obtenerCitasPaciente(id_paciente);
            List<CitaDTO> citasDTO = new ArrayList<>();
            for (Cita cita : citas) {
                citasDTO.add(Mapper.toDTO(cita));
            }
            return citasDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al obtener las citas.", ex);
            throw new NegocioException("Hubo un error al obtener las citas.", ex);
        }
    }
    
}
