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
 * La clase Mapper proporciona métodos estáticos para convertir entre 
 * objetos DTO (Data Transfer Object) y entidades del modelo.
 * Facilita la transferencia de datos entre capas de la aplicación, 
 * permitiendo la conversión de objetos de un tipo a otro.
 * 
 * @author Abraham Coronel
 */
public class Mapper {

    /**
     * Convierte un objeto CitaDTO a una entidad Cita.
     * 
     * @param citaDTO El objeto CitaDTO a convertir.
     * @return La entidad Cita correspondiente, o null si citaDTO es null.
     */
    public static Cita toEntity(CitaDTO citaDTO) {
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

    /**
     * Convierte una entidad Cita a un objeto CitaDTO.
     * 
     * @param cita La entidad Cita a convertir.
     * @return El objeto CitaDTO correspondiente, o null si cita es null.
     */
    public static CitaDTO toDTO(Cita cita) {
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

    /**
     * Convierte un objeto PacienteDTO a una entidad Paciente.
     * 
     * @param pacienteDTO El objeto PacienteDTO a convertir.
     * @return La entidad Paciente correspondiente, o null si pacienteDTO es null.
     */
    public static Paciente toEntity(PacienteDTO pacienteDTO) {
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

    /**
     * Convierte una entidad Paciente a un objeto PacienteDTO.
     * 
     * @param paciente La entidad Paciente a convertir.
     * @return El objeto PacienteDTO correspondiente, o null si paciente es null.
     */
    public static PacienteDTO toDTO(Paciente paciente) {
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

    /**
     * Convierte un objeto UsuarioDTO a una entidad Usuario.
     * 
     * @param usuarioDTO El objeto UsuarioDTO a convertir.
     * @return La entidad Usuario correspondiente, o null si usuarioDTO es null.
     */
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

    /**
     * Convierte una entidad Usuario a un objeto UsuarioDTO.
     * 
     * @param usuario La entidad Usuario a convertir.
     * @return El objeto UsuarioDTO correspondiente, o null si usuario es null.
     */
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId_usuario(usuario.getId_usuario());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setContrasenia(usuario.getContrasenia());

        return usuarioDTO;
    }

    /**
     * Convierte un objeto MedicoDTO a una entidad Medico.
     * 
     * @param medicoDTO El objeto MedicoDTO a convertir.
     * @return La entidad Medico correspondiente, o null si medicoDTO es null.
     */
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

    /**
     * Convierte una entidad Medico a un objeto MedicoDTO.
     * 
     * @param medico La entidad Medico a convertir.
     * @return El objeto MedicoDTO correspondiente, o null si medico es null.
     */
    public static MedicoDTO toDTO(Medico medico) {
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

    /**
     * Convierte un objeto ConsultaDTO a una entidad Consulta.
     * 
     * @param consultaDTO El objeto ConsultaDTO a convertir.
     * @return La entidad Consulta correspondiente, o null si consultaDTO es null.
     */
    public static Consulta toEntity(ConsultaDTO consultaDTO) {
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

    /**
     * Convierte una entidad Consulta a un objeto ConsultaDTO.
     * 
     * @param consulta La entidad Consulta a convertir.
     * @return El objeto ConsultaDTO correspondiente, o null si consulta es null.
     */
    public static ConsultaDTO toDTO(Consulta consulta) {
        if (consulta == null) {
            return null;
        }

        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setId_consulta(consulta.getId_consulta());
        consultaDTO.setFecha_hora(consulta.getFecha_hora());
        consultaDTO.setDiagnostico(consulta.getDiagnostico());
        consultaDTO.setTratamiento(consulta.getTratamiento());
        consultaDTO.setObservaciones(consulta.getObservaciones());

        CitaDTO citaDTO = toDTO(consulta.getCita());
        consultaDTO.setCita(citaDTO);

        return consultaDTO;
    }
}

