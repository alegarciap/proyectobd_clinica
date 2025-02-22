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
public class AuditoriaDTO {
    
    private int id_auditoria;
    private String accion;
    private LocalDateTime fecha_hora;
    private CitaDTO cita;

    public AuditoriaDTO() {
    }

    public AuditoriaDTO(int id_auditoria, String accion, LocalDateTime fecha_hora, CitaDTO cita) {
        this.id_auditoria = id_auditoria;
        this.accion = accion;
        this.fecha_hora = fecha_hora;
        this.cita = cita;
    }

    public AuditoriaDTO(String accion, LocalDateTime fecha_hora, CitaDTO cita) {
        this.accion = accion;
        this.fecha_hora = fecha_hora;
        this.cita = cita;
    }

    public int getId_auditoria() {
        return id_auditoria;
    }

    public void setId_auditoria(int id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public CitaDTO getCita() {
        return cita;
    }

    public void setCita(CitaDTO cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "AuditoriaDTO{" + "id_auditoria=" + id_auditoria + ", accion=" + accion + ", fecha_hora=" + fecha_hora + ", cita=" + cita + '}';
    }
    
}
