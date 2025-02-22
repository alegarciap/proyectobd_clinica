/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author alega
 */
public class CitaDTO {
    
    private int id_cita;
    private Timestamp fecha_hora;
    private String estado;
    private String folio;
    private PacienteDTO paciente;
    private MedicoDTO medico;

    public CitaDTO() {
    }

    public CitaDTO(int id_cita, Timestamp fecha_hora, String estado, String folio, PacienteDTO paciente, MedicoDTO medico) {
        this.id_cita = id_cita;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.paciente = paciente;
        this.medico = medico;
    }

    public CitaDTO(Timestamp fecha_hora, String estado, String folio, PacienteDTO paciente, MedicoDTO medico) {
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.paciente = paciente;
        this.medico = medico;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public MedicoDTO getMedico() {
        return medico;
    }

    public void setMedico(MedicoDTO medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "CitaDTO{" + "id_cita=" + id_cita + ", fecha_hora=" + fecha_hora + ", estado=" + estado + ", folio=" + folio + ", paciente=" + paciente + ", medico=" + medico + '}';
    }
    
}
