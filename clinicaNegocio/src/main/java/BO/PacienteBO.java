/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IPacienteDAO;
import DAO.PacienteDAO;
import DTO.PacienteDTO;
import DTO.UsuarioDTO;
import conexion.IConexion;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.Mapper;

/**
 *
 * @author alega
 */
public class PacienteBO {
    
    private static final Logger logger = Logger.getLogger(CitaBO.class.getName());
    private final IPacienteDAO pacienteDAO;
    
    public PacienteBO(IConexion conexion) {
        this.pacienteDAO = new PacienteDAO(conexion);
    }
    
    public void registrarPaciente(PacienteDTO pacienteDTO) throws PersistenciaException, NegocioException {
        // validaciones necesarias
        if (pacienteDTO.getNombre() == null || pacienteDTO.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre del paciente no debe estar vacío, es obligatorio.");
        }
        
        // validar apellidos
        // validar direccion
        // validar telefono
        // validar correo
        // validar id usuario
        // validar nombre usuario
        // validar contraseña
        
        try {
            pacienteDAO.registrarPaciente(Mapper.toEntity(pacienteDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al registrar paciente.", ex);
            throw new NegocioException("Ocurrió un error al registrar el paciente.", ex);
        }
    }
    
}
