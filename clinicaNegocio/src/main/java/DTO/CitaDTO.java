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
    private int id_medico;
    private int id_paciente;

    public CitaDTO() {
    }

    public CitaDTO(int id_cita, Timestamp fecha_hora, String estado, String folio, int id_medico, int id_paciente) {
        this.id_cita = id_cita;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
    }

    public CitaDTO(Timestamp fecha_hora, String estado, String folio, int id_medico, int id_paciente) {
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
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

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    @Override
    public String toString() {
        return "CitaDTO{" + "id_cita=" + id_cita + ", fecha_hora=" + fecha_hora + ", estado=" + estado + ", folio=" + folio + ", id_medico=" + id_medico + ", id_paciente=" + id_paciente + '}';
    }
    
}
