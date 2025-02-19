/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Timestamp;

/**
 *
 * @author alega
 */
public class Cita {
    
    private int id_cita;
    private Timestamp fecha_hora;
    private String estado;
    private String folio;
    private Medico medico;
    private Paciente paciente;

    public Cita() {
    }

    public Cita(int id_cita, Timestamp fecha_hora, String estado, String folio, Medico medico, Paciente paciente) {
        this.id_cita = id_cita;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Cita(Timestamp fecha_hora, String estado, String folio, Medico medico, Paciente paciente) {
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.medico = medico;
        this.paciente = paciente;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Cita{" + "id_cita=" + id_cita + ", fecha_hora=" + fecha_hora + ", estado=" + estado + ", folio=" + folio + ", medico=" + medico + ", paciente=" + paciente + '}';
    }
    
}
