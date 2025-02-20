/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import DTO.CitaDTO;
import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;

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
    
}
