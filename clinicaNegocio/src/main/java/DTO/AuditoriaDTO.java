/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;

/**
 * La clase AuditoriaDTO representa un objeto de transferencia de datos 
 * utilizado para almacenar información sobre las acciones realizadas 
 * en el sistema en relación con las citas. Incluye detalles sobre 
 * la acción, la fecha y hora de la acción, y la cita asociada.
 * 
 * @author Abraham Coronel Bringas
 */
public class AuditoriaDTO {

    private int id_auditoria;
    private String accion;
    private LocalDateTime fecha_hora;
    private CitaDTO cita;

    /**
     * Constructor vacío de AuditoriaDTO.
     */
    public AuditoriaDTO() {
    }

    /**
     * Constructor de AuditoriaDTO con todos los parámetros.
     * 
     * @param id_auditoria El ID de la auditoría.
     * @param accion La acción que se registró.
     * @param fecha_hora La fecha y hora en que se registró la acción.
     * @param cita La cita asociada a la acción.
     */
    public AuditoriaDTO(int id_auditoria, String accion, LocalDateTime fecha_hora, CitaDTO cita) {
        this.id_auditoria = id_auditoria;
        this.accion = accion;
        this.fecha_hora = fecha_hora;
        this.cita = cita;
    }

    /**
     * Constructor de AuditoriaDTO sin ID de auditoría.
     * 
     * @param accion La acción que se registró.
     * @param fecha_hora La fecha y hora en que se registró la acción.
     * @param cita La cita asociada a la acción.
     */
    public AuditoriaDTO(String accion, LocalDateTime fecha_hora, CitaDTO cita) {
        this.accion = accion;
        this.fecha_hora = fecha_hora;
        this.cita = cita;
    }

    /**
     * Obtiene el ID de la auditoría.
     * 
     * @return El ID de la auditoría.
     */
    public int getId_auditoria() {
        return id_auditoria;
    }

    /**
     * Establece el ID de la auditoría.
     * 
     * @param id_auditoria El nuevo ID de la auditoría.
     */
    public void setId_auditoria(int id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    /**
     * Obtiene la acción registrada.
     * 
     * @return La acción registrada.
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Establece la acción registrada.
     * 
     * @param accion La nueva acción registrada.
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * Obtiene la fecha y hora de la acción.
     * 
     * @return La fecha y hora de la acción.
     */
    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    /**
     * Establece la fecha y hora de la acción.
     * 
     * @param fecha_hora La nueva fecha y hora de la acción.
     */
    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    /**
     * Obtiene la cita asociada a la acción.
     * 
     * @return La cita asociada a la acción.
     */
    public CitaDTO getCita() {
        return cita;
    }

    /**
     * Establece la cita asociada a la acción.
     * 
     * @param cita La nueva cita asociada a la acción.
     */
    public void setCita(CitaDTO cita) {
        this.cita = cita;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto AuditoriaDTO.
     * 
     * @return Una cadena que representa el objeto AuditoriaDTO.
     */
    @Override
    public String toString() {
        return "AuditoriaDTO{" + "id_auditoria=" + id_auditoria + ", accion=" + accion + ", fecha_hora=" + fecha_hora + ", cita=" + cita + '}';
    }
}
