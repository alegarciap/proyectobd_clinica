/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import DTO.CitaDTO;
import DTO.PacienteDTO;
import DTO.UsuarioDTO;
import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;
import entidades.Usuario;

/**
 *
 * @author alega
 */
public class Mapper {
    
    // Convertir de DTO a Entidad (CitaDTO -> Cita)
    public static Cita toEntity (CitaDTO citaDTO) {
        if (citaDTO == null) {
            return null;
        }
        
        Cita cita = new Cita();
        cita.setId_cita(citaDTO.getId_cita());
        cita.setFecha_hora(citaDTO.getFecha_hora());
        cita.setEstado(citaDTO.getEstado());
        cita.setFolio(citaDTO.getFolio());
        
        Paciente paciente = new Paciente();
        paciente.setId_paciente(citaDTO.getId_paciente());
        cita.setPaciente(paciente);

        Medico medico = new Medico();
        medico.setId_medico(citaDTO.getId_medico());
        cita.setMedico(medico);

        return cita;
        
    }
    
    // Convertir de Entidad a DTO (Cita -> citaDTO)
    public static CitaDTO toDTO (Cita cita) {
        if (cita == null) {
            return null;
        }
        
        CitaDTO citaDTO = new CitaDTO();
        citaDTO.setId_cita(cita.getId_cita());
        citaDTO.setFecha_hora(cita.getFecha_hora());
        citaDTO.setEstado(cita.getEstado());
        citaDTO.setFolio(cita.getFolio());
        citaDTO.setId_medico(cita.getMedico().getId_medico());
        citaDTO.setId_paciente(cita.getPaciente().getId_paciente());
        
        return citaDTO;
    }
    
    // Convertir de DTO a Entidad (PacienteDTO -> Paciente)
    public static Paciente toEntity (PacienteDTO pacienteDTO) {
        if (pacienteDTO == null) {
            return null;
        }
        
        Paciente paciente = new Paciente();
        paciente.setId_paciente(pacienteDTO.getId_paciente());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido_paterno(pacienteDTO.getApellido_paterno());
        paciente.setApellido_materno(pacienteDTO.getApellido_materno());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setFecha_nacimiento(pacienteDTO.getFecha_nacimiento());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setCorreo(pacienteDTO.getCorreo());
        
        Usuario usuario = new Usuario();
        usuario.setId_usuario(pacienteDTO.getId_usuario());
        usuario.setNombre(pacienteDTO.getNombre_usuario());
        usuario.setContrasenia(pacienteDTO.getContrasenia_usuario());
        paciente.setUsuario(usuario);
        
        return paciente;
    }
    
    // Convertir de Entidad a DTO (Paciente -> PacienteDTO)
    public static PacienteDTO toDTO (Paciente paciente) {
        if (paciente == null) {
            return null;
        }
        
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId_paciente(paciente.getId_paciente());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellido_paterno(paciente.getApellido_paterno());
        pacienteDTO.setApellido_materno(paciente.getApellido_materno());
        pacienteDTO.setDireccion(paciente.getDireccion());
        pacienteDTO.setFecha_nacimiento(paciente.getFecha_nacimiento());
        pacienteDTO.setTelefono(paciente.getTelefono());
        pacienteDTO.setCorreo(paciente.getCorreo());
        pacienteDTO.setId_usuario(paciente.getUsuario().getId_usuario());
        pacienteDTO.setNombre_usuario(paciente.getUsuario().getNombre());
        pacienteDTO.setContrasenia_usuario(paciente.getUsuario().getContrasenia());
        
        return pacienteDTO;
    }
    
}
