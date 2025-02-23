/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IPacienteDAO;
import DAO.PacienteDAO;
import DTO.PacienteDTO;
import conexion.IConexion;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import mapper.Mapper;

/**
 *
 * @author alega
 */
public class PacienteBO {
    
    private static final Logger logger = Logger.getLogger(PacienteBO.class.getName());
    private final IPacienteDAO pacienteDAO;
    
    public PacienteBO(IConexion conexion) {
        this.pacienteDAO = new PacienteDAO(conexion);
    }
    
    public void registrarPaciente(PacienteDTO pacienteDTO) throws PersistenciaException, NegocioException {
        // validaciones necesarias
        if (pacienteDTO.getNombre() == null || pacienteDTO.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre del paciente no debe estar vacío, es obligatorio.");
        }
        
        // validar apellido
        if (pacienteDTO.getApellido_paterno() == null || pacienteDTO.getApellido_paterno().trim().isEmpty()) {
            throw new NegocioException("El paciente debe registrar al menos un apellido.");
        }
        
        // validar direccion
        if (pacienteDTO.getDireccion() == null || pacienteDTO.getDireccion().trim().isEmpty()) {
            throw new NegocioException("La dirección del paciente debe ser registrada");
        }
        // validar telefono
        Pattern regexTelefono = Pattern.compile("^\\d{10}$");
        if (pacienteDTO.getTelefono() == null || !regexTelefono.matcher(pacienteDTO.getTelefono().trim()).matches()) {
            throw new NegocioException("Número de teléfono inválido. Debe contener 10 dígitos.");
        }
        
        // validar correo
        Pattern regexCorreo = Pattern.compile("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$");
        if (pacienteDTO.getCorreo() == null || !regexCorreo.matcher(pacienteDTO.getCorreo().trim()).matches()) {
            throw new NegocioException("Correo electrónico inválido.");
        }
        
        // validar nombre usuario
        if (pacienteDTO.getUsuario().getNombre() == null || pacienteDTO.getUsuario().getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre de usuario no debe estar vacío.");
        }
        
        // validar contraseña
        if (pacienteDTO.getUsuario().getContrasenia() == null || pacienteDTO.getUsuario().getContrasenia().trim().isEmpty() || 
                pacienteDTO.getUsuario().getContrasenia().length() < 8) {
            throw new NegocioException("La contraseña debe contener mínimo 8 caracteres.");
        }
        
        try {
            pacienteDAO.registrarPaciente(Mapper.toEntity(pacienteDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al registrar paciente.", ex);
            throw new NegocioException("Ocurrió un error al registrar el paciente.", ex);
        }
    }
    
    public void actualizarPaciente(PacienteDTO pacienteDTO) throws PersistenciaException, NegocioException {
        // validaciones necesarias
        
        try {
            pacienteDAO.actualizarPaciente(Mapper.toEntity(pacienteDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al actualizar paciente.", ex);
            throw new NegocioException("Ocurrió un error al actualizar el paciente.", ex);
        }
    }
    
}
