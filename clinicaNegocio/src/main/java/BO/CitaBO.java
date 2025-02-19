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
import entidades.Medico;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.CitaMapper;

/**
 *
 * @author alega
 */
public class CitaBO {
    
    private static final Logger logger = Logger.getLogger(CitaBO.class.getName());
    private final ICitaDAO citaDAO;
    private final CitaMapper mapper = new CitaMapper();
    
    public CitaBO(IConexion conexion) {
        this.citaDAO = new CitaDAO(conexion);
    }
    
    public boolean agendarCita(CitaDTO citaDTO) throws NegocioException, PersistenciaException {
        if (citaDTO == null) {
            throw new NegocioException("La cita no debe ser nula.");
        }
        
        if (citaDTO.getFecha_hora() == null) {
            throw new NegocioException("La fecha de la cita no debe estar vacía.");
        }
        
        // validaciones necesarias
        
        // convertir la citadto a entidad cita
        Cita cita = mapper.toentity(citaDTO);
        
        // ahora si intentar agendar la cita
        try {
            return citaDAO.agendarCita(cita);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al agendar la cita.", ex);
            throw new NegocioException("Hubo un error al agendar la cita.", ex);
        }
    }
    
    public boolean agendarCitaEmergencia(CitaDTO citaDTO) throws NegocioException, PersistenciaException {
        if (citaDTO == null) {
            throw new NegocioException("La cita no debe ser nula.");
        }
        
        // validaciones necesarias
        
        // convertir la citadto a entidad cita
        Cita cita = mapper.toentity(citaDTO);
        
        // ahora si intentar agendar la cita
        try {
            return citaDAO.agendarCitaEmergencia(cita);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al agendar la cita de emergencia.", ex);
            throw new NegocioException("Hubo un error al agendar la cita de emergencia.", ex);
        }
    }

    
}
