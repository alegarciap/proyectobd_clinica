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
public class CitaMapper {
    
    public Cita toentity (CitaDTO citaDTO) {
        if (citaDTO == null) {
            return null;
        }
        
        Cita cita = new Cita();
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
    
}
