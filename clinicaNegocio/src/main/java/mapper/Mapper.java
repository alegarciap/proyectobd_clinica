/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import DTO.CitaDTO;
import DTO.ConsultaDTO;
import DTO.MedicoDTO;
import DTO.PacienteDTO;
import DTO.UsuarioDTO;
import entidades.Cita;
import entidades.Consulta;
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
        
        Paciente paciente = toEntity(citaDTO.getPaciente());      
        cita.setPaciente(paciente);

        Medico medico = toEntity(citaDTO.getMedico());
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
        
        MedicoDTO medico = toDTO(cita.getMedico());
        citaDTO.setMedico(medico);
        
        PacienteDTO paciente = toDTO(cita.getPaciente());
        citaDTO.setPaciente(paciente);
        
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
        
        Usuario usuario = toEntity(pacienteDTO.getUsuario());
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
        
        UsuarioDTO usuario = toDTO(paciente.getUsuario());
        pacienteDTO.setUsuario(usuario);
        
        return pacienteDTO;
    }
    
    // Convertir de DTO a Entidad (UsuarioDTO -> Usuario)
    public static Usuario toEntity(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null;
        }
        
        Usuario usuario = new Usuario();
        usuario.setId_usuario(usuarioDTO.getId_usuario());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setContrasenia(usuarioDTO.getContrasenia());
        
        return usuario;
    }
    
    // Convertir de Entidad a DTO (Usuario -> UsuarioDTO)
    public static UsuarioDTO toDTO (Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId_usuario(usuario.getId_usuario());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setContrasenia(usuario.getContrasenia());
        
        return usuarioDTO;
    }
    
    // Convertir de DTO a Entidad (MedicoDTO -> Medico)
    public static Medico toEntity(MedicoDTO medicoDTO) {
        if (medicoDTO == null) {
            return null;
        }
        
        Medico medico = new Medico();
        medico.setId_medico(medicoDTO.getId_medico());
        medico.setNombre(medicoDTO.getNombre());
        medico.setApellido_paterno(medicoDTO.getApellido_paterno());
        medico.setApellido_materno(medicoDTO.getApellido_materno());
        medico.setCedula(medicoDTO.getCedula());
        medico.setEspecialidad(medicoDTO.getEspecialidad());
        medico.setEstado(medicoDTO.getEstado());
        
        Usuario usuario = toEntity(medicoDTO.getUsuario());
        medico.setUsuario(usuario);
        
        return medico;
    }
    
    // Convertir de Entidad a DTO (Medico -> MedicoDTO)
    public static MedicoDTO toDTO (Medico medico) {
        if (medico == null) {
            return null;
        }
        
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setId_medico(medico.getId_medico());
        medicoDTO.setNombre(medico.getNombre());
        medicoDTO.setApellido_paterno(medico.getApellido_paterno());
        medicoDTO.setApellido_materno(medico.getApellido_materno());
        medicoDTO.setCedula(medico.getCedula());
        medicoDTO.setEspecialidad(medico.getEspecialidad());
        medicoDTO.setEstado(medico.getEstado());
        
        UsuarioDTO usuario = toDTO(medico.getUsuario());
        medicoDTO.setUsuario(usuario);
        
        return medicoDTO;
    }
    
    // Convertir de DTO a Entidad (ConsultaDTO -> Consulta)
    public static Consulta toEntity (ConsultaDTO consultaDTO) {
        if (consultaDTO == null) {
            return null;
        }
        
        Consulta consulta = new Consulta();
        consulta.setId_consulta(consultaDTO.getId_consulta());
        consulta.setFecha_hora(consultaDTO.getFecha_hora());
        consulta.setDiagnostico(consultaDTO.getDiagnostico());
        consulta.setTratamiento(consultaDTO.getTratamiento());
        consulta.setObservaciones(consultaDTO.getObservaciones());
        
        Cita cita = toEntity(consultaDTO.getCita());
        consulta.setCita(cita);
        
        return consulta;
    }
    
    // Convertir de Entidad a DTO (Consulta -> ConsultaDTO)
    public static ConsultaDTO toDTO(Consulta consulta) {
        if (consulta == null) {
            return null;
        }
        
        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setId_consulta(consulta.getId_consulta());
        consultaDTO.setFecha_hora(consulta.getFecha_hora());
        consultaDTO.setDiagnostico(consulta.getDiagnostico());
        consultaDTO.setTratamiento(consulta.getTratamiento());
        consultaDTO.setObservaciones(consultaDTO.getObservaciones());
        
        CitaDTO citaDTO = toDTO(consulta.getCita());
        consultaDTO.setCita(citaDTO);
        
        return consultaDTO;
    }
    
}
