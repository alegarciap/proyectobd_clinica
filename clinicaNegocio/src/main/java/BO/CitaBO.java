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
 *
 * @author alega
 */
public class CitaBO {
    
    private static final Logger logger = Logger.getLogger(CitaBO.class.getName());
    private final ICitaDAO citaDAO;
    
    public CitaBO(IConexion conexion) {
        this.citaDAO = new CitaDAO(conexion);
    }
    
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
    
    public List<CitaDTO> obtenerCitasMedico(int id_medico) throws PersistenciaException, NegocioException {
        if (id_medico <= 0) {
            throw new NegocioException("ID de venta inválido.");
        }
        
        try {
            List<Cita> citas = citaDAO.obtenerCitasMedico(id_medico);
            List<CitaDTO> citasDTO = new ArrayList<>();
            for (Cita cita : citas) {
                citasDTO.add(Mapper.toDTO(cita));
            }
            return citasDTO;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al obtener las ventas.", ex);
            throw new NegocioException("Hubo un error al obtener las ventas.", ex);
        }
    }
    
}
