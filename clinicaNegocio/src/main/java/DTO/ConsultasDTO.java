/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author alega
 */
public class ConsultasDTO {
    
    private int id_consulta;
    private LocalDateTime fecha_hora;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;
    private CitaDTO cita;

    public ConsultasDTO() {
    }

    public ConsultasDTO(int id_consulta, LocalDateTime fecha_hora, String diagnostico, String tratamiento, String observaciones, CitaDTO cita) {
        this.id_consulta = id_consulta;
        this.fecha_hora = fecha_hora;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    public ConsultasDTO(LocalDateTime fecha_hora, String diagnostico, String tratamiento, String observaciones, CitaDTO cita) {
        this.fecha_hora = fecha_hora;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public CitaDTO getCita() {
        return cita;
    }

    public void setCita(CitaDTO cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "ConsultasDTO{" + "id_consulta=" + id_consulta + ", fecha_hora=" + fecha_hora + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + ", cita=" + cita + '}';
    }
    
}
