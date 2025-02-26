/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

/**
 * La clase ConsultaDTO representa un objeto de transferencia de datos
 * utilizado para almacenar información sobre consultas médicas en el sistema.
 * Incluye detalles sobre la fecha y hora de la consulta, el diagnóstico, 
 * el tratamiento, las observaciones y la cita asociada.
 * 
 * @author alega
 */
public class ConsultaDTO {

    private int id_consulta;
    private Timestamp fecha_hora;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;
    private CitaDTO cita;

    /**
     * Constructor vacío de ConsultaDTO.
     */
    public ConsultaDTO() {
    }

    /**
     * Constructor de ConsultaDTO con todos los parámetros.
     * 
     * @param id_consulta El ID de la consulta.
     * @param fecha_hora La fecha y hora de la consulta.
     * @param diagnostico El diagnóstico proporcionado durante la consulta.
     * @param tratamiento El tratamiento recomendado durante la consulta.
     * @param observaciones Observaciones adicionales sobre la consulta.
     * @param cita La cita asociada a la consulta.
     */
    public ConsultaDTO(int id_consulta, Timestamp fecha_hora, String diagnostico, String tratamiento, String observaciones, CitaDTO cita) {
        this.id_consulta = id_consulta;
        this.fecha_hora = fecha_hora;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    /**
     * Constructor de ConsultaDTO sin ID de consulta.
     * 
     * @param fecha_hora La fecha y hora de la consulta.
     * @param diagnostico El diagnóstico proporcionado durante la consulta.
     * @param tratamiento El tratamiento recomendado durante la consulta.
     * @param observaciones Observaciones adicionales sobre la consulta.
     * @param cita La cita asociada a la consulta.
     */
    public ConsultaDTO(Timestamp fecha_hora, String diagnostico, String tratamiento, String observaciones, CitaDTO cita) {
        this.fecha_hora = fecha_hora;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    /**
     * Obtiene el ID de la consulta.
     * 
     * @return El ID de la consulta.
     */
    public int getId_consulta() {
        return id_consulta;
    }

    /**
     * Establece el ID de la consulta.
     * 
     * @param id_consulta El nuevo ID de la consulta.
     */
    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    /**
     * Obtiene la fecha y hora de la consulta.
     * 
     * @return La fecha y hora de la consulta.
     */
    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    /**
     * Establece la fecha y hora de la consulta.
     * 
     * @param fecha_hora La nueva fecha y hora de la consulta.
     */
    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    /**
     * Obtiene el diagnóstico proporcionado durante la consulta.
     * 
     * @return El diagnóstico de la consulta.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Establece el diagnóstico proporcionado durante la consulta.
     * 
     * @param diagnostico El nuevo diagnóstico de la consulta.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Obtiene el tratamiento recomendado durante la consulta.
     * 
     * @return El tratamiento de la consulta.
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Establece el tratamiento recomendado durante la consulta.
     * 
     * @param tratamiento El nuevo tratamiento de la consulta.
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Obtiene las observaciones adicionales sobre la consulta.
     * 
     * @return Las observaciones de la consulta.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones adicionales sobre la consulta.
     * 
     * @param observaciones Las nuevas observaciones de la consulta.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene la cita asociada a la consulta.
     * 
     * @return La cita asociada a la consulta.
     */
    public CitaDTO getCita() {
        return cita;
    }

    /**
     * Establece la cita asociada a la consulta.
     * 
     * @param cita La nueva cita asociada a la consulta.
     */
    public void setCita(CitaDTO cita) {
        this.cita = cita;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto ConsultaDTO.
     * 
     * @return Una cadena que representa el objeto ConsultaDTO.
     */
    @Override
    public String toString() {
        return "ConsultasDTO{" + "id_consulta=" + id_consulta + ", fecha_hora=" + fecha_hora + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + ", cita=" + cita + '}';
    }
}
